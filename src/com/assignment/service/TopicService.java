package com.assignment.service;

public interface TopicService {

    public String addTopic(String topicName, String username, UserService userService);

    String subscribeTopic(String topicName, String userName, UserService userService);

    String publishMessage(String message);

    String processMessages();

    String removeTopic();

}
