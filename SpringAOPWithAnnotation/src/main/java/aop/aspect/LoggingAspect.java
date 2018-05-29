package main.java.aop.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class LoggingAspect {

	@Before("execution(* main.java.aop.business.OscarPredictions.getBestPicture())")
	public void logBestPicture(){
		
		System.out.println("Best Picture Prediction called.");
	}
	
	
	
}
