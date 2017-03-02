package neo.lookup;

import util.GenericRequest;
import util.GenericResponse;

public class NEOLookupRequest extends GenericRequest {

	/* API-Dependent constants */
	private static final String BASE_URL = "https://api.nasa.gov/neo/rest/v1/neo/";
	private static final String PARAM_ASTEROID_ID = "asteroid_id";

	private Integer asteroidID;
	
	public NEOLookupRequest(Integer asteroidID, String apiKey) {
		super(apiKey);
		this.asteroidID = asteroidID;
	}
	
	/*public NEOLookupRequest(String apiKey) {
		super(apiKey);
	}*/

	public Integer getAsteroidID() {
		return asteroidID;
	}

	public void setAsteroidID(Integer asteroidID) {
		this.asteroidID = asteroidID;
	}

	@Override
	public GenericResponse newResponse() {
		return new NEOLookupResponse();
	}

	@Override
	public String getQueryString() {
		String queryString = BASE_URL;
		queryString += asteroidID;
		queryString += "?" + PARAM_APIKEY + "=" + apiKey;
		//if(asteroidID != null)
		//	queryString += "&" + PARAM_ASTEROID_ID + "=" + asteroidID;
		return queryString;
	}

}
