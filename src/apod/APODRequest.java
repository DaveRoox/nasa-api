package apod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import util.Http;

public class APODRequest {

	/* API-Dependent constants */
	private static final String BASE_URL = "https://api.nasa.gov/planetary/apod";
	private static final String BASE_STRING_DATE = "1995-6-16";
	private static final String DATE_FORMAT = "yyyy-M-d";
	private static final String PARAM_DATE = "date";
	private static final String PARAM_HD = "hd";
	private static final String PARAM_APIKEY = "api_key";

	/* Utility SimpleDateFormatter */
	private static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

	private static Date BASE_DATE = null;

	private Date date;
	private Boolean hd;
	private String apiKey;

	static {
		try {
			BASE_DATE = sdf.parse(BASE_STRING_DATE);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private APODRequest(Date date, Boolean hd, String apiKey) throws BadDateFormatException, ParseException {

		date = sdf.parse(sdf.format(date));

		if(date.before(BASE_DATE))
			throw new BadDateFormatException();

		this.hd = hd;
		this.apiKey = apiKey;
		this.date = date;
	}
	
	public APODRequest(Integer year, Integer month, Integer day, Boolean hd, String apiKey) throws BadDateFormatException, ParseException {
		// TODO: trovare un modo per scrivere in automatico la stringa giusta che rispetti il formato!
		this(sdf.parse("" + year + "-" + month + "-" + day), hd, apiKey);
	}

	public APODRequest(Boolean hd, String apiKey) throws BadDateFormatException, ParseException {
		this(sdf.parse(sdf.format(new Date())), hd, apiKey);
	}

	public APODRequest(String date, Boolean hd, String apiKey) throws BadDateFormatException, ParseException {
		this(sdf.parse(date), hd, apiKey);
	}

	public APODResponse send() throws Exception {

		APODResponse apodResponse = new APODResponse();

		String formattedDate = sdf.format(date);
		String queryString = BASE_URL;
		queryString += "?" + PARAM_APIKEY + "=" + apiKey;
		queryString += "&" + PARAM_HD + "=" + hd;
		queryString += "&" + PARAM_DATE + "=" + formattedDate;

		Http.sendGet(queryString, apodResponse);

		switch(apodResponse.getResponseCode()) {
			case(200):
				try {
					
					System.out.println(apodResponse.getRawResponse());
					JSONObject jobj = new JSONObject(apodResponse.getRawResponse());
					apodResponse.setDate(sdf.parse(jobj.getString(APODResponse.FIELD_DATE)));
					apodResponse.setExplanation(jobj.getString(APODResponse.FIELD_EXPL));
					apodResponse.setHdurl(jobj.getString(APODResponse.FIELD_HDURL));
					apodResponse.setMediaType(jobj.getString(APODResponse.FIELD_MEDIA_TYPE));
					apodResponse.setServiceVersion(jobj.getString(APODResponse.FIELD_SERVICE_VERSION));
					apodResponse.setTitle(jobj.getString(APODResponse.FIELD_TITLE));
					apodResponse.setUrl(jobj.getString(APODResponse.FIELD_URL));
	
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

		return apodResponse;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Boolean getHd() {
		return hd;
	}
	public void setHd(Boolean hd) {
		this.hd = hd;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

}
