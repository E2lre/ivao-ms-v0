package com.e2lre.ivaomsv0.controler;

import com.e2lre.ivaomsv0.controler.exception.AirportIdtNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ivaoWeatherControler {
    private static final Logger logger = LogManager.getLogger(ivaoWeatherControler.class);

    /*---------------------------  GET by id -----------------------------*/
    @GetMapping(value = "airportWeather/{airportId}")
    @ResponseStatus(HttpStatus.OK)
    public String getWeatherByAirportId(@PathVariable String airportId) throws AirportIdtNotFoundException {

        logger.info("getWeatherByAirportId start-"+airportId);
        String result = airportId;
        if (result==null){
            logger.warn("The airport Id " + airportId + " does not exist");
            throw new AirportIdtNotFoundException("The airport Id " + airportId + " does not exist");
        }
        logger.info("getWeatherByAirportId finish");
        return result;

    }
}
