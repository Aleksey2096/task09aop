package by.academy.task09aop.service;

public class MessageServiceImpl implements MessageService {

    public static final String SENDING_MESSAGE = "Sending message: ";

    @Override
    public void send(final String message) {
        System.out.println(SENDING_MESSAGE + message);
    }
}
