package apod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;

import util.GenericResponse;

public class APODResponse extends GenericResponse {
	
	/* API-Dependent constants */
	private static final String DATE_FORMAT = "yyyy-MM-dd";
	private static final String FIELD_DATE = "date";
	private static final String FIELD_EXPLANATION = "explanation";
	private static final String FIELD_HDURL = "hdurl";
	private static final String FIELD_MEDIA_TYPE = "media_type";
	private static final String FIELD_SERVICE_VERSION = "service_version";
	private static final String FIELD_TITLE = "title";
	private static final String FIELD_URL = "url";
	
	/* Utility SimpleDateFormatter */
	private static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	
	private Date date;
	private String explanation;
	private String hdurl;
	private String mediaType;
	private String serviceVersion;
	private String title;
	private String url;
	
	public APODResponse() {
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
	public void fillObject() {
		try {
			date = sdf.parse(jsonObject.getString(APODResponse.FIELD_DATE));
			explanation = jsonObject.getString(APODResponse.FIELD_EXPLANATION);
			hdurl = jsonObject.getString(APODResponse.FIELD_HDURL);
			mediaType = jsonObject.getString(APODResponse.FIELD_MEDIA_TYPE);
			serviceVersion = jsonObject.getString(APODResponse.FIELD_SERVICE_VERSION);
			title = jsonObject.getString(APODResponse.FIELD_TITLE);
			url = jsonObject.getString(APODResponse.FIELD_URL);
		} catch (JSONException | ParseException e) {
			e.printStackTrace();
		}
	}
	

}
