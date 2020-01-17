package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	// a new advice for @AfterReturning on findAccounts method
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
