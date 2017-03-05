package neo;

import org.json.JSONException;
import org.json.JSONObject;

public class Page {

	/* API-Dependent constants */
	private static final String FIELD_SIZE = "size";
	private static final String FIELD_TOTAL_ELEMENTS = "total_elements";
	private static final String FIELD_TOTAL_PAGES = "total_pages";
	private static final String FIELD_NUMBER = "number";

	private Integer size;
	private Integer totalElements;
	private Integer totalPages;
	private Integer number;

	public Page() {
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Integer totalElements) {
		this.totalElements = totalElements;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public void parse(JSONObject jsonObject) throws JSONException {

		if(jsonObject.has(FIELD_NUMBER))
			number = jsonObject.getInt(FIELD_NUMBER);

		if(jsonObject.has(FIELD_SIZE))
			size = jsonObject.getInt(FIELD_SIZE);

		if(jsonObject.has(FIELD_TOTAL_ELEMENTS))
			totalElements = jsonObject.getInt(FIELD_TOTAL_ELEMENTS);

		if(jsonObject.has(FIELD_TOTAL_PAGES))
			totalPages = jsonObject.getInt(FIELD_TOTAL_PAGES);

	}

}
