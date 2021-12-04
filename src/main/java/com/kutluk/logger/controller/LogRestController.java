package com.kutluk.logger.controller;

import com.kutluk.logger.service.ClassWhichIsLoggable;
import com.kutluk.logger.service.ClassWithLoggableMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logRest")
public class LogRestController {

    @Autowired
    ClassWithLoggableMethods classWithLoggableMethods;

    @Autowired
    ClassWhichIsLoggable classWhichIsLoggable;

    @RequestMapping(value = "/serviceWithLog", method = RequestMethod.POST)
    @ResponseBody
    public String serviceWithLog() {

        System.out.println("\n\n\n------------------------------------------------------------------------------");
        System.out.println("                       ClassWhichIsLoggable");
        System.out.println("------------------------------------------------------------------------------");

        printSeparator();
        classWhichIsLoggable.methodOne();
        printSeparator();
        classWhichIsLoggable.methodTwo();
        printSeparator();
        classWhichIsLoggable.methodThree();
        printSeparator();
        try {
            classWhichIsLoggable.methodFour();
        }catch(Exception e){
            System.out.println("Custom exception caught");
        }


        System.out.println("\n\n\n------------------------------------------------------------------------------");
        System.out.println("                     ClassWithLoggableMethods");
        System.out.println("------------------------------------------------------------------------------");

        printSeparator();
        classWithLoggableMethods.methodOne();
        printSeparator();
        try {
            classWithLoggableMethods.methodTwo();
        }catch(Exception e){
            System.out.println("Custom exception caught");
        }
        printSeparator();
        classWithLoggableMethods.methodThree();
        printSeparator();

        return "done";
    }

    private void printSeparator(){
        System.out.println("\n---------------------------------------\n");
    }

}
