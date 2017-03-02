package neo.lookup;

import org.json.JSONException;
import org.json.JSONObject;

public class Velocity {

	/* API-Dependent constants */
	private static final String FIELD_KILOMETERS_PER_SECOND = "kilometers_per_second";
	private static final String FIELD_KILOMETERS_PER_HOUR = "kilometers_per_hour";
	private static final String FIELD_MILES_PER_HOUR = "miles_per_hour";

	private Double kilometersPerSecond;
	private Double kilometersPerHour;
	private Double milesPerHour;

	public Velocity() {
	}

	public Velocity(Double kilometersPerSecond, Double kilometersPerHour, Double milesPerHour) {
		super();
		this.kilometersPerSecond = kilometersPerSecond;
		this.kilometersPerHour = kilometersPerHour;
		this.milesPerHour = milesPerHour;
	}

	public Double getKilometersPerSecond() {
		return kilometersPerSecond;
	}

	public void setKilometersPerSecond(Double kilometersPerSecond) {
		this.kilometersPerSecond = kilometersPerSecond;
	}

	public Double getKilometersPerHour() {
		return kilometersPerHour;
	}

	public void setKilometersPerHour(Double kilometersPerHour) {
		this.kilometersPerHour = kilometersPerHour;
	}

	public Double getMilesPerHour() {
		return milesPerHour;
	}

	public void setMilesPerHour(Double milesPerHour) {
		this.milesPerHour = milesPerHour;
	}

	public void parse(JSONObject jobj) throws NumberFormatException, JSONException {
		kilometersPerSecond = Double.valueOf(jobj.getString(Velocity.FIELD_KILOMETERS_PER_SECOND));
		kilometersPerHour = Double.valueOf(jobj.getString(Velocity.FIELD_KILOMETERS_PER_HOUR));
		milesPerHour = Double.valueOf(jobj.getString(Velocity.FIELD_MILES_PER_HOUR));
	}

}
