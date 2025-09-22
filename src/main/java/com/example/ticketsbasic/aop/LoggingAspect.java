package com.example.ticketsbasic.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// Cross-cutting logger to trace method entry/exit
@Aspect
@Component
public class LoggingAspect {
  private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

  // log entry to any app method
  @Before("execution(* com.example.ticketsbasic..*(..))")
  public void enter(JoinPoint jp){ log.info("ENTER {}", jp.getSignature()); }

  // log exit from any app method
  @AfterReturning("execution(* com.example.ticketsbasic..*(..))")
  public void exit(JoinPoint jp){ log.info("EXIT {}", jp.getSignature()); }
}
