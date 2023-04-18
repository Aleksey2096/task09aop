package by.academy.task09aop.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class AspectServiceImpl implements AspectService {

    public static final String TIME_OF_EXECUTION_MILLISECONDS
            = "Time of execution (milliseconds): ";
    public static final String EXCEPTION_WAS_GENERATED
            = "Exception was generated!";
    public static final String MESSAGE = "Message: ";
    public static final String METHOD_SEND_WAS_CALLED
            = "Method \"send\" was called!";
    public static final String METHOD_SEND_WILL_BE_CALLED_NOW
            = "Method \"send\" will be called now!";

    @Pointcut(
            "execution(void by.academy.task09aop.service.MessageServiceImpl.send(String))")
    public void send() {
    }

    @Pointcut(
            "execution(void by.academy.task09aop.service.MessageServiceImpl.sendException(String))")
    public void sendException() {
    }

    @Override
    @Before("send()")
    public void beforeSend() {
        System.out.println(METHOD_SEND_WILL_BE_CALLED_NOW);
    }

    @Override
    @AfterReturning("send()")
    public void afterSend() {
        System.out.println(METHOD_SEND_WAS_CALLED);
    }

    @Override
    @Around("send()")
    public Object aroundSend(ProceedingJoinPoint joinPoint) throws Throwable {
        String message = (String) joinPoint.getArgs()[0];
        System.out.println(MESSAGE + message);
        long beginTime = System.currentTimeMillis();
        joinPoint.proceed();
        System.out.println(TIME_OF_EXECUTION_MILLISECONDS
                + (System.currentTimeMillis() - beginTime));
        return joinPoint;
    }

    @Override
    @AfterThrowing("sendException()")
    public void afterSendException() {
        System.out.println(EXCEPTION_WAS_GENERATED);
    }
}
