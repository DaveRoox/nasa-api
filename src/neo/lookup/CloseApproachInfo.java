package neo.lookup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class CloseApproachInfo {

	/* API-Dependent constants */
	private static final String DATE_FORMAT = "yyyy-MM-dd";
	private static final String FIELD_CLOSEST_APPROACH_DATE = "close_approach_date";
	private static final String FIELD_EPOCH_DATE_CLOSE_APPROACH = "epoch_date_close_approach";
	private static final String FIELD_RELATIVE_VELOCITY = "relative_velocity";
	private static final String FIELD_MISS_DISTANCE = "miss_distance";
	private static final String FIELD_ORBITING_BODY = "orbiting_body";

	/* Utility SimpleDateFormatter */
	private static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

	private Date closeApproachDate;
	private Long epochDateCloseApproach;
	private Velocity relativeVelocity;
	private Distance missDistance;
	private String orbitingBody;

	public CloseApproachInfo() {
	}

	public CloseApproachInfo(Date closeApproachDate, Long epochDateCloseApproach, Velocity relativeVelocity,
			Distance missDistance, String orbitingBody) {
		super();
		this.closeApproachDate = closeApproachDate;
		this.epochDateCloseApproach = epochDateCloseApproach;
		this.relativeVelocity = relativeVelocity;
		this.missDistance = missDistance;
		this.orbitingBody = orbitingBody;
	}

	public Date getCloseApproachDate() {
		return closeApproachDate;
	}

	public void setCloseApproachDate(Date closeApproachDate) {
		this.closeApproachDate = closeApproachDate;
	}

	public Long getEpochDateCloseApproach() {
		return epochDateCloseApproach;
	}

	public void setEpochDateCloseApproach(Long epochDateCloseApproach) {
		this.epochDateCloseApproach = epochDateCloseApproach;
	}

	public Velocity getRelativeVelocity() {
		return relativeVelocity;
	}

	public void setRelativeVelocity(Velocity relativeVelocity) {
		this.relativeVelocity = relativeVelocity;
	}

	public Distance getMissDistance() {
		return missDistance;
	}

	public void setMissDistance(Distance missDistance) {
		this.missDistance = missDistance;
	}

	public String getOrbitingBody() {
		return orbitingBody;
	}

	public void setOrbitingBody(String orbitingBody) {
		this.orbitingBody = orbitingBody;
	}
	
	public void parse(JSONObject jobj) throws ParseException, JSONException {
		
		closeApproachDate = sdf.parse(jobj.getString(CloseApproachInfo.FIELD_CLOSEST_APPROACH_DATE));
		epochDateCloseApproach = jobj.getLong(CloseApproachInfo.FIELD_EPOCH_DATE_CLOSE_APPROACH);
		
		JSONObject velocity = jobj.getJSONObject(CloseApproachInfo.FIELD_RELATIVE_VELOCITY);
		if(relativeVelocity == null)
			relativeVelocity = new Velocity();
		relativeVelocity.parse(velocity);
		
		JSONObject distance = jobj.getJSONObject(CloseApproachInfo.FIELD_MISS_DISTANCE);
		if(missDistance == null)
			missDistance = new Distance();
		missDistance.parse(distance);
		
		orbitingBody = jobj.getString(CloseApproachInfo.FIELD_ORBITING_BODY);
		
	}

}
