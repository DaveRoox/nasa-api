import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import apod.APODResponse;
import nasaapis.NasaAPIs;
import neo.CloseApproachInfo;
import neo.NearEarthObject;
import neo.browse.NEOBrowseResponseCollector;
import neo.lookup.NEOLookupResponse;

public class Main {
	public static void main(String[] args) {
		
		NasaAPIs wrapper = new NasaAPIs("cUtZTKpfckrUO61AzkWoGL4AC94keFUW1zSrcD0A");
		
		/* APOD Example */
		APODResponse apodResponse = wrapper.apod(2017, 3, 4);
		System.out.println(apodResponse.getHdurl());
		
		/* NeoLookup Example */
		NEOLookupResponse neoLookupResponse = wrapper.neoLookup(3542520);
		NearEarthObject neo = neoLookupResponse.getNearEarthObject();
		try {
			System.out.println("Asteroid " + neo.getNeoReferenceID() + (neo.getIsPotentiallyHazardousAsteroid()? " IS " : " is NOT ") + "potentially hazardous!");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat outSdf = new SimpleDateFormat("d/M/yyyy");
			Date startDate = sdf.parse("1950-1-1");
			Date endDate = sdf.parse("2018-1-1");
			String orbitingBody = "earth";
			int k = 0;
			for(CloseApproachInfo closeApproachInfo : neo.getCloseApproachData()) {
				if(
						!closeApproachInfo.getOrbitingBody().toLowerCase().equals(orbitingBody) ||
						closeApproachInfo.getCloseApproachDate().before(startDate) ||
						closeApproachInfo.getCloseApproachDate().after(endDate)
					)
					continue;
				k++;
				System.out.print("" + k + ") Asteroid " + neo.getNeoReferenceID());
				System.out.print(" was orbiting " + (int)closeApproachInfo.getMissDistance().getKilometers().doubleValue() + " kilometers");
				System.out.print(" far from " + closeApproachInfo.getOrbitingBody());
				System.out.print(" in " + outSdf.format(closeApproachInfo.getCloseApproachDate()));
				System.out.println(" at " + (int)closeApproachInfo.getRelativeVelocity().getKilometersPerHour().doubleValue() + " km/h");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		/* NeoBrowse Example */
		NEOBrowseResponseCollector neoBrowseResponseCollector = wrapper.neoBrowseCollector();
		neoBrowseResponseCollector.collectTillPage(6);
		int i = 0;
		for(NearEarthObject neoo : neoBrowseResponseCollector.getNeoObjects()) {
			System.out.println(++i + ".\tAsteroid " + neoo.getName() + " [" + neoo.getNeoReferenceID() + "]");
		}
	}
}
