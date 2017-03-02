package neo.lookup;

import java.util.ArrayList;
import java.util.List;

import util.RawResponse;

public class NEOLookupResponse  extends RawResponse {
	
	/* API-Dependent constants */
	public static final String FIELD_NEO_REFERENCE_ID = "neo_reference_id";
	public static final String FIELD_NAME = "name";
	public static final String FIELD_NASA_JPL_URL = "nasa_jpl_url";
	public static final String FIELD_ABSOLUTE_MAGNITUDE_H = "absolute_magnitude_h";
	public static final String FIELD_ESTIMATED_DIAMETER = "estimated_diameter";
	public static final String FIELD_IS_POTENTIALLY_HAZARDOUS_ASTEROID = "is_potentially_hazardous_asteroid";
	public static final String FIELD_CLOSE_APPROACH_DATA = "close_approach_data";
	public static final String FIELD_ORBITAL_DATA = "orbital_data";
	
	private String neoReferenceID;
	private String name;
	private String nasaJplUrl;
	private Double absoluteMagnitudeH;
	private List<EstimatedDiameter> estimatedDiameter;
	private Boolean isPotentiallyHazardousAsteroid;
	private List<CloseApproachItem> closeApproachData;
	private OrbitalData orbitalData;
	
	public NEOLookupResponse() {
		estimatedDiameter = new ArrayList<>();
		closeApproachData = new ArrayList<>();
	}

	public NEOLookupResponse(Integer responseCode, String rawResponse, String neoReferenceID, String name,
			String nasaJplUrl, Double absoluteMagnitudeH, List<EstimatedDiameter> estimatedDiameter,
			Boolean isPotentiallyHazardousAsteroid, List<CloseApproachItem> closeApproachData,
			OrbitalData orbitalData) {
		super(responseCode, rawResponse);
		this.neoReferenceID = neoReferenceID;
		this.name = name;
		this.nasaJplUrl = nasaJplUrl;
		this.absoluteMagnitudeH = absoluteMagnitudeH;
		this.estimatedDiameter = estimatedDiameter;
		this.isPotentiallyHazardousAsteroid = isPotentiallyHazardousAsteroid;
		this.closeApproachData = closeApproachData;
		this.orbitalData = orbitalData;
	}

	public String getNeoReferenceID() {
		return neoReferenceID;
	}

	public void setNeoReferenceID(String neoReferenceID) {
		this.neoReferenceID = neoReferenceID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNasaJplUrl() {
		return nasaJplUrl;
	}

	public void setNasaJplUrl(String nasaJplUrl) {
		this.nasaJplUrl = nasaJplUrl;
	}

	public Double getAbsoluteMagnitudeH() {
		return absoluteMagnitudeH;
	}

	public void setAbsoluteMagnitudeH(Double absoluteMagnitudeH) {
		this.absoluteMagnitudeH = absoluteMagnitudeH;
	}

	public List<EstimatedDiameter> getEstimatedDiameter() {
		return estimatedDiameter;
	}

	public void setEstimatedDiameter(List<EstimatedDiameter> estimatedDiameter) {
		this.estimatedDiameter = estimatedDiameter;
	}

	public Boolean getIsPotentiallyHazardousAsteroid() {
		return isPotentiallyHazardousAsteroid;
	}

	public void setIsPotentiallyHazardousAsteroid(Boolean isPotentiallyHazardousAsteroid) {
		this.isPotentiallyHazardousAsteroid = isPotentiallyHazardousAsteroid;
	}

	public List<CloseApproachItem> getCloseApproachData() {
		return closeApproachData;
	}

	public void setCloseApproachData(List<CloseApproachItem> closeApproachData) {
		this.closeApproachData = closeApproachData;
	}

	public OrbitalData getOrbitalData() {
		return orbitalData;
	}

	public void setOrbitalData(OrbitalData orbitalData) {
		this.orbitalData = orbitalData;
	}

}
