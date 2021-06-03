package com.assignment;

import com.assignment.service.TopicService;
import com.assignment.service.TopicServiceImpl;
import com.assignment.service.UserService;
import com.assignment.service.UserServiceImpl;

import java.util.Scanner;

public class Assignment {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        TopicService topicService = new TopicServiceImpl();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String command = input.split(" ")[0];
            String username = "";
            String topicName = "";
            if (command.equals("killApp")) {
                break;
            }
            try {
                switch (command) {
                    case "addUser":
                        username = input.split(" ")[1];
                        String role = input.split(" ")[2];
                        System.out.println(userService.addUser(username, role));
                        break;
                    case "addTopic":
                        topicName = input.split(" ")[1];
                        username = input.split(" ")[2];
                        System.out.println(topicService.addTopic(topicName, username, userService));
                        break;
                    case "subscribeTopic":
                        topicName = input.split(" ")[1];
                        username = input.split(" ")[2];
                        System.out.println(topicService.subscribeTopic(topicName, username, userService));
                        break;
                    case "publishMessage":
                        String messageBody = input.split(":")[1];
                        System.out.println(topicService.publishMessage(messageBody));
                        break;
                    case "processMessages":
                        System.out.println(topicService.processMessages());
                        break;
                    default:
                        System.out.println("Command not recognized");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Arguments incomplete. Please enter command again");
            }
        }

    }

}
