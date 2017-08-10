package com.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	// Logger
	private Logger LOGGER = Logger.getLogger(this.getClass().getName());
	
	// Point cut expression
	@Pointcut("execution(* com.controllers.*.*(..))")
	private void forControllerPackage(){}
	// For Service package
	@Pointcut("execution(* com.Service.*.*(..))")
	private void forServicePackage(){}
	//For Controller or Service
	@Pointcut("forControllerPackage() || forServicePackage() ")
	private void forApp(){}
	@Pointcut("execution(* com.Service.CustomerServiceImpl.getCustomer(..))")
	private void forGetCustomer(){}
	
	// @Before advice
	@Before("forApp()")
	public void before(JoinPoint theJoinPoint){
		LOGGER.info("Aspect @Before:"+theJoinPoint.getSignature().toShortString());
		
		for(Object arg : theJoinPoint.getArgs())
			LOGGER.info("Aspect @Before parameters:"+arg);
		
	}
	// @Around advice
	@Around("forGetCustomer()")
	public Object AroundAdvice(ProceedingJoinPoint PJP){
		for(Object arg : PJP.getArgs())
			LOGGER.info("Aspect @Around parameters:"+arg);
		Object obj = new Object();
		try {
			obj = PJP.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
}
