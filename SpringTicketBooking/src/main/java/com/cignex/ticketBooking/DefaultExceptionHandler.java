package com.cignex.ticketBooking;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler
	public final ResponseEntity<ErrorMessage> somethingWentWrong(Exception ex){
		ErrorMessage exceptionResponse = new ErrorMessage(ex.getMessage(),"What else do you want to add?");
		return new ResponseEntity<ErrorMessage>(exceptionResponse,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
 class ErrorMessage{
	 private String message;
	 private String Details;
	public ErrorMessage() {
		super();
	}
	public ErrorMessage(String message, String details) {
		super();
		this.message = message;
		Details = details;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
 }