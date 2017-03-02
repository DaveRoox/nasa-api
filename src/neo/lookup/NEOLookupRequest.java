package neo.lookup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import util.Http;

public class NEOLookupRequest {

	/* API-Dependent constants */
	private static final String BASE_URL = "https://api.nasa.gov/neo/rest/v1/neo/3542519";
	private static final String PARAM_ASTEROID_ID = "asteroid_id";
	private static final String PARAM_APIKEY = "api_key";

	private Integer asteroidID;
	private String apiKey;
	
	public NEOLookupRequest(Integer asteroidID, String apiKey) {
		this.asteroidID = asteroidID;
		this.apiKey = apiKey;
	}
	
	public NEOLookupRequest(String apiKey) {
		this.apiKey = apiKey;
	}

	public Integer getAsteroidID() {
		return asteroidID;
	}

	public void setAsteroidID(Integer asteroidID) {
		this.asteroidID = asteroidID;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public NEOLookupResponse send() throws Exception {

		NEOLookupResponse neoLookupResponse = new NEOLookupResponse();
		
		String queryString = BASE_URL;
		queryString += "?" + PARAM_APIKEY + "=" + apiKey;
		if(asteroidID != null)
			queryString += "&" + PARAM_ASTEROID_ID + "=" + asteroidID;

		Http.sendGet(queryString, neoLookupResponse);

		switch(neoLookupResponse.getResponseCode()) {
		
			case(200):
				try {
					System.out.println(neoLookupResponse.getRawResponse());
					JSONObject jobj = new JSONObject(neoLookupResponse.getRawResponse());
					neoLookupResponse.setNeoReferenceID(jobj.getString(NEOLookupResponse.FIELD_NEO_REFERENCE_ID));
					neoLookupResponse.setName(jobj.getString(NEOLookupResponse.FIELD_NAME));
					neoLookupResponse.setNasaJplUrl(jobj.getString(NEOLookupResponse.FIELD_NASA_JPL_URL));
					neoLookupResponse.setAbsoluteMagnitudeH(jobj.getDouble(NEOLookupResponse.FIELD_ABSOLUTE_MAGNITUDE_H));
					neoLookupResponse.setIsPotentiallyHazardousAsteroid(jobj.getBoolean(NEOLookupResponse.FIELD_IS_POTENTIALLY_HAZARDOUS_ASTEROID));
					JSONObject estimatedDiameter = jobj.getJSONObject(NEOLookupResponse.FIELD_ESTIMATED_DIAMETER);
					for(UnitOfMeasurement uom : UnitOfMeasurement.values()) {
						EstimatedDiameter ed = new EstimatedDiameter();
						ed.setUnitOfMeasurement(uom);
						assert(ed.parse(estimatedDiameter.getJSONObject(uom.getValue())));
						neoLookupResponse.getEstimatedDiameter().add(ed);
					}
					JSONArray jarr = jobj.getJSONArray(NEOLookupResponse.FIELD_CLOSE_APPROACH_DATA);
					for(int i = 0; i < jarr.length(); i++) {
						CloseApproachItem closeApproachItem = new CloseApproachItem();
						assert(closeApproachItem.parse(jarr.getJSONObject(i)));
					}
						
	
				} catch (JSONException e) {
					e.printStackTrace();
				}
				break;
			case(403): // invalid api key
				System.err.println("Invalid API key: " + apiKey);
				break;
			case(500): // internal server error
				System.err.println("Internal server error");
				break;
			default:
				break;
		}

		return neoLookupResponse;
	}

}
