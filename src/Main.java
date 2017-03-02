import apod.APODResponse;
import nasaapis.NasaAPIs;
import neo.lookup.NEOLookupResponse;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("Ciao!");
		NasaAPIs wrapper = new NasaAPIs("cUtZTKpfckrUO61AzkWoGL4AC94keFUW1zSrcD0A");
		//APODResponse apodResponse = wrapper.apod(2005, 2, 26);
		//System.out.println(apodResponse.getHdurl());
		NEOLookupResponse neoLookupResponse = wrapper.neoLookup();
		System.out.println(neoLookupResponse);
	}
}
