package br.com.project.leonardo.leonardobasics.exception.handler;

import br.com.project.leonardo.leonardobasics.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class})
    protected ResponseEntity<RestErrorMessageDTO> userNotFoundExceptionHandler(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<RestErrorMessageDTO>(RestErrorMessageDTO.builder().message("User Not found").build(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

}
