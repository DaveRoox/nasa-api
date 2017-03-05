package nasaapis;

import apod.APODRequest;
import apod.APODResponse;
import neo.browse.NEOBrowseRequest;
import neo.browse.NEOBrowseResponse;
import neo.browse.NEOBrowseResponseCollector;
import neo.lookup.NEOLookupRequest;
import neo.lookup.NEOLookupResponse;

public class NasaAPIs {
	
	private String apiKey;
	
	public NasaAPIs(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	/***** Public NASA APIs *****/
	
	/* APOD (Astronomy Picture of the Day) */
	
	public APODResponse apod(int year, int month, int day, Boolean hd) {
		try {
			return (APODResponse) new APODRequest(year, month, day, hd, apiKey).send();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public APODResponse apod(int year, int month, int day) {
		return apod(year, month, day, false);
	}
	
	public APODResponse apod(Boolean hd) {
		try {
			return (APODResponse) new APODRequest(hd, apiKey).send();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public APODResponse apod() {
		return apod(false);
	}
	
	/* NeoWs (Near Earth Object Web Service) */
	
	// NEO Feed
	/*public NEOFeedResponse neoFeed(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay) {
		return (NEOFeedResponse) new NEOFeedRequest(startYear, startMonth, startDay, endYear, endMonth, endDay, apiKey);
	}*/
	
	// NEO Lookup
	/* It's just an example, this method won't be present in the final release */
	public NEOLookupResponse neoLookup() {
		return (NEOLookupResponse) new NEOLookupRequest(3542519, apiKey).send();
	}
	
	/* NeoLookup */
	public NEOLookupResponse neoLookup(int asteroidID) {
		return (NEOLookupResponse) new NEOLookupRequest(asteroidID, apiKey).send();
	}
	
	/* NeoBrowse */
	public NEOBrowseResponse neoBrowse() {
		return (NEOBrowseResponse) new NEOBrowseRequest(apiKey).send();
	}
	
	public NEOBrowseResponseCollector neoBrowseCollector() {
		return new NEOBrowseResponseCollector((NEOBrowseResponse) new NEOBrowseRequest(apiKey).send());
	}
}
