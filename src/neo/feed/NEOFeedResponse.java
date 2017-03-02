package neo.feed;

import org.json.JSONException;
import org.json.JSONObject;

import util.GenericResponse;

public class NEOFeedResponse extends GenericResponse {

	/* API-Dependent constants */
	public static final String FIELD_CODE = "code";
	// TODO: Inserire i nomi degli altri campi!

	// TODO: Inserire gli attributi!

	public NEOFeedResponse() {

	}

	@Override
	public void fillObject() {
		try {
			System.out.println(rawResponse);
			JSONObject jobj = new JSONObject(rawResponse);
			// TODO: Inserire il filling dei campi della risposta!
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}