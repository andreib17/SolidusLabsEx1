package com.company.solidusEx1.exceptions;

public class MessageNotFoundException extends RuntimeException{

    public MessageNotFoundException(String hash) {
        super("Message not found by the following hash " + hash);
    }
}
