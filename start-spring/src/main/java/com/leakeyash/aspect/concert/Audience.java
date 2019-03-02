package com.leakeyash.aspect.concert;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {
    @Before("execution(** com.leakeyash.aspect.concert.Performance.perform(..))")
    public void silenceCellPhones(){
        System.out.println("Silencing cell phones");
    }
    @Before("execution(** com.leakeyash.aspect.concert.Performance.perform(..))")
    public void takeSeats(){
        System.out.println("Taking seats");
    }
    @AfterReturning("execution(** com.leakeyash.aspect.concert.Performance.perform(..))")
    public void applause(){
        System.out.println("CLAP CLAP CLAP!!!");
    }
    @AfterThrowing("execution(** com.leakeyash.aspect.concert.Performance.perform(..))")
    public void demandRefund(){
        System.out.println("Demanding a refund");
    }
}
