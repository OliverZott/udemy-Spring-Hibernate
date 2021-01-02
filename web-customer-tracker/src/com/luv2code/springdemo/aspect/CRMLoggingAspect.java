package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// setup POINTCUT declaration
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	// Combine Pointut expressions!
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
	}

	// add @Before ADVICE
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {

		// display method we are calling
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("----------> inside @Before, regarding method: " + method);

		// display arguments to the method

	}

	// add @AfterReturning advice

}
