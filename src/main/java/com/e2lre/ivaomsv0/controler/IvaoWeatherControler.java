package com.e2lre.ivaomsv0.controler;

import com.e2lre.ivaomsv0.controler.exception.AirportIdtNotFoundException;
import com.e2lre.ivaomsv0.service.IvaoWeatherService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class IvaoWeatherControler {
    private static final Logger logger = LogManager.getLogger(IvaoWeatherControler.class);
    @Autowired
    private IvaoWeatherService ivaoWeatherService;

    /*---------------------------  GET by id -----------------------------*/
    @GetMapping(value = "airportWeatherObs/{airportId}")
    @ResponseStatus(HttpStatus.OK)
    public String getWeatherObsByAirportId(@PathVariable String airportId) throws AirportIdtNotFoundException {

        logger.info("getWeatherObsByAirportId start-" + airportId);
        String result = null;
        try {
            result = ivaoWeatherService.getWeatherObsByAirport(airportId);
            if (result == null) {
                logger.warn("The airport Id " + airportId + " does not exist");
                throw new AirportIdtNotFoundException("The airport Id " + airportId + " does not exist");
            }
        }
        catch (URISyntaxException e) {
            logger.info("getWeatherObsByAirportId ERROR URISyntaxException");
            result = "ERROR";
        }
        catch (IOException e) {
            logger.info("getWeatherObsByAirportId ERROR IOException");
            result = "ERROR";
        }
        catch (InterruptedException e) {
            logger.info("getWeatherObsByAirportId ERROR InterruptedException");
            result = "ERROR";
        }
        logger.info("getWeatherObsByAirportId finish");
        return result;

    }
}
