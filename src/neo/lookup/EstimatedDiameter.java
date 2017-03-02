package neo.lookup;

import org.json.JSONException;
import org.json.JSONObject;

public class EstimatedDiameter {

	/* API-Dependent constants */
	private static final String PARAM_ESTIMATED_DIAMETER_MIN = "estimated_diameter_min";
	private static final String PARAM_ESTIMATED_DIAMETER_MAX = "estimated_diameter_max";

	private UnitOfMeasurement unitOfMeasurement;
	private Double estimatedDiameterMin;
	private Double estimatedDiameterMax;

	public EstimatedDiameter() {
	}

	public EstimatedDiameter(UnitOfMeasurement unitOfMeasurement, Double estimatedDiameterMin,
			Double estimatedDiameterMax) {
		super();
		this.unitOfMeasurement = unitOfMeasurement;
		this.estimatedDiameterMin = estimatedDiameterMin;
		this.estimatedDiameterMax = estimatedDiameterMax;
	}

	public UnitOfMeasurement getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	public void parse(JSONObject jobj) throws JSONException {

		if(unitOfMeasurement == null)
			return;

		estimatedDiameterMax = jobj.getDouble(PARAM_ESTIMATED_DIAMETER_MAX);
		estimatedDiameterMin = jobj.getDouble(PARAM_ESTIMATED_DIAMETER_MIN);
	}

	public void setUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}

	public Double getEstimatedDiameterMin() {
		return estimatedDiameterMin;
	}

	public void setEstimatedDiameterMin(Double estimatedDiameterMin) {
		this.estimatedDiameterMin = estimatedDiameterMin;
	}

	public Double getEstimatedDiameterMax() {
		return estimatedDiameterMax;
	}

	public void setEstimatedDiameterMax(Double estimatedDiameterMax) {
		this.estimatedDiameterMax = estimatedDiameterMax;
	}

}
