package by.academy.task09aop.service;

import org.aspectj.lang.ProceedingJoinPoint;

public interface AspectService {
    void beforeSend();

    void afterSend();

    Object aroundSend(ProceedingJoinPoint joinPoint) throws Throwable;

    void afterSendException();
}
