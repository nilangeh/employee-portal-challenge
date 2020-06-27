package allianz.project.challenge.employee.exception;

/**
 * 
 * This class is used to display error details with message and error codes
 * 
 * @author harshada
 *
 */


public class EmployeeErrorDetails {

	private String message;
	private String errorCode;

	public EmployeeErrorDetails( String message, String errorCode) {
		super();
		
		this.message = message;
		this.errorCode = errorCode;
	}


	public String getMessage() {
		return message;
	}

	public String getErrorCode() {
		return errorCode;
	}
}