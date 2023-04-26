package com.cakeapp.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.training.controller.*.*(..))")
	public void forControllerPackage() {
	}

	@Pointcut("execution(* com.training.service.*.*(..))")
	public void forServicePackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage()")
	public void forAppFlow() {
	}

	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n ====>>> in @Before: calling method: " + method);

		Object[] args = theJoinPoint.getArgs();

		// loop through and display the arguments
		for (Object tempArg : args) {
			myLogger.info("\n=====>>> argument: " + tempArg);
		}
	}

	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturing(JoinPoint theJoinPoint, Object theResult) {

		// display the method we are returning from
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n ====>>> in @AfterReturing: from method: " + method);

		myLogger.info("\n====>>> the result is: " + theResult);
	}

}