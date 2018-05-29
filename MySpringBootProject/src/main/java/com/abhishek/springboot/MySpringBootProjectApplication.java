package com.abhishek.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class MySpringBootProjectApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(MySpringBootProjectApplication.class, args);
		
		//Refer to https://docs.spring.io/spring-boot/docs/1.5.10.RELEASE/reference/htmlsingle
		
		//23.5 Application events and listeners
		//SpringApplication.addListeners(…​)
		
		//25. Profiles
		//Spring Profiles provide a way to segregate parts of your application configuration and 
		//make it only available in certain environments
		
		//
		
		
		//27.3.1 Servlets, Filters, and listeners - Registering into the underlying servlet container, use
		//ServletRegistrationBean,
		//FilterRegistrationBean and
		//ServletListenerRegistrationBean for complete control.
		
		//27.3.2 Servlet Context Initialization
		
		//End of comments.
		
		
		
		
	}
}
