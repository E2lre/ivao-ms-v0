package com.e2lre.ivaomsv0.service;

import com.e2lre.ivaomsv0.model.ivao.Atc;
import com.e2lre.ivaomsv0.model.ivao.Pilot;
import com.e2lre.ivaomsv0.model.ivao.Whazuup;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.ResourceBundle;


@Service
public class IvaoUtilServiceImpl implements IvaoUtilService{
    private static final Logger logger = LogManager.getLogger(IvaoUtilService.class);

    @Override
    public HashMap<String, String> getMapFromList(List<String> myList, String separator, int keyPosition) {
        HashMap<String, String> myMap = new HashMap<>();
        int position;
        for( String e : myList){
            List<String> info = Arrays.asList(e.split(separator));
            //logger.info("taille de la liste vers la map : "+info.size());
            position = keyPosition;
            if (info.size()<=keyPosition) {
                position =0;
            }
            myMap.put(info.get(position), e);

        }
        return myMap;
    }

    @Override
    public List<String> getWeatherObsAirportList(){
        List<String> resultList = null;
        String airportList = null;
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("application");
            String url = bundle.getString("url.metar.apiv1");
            //String url = bundle.getString("url.metar.apiv1");

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString()); // BodyHandler.asString());
            airportList = response.body().toString();

            resultList = Arrays.asList(airportList.split("\n"));

        }
        catch (URISyntaxException e) {
            logger.error("GetWeateherObsAirportList ERROR URISyntaxException");
            resultList = null;
        }
        catch (IOException e) {
            logger.error("GetWeateherObsAirportList ERROR IOException");
            resultList = null;
        }
        catch (InterruptedException e) {
            logger.error("GetWeateherObsAirportList ERROR InterruptedException");
            resultList = null;
        }
        return resultList;
    }
    @Override
    public  Atc findAtcByVid(List<Atc> atcs, String vid) {
        Atc atcResult = null;
        for (Atc a : atcs){
            if (a.getUserId().equals(vid)) {
                atcResult = a;
            }
        }
        return atcResult;
    }
    @Override
    public  Pilot findPilotByVid(List<Pilot> pilotes, String vid) {
        Pilot piloteResult = null;
        for (Pilot p : pilotes){
            if (p.getUserId().equals(vid)) {
                piloteResult = p;
            }
        }
        return piloteResult;
    }

    /**
     * convert JSON format to whazuup Object
     * @param myJson data in json format from ivao API V2
     * @return whazuup object
     */
    @Override
    public  Whazuup getWhazuppFromJSON(String myJson)  {
        logger.info ("getWhazuppFromJSON - Start");
        ObjectMapper objectMapper = new ObjectMapper();
        Whazuup whazuup = null;
        try {
            whazuup = objectMapper.readValue(myJson, Whazuup.class); //https://www.baeldung.com/jackson-object-mapper-tutorial
        } catch (JsonProcessingException e) {
            e.printStackTrace();

            logger.error("getMapFromJSON - Erreur au dépassage : "+e.getMessage());
        }
        logger.info ("getWhazuppFromJSON - End");
        return whazuup;


    }
    /**
     * Get weather prevition for all the airport
     * @return list of weather prevition
     */
    @Override
    public  List<String> getWeatherPrevAirportList(){
        List<String> resultList = null;
        String airportList = null;
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("application");
            String url = bundle.getString("url.tar.apiv1");

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString()); // BodyHandler.asString());
            airportList = response.body().toString();

            resultList = Arrays.asList(airportList.split("\n"));

        }
        catch (URISyntaxException e) {
            logger.error("getWeatherPrevAirportList ERROR URISyntaxException");
            resultList = null;
        }
        catch (IOException e) {
            logger.error("getWeatherPrevAirportList ERROR IOException");
            resultList = null;
        }
        catch (InterruptedException e) {
            logger.error("getWeatherPrevAirportList ERROR InterruptedException");
            resultList = null;
        }
        return resultList;
    }
    /**
     * Get weather prevition for all the airport from ivao API V1
     * @return list of weather prevition
     */
 /*   @Deprecated
    @Override
    public  List<String> getPilotInfoList(){
        List<String> resultList = null;
        String pilotInfoList = null;
        try {

            ResourceBundle bundle = ResourceBundle.getBundle("application");
            String url = bundle.getString("url.whazzup.apiv1");

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString()); // BodyHandler.asString());
            pilotInfoList = response.body().toString();

            resultList = Arrays.asList(pilotInfoList.split("\n"));

        }
        catch (URISyntaxException e) {
            logger.error("getPilotInfoList ERROR URISyntaxException");
            resultList = null;
        }
        catch (IOException e) {
            logger.error("getPilotInfoList ERROR IOException");
            resultList = null;
        }
        catch (InterruptedException e) {
            logger.error("getPilotInfoList ERROR InterruptedException");
            resultList = null;
        }
        return resultList;
    }
    */

    /**
     * Get weather prevition for all the airport from ivao API V2
     * @return list of weather prevition
     */
    @Override
    public  String getPilotInfoList2(){
        List<String> resultList = null;
        String pilotInfoList = null;
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("application");
            String url = bundle.getString("url.whazzup.apiv2");

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString()); // BodyHandler.asString());
            pilotInfoList = response.body().toString();
        }
        catch (URISyntaxException e) {
            logger.error("getPilotInfoList ERROR URISyntaxException");
            resultList = null;
        }
        catch (IOException e) {
            logger.error("getPilotInfoList ERROR IOException");
            resultList = null;
        }
        catch (InterruptedException e) {
            logger.error("getPilotInfoList ERROR InterruptedException");
            resultList = null;
        }
        return pilotInfoList;
    }
}
