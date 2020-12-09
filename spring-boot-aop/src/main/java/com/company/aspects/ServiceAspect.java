package com.company.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Before("execution(* com.company.service.*.*(..))")
    public void msgMethodundanEvvel(JoinPoint joinPoint){
        System.out.println("msg methodundan evvelki parametr = "+joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

    @After("execution(* com.company.service.*.*(..))")
    public void msgMethodundanSonra(JoinPoint joinPoint){
        System.out.println("msg methodundan sonraki parametr = "+joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }
}
