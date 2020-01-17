package com.luv2code.aopdemo.aspect;

import java.util.List;

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

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
		ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// print method we are advising
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n========== Executing @Around on method : "+ method);	
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// execute method
		Object result = theProceedingJoinPoint.proceed(); //invoke method
		
		// get end timestamp
		long end = System.currentTimeMillis();
		
		//compute duration and display
		long duration = end - begin;
		
		System.out.println("========== duration : "+ duration/1000.0 + " seconds");
		
		return result;
	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterThrowingFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print which method advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========== Executing @After (finally) on method : "+ method);	
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing= "theExc")
	public void afterThrowingFindAccountsAdvice(
			JoinPoint theJoinPoint,Throwable theExc) {
		
		// print which method advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========== Executing @AfterThrowing on method : "+ method);
				
		//log the exception
		System.out.println("\n========== the exception is : "+ theExc);
	}
	
	@AfterReturning(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(	
		JoinPoint theJoinPoint, List<Account> result) {
		
		// print which method advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========== Executing @AfterReturning on method : "+ method);
		
		// print results of the method call
		System.out.println("\n		result : "+ result);
		
		// post process the data...modify it 
		
		// convert account to upper case
		convertAccountNameToUpperCase(result);
		
		// print results of the method call after process
		System.out.println("\n		modified result : "+ result);
	}
	
	
	private void convertAccountNameToUpperCase(List<Account> result) {
		
		for(Account account : result) {
			
			String upperName =  account.getName().toUpperCase();
			
			//update
			account.setName(upperName);
		}
	}


	// start with @Before advice
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

		System.out.println("\n========== Executing @Before advice on addAccount()");
		
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("\n		method: " + methodSignature);
		
		// display method arguments
		//System.out.println("\n		method: " + methodSignature);
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop through the args
		for(Object tempArg : args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				Account theAccount = (Account)tempArg;
				System.out.println("account name: "+ theAccount.getName());
				System.out.println("account level: "+ theAccount.getLevel());
			}
		}
	}
}
