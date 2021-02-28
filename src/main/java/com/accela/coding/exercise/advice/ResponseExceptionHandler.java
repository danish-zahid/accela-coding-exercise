package com.accela.coding.exercise.advice;

import com.accela.coding.exercise.dto.Response;
import com.accela.coding.exercise.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.accela.coding.exercise.util.Constants.INTERNAL_SERVER_ERROR_MESSAGE;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<Response<String>> handleResourceNotFoundException(Exception exp, WebRequest request) {
        Response<String> response = new Response<String>(exp.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Response<String>> handleServerException(Exception exp, WebRequest request) {
        Response<String> response = new Response<String>(INTERNAL_SERVER_ERROR_MESSAGE);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
