package com.assignment.entities;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Topic {

    private String topicName;
    private User createdByUser;
    private List<User> subscribedUsers;
    private Queue<Message> messages;

    public Topic(String topicName, User user) {
        this.topicName = topicName;
        this.createdByUser = user;
        this.subscribedUsers = new ArrayList<>();
        this.messages = new LinkedList<>();
    }

    public List<User> getAllSubscribedUsers() {
        return subscribedUsers;
    }

    public Queue<Message> getMessages() {
        return messages;
    }

    public int checkIfMessagesPresent() {
        return messages.size();
    }

}
