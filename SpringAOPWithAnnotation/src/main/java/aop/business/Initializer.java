package main.java.aop.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Initializer {

	public static void main(String[] args) {
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		 OscarPredictions oscarPrediction = context.getBean("oscarPredictionBean",OscarPredictions.class);
	    
		 if(oscarPrediction!=null){
			 oscarPrediction.getBestPicture();
		 }
		 
	}

}
