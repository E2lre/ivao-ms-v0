package com.e2lre.ivaomsv0.controler.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class PrintException extends Exception {
    private static final Logger logger = LogManager.getLogger(PrintException.class);
    public PrintException(String s) {
        super(s);
        logger.error(s);
    }
}
