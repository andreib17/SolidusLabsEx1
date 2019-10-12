package com.company.solidusEx1.controllers;

import com.company.solidusEx1.domain.Message;
import com.company.solidusEx1.exceptions.MessageNotFoundException;
import com.company.solidusEx1.services.MessageServiceIfc;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController
public class MessageController {

    private MessageServiceIfc messageService;

    public MessageController(MessageServiceIfc messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(path = "/messages", method = RequestMethod.POST, consumes = {"application/json"})
    public ObjectNode saveMessage(@RequestBody Message message) throws NoSuchAlgorithmException {
        String hashStr = messageService.saveMessage(message);
        return messageService.formulateJsonResponse("digest", hashStr);
    }

    @GetMapping("/messages/{hash}")
    public ObjectNode getMessageByHash(@PathVariable String hash) {
        Optional<Message> optMsg = messageService.getMessageByHash(hash);
        if (optMsg.isPresent()) {
            return messageService.formulateJsonResponse("message", optMsg.get().getMessage());
        }
        throw new MessageNotFoundException(hash);
    }
}
