package neo.feed;

import java.text.SimpleDateFormat;
import java.util.Date;

import util.GenericRequest;
import util.GenericResponse;

public class NEOFeedRequest extends GenericRequest {

	/* API-Dependent constants */
	private static final String BASE_URL = "https://api.nasa.gov/neo/rest/v1/feed";
	private static final String DATE_FORMAT = "yyyy-M-d";
	private static final String PARAM_START_DATE = "start_date";
	private static final String PARAM_END_DATE = "end_date";

	/* Utility SimpleDateFormatter */
	private static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

	private Date startDate;
	private Date endDate;
	
	protected NEOFeedRequest(String apiKey) {
		super(apiKey);
	}

	@Override
	public GenericResponse newResponse() {
		return new NEOFeedResponse();
	}

	@Override
	public String getQueryString() {
		String formattedStartDate = sdf.format(startDate);
		String formattedEndDate = sdf.format(endDate);
		String queryString = BASE_URL;
		queryString += "?" + PARAM_APIKEY + "=" + apiKey;
		queryString += "&" + PARAM_START_DATE + "=" + formattedStartDate;
		queryString += "&" + PARAM_END_DATE + "=" + formattedEndDate;
		return queryString;
	}

}
