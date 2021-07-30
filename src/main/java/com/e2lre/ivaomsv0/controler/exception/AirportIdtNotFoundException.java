package com.e2lre.ivaomsv0.controler.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AirportIdtNotFoundException extends Exception {
    private static final Logger logger = LogManager.getLogger(AirportIdtNotFoundException.class);
    public AirportIdtNotFoundException(String s) {
        super(s);
        logger.error(s);
    }
}
