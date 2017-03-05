package neo.browse;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import neo.Links;
import neo.NearEarthObject;
import neo.Page;
import util.GenericResponse;

public class NEOBrowseResponse extends GenericResponse {

	/* API-Dependent constants */
	protected static final String FIELD_LINKS = "links";
	protected static final String FIELD_PAGE = "page";
	protected static final String FIELD_NEAR_EARTH_OBJECTS = "near_earth_objects";

	protected Links links;
	protected Page page;
	protected List<NearEarthObject> nearEarthObjects;

	public NEOBrowseResponse() {
	}

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<NearEarthObject> getNearEarthObjects() {
		return nearEarthObjects;
	}

	public void setNearEarthObjects(List<NearEarthObject> nearEarthObjects) {
		this.nearEarthObjects = nearEarthObjects;
	}

	@Override
	public void fillObject() {

		try {

			if(jsonObject.has(FIELD_LINKS)) {
				if(links == null)
					links = new Links();
				links.parse(jsonObject.getJSONObject(FIELD_LINKS));
			}

			if(jsonObject.has(FIELD_PAGE)) {
				if(page == null)
					page = new Page();
				page.parse(jsonObject.getJSONObject(FIELD_PAGE));
			}

			if(jsonObject.has(FIELD_NEAR_EARTH_OBJECTS)) {
				JSONArray jarr = jsonObject.getJSONArray(FIELD_NEAR_EARTH_OBJECTS);
				nearEarthObjects = new ArrayList<>(jarr.length());
				for(int i = 0; i < jarr.length(); i++) {
					NearEarthObject nearEarthObject = new NearEarthObject(); 
					nearEarthObject.parse(jarr.getJSONObject(i));
					nearEarthObjects.add(nearEarthObject);
				}
			}

		} catch (JSONException | ParseException e) {
			e.printStackTrace();
		}

	}

}
