package com.company.solidusEx1.services;

import com.company.solidusEx1.domain.Message;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public interface MessageServiceIfc {

    String saveMessage(Message message) throws NoSuchAlgorithmException;

    Optional<Message> getMessageByHash(String hash);

    ObjectNode formulateJsonResponse(String fieldName, String fieldValue);
}
