package by.academy.task09aop.controller;

import by.academy.task09aop.service.MessageService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static final String TEST_MESSAGE = "Test message";
    public static final String SPRING_CONFIG_XML = "SpringConfig.xml";
    public static final String MESSAGE_SERVICE_IMPL = "messageServiceImpl";

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext(SPRING_CONFIG_XML);
        MessageService messageService = (MessageService) context.getBean(
                MESSAGE_SERVICE_IMPL);
        messageService.send(TEST_MESSAGE);
        try {
            messageService.sendException(TEST_MESSAGE);
        } catch (Exception newE) {
            System.out.println(newE.getClass());
        }
        context.close();
    }
}
