package neo;

import org.json.JSONException;
import org.json.JSONObject;

public class Links {

	/* API-Dependent constants */
	private static final String FIELD_SELF = "self";
	private static final String FIELD_NEXT = "next";
	private static final String FIELD_PREV = "prev";

	private String self;
	private String next;
	private String prev;

	public Links() {
	}

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrev() {
		return prev;
	}

	public void setPrev(String prev) {
		this.prev = prev;
	}

	public void parse(JSONObject jsonObject) throws JSONException {

		if(jsonObject.has(FIELD_SELF))
			self = jsonObject.getString(FIELD_SELF);

		if(jsonObject.has(FIELD_NEXT))
			next = jsonObject.getString(FIELD_NEXT);

		if(jsonObject.has(FIELD_PREV))
			prev = jsonObject.getString(FIELD_PREV);
	}

}
