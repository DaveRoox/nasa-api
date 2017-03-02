package neo.lookup;

public enum Velocity {
	
	KILOMETERS_PER_SECOND("kilometers_per_second"),
	KILOMETERS_PER_HOUR("kilometers_per_hour"),
	MILES_PER_HOUR("miles_per_hour");
	
	private String value;
	
	Velocity(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
