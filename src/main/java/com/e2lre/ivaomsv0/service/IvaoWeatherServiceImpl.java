package com.e2lre.ivaomsv0.service;

import com.e2lre.ivaomsv0.controler.IvaoWeatherControler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;



@Service
public class IvaoWeatherServiceImpl implements IvaoWeatherService {
    private static final Logger logger = LogManager.getLogger(IvaoWeatherServiceImpl.class);
    @Override
    public String getWeatherByAirport(String airportId) {
        logger.info("getWeatherByAirport start/Finish-"+airportId);
       /* https://www.baeldung.com/java-http-request
        URL url = new URL("http://example.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");*/

        return airportId;
    }
}
