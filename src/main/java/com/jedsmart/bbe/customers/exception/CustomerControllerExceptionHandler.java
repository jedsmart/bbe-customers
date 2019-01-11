package com.jedsmart.bbe.customers.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jedsmart.bbe.customers.dto.ExceptionDTO;
import com.jedsmart.bbe.customers.dto.ExceptionDTO.ExceptionDTOBuilder;

@RestControllerAdvice
public class CustomerControllerExceptionHandler {

	@ExceptionHandler({ ResourceNotFoundException.class })
	public ResponseEntity<ExceptionDTO> customerNotFoundException(HttpServletRequest req, Exception ex) {
		ExceptionDTOBuilder builder = ExceptionDTO.builder();
		builder.code("");
		builder.reason(ex.getMessage());
		builder.url(req.getRequestURL().toString());
		builder.timestamp(new Date());
		return new ResponseEntity<ExceptionDTO>(builder.build(), HttpStatus.NOT_FOUND);
	}

}
