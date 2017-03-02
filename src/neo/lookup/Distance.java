package neo.lookup;

import org.json.JSONException;
import org.json.JSONObject;

public class Distance {
	
	/* API-Dependent constants */
	private static final String PARAM_ASTRONOMICAL = "astronomical";
	private static final String PARAM_LUNAR = "lunar";
	private static final String PARAM_KILOMETERS = "kilometers";
	private static final String PARAM_MILES = "miles";
	
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
	
	public boolean parse(JSONObject jobj) {
		try {
			astronomical = Double.valueOf(jobj.getString(Distance.PARAM_ASTRONOMICAL));
			kilometers = Double.valueOf(jobj.getString(Distance.PARAM_KILOMETERS));
			lunar = Double.valueOf(jobj.getString(Distance.PARAM_LUNAR));
			miles = Double.valueOf(jobj.getString(Distance.PARAM_MILES));
		} catch (JSONException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
