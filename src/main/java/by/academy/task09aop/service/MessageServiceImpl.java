package by.academy.task09aop.service;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    public static final String SENDING_MESSAGE = "Sending message: ";

    @Override
    public void send(final String message) {
        System.out.println(SENDING_MESSAGE + message);
    }

    @Override
    public void sendException(final String message) throws Exception {
        throw new Exception();
    }
}
