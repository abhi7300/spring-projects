package com.app.myspringmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyControllerAdvice {
	
/*	   Any class annotated with @ControllerAdvice becomes a controller-advice and three types of method are supported:

		1. Exception handling methods annotated with @ExceptionHandler.
		2. Model enhancement methods (for adding additional data to the model) annotated with
		   @ModelAttribute. Note that these attributes are not available to the exception handling views.
		3. Binder initialization methods (used for configuring form-handling) annotated with
		   @InitBinder.
		
*/
	
	public static final String DEFAULT_ERROR_VIEW = "Error";
	
	 @ExceptionHandler(value = Exception.class)
	  public ModelAndView
	  defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
	    // If the exception is annotated with @ResponseStatus rethrow it and let
	    // the framework handle it - like the OrderNotFoundException example
	    // at the start of this post.
	    // AnnotationUtils is a Spring Framework utility class.
	    if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
	      throw e;

	    // Otherwise setup and send the user to a default error-view.
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("exception", e);
	    mav.addObject("url", req.getRequestURL());
	    mav.setViewName(DEFAULT_ERROR_VIEW);
	    return mav;
	  }

}
