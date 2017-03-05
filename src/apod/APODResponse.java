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
			
			if(jsonObject.has(FIELD_DATE))
				date = sdf.parse(jsonObject.getString(FIELD_DATE));
			
			if(jsonObject.has(FIELD_EXPLANATION))
				explanation = jsonObject.getString(FIELD_EXPLANATION);
			
			if(jsonObject.has(FIELD_HDURL))
				hdurl = jsonObject.getString(FIELD_HDURL);
			
			if(jsonObject.has(FIELD_MEDIA_TYPE))
				mediaType = jsonObject.getString(FIELD_MEDIA_TYPE);
			
			if(jsonObject.has(FIELD_SERVICE_VERSION))
				serviceVersion = jsonObject.getString(FIELD_SERVICE_VERSION);
			
			if(jsonObject.has(FIELD_TITLE))
				title = jsonObject.getString(FIELD_TITLE);
			
			if(jsonObject.has(FIELD_URL))
				url = jsonObject.getString(FIELD_URL);
			
		} catch (JSONException | ParseException e) {
			e.printStackTrace();
		}
	}
	

}
