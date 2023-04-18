package by.academy.task09aop.service;

public interface MessageService {
    void send(String message);

    void sendException(String message) throws Exception;
}
