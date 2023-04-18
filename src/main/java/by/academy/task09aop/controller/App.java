package by.academy.task09aop.controller;

import by.academy.task09aop.service.MessageInterceptor;
import by.academy.task09aop.service.MessageService;
import by.academy.task09aop.service.MessageServiceImpl;
import org.springframework.aop.framework.ProxyFactory;

public class App {
    public static final String TEST_MESSAGE_1 = "Test message1";
    public static final String TEST_MESSAGE_2 = "Test message2";
    private static MessageService target;
    private static MessageService proxy;

    public static void init() {
        target = new MessageServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new MessageInterceptor());
        proxyFactory.setTarget(target);
        proxy = (MessageService) proxyFactory.getProxy();
    }

    public static void main(String[] args) {
        init();
        process(TEST_MESSAGE_1);
        processProxy(TEST_MESSAGE_2);
    }

    public static void process(String message) {
        target.send(message);
    }

    public static void processProxy(String message) {
        proxy.send(message);
    }
}
