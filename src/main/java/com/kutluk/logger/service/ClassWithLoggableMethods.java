package com.kutluk.logger.service;

import com.kutluk.logger.annotations.LoggableMethod;
import org.springframework.stereotype.Service;

@Service
public class ClassWithLoggableMethods {

    @LoggableMethod
    public void methodOne(){
        System.out.println("ClassWithLoggableMethods -> method with @LoggableMethod annoation called");
    }

    @LoggableMethod
    public void methodTwo() throws Exception{
        System.out.println("ClassWithLoggableMethods -> method with @LoggableMethod annoation throwing exception called");
        throw new Exception("custom exception");
    }

    public void methodThree(){
        System.out.println("ClassWithLoggableMethods -> method without @LoggableMethod annoation called");
    }
}
