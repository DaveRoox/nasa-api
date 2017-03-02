package neo.lookup;

public enum Distance {
	
	ASTRONOMICAL("astronomical"),
	LUNAR("lunar"),
	KILOMETERS("kilometers"),
	MILES("miles");
	
	private String value;
	
	Distance(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
