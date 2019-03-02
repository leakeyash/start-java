package com.leakeyash.aspect.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author henry
 */
@Aspect
@Component
public class Audience {

    @Pointcut("execution(* com.leakeyash.aspect.concert.Performance.perform(..))")
    public void performance(){
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp){
        try{
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");
            jp.proceed();
            System.out.println("CLAP CLAP CLAP!!!");
        }
        catch (Throwable e){
            System.out.println("Demanding a refund");
        }
    }
}
