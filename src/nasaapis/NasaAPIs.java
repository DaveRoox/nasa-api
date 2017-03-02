package nasaapis;

import apod.APODRequest;
import apod.APODResponse;

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
			return new APODRequest(year, month, day, hd, apiKey).send();
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
			return new APODRequest(hd, apiKey).send();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public APODResponse apod() {
		return apod(false);
	}
	
	/* NeoWs (Near Earth Object Web Service) / NEO */
	
	/*public NEOFeedResponse neoFeed(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay) {
		return new NEOFeedRequest(startYear, startMonth, startDay, endYear, endMonth, endDay, apiKey);
	}*/
	
}
