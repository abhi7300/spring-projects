package com.abhishek.springboot.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping(path="/hello")
	public String helloWorld(){
		
		
		// Uncomment the next four lines to test the error handler code.
		
		/*String str = null;
		if(str.equals("empty")){
			System.out.println("This wont be executed.");
		}*/
		
		// Uncomment the above four lines to test the error handler code.
		
		return "Hello World";
	}
}
