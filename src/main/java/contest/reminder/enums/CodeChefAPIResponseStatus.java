package contest.reminder.enums;

public enum CodeChefAPIResponseStatus {

	OK("OK"),
	NO_AUTHORIZATION("NO AUTHORIZATION");
	
	private String message;
	
	private CodeChefAPIResponseStatus(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
