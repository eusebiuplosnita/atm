package com.interview.ing.atm.machine.exceptions;

import java.time.Instant;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	protected ResponseEntity<Object> handleIllegalException(IllegalArgumentException ex) {
		return buildResponseEntity(new ServiceError(HttpStatus.BAD_REQUEST, ex));
	}

	@ExceptionHandler(NoSuchElementException.class)
	protected ResponseEntity<Object> handleNotFoundException(NoSuchElementException ex) {
		return buildResponseEntity(new ServiceError(HttpStatus.NOT_FOUND, ex));
	}

	private ResponseEntity<Object> buildResponseEntity(ServiceError serviceError) {
		return new ResponseEntity<>(serviceError, serviceError.getStatus());
	}

	@JsonInclude(Include.NON_NULL)
	private class ServiceError {

		private HttpStatus status;

		private Instant timestamp;

		private String message;

		public ServiceError() {
			this.timestamp = Instant.now();
		}

		public ServiceError(HttpStatus status, Throwable exception) {
			this();
			this.status = status;
			this.message = exception.getMessage();
		}

		public HttpStatus getStatus() {
			return status;
		}

		public void setStatus(HttpStatus status) {
			this.status = status;
		}

		public Instant getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(Instant timestamp) {
			this.timestamp = timestamp;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
}
