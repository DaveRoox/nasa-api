package neo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class OrbitalData {

	/* API-Dependent constants */
	private static final String DATE_FORMAT = "yyyy-MM-d HH:mm:ss";
	private static final String FIELD_ORBIT_ID = "orbit_id";
	private static final String FIELD_ORBIT_DETERMINATION_DATE = "orbit_determination_date";
	private static final String FIELD_ORBIT_UNCERTAINTY = "orbit_uncertainty";
	private static final String FIELD_MINIMUM_ORBIT_INTERSECTION = "minimum_orbit_intersection";
	private static final String FIELD_JUPITER_TISSERAND_INVARIANT = "jupiter_tisserand_invariant";
	private static final String FIELD_EPOCH_OSCULATION = "epoch_osculation";
	private static final String FIELD_ECCENTRICITY = "eccentricity";
	private static final String FIELD_SEMI_MAJOR_AXIS = "semi_major_axis";
	private static final String FIELD_INCLINATION = "inclination";
	private static final String FIELD_ASCENDING_NODE_LONGITUDE = "ascending_node_longitude";
	private static final String FIELD_ORBITAL_PERIOD = "orbital_period";
	private static final String FIELD_PERIHELION_DISTANCE = "perihelion_distance";
	private static final String FIELD_PERIHELION_ARGUMENT = "perihelion_argument";
	private static final String FIELD_APHELION_DISTANCE = "aphelion_distance";
	private static final String FIELD_PERIHELION_TIME = "perihelion_time";
	private static final String FIELD_MEAN_ANOMALY = "mean_anomaly";
	private static final String FIELD_MEAN_MOTION = "mean_motion";
	private static final String FIELD_EQUINOX = "equinox";

	/* Utility SimpleDateFormatter */
	private static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

	private String orbitID;
	private Date orbitDeterminationDate;
	private Integer orbitUncertainty; // oppure Double?
	private Double minimumOrbitIntersection;
	private Double jupiterTisserandInvariant;
	private Double epochOsculation;
	private Double eccentricity;
	private Double semiMajorAxis;
	private Double inclination;
	private Double ascendingNodeLongitude;
	private Double orbital_period;
	private Double perihelionDistance;
	private Double perihelionArgument;
	private Double aphelionDistance;
	private Double perihelionTime;
	private Double meanAnomaly;
	private Double meanMotion;
	private String equinox;

	public OrbitalData() {
	}

	public static SimpleDateFormat getSdf() {
		return sdf;
	}

	public static void setSdf(SimpleDateFormat sdf) {
		OrbitalData.sdf = sdf;
	}

	public String getOrbitID() {
		return orbitID;
	}

	public void setOrbitID(String orbitID) {
		this.orbitID = orbitID;
	}

	public Date getOrbitDeterminationDate() {
		return orbitDeterminationDate;
	}

	public void setOrbitDeterminationDate(Date orbitDeterminationDate) {
		this.orbitDeterminationDate = orbitDeterminationDate;
	}

	public Integer getOrbitUncertainty() {
		return orbitUncertainty;
	}

	public void setOrbitUncertainty(Integer orbitUncertainty) {
		this.orbitUncertainty = orbitUncertainty;
	}

	public Double getMinimumOrbitIntersection() {
		return minimumOrbitIntersection;
	}

	public void setMinimumOrbitIntersection(Double minimumOrbitIntersection) {
		this.minimumOrbitIntersection = minimumOrbitIntersection;
	}

	public Double getJupiterTisserandInvariant() {
		return jupiterTisserandInvariant;
	}

	public void setJupiterTisserandInvariant(Double jupiterTisserandInvariant) {
		this.jupiterTisserandInvariant = jupiterTisserandInvariant;
	}

	public Double getEpochOsculation() {
		return epochOsculation;
	}

	public void setEpochOsculation(Double epochOsculation) {
		this.epochOsculation = epochOsculation;
	}

	public Double getEccentricity() {
		return eccentricity;
	}

	public void setEccentricity(Double eccentricity) {
		this.eccentricity = eccentricity;
	}

	public Double getSemiMajorAxis() {
		return semiMajorAxis;
	}

	public void setSemiMajorAxis(Double semiMajorAxis) {
		this.semiMajorAxis = semiMajorAxis;
	}

	public Double getInclination() {
		return inclination;
	}

	public void setInclination(Double inclination) {
		this.inclination = inclination;
	}

	public Double getAscendingNodeLongitude() {
		return ascendingNodeLongitude;
	}

	public void setAscendingNodeLongitude(Double ascendingNodeLongitude) {
		this.ascendingNodeLongitude = ascendingNodeLongitude;
	}

	public Double getOrbital_period() {
		return orbital_period;
	}

	public void setOrbital_period(Double orbital_period) {
		this.orbital_period = orbital_period;
	}

	public Double getPerihelionDistance() {
		return perihelionDistance;
	}

	public void setPerihelionDistance(Double perihelionDistance) {
		this.perihelionDistance = perihelionDistance;
	}

	public Double getPerihelionArgument() {
		return perihelionArgument;
	}

	public void setPerihelionArgument(Double perihelionArgument) {
		this.perihelionArgument = perihelionArgument;
	}

	public Double getAphelionDistance() {
		return aphelionDistance;
	}

	public void setAphelionDistance(Double aphelionDistance) {
		this.aphelionDistance = aphelionDistance;
	}

	public Double getPerihelionTime() {
		return perihelionTime;
	}

	public void setPerihelionTime(Double perihelionTime) {
		this.perihelionTime = perihelionTime;
	}

	public Double getMeanAnomaly() {
		return meanAnomaly;
	}

	public void setMeanAnomaly(Double meanAnomaly) {
		this.meanAnomaly = meanAnomaly;
	}

	public Double getMeanMotion() {
		return meanMotion;
	}

	public void setMeanMotion(Double meanMotion) {
		this.meanMotion = meanMotion;
	}

	public String getEquinox() {
		return equinox;
	}

	public void setEquinox(String equinox) {
		this.equinox = equinox;
	}

	public void parse(JSONObject jobj) throws JSONException, ParseException {

		if(jobj.has(FIELD_ORBIT_ID))
			orbitID = jobj.getString(FIELD_ORBIT_ID);

		if(jobj.has(FIELD_ORBIT_DETERMINATION_DATE))
			orbitDeterminationDate = sdf.parse(jobj.getString(FIELD_ORBIT_DETERMINATION_DATE));

		if(jobj.has(FIELD_ORBIT_UNCERTAINTY))
			orbitUncertainty = Integer.valueOf(jobj.getString(FIELD_ORBIT_UNCERTAINTY));

		if(jobj.has(FIELD_MINIMUM_ORBIT_INTERSECTION))
			minimumOrbitIntersection = Double.valueOf(jobj.getString(FIELD_MINIMUM_ORBIT_INTERSECTION));

		if(jobj.has(FIELD_JUPITER_TISSERAND_INVARIANT))
			jupiterTisserandInvariant = Double.valueOf(jobj.getString(FIELD_JUPITER_TISSERAND_INVARIANT));

		if(jobj.has(FIELD_EPOCH_OSCULATION))
			epochOsculation = Double.valueOf(jobj.getString(FIELD_EPOCH_OSCULATION));

		if(jobj.has(FIELD_ECCENTRICITY))
			eccentricity = Double.valueOf(jobj.getString(FIELD_ECCENTRICITY));

		if(jobj.has(FIELD_SEMI_MAJOR_AXIS))
			semiMajorAxis = Double.valueOf(jobj.getString(FIELD_SEMI_MAJOR_AXIS));

		if(jobj.has(FIELD_INCLINATION))
			inclination = Double.valueOf(jobj.getString(FIELD_INCLINATION));

		if(jobj.has(FIELD_ASCENDING_NODE_LONGITUDE))
			ascendingNodeLongitude = Double.valueOf(jobj.getString(FIELD_ASCENDING_NODE_LONGITUDE));

		if(jobj.has(FIELD_ORBITAL_PERIOD))
			orbital_period = Double.valueOf(jobj.getString(FIELD_ORBITAL_PERIOD));

		if(jobj.has(FIELD_PERIHELION_DISTANCE))
			perihelionDistance = Double.valueOf(jobj.getString(FIELD_PERIHELION_DISTANCE));

		if(jobj.has(FIELD_PERIHELION_ARGUMENT))
			perihelionArgument = Double.valueOf(jobj.getString(FIELD_PERIHELION_ARGUMENT));

		if(jobj.has(FIELD_APHELION_DISTANCE))
			aphelionDistance = Double.valueOf(jobj.getString(FIELD_APHELION_DISTANCE));

		if(jobj.has(FIELD_PERIHELION_TIME))
			perihelionTime = Double.valueOf(jobj.getString(FIELD_PERIHELION_TIME));

		if(jobj.has(FIELD_MEAN_ANOMALY))
			meanAnomaly = Double.valueOf(jobj.getString(FIELD_MEAN_ANOMALY));

		if(jobj.has(FIELD_MEAN_MOTION))
			meanMotion = Double.valueOf(jobj.getString(FIELD_MEAN_MOTION));

		if(jobj.has(FIELD_EQUINOX))
			equinox = jobj.getString(FIELD_EQUINOX);
		
	}

}
