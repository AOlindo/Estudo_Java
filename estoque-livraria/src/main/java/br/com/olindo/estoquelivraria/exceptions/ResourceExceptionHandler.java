package br.com.olindo.estoquelivraria.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<Error> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		Error erro = new Error(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage(),
				 request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);

	}
	@ExceptionHandler(RegraDeNegocioException.class)
	public ResponseEntity<Error> regraNegocio(RegraDeNegocioException e, HttpServletRequest request) {
		Error erro = new Error(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),e.getMessage(),
				 request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);

	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Error> validacao(MethodArgumentNotValidException e, HttpServletRequest request) {
		ValidationError validationError = new ValidationError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage(),
				request.getRequestURI());
		for(FieldError x : e.getBindingResult().getFieldErrors()) {
			validationError.addError(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationError);

	}
}
