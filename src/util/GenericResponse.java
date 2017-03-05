package util;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class GenericResponse {
	
	/* API-Dependent constants */
	//private static final String FIELD_CODE = "code";
	private static final String FIELD_MSG = "msg";
	
	protected Integer responseCode;
	protected String rawResponse;
	protected JSONObject jsonObject;
	
	public GenericResponse() {
	}
	
	public Integer getResponseCode() {
		return responseCode;
	}
	
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	
	public String getRawResponse() {
		return rawResponse;
	}
	
	public void setRawResponse(String rawResponse) {
		this.rawResponse = rawResponse;
	}
	
	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	public void parse() throws JSONException {
		
		if(rawResponse != null)
			jsonObject = new JSONObject(rawResponse);
		
		switch(responseCode) {
			case(200):
				fillObject();
				break;
			/*case(403): // invalid api key
				System.err.println("Invalid API key");
				break;
			case(404): // not found
				System.err.println("Data not found");
				break;
			case(500): // internal server error
				System.err.println("Internal server error");
				break;*/
			default:
				handleError();
		}
	}
	
	private void handleError() {
		// TODO: Replace print with exception
		try {
			System.err.print("[Response code " + responseCode + "]");
			System.err.println(jsonObject != null? ": " + jsonObject.getString(GenericResponse.FIELD_MSG) : "");
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public abstract void fillObject();
	
}
