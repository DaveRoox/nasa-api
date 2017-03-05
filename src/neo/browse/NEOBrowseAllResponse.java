package neo.browse;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import neo.Links;
import util.Http;

public class NEOBrowseAllResponse extends NEOBrowseResponse {

	public NEOBrowseAllResponse() {
		super();
	}

	@Override
	public void fillObject() {
		try {
			super.fillObject(); // Page and Links are initialized to the corresponding elements of the first page
			this.nearEarthObjects = new ArrayList<>(page.getTotalElements());
			JSONObject jobj = jsonObject;
			Links links = this.links;
			boolean moreLinks;
			NEOBrowseResponse tmpResponse = new NEOBrowseResponse();
			for(int nPage = page.getNumber() + 1; nPage < page.getTotalPages(); nPage++) {
				JSONArray jarr = jobj.getJSONArray(NEOBrowseResponse.FIELD_NEAR_EARTH_OBJECTS);
				this.fillNearEarthObjectsList(jarr);
				String nextLink = links.getNext();
				moreLinks = !nextLink.equals("");
				if(!moreLinks) {
					System.out.println("ESCO!");
					break;
				}
				System.out.println("Richiesta alla pagina #" + nPage + ": " + nextLink);
				Http.sendGet(nextLink, tmpResponse);
				jobj = tmpResponse.getJsonObject();
				links = tmpResponse.links;
			}
		} catch (JSONException | ParseException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void fillObjects() {
		// MUST be empty!
	}

}
