package neo;

import org.json.JSONException;
import org.json.JSONObject;

public class EstimatedDiameter {

	/* API-Dependent constants */
	private static final String FIELD_ESTIMATED_DIAMETER_MIN = "estimated_diameter_min";
	private static final String FIELD_ESTIMATED_DIAMETER_MAX = "estimated_diameter_max";

	private UnitOfMeasurement unitOfMeasurement;
	private Double estimatedDiameterMin;
	private Double estimatedDiameterMax;

	public EstimatedDiameter() {
	}

	public UnitOfMeasurement getUnitOfMeasurement() {
		return unitOfMeasurement;
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

	public void parse(JSONObject jobj, UnitOfMeasurement unitOfMeasurement) throws JSONException {

		if(jobj.has(unitOfMeasurement.getValue())) {
			
			this.unitOfMeasurement = unitOfMeasurement;
			
			JSONObject subObj = jobj.getJSONObject(unitOfMeasurement.getValue());

			if(subObj.has(FIELD_ESTIMATED_DIAMETER_MAX))
				estimatedDiameterMax = subObj.getDouble(FIELD_ESTIMATED_DIAMETER_MAX);

			if(subObj.has(FIELD_ESTIMATED_DIAMETER_MIN))
				estimatedDiameterMin = subObj.getDouble(FIELD_ESTIMATED_DIAMETER_MIN);
		}
	}

}
