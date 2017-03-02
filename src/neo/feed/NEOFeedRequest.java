package neo.feed;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import util.Http;

public class NEOFeedRequest {

	/* API-Dependent constants */
	private static final String BASE_URL = "https://api.nasa.gov/neo/rest/v1/feed";
	private static final String DATE_FORMAT = "yyyy-M-d";
	private static final String PARAM_START_DATE = "start_date";
	private static final String PARAM_END_DATE = "end_date";
	private static final String PARAM_APIKEY = "api_key";

	/* Utility SimpleDateFormatter */
	private static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

	private Date startDate;
	private Date endDate;
	private String apiKey;

	public NEOFeedResponse send() throws Exception {

		NEOFeedResponse neoFeedResponse = new NEOFeedResponse();

		String formattedStartDate = sdf.format(startDate);
		String formattedEndDate = sdf.format(endDate);
		String queryString = BASE_URL;
		queryString += "?" + PARAM_APIKEY + "=" + apiKey;
		queryString += "&" + PARAM_START_DATE + "=" + formattedStartDate;
		queryString += "&" + PARAM_END_DATE + "=" + formattedEndDate;

		Http.sendGet(queryString, neoFeedResponse);

		switch(neoFeedResponse.getResponseCode()) {
			case(200):
				try {
					
					System.out.println(neoFeedResponse.getRawResponse());
					JSONObject jobj = new JSONObject(neoFeedResponse.getRawResponse());
					// TODO: Inserire il filling dei campi della risposta!
	
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

		return neoFeedResponse;
	}

}
