package allianz.project.challenge.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * This is generic exception handler which wraps error details 
 * @return response entity with error details and HTTP status
 * 
 * @author harshada
 *
 */
@ControllerAdvice
public class GlobalExceptionCatcher extends ResponseEntityExceptionHandler {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(EmployeeNotFoundException ex, WebRequest request) {
		EmployeeErrorDetails errorDetails = new EmployeeErrorDetails(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		EmployeeErrorDetails errorDetails = new EmployeeErrorDetails(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}