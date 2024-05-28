package ru.gb.ksv.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect()
@Component
public class TrackUserAspect {

    @Pointcut("@annotation(ru.gb.ksv.aspect.annotation.TrackUserAction)")
    public void trackUserActionPointcut() {}

//    @AfterReturning(value = "@annotation(ru.gb.ksv.aspect.annotation.TrackUserAction)",returning = "returnedValue")
//    public void afterReturning(Object returnedValue) {
//        System.out.println(returnedValue.toString());
//    }

    @Around("execution(* ru.gb.ksv.service.*.*(..)) && trackUserActionPointcut()" )
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();
        String thisClass = joinPoint.getThis().toString();

        Object returnedByMethod = joinPoint.proceed(arguments);

        System.out.printf("Method %s from class %s with parameters %s,\nwill return %s%n",methodName,thisClass, Arrays.asList(arguments), returnedByMethod);

        return returnedByMethod;
    }
}

