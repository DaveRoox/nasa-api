package neo.lookup;

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

	public Distance(Double astronomical, Double lunar, Double kilometers, Double miles) {
		super();
		this.astronomical = astronomical;
		this.lunar = lunar;
		this.kilometers = kilometers;
		this.miles = miles;
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
		astronomical = Double.valueOf(jobj.getString(Distance.FIELD_ASTRONOMICAL));
		kilometers = Double.valueOf(jobj.getString(Distance.FIELD_KILOMETERS));
		lunar = Double.valueOf(jobj.getString(Distance.FIELD_LUNAR));
		miles = Double.valueOf(jobj.getString(Distance.FIELD_MILES));
	}

}
