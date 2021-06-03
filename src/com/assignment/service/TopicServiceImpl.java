package com.assignment.service;

import com.assignment.entities.Message;
import com.assignment.entities.Roles;
import com.assignment.entities.Topic;
import com.assignment.entities.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopicServiceImpl implements TopicService {

    private Map<String, Topic> topicNameVsTopicMap = new HashMap<>();

    @Override
    public String addTopic(String topicName, String username, UserService userService) {
        if (topicName.equals("")) {
            return "ERROR : topicName cannot be empty!";
        }
        if (!userService.checkIfUserExists(username)) {
            return "ERROR : User does not exist in the system!";
        }
        User user = userService.getUserFromUsername(username);
        if (user.getUserRole().equals(Roles.ROLE_ADMIN)) {
            Topic topic = new Topic(topicName, user);
            topicNameVsTopicMap.put(topicName, topic);
            return "SUCCESS : Topic ".concat(topicName).concat(" added!");
        } else {
            return "ERROR: Only users with ADMIN role are allowed to create topics!";
        }
    }

    @Override
    public String subscribeTopic(String topicName, String userName, UserService userService) {
        if (!topicNameVsTopicMap.containsKey(topicName)) {
            return "ERROR : The specified topic does not exist in the system!";
        }
        if (!userService.checkIfUserExists(userName)) {
            return "ERROR: The specified user does not exist in the system";
        }
        User user = userService.getUserFromUsername(userName);
        topicNameVsTopicMap.get(topicName).getAllSubscribedUsers().add(user);
        return "SUCCESS : User ".concat(userName).concat(" subscribed to ").concat(topicName).concat(" topic!");
    }

    @Override
    public String publishMessage(String messageBody) {
        String[] arr = messageBody.split("_");
        String id = arr[0];
        String topicName = arr[1];
        String text = arr[2];
        if (!topicNameVsTopicMap.containsKey(topicName)) {
            return "ERROR : The specified topic does not exists!";
        }
        Message message = new Message(id, text);
        topicNameVsTopicMap.get(topicName).getMessages().add(message);
        return "SUCCESS : Message published in the topic";
    }

    @Override
    public String processMessages() {
        System.out.println("Processing Messages");
        int processedMessages = 0;
        for (String topic: topicNameVsTopicMap.keySet()) {
            Queue<Message> messages = topicNameVsTopicMap.get(topic).getMessages();
            List<User> users = topicNameVsTopicMap.get(topic).getAllSubscribedUsers();
            while(!messages.isEmpty()) {
                Message message = messages.poll();
                for (User user : users) {
                    System.out.println("{ topic: ".concat(topic).concat(", message: ")
                            .concat(message.getMessage())
                            .concat(", sentTo : ")
                            .concat(user.getUsername())
                            .concat(" }"));
                    processedMessages++;
                }
            }
        }
        if (processedMessages == 0) {
            return "No messages available!";
        }
        return "SUCCESS : All messages processed!";
    }

    @Override
    public String removeTopic() {
        return "will be implemented later";
    }
}
