package br.com.softblue.bluetasks.infrastructure.web;

import org.springframework.data.rest.core.RepositoryConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.softblue.bluetasks.domain.task.DuplicationTaskException;

@RestControllerAdvice
public class WebRequestExceptionHandler {

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public RestResponseError handlerException(RepositoryConstraintViolationException e) {
		return RestResponseError.fromValidaError(e.getErrors());
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public RestResponseError handlerException(DuplicationTaskException e) {
		return RestResponseError.fromMEssage(e.getMessage());
	}
	
}
