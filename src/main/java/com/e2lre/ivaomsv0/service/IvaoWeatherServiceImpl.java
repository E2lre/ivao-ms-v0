package com.e2lre.ivaomsv0.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@Service
public class IvaoWeatherServiceImpl implements IvaoWeatherService {
    private static final Logger logger = LogManager.getLogger(IvaoWeatherServiceImpl.class);
    @Override
    public String getWeatherObsByAirport(String airportId) throws URISyntaxException, IOException, InterruptedException {
        String result = null;
        HashMap<String, String> weatherAirportMap = new HashMap<>();
        logger.info("getWeatherObsByAirport start-"+airportId);

        List<String> weatherAirportList = GetWeateherObsAirportList();
        if (weatherAirportList != null)  {
            for( String weatherAirport : weatherAirportList){
               List<String> weatherInfo = Arrays.asList(weatherAirport.split(" "));
               weatherAirportMap.put(weatherInfo.get(0),weatherAirport);
            }
            result = weatherAirportMap.get(airportId);

        }
        else {
            result = null;
        }
        logger.info("getWeatherObsByAirport Finish-"+airportId);
        return result;
    }


    private List<String> GetWeateherObsAirportList(){
        List<String> resultList = null;
        String airportList = null;
        try {
           HttpRequest request = HttpRequest.newBuilder()
                   .uri(new URI("http://wx.ivao.aero/metar.php"))
                   .GET()
                   .build();


           HttpResponse<String> response = HttpClient.newBuilder()
                   .build()
                   .send(request, HttpResponse.BodyHandlers.ofString()); // BodyHandler.asString());
           //CompletableFuture<HttpHeaders> trailers = response. response.trailers();
           airportList = response.body().toString();

            resultList = Arrays.asList(airportList.split("\n"));

       }
       catch (URISyntaxException e) {
           logger.info("GetWeateherObsAirportList ERROR URISyntaxException");
           resultList = null;
       }
       catch (IOException e) {
           logger.info("GetWeateherObsAirportList ERROR IOException");
           resultList = null;
       }
       catch (InterruptedException e) {
           logger.info("GetWeateherObsAirportList ERROR InterruptedException");
           resultList = null;
       }


        return resultList;

    }
}
