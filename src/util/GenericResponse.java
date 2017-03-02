package util;

public abstract class GenericResponse {
	
	protected Integer responseCode;
	protected String rawResponse;
	
	public GenericResponse(Integer responseCode, String rawResponse) {
		super();
		this.responseCode = responseCode;
		this.rawResponse = rawResponse;
	}
	
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
	
	public boolean parse() {
		switch(responseCode) {
			case(200):
				fillObject();
				break;
			case(403): // invalid api key
				System.err.println("Invalid API key");
				break;
			case(404): // not found
				System.err.println("Data not found");
				break;
			case(500): // internal server error
				System.err.println("Internal server error");
				break;
			default:
				break;
		}
		return true;
	}
	
	public abstract void fillObject();
	
}
