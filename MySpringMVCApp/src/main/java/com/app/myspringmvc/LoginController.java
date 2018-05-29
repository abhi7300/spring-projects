package com.app.myspringmvc;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.myspringmvc.exceptions.MyCustomException;
import com.app.myspringmvc.model.User;

@Controller  //Check this out. This class was nothing! But was anointed a Controller by this annotation!
public class LoginController {

	@RequestMapping(path = "/login")
	public ModelAndView loginPage(Model model) throws Exception {

		// use the following url to invoke this method:
		// http://localhost:8080/MySpringMVCApp/mymvcapp/login

		ModelAndView mv = new ModelAndView("LoginPage");
		model.addAttribute("user", new User());

		return mv;

	}

	@RequestMapping(path = "/validatelogin", method = RequestMethod.POST)
	public String validateLogin(@Valid User user, BindingResult result, Model model)
			throws Exception {

		// BindingResult result and ModelMap model are optional parameters

		// 1. use the following url to invoke this method:
		//    http://localhost:8080/MySpringMVCApp/mymvcapp/validatelogin
		
		
		// 2. The user parameters are mapped to the user object even without using the @ModelAttribute annotation
		//    like [ @Valid @ModelAttribute("user") User user ]
		
		
		// 3. BindingResult is used to check if any errors were found while validating the form fields.
		
		// 4. To enable form validation
		//    a. Add the maven dependency for javax.validation (validation-api)
		//    b. Add the maven dependency for hibernate-validator
		//    c. Add the javax.validation annotations to the form fields like @NotNull, @NotEmpty, @Size
		//    d. Add the form object in jsp, the <form:errors path="userId" /> tag. Use * as path value 
		//       to show any kind of error message associated with this form.
		//    e. Check the BindingResult object to see if there are any errors.
		//    f. Make sure proper error message is in place.
		//    g. Separate error messages can be displayed using bindingResultObject.addError(ObjectError objectError) method.
		
		

		if (result.hasErrors()) {
			
			return "LoginPage";  // String can be returned instead of ModelAndView
			
		}

		if (user != null && user.getUserId().equals("12346") && user.getPassword().equals("password")) {
			user.setFirstname("Indiana Jones");
			model.addAttribute("welcomeMessage", "Welcome to the dashboard, "+ user.getFirstname());
			
			return "Dashboard";// String can be returned instead of ModelAndView
			
		}else if (user != null && user.getUserId().contains("a")) {
			throw new MyCustomException();
		}
		else{
			
			result.addError(new ObjectError("incorrectPassword", "The user Id or password you have entered is incorrect."));
		}

		
		return "LoginPage";// String can be returned instead of ModelAndView

	}
	
	
	
	  // Local Exception Handling
	  // Specify name of a specific view that will be used to display the error:
	  @ExceptionHandler({SQLException.class})
	  public String databaseError() {
	    // Nothing to do.  Returns the logical view name of an error page, passed
	    // to the view-resolver(s) in usual way.
	    // Note that the exception is NOT available to this view (it is not added
	    // to the model) but see "Extending ExceptionHandlerExceptionResolver"
	    // below.
	    return "databaseError";
	  }
	  
	  
	  //Local Exception Handling
	  @ExceptionHandler(MyCustomException.class)
	  public ModelAndView handleError(HttpServletRequest req, Exception ex) {
	   

	    ModelAndView mav = new ModelAndView("Error");
	    mav.addObject("exception", ex);
	    mav.addObject("url", req.getRequestURL());
	    mav.addObject("errorMessage","There was an exception!");
	    return mav;
	    
	  }

}
