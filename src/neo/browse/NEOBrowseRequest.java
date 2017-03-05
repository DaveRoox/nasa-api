package neo.browse;

import util.GenericRequest;
import util.GenericResponse;

public class NEOBrowseRequest extends GenericRequest {

	/* API-Dependent constants */
	private static final String BASE_URL = "https://api.nasa.gov/neo/rest/v1/neo/browse";
	
	public NEOBrowseRequest(String apiKey) {
		super(apiKey);
	}

	@Override
	public GenericResponse newResponse() {
		return new NEOBrowseResponse();
	}

	@Override
	public String getQueryString() {
		String queryString = BASE_URL;
		queryString += "?" + PARAM_APIKEY + "=" + apiKey;
		return queryString;
	}

}
