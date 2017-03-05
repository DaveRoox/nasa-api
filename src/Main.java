import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import apod.APODResponse;
import nasaapis.NasaAPIs;
import neo.CloseApproachInfo;
import neo.Links;
import neo.NearEarthObject;
import neo.browse.NEOBrowseAllRequest;
import neo.browse.NEOBrowseAllResponse;
import neo.browse.NEOBrowseResponse;
import neo.lookup.NEOLookupResponse;

public class Main {
	public static void main(String[] args) {
		
		NasaAPIs wrapper = new NasaAPIs("cUtZTKpfckrUO61AzkWoGL4AC94keFUW1zSrcD0A");
		
		APODResponse apodResponse = wrapper.apod(2017, 3, 4);
		System.out.println(apodResponse.getHdurl());
		
		/* Cerco le informazioni sull'asteroide 3542518 */
		NEOLookupResponse neoLookupResponse = wrapper.neoLookup(3542518);
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
		
		NEOBrowseResponse neoBrowserResponse = wrapper.neoBrowse();
		Links links = neoBrowserResponse.getLinks();
		System.out.println("Self is " + links.getSelf());
		System.out.println("Prev is " + links.getPrev());
		System.out.println("Next is " + links.getNext());
		System.out.println(neoBrowserResponse);
		int j = 0;
		for(NearEarthObject nearEarthObject : neoBrowserResponse.getNearEarthObjects()) {
			System.out.println(++j + ") Asteroid " + nearEarthObject.getNeoReferenceID() + (nearEarthObject.getIsPotentiallyHazardousAsteroid()? " IS " : " is NOT ") + "potentially hazardous!");
		}
		
		NEOBrowseAllResponse neoBrowseAllResponse = wrapper.neoBrowseAll();
		j = 0;
		//for(NearEarthObject x : neoBrowseAllResponse.getNearEarthObjects())
		//	System.out.println(++j + ") Asteroid " + x.getNeoReferenceID() + (x.getIsPotentiallyHazardousAsteroid()? " IS " : " is NOT ") + "potentially hazardous!");
	}
}
