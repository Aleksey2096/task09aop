package by.academy.task09aop.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;

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

    @Override
    public void beforeSend() {
        System.out.println(METHOD_SEND_WILL_BE_CALLED_NOW);
    }

    @Override
    public void afterSend() {
        System.out.println(METHOD_SEND_WAS_CALLED);
    }

    @Override
    public void aroundSend(ProceedingJoinPoint joinPoint) throws Throwable {
        String message = (String) joinPoint.getArgs()[0];
        System.out.println(MESSAGE + message);
        long beginTime = System.currentTimeMillis();
        joinPoint.proceed();
        System.out.println(TIME_OF_EXECUTION_MILLISECONDS
                + (System.currentTimeMillis() - beginTime));
    }

    @Override
    public void afterSendException() {
        System.out.println(EXCEPTION_WAS_GENERATED);
    }
}
