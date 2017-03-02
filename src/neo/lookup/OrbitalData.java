package neo.lookup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class OrbitalData {

	/* API-Dependent constants */
	private static final String DATE_FORMAT = "yyyy-MM-d HH:mm:ss";
	private static final String PARAM_ORBIT_ID = "orbit_id";
	private static final String PARAM_ORBIT_DETERMINATION_DATE = "orbit_determination_date";
	private static final String PARAM_ORBIT_UNCERTAINTY = "orbit_uncertainty";
	private static final String PARAM_MINIMUM_ORBIT_INTERSECTION = "minimum_orbit_intersection";
	private static final String PARAM_JUPITER_TISSERAND_INVARIANT = "jupiter_tisserand_invariant";
	private static final String PARAM_EPOCH_OSCULATION = "epoch_osculation";
	private static final String PARAM_ECCENTRICITY = "eccentricity";
	private static final String PARAM_SEMI_MAJOR_AXIS = "semi_major_axis";
	private static final String PARAM_INCLINATION = "inclination";
	private static final String PARAM_ASCENDING_NODE_LONGITUDE = "ascending_node_longitude";
	private static final String PARAM_ORBITAL_PERIOD = "orbital_period";
	private static final String PARAM_PERIHELION_DISTANCE = "perihelion_distance";
	private static final String PARAM_PERIHELION_ARGUMENT = "perihelion_argument";
	private static final String PARAM_APHELION_DISTANCE = "aphelion_distance";
	private static final String PARAM_PERIHELION_TIME = "perihelion_time";
	private static final String PARAM_MEAN_ANOMALY = "mean_anomaly";
	private static final String PARAM_MEAN_MOTION = "mean_motion";
	private static final String PARAM_EQUINOX = "equinox";

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

	public OrbitalData(String orbitID, Date orbitDeterminationDate, Integer orbitUncertainty,
			Double minimumOrbitIntersection, Double jupiterTisserandInvariant, Double epochOsculation,
			Double eccentricity, Double semiMajorAxis, Double inclination, Double ascendingNodeLongitude,
			Double orbital_period, Double perihelionDistance, Double perihelionArgument, Double aphelionDistance,
			Double perihelionTime, Double meanAnomaly, Double meanMotion, String equinox) {
		this.orbitID = orbitID;
		this.orbitDeterminationDate = orbitDeterminationDate;
		this.orbitUncertainty = orbitUncertainty;
		this.minimumOrbitIntersection = minimumOrbitIntersection;
		this.jupiterTisserandInvariant = jupiterTisserandInvariant;
		this.epochOsculation = epochOsculation;
		this.eccentricity = eccentricity;
		this.semiMajorAxis = semiMajorAxis;
		this.inclination = inclination;
		this.ascendingNodeLongitude = ascendingNodeLongitude;
		this.orbital_period = orbital_period;
		this.perihelionDistance = perihelionDistance;
		this.perihelionArgument = perihelionArgument;
		this.aphelionDistance = aphelionDistance;
		this.perihelionTime = perihelionTime;
		this.meanAnomaly = meanAnomaly;
		this.meanMotion = meanMotion;
		this.equinox = equinox;
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
		orbitID = jobj.getString(OrbitalData.PARAM_ORBIT_ID);
		orbitDeterminationDate = sdf.parse(jobj.getString(OrbitalData.PARAM_ORBIT_DETERMINATION_DATE));
		orbitUncertainty = Integer.valueOf(jobj.getString(OrbitalData.PARAM_ORBIT_UNCERTAINTY));
		minimumOrbitIntersection = Double.valueOf(jobj.getString(OrbitalData.PARAM_MINIMUM_ORBIT_INTERSECTION));
		jupiterTisserandInvariant = Double.valueOf(jobj.getString(OrbitalData.PARAM_JUPITER_TISSERAND_INVARIANT));
		epochOsculation = Double.valueOf(jobj.getString(OrbitalData.PARAM_EPOCH_OSCULATION));
		eccentricity = Double.valueOf(jobj.getString(OrbitalData.PARAM_ECCENTRICITY));
		semiMajorAxis = Double.valueOf(jobj.getString(OrbitalData.PARAM_SEMI_MAJOR_AXIS));
		inclination = Double.valueOf(jobj.getString(OrbitalData.PARAM_INCLINATION));
		ascendingNodeLongitude = Double.valueOf(jobj.getString(OrbitalData.PARAM_ASCENDING_NODE_LONGITUDE));
		orbital_period = Double.valueOf(jobj.getString(OrbitalData.PARAM_ORBITAL_PERIOD));
		perihelionDistance = Double.valueOf(jobj.getString(OrbitalData.PARAM_PERIHELION_DISTANCE));
		perihelionArgument = Double.valueOf(jobj.getString(OrbitalData.PARAM_PERIHELION_ARGUMENT));
		aphelionDistance = Double.valueOf(jobj.getString(OrbitalData.PARAM_APHELION_DISTANCE));
		perihelionTime = Double.valueOf(jobj.getString(OrbitalData.PARAM_PERIHELION_TIME));
		meanAnomaly = Double.valueOf(jobj.getString(OrbitalData.PARAM_MEAN_ANOMALY));
		meanMotion = Double.valueOf(jobj.getString(OrbitalData.PARAM_MEAN_MOTION));
		equinox = jobj.getString(OrbitalData.PARAM_EQUINOX);
	}

}
