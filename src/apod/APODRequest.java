package apod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import util.GenericRequest;
import util.GenericResponse;

public class APODRequest extends GenericRequest {

	/* API-Dependent constants */
	private static final String BASE_URL = "https://api.nasa.gov/planetary/apod";
	private static final String BASE_STRING_DATE = "1995-6-16";
	private static final String DATE_FORMAT = "yyyy-MM-dd";
	private static final String PARAM_DATE = "date";
	private static final String PARAM_HD = "hd";

	/* Utility SimpleDateFormatter */
	public static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

	private static Date BASE_DATE = null;

	private Date date;
	private Boolean hd;

	static {
		try {
			BASE_DATE = sdf.parse(BASE_STRING_DATE);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private APODRequest(Date date, Boolean hd, String apiKey) throws BadDateFormatException, ParseException {
		
		super(apiKey);
		date = sdf.parse(sdf.format(date));

		if(date.before(BASE_DATE))
			throw new BadDateFormatException();

		this.hd = hd;
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

	@Override
	public GenericResponse newResponse() {
		return new APODResponse();
	}

	@Override
	public String getQueryString() {
		String formattedDate = sdf.format(date);
		String queryString = BASE_URL;
		queryString += "?" + PARAM_APIKEY + "=" + apiKey;
		queryString += "&" + PARAM_HD + "=" + hd;
		queryString += "&" + PARAM_DATE + "=" + formattedDate;
		return queryString;
	}

}
