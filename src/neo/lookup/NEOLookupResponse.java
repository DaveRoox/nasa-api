package neo.lookup;

import java.text.ParseException;

import org.json.JSONException;

import neo.Links;
import neo.NearEarthObject;
import util.GenericResponse;

public class NEOLookupResponse extends GenericResponse {

	/* API-Dependent constants */
	private static final String FIELD_LINKS = "links";

	private NearEarthObject nearEarthObject;
	private Links links;

	public NEOLookupResponse() {
	}

	public NearEarthObject getNearEarthObject() {
		return nearEarthObject;
	}

	public void setNearEarthObject(NearEarthObject nearEarthObject) {
		this.nearEarthObject = nearEarthObject;
	}

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

	@Override
	public void fillObject() {
		try {
			if(nearEarthObject == null)
				nearEarthObject = new NearEarthObject();
			nearEarthObject.parse(jsonObject);

			if(jsonObject.has(FIELD_LINKS)) {
				if(links == null)
					links = new Links();
				links.parse(jsonObject.getJSONObject(FIELD_LINKS));
			}
		} catch (JSONException | ParseException e) {
			e.printStackTrace();
		}
	}

}
