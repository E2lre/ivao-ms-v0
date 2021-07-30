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

@RestController
public class IvaoWeatherControler {
    private static final Logger logger = LogManager.getLogger(IvaoWeatherControler.class);
    @Autowired
    private IvaoWeatherService ivaoWeatherService;

    /*---------------------------  GET by id -----------------------------*/
    @GetMapping(value = "airportWeather/{airportId}")
    @ResponseStatus(HttpStatus.OK)
    public String getWeatherByAirportId(@PathVariable String airportId) throws AirportIdtNotFoundException {

        logger.info("getWeatherByAirportId start-"+airportId);
        String result = ivaoWeatherService.getWeatherByAirport(airportId);
        if (result==null){
            logger.warn("The airport Id " + airportId + " does not exist");
            throw new AirportIdtNotFoundException("The airport Id " + airportId + " does not exist");
        }
        logger.info("getWeatherByAirportId finish");
        return result;

    }
}
