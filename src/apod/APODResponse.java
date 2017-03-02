package apod;

import java.util.Date;

import util.RawResponse;

public class APODResponse extends RawResponse {
	
	/* API-Dependent constants */
	public static final String FIELD_CODE = "code";
	public static final String FIELD_MSG = "msg";
	public static final String FIELD_DATE = "date";
	public static final String FIELD_EXPL = "explanation";
	public static final String FIELD_HDURL = "hdurl";
	public static final String FIELD_MEDIA_TYPE = "media_type";
	public static final String FIELD_SERVICE_VERSION = "service_version";
	public static final String FIELD_TITLE = "title";
	public static final String FIELD_URL = "url";
	
	private Date date;
	private String explanation;
	private String hdurl;
	private String mediaType;
	private String serviceVersion;
	private String title;
	private String url;
	
	public APODResponse() {
		
	}
	
	public APODResponse(Integer responseCode, Date date, String explanation, String hdurl, String mediaType, String serviceVersion,
			String title, String url) {
		super();
		this.date = date;
		this.explanation = explanation;
		this.hdurl = hdurl;
		this.mediaType = mediaType;
		this.serviceVersion = serviceVersion;
		this.title = title;
		this.url = url;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public String getHdurl() {
		return hdurl;
	}
	public void setHdurl(String hdurl) {
		this.hdurl = hdurl;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public String getServiceVersion() {
		return serviceVersion;
	}
	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "APODResponse [responseCode=" + responseCode + ", date=" + date + ", explanation=" + explanation
				+ ", hdurl=" + hdurl + ", mediaType=" + mediaType + ", serviceVersion=" + serviceVersion + ", title="
				+ title + ", url=" + url + "]";
	}
	

}