package com.company.solidusEx1.controllers;

import com.company.solidusEx1.exceptions.MessageNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestControllerAdvice
public class ExceptionHandlerController {

    /**
     * send a not found error code 404 and error message
     */
    @ExceptionHandler(MessageNotFoundException.class)
    public void handleNotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
}
