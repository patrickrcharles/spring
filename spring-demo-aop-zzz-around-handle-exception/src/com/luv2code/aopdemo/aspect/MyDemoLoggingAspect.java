package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		// print method we are advising
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n========== Executing @Around on method : " + method);

		// get begin timestamp
		long begin = System.currentTimeMillis();

		// execute method
		Object result = null; // invoke method

		try {
			result = theProceedingJoinPoint.proceed(); // invoke method

		} catch (Exception e) {
			// log exception
			myLogger.warning(e.getMessage());
			
			//rethrow exception
			throw e;
		}

		// get end timestamp
		long end = System.currentTimeMillis();

		// compute duration and display
		long duration = end - begin;

		myLogger.info("========== duration : " + duration / 1000.0 + " seconds");

		return result;
	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterThrowingFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {

		// print which method advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n========== Executing @After (finally) on method : " + method);
	}

	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {

		// print which method advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n========== Executing @AfterThrowing on method : " + method);

		// log the exception
		myLogger.info("\n========== the exception is : " + theExc);
	}

	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

		// print which method advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n========== Executing @AfterReturning on method : " + method);

		// print results of the method call
		myLogger.info("\n		result : " + result);

		// post process the data...modify it

		// convert account to upper case
		convertAccountNameToUpperCase(result);

		// print results of the method call after process
		myLogger.info("\n		modified result : " + result);
	}

	private void convertAccountNameToUpperCase(List<Account> result) {

		for (Account account : result) {

			String upperName = account.getName().toUpperCase();

			// update
			account.setName(upperName);
		}
	}

	// start with @Before advice
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

		myLogger.info("\n========== Executing @Before advice on addAccount()");

		// display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("\n		method: " + methodSignature);

		// display method arguments
		// myLogger.info("\n method: " + methodSignature);

		// get args
		Object[] args = theJoinPoint.getArgs();

		// loop through the args
		for (Object tempArg : args) {
			myLogger.info(tempArg.toString());

			if (tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				myLogger.info("account name: " + theAccount.getName());
				myLogger.info("account level: " + theAccount.getLevel());
			}
		}
	}
}
