package util;

public abstract class GenericRequest {

	/* API-Dependent constants */
	protected static final String PARAM_APIKEY = "api_key";
	
	protected String apiKey;

	protected GenericRequest(String apiKey) {
		this.apiKey = apiKey;
	}

	public GenericResponse send() throws Exception {
		GenericResponse response = newResponse();
		String queryString = getQueryString();
		Http.sendGet(queryString, response);
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

