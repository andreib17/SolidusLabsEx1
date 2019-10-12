package com.company.solidusEx1.services;

import com.company.solidusEx1.domain.Message;
import com.company.solidusEx1.repositories.MessageRepository;
import com.company.solidusEx1.utils.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class MessageService implements MessageServiceIfc {

    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    /**
     * save the sent message to the DB, and return the hash as a string
     */
    public String saveMessage(Message message) throws NoSuchAlgorithmException {
        byte[] encodedhash = getHash256ByteArray(message);
        String hashStr = Utils.bytesToHexStr(encodedhash);
        message.setHash256(hashStr);
        messageRepository.save(message);
        return hashStr;
    }

    private byte[] getHash256ByteArray(Message message) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(message.getMessage().getBytes(StandardCharsets.UTF_8));
    }

    /**
     * find a message the given hash
     */
    public Optional<Message> getMessageByHash(String hash) {
        return messageRepository.findByHash256(hash);
    }

    /**
     * create a json object by given fieldName and field value
     */
    public ObjectNode formulateJsonResponse(String fieldName, String fieldValue) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put(fieldName, fieldValue);
        return objectNode;
    }
}
