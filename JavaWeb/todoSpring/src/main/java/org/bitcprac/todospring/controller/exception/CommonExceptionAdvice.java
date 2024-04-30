package org.bitcprac.todospring.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoHandlerFoundException.class)
	public String notFound(){
		return "error/custom404";
	}

	@ResponseBody
	@ExceptionHandler(NumberFormatException.class)
	public String exception(NumberFormatException e) {
		log.info(e.getMessage());

		return "Number Format Exception !";
	}

	@ResponseBody
	@ExceptionHandler(Exception.class)
	public String allException(Exception e){
		log.info(e.getMessage());

		return "Exception !";
	}
}
