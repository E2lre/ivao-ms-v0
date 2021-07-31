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
    /**
     * give weather Observation for the airport
     */
    public String getWeatherObsByAirport(String airportId) throws URISyntaxException, IOException, InterruptedException {
        String result = null;
        //HashMap<String, String> weatherAirportMap = new HashMap<>();
        logger.info("getWeatherObsByAirport start-"+airportId);

        List<String> weatherAirportList = getWeatherObsAirportList();
        if (weatherAirportList != null)  {
            result = getMapFromList(weatherAirportList," ").get(airportId);
        }
        else {
            result = null;
        }
        logger.info("getWeatherObsByAirport Finish-"+airportId);
        return result;
    }

    @Override
    /**
     * give weather prevition for the airport
     */
    public String getWeatherPrevByAirport(String airportId) throws URISyntaxException, IOException, InterruptedException {
        String result = null;
        //HashMap<String, String> weatherAirportMap = new HashMap<>();
        logger.info("getWeatherPrevByAirport start-"+airportId);

        List<String> weatherAirportList = getWeatherPrevAirportList();
        if (weatherAirportList != null)  {
            result = getMapFromList(weatherAirportList," ").get(airportId);
        }
        else {
            result = null;
        }
        logger.info("getWeatherPrevByAirport Finish-"+airportId);
        return result;
    }

    /**
     * Transfort list with separator to a map.the key map will be the first element of rach line
     * @param myList list to be transfort
     * @param separator list séparator
     * @return map from the list
     */
    private HashMap<String, String> getMapFromList(List<String> myList, String separator) {
        HashMap<String, String> myMap = new HashMap<>();
        for( String e : myList){
            List<String> weatherInfo = Arrays.asList(e.split(separator));
            myMap.put(weatherInfo.get(0),e);
        }
        return myMap;
    }

    /**
     * Get weather observation for all the airport
     * @return list of weather observation
     */
    private List<String> getWeatherObsAirportList(){
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

    /**
     * Get weather prevition for all the airport
     * @return list of weather prevition
     */
    private List<String> getWeatherPrevAirportList(){
        List<String> resultList = null;
        String airportList = null;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://wx.ivao.aero/taf.php"))
                    .GET()
                    .build();


            HttpResponse<String> response = HttpClient.newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString()); // BodyHandler.asString());
            airportList = response.body().toString();

            resultList = Arrays.asList(airportList.split("\n"));

        }
        catch (URISyntaxException e) {
            logger.info("getWeatherPrevAirportList ERROR URISyntaxException");
            resultList = null;
        }
        catch (IOException e) {
            logger.info("getWeatherPrevAirportList ERROR IOException");
            resultList = null;
        }
        catch (InterruptedException e) {
            logger.info("getWeatherPrevAirportList ERROR InterruptedException");
            resultList = null;
        }
        return resultList;
    }
}
