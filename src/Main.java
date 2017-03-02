import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import apod.APODResponse;
import nasaapis.NasaAPIs;
import neo.lookup.CloseApproachInfo;
import neo.lookup.NEOLookupResponse;

public class Main {
	public static void main(String[] args) {
		
		NasaAPIs wrapper = new NasaAPIs("cUtZTKpfckrUO61AzkWoGL4AC94keFUW1zSrcD0A");
		
		APODResponse apodResponse = wrapper.apod(2017, 3, 2);
		System.out.println(apodResponse.getHdurl());
		
		/* Cerco le informazioni sull'asteroide 3542518 */
		NEOLookupResponse neoLookupResponse = wrapper.neoLookup(3542518);
		
		try {
			System.out.println("Asteroid " + neoLookupResponse.getNeoReferenceID() + (neoLookupResponse.getIsPotentiallyHazardousAsteroid()? " IS " : " is NOT ") + "potentially hazardous!");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat outSdf = new SimpleDateFormat("d/M/yyyy");
			Date startDate = sdf.parse("1950-1-1");
			Date endDate = sdf.parse("2018-1-1");
			String orbitingBody = "earth";
			int k = 0;
			for(CloseApproachInfo closeApproachInfo : neoLookupResponse.getCloseApproachData()) {
				if(
						!closeApproachInfo.getOrbitingBody().toLowerCase().equals(orbitingBody) ||
						closeApproachInfo.getCloseApproachDate().before(startDate) ||
						closeApproachInfo.getCloseApproachDate().after(endDate)
					)
					continue;
				k++;
				System.out.print("" + k + ") Asteroid " + neoLookupResponse.getNeoReferenceID());
				System.out.print(" was orbiting " + (int)closeApproachInfo.getMissDistance().getKilometers().doubleValue() + " kilometers");
				System.out.print(" far from " + closeApproachInfo.getOrbitingBody());
				System.out.print(" in " + outSdf.format(closeApproachInfo.getCloseApproachDate()));
				System.out.println(" at " + (int)closeApproachInfo.getRelativeVelocity().getKilometersPerHour().doubleValue() + " km/h");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
