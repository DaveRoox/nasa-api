package apod;

public class BadDateFormatException extends Exception {

	private static final long serialVersionUID = 2080073606897235751L;
	private static final String MSG = "Invalid date. Date must be between Jun 16, 1995 and today.";
	
	public BadDateFormatException() {
		super();
	}
	
	@Override
	public String getMessage() {
		return MSG;
	}
	
}
