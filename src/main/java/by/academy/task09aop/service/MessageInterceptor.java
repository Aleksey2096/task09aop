package by.academy.task09aop.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageInterceptor implements MethodInterceptor {

    public static final String MESSAGE_INTERCEPTED = "Message intercepted: ";

    @Override
    public Object invoke(final MethodInvocation invocation) throws Throwable {
        String message = (String) invocation.getArguments()[0];
        System.out.println(MESSAGE_INTERCEPTED + message);
        return invocation.proceed();
    }
}
