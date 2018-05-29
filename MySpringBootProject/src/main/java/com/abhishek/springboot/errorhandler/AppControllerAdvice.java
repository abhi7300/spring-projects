package com.abhishek.springboot.errorhandler;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.abhishek.springboot.helloworld.HelloWorldController;

@ControllerAdvice(basePackageClasses=HelloWorldController.class)
public class AppControllerAdvice extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(Exception.class)
    @ResponseBody
    ResponseEntity<CustomErrorType> handleControllerException(HttpServletRequest request, Throwable ex) {
        HttpStatus status = getStatus(request);
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(status.value(), ex.getMessage()), status);
    }
	
	@ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    ResponseEntity<CustomErrorType> handleEntityNotFoundException(HttpServletRequest request, Throwable ex) {
        HttpStatus status = getStatus(request);
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(status.value(), ex.getMessage()), status);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
	
}
