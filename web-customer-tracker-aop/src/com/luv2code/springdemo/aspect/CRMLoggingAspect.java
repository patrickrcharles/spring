package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declaration
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}

	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// add @Before
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display method calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("========== @Before: calling method : "+ theMethod);
		
		// display args to the method
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru and display args
		for( Object tempArg : args) {
			
			myLogger.info("========== argument : "+ tempArg);
		}	
	}
	
	// add @After
	@AfterReturning(
			pointcut="forAppFlow()",
			returning = "theResult")
	public void afterReturnign(JoinPoint theJoinPoint, Object theResult) {
		
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("========== @AfterReturning: from method : "+ theMethod);
		
		// display data returned
		myLogger.info("========== result : "+ theResult);
	}	
}
