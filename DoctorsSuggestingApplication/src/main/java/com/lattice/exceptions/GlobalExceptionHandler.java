package com.lattice.exceptions;

import java.time.LocalDateTime;

import javax.security.auth.login.LoginException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DoctorException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(DoctorException doctorExp, WebRequest req) {
		
		MyErrorDetails error = new MyErrorDetails(LocalDateTime.now(), doctorExp.getMessage(), req.getDescription(false));
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(doctorExp.getMessage());
		error.setDescription(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(PatientException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(PatientException patientExp, WebRequest req) {
		
		MyErrorDetails error = new MyErrorDetails(LocalDateTime.now(), patientExp.getMessage(), req.getDescription(false));
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(patientExp.getMessage());
		error.setDescription(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe, WebRequest req) {

		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(nfe.getMessage());
		error.setDescription(req.getDescription(false));

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me) {

		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage("Validation Error");
		error.setDescription(me.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception ae, WebRequest req) {

		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ae.getMessage());
		error.setDescription(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.NOT_FOUND);
	}

}
