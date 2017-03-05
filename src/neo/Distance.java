package neo;

import org.json.JSONException;
import org.json.JSONObject;

public class Distance {

	/* API-Dependent constants */
	private static final String FIELD_ASTRONOMICAL = "astronomical";
	private static final String FIELD_LUNAR = "lunar";
	private static final String FIELD_KILOMETERS = "kilometers";
	private static final String FIELD_MILES = "miles";

	private Double astronomical;
	private Double lunar;
	private Double kilometers;
	private Double miles;

	public Distance() {
	}

	public Double getAstronomical() {
		return astronomical;
	}

	public void setAstronomical(Double astronomical) {
		this.astronomical = astronomical;
	}

	public Double getLunar() {
		return lunar;
	}

	public void setLunar(Double lunar) {
		this.lunar = lunar;
	}

	public Double getKilometers() {
		return kilometers;
	}

	public void setKilometers(Double kilometers) {
		this.kilometers = kilometers;
	}

	public Double getMiles() {
		return miles;
	}

	public void setMiles(Double miles) {
		this.miles = miles;
	}

	public void parse(JSONObject jobj) throws NumberFormatException, JSONException {

		if(jobj.has(FIELD_ASTRONOMICAL))
			astronomical = Double.valueOf(jobj.getString(FIELD_ASTRONOMICAL));

		if(jobj.has(FIELD_KILOMETERS))
			kilometers = Double.valueOf(jobj.getString(FIELD_KILOMETERS));

		if(jobj.has(FIELD_LUNAR))
			lunar = Double.valueOf(jobj.getString(FIELD_LUNAR));

		if(jobj.has(FIELD_MILES))
			miles = Double.valueOf(jobj.getString(FIELD_MILES));
	}

}
