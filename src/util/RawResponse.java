package util;

public abstract class RawResponse {
	
	protected Integer responseCode;
	protected String rawResponse;
	
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
	public RawResponse(Integer responseCode, String rawResponse) {
		super();
		this.responseCode = responseCode;
		this.rawResponse = rawResponse;
	}
	public RawResponse() {
		
	}
	
}
