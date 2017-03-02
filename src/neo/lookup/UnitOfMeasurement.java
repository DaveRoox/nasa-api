package neo.lookup;

public enum UnitOfMeasurement {
	
	KILOMETERS("kilometers"),
	METERS("meters"),
	MILES("miles"),
	FEET("feet");
	
	private String value;
	
	UnitOfMeasurement(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
}