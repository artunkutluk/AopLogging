package com.kutluk.logger.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

    @Pointcut("@within(com.kutluk.logger.annotations.LoggableClass)")
    public void loggableClass() {}

    @Pointcut("@annotation(com.kutluk.logger.annotations.LoggableMethod)")
    public void loggableMethod() {}

    @Pointcut("@annotation(com.kutluk.logger.annotations.NotLoggableMethod)")
    public void notLoggableMethod() {}



    @Before("(loggableClass() ||  loggableMethod()) && !notLoggableMethod()")
    public void adviceBefore(JoinPoint jp)  {
        System.out.println("@Before called");
    }

    @After("(loggableClass() ||  loggableMethod()) && !notLoggableMethod()")
    public void adviceAfter(JoinPoint jp)  {
        System.out.println("@After called");
    }

    @AfterThrowing("(loggableClass() ||  loggableMethod()) && !notLoggableMethod()")
    public void adviceAfterThrowing(JoinPoint jp){
        System.out.println("@AfterThrowing called");
    }

}
