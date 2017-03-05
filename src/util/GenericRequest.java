package util;

import java.io.IOException;

import org.json.JSONException;

public abstract class GenericRequest {

	/* API-Dependent constants */
	protected static final String PARAM_APIKEY = "api_key";
	
	protected String apiKey;

	protected GenericRequest(String apiKey) {
		this.apiKey = apiKey;
	}

	public GenericResponse send() {
		GenericResponse response = newResponse();
		String queryString = getQueryString();
		try {
			Http.sendGet(queryString, response);
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public abstract GenericResponse newResponse();
	public abstract String getQueryString();
	
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

}

