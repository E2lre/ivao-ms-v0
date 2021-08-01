package com.e2lre.ivaomsv0.service;

import com.e2lre.ivaomsv0.model.*;
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
            result = getMapFromList(weatherAirportList," ",0).get(airportId);
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
            result = getMapFromList(weatherAirportList," ",0).get(airportId);
        }
        else {
            result = null;
        }
        logger.info("getWeatherPrevByAirport Finish-"+airportId);
        return result;
    }

    /**
     * Give pilotinfo by callsign
     * @param callsign pilot callsign
     * @return pilotatc
     */
    @Override
    public PilotATC getPilotInfoByCallsign(String callsign) {
        PilotATC piloteATCResults = null;
        List<String> pilotInfoList = getPilotInfoList();
        if (pilotInfoList != null) {
            String result = getMapFromList(pilotInfoList,":",0).get(callsign);
            logger.info(result);
            if (result != null) {
                piloteATCResults = transfortStringToPilotATC(result);
                if (!piloteATCResults.getOtherInfo().getClientType().equals("PILOT")) {
                     logger.info("getPilotInfoByCallsign - Callsign "+ callsign +" is not PILOT but "+piloteATCResults.getOtherInfo().getClientType() );
                    piloteATCResults=null;
                }
            }
        }

        return piloteATCResults;
    }

    @Override
    public PilotATC getPilotInfoByVid(String vid) {
        PilotATC piloteATCResults = null;
        List<String> pilotInfoList = getPilotInfoList();
        if (pilotInfoList != null) {
            String result = getMapFromList(pilotInfoList,":",1).get(vid);
            logger.info(result);
            if (result != null) {
                piloteATCResults = transfortStringToPilotATC(result);
                if (!piloteATCResults.getOtherInfo().getClientType().equals("PILOT")) {
                    logger.info("getPilotInfoByCallsign - vid "+ vid +" is not PILOT but "+piloteATCResults.getOtherInfo().getClientType() );
                    piloteATCResults=null;
                }
            }
        }

        return piloteATCResults;
    }

    @Override
    public PilotATC getATISInfoByVid(String vid) {
        PilotATC piloteATCResults = null;
        List<String> atcInfoList = getPilotInfoList();
        if (atcInfoList != null) {
            String result = getMapFromList(atcInfoList,":",1).get(vid);
            logger.info(result);
            if (result != null) {
                piloteATCResults = transfortStringToPilotATC(result);
                if (!piloteATCResults.getOtherInfo().getClientType().equals("ATC")) {
                    logger.info("getATISInfoByVid - vid "+ vid +" is not ATC but "+piloteATCResults.getOtherInfo().getClientType() );
                    piloteATCResults=null;
                }
            }
        }

        return piloteATCResults;
    }

    @Override
    public PilotATC getFOLMEInfoByVid(String vid) {
        PilotATC piloteATCResults = null;
        List<String> atcInfoList = getPilotInfoList();
        if (atcInfoList != null) {
            String result = getMapFromList(atcInfoList,":",1).get(vid);
            logger.info(result);
            if (result != null) {
                piloteATCResults = transfortStringToPilotATC(result);
                if (!piloteATCResults.getOtherInfo().getClientType().equals("FOLME")) {
                    logger.info("getFOLMEInfoByVid - vid "+ vid +" is not FOLME but "+piloteATCResults.getOtherInfo().getClientType() );
                    piloteATCResults=null;
                }
            }
        }
        return piloteATCResults;
    }

    /**
     * Transfort list with separator to a map.the key map will be the first element of rach line
     * @param myList list to be transfort
     * @param separator list séparator
     * @return map from the list
     */
    private HashMap<String, String> getMapFromList(List<String> myList, String separator,int keyPosition) {
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

    private PilotATC transfortStringToPilotATC(String pilotATCList) {
        PilotATC pilotATC = new PilotATC();
        ATC atc = new ATC();
        Flightplan flightplan =new Flightplan();
        OtherInfo otherInfo = new OtherInfo();
        Pilote pilote = new Pilote();

        List<String> pilotAtcItem = Arrays.asList(pilotATCList.split(":"));
        otherInfo.setCallsign(pilotAtcItem.get(0));
        otherInfo.setVid(pilotAtcItem.get(1));
        otherInfo.setName(pilotAtcItem.get(2));
        otherInfo.setClientType(pilotAtcItem.get(3));
        atc.setFrequency(pilotAtcItem.get(4));
        otherInfo.setLatitude(pilotAtcItem.get(5));
        otherInfo.setLongitude(pilotAtcItem.get(6));
        otherInfo.setAltitude(pilotAtcItem.get(7));
        pilote.setGroundSpeed(pilotAtcItem.get(8));
        flightplan.setAircraft(pilotAtcItem.get(9));
        flightplan.setCruisingSpeed(pilotAtcItem.get(10));
        flightplan.setDepartureAerodrome(pilotAtcItem.get(11));
        flightplan.setCruisingLevel(pilotAtcItem.get(12));
        flightplan.setDestinationAerodrome(pilotAtcItem.get(13));
        otherInfo.setServer(pilotAtcItem.get(14));
        otherInfo.setProtocol(pilotAtcItem.get(15));
        otherInfo.setCombinedRating(pilotAtcItem.get(16));
        pilote.setTransponderCode(pilotAtcItem.get(17));
        pilote.setFacilityType(pilotAtcItem.get(18));
        pilote.setVisualRange(pilotAtcItem.get(18));
        flightplan.setRevision(pilotAtcItem.get(19));
        flightplan.setFlightRules(pilotAtcItem.get(20));
        flightplan.setDepartureTime(pilotAtcItem.get(21));
        flightplan.setActualDepartureTime(pilotAtcItem.get(22));
        flightplan.setEETHours(pilotAtcItem.get(23));
        flightplan.setEETMinutes(pilotAtcItem.get(24));
        flightplan.setEnduranceHours(pilotAtcItem.get(25));
        flightplan.setEnduranceMinutes(pilotAtcItem.get(26));
        flightplan.setAlternateAerodrome(pilotAtcItem.get(27));
        flightplan.setOtherInfo(pilotAtcItem.get(28));
        flightplan.setRoute(pilotAtcItem.get(29));
        otherInfo.setUnused1(pilotAtcItem.get(30));
        otherInfo.setUnused2(pilotAtcItem.get(31));
        atc.setAtis(pilotAtcItem.get(32));
        atc.setAtisTime(pilotAtcItem.get(33));
        otherInfo.setConnectionTime(pilotAtcItem.get(34));
        otherInfo.setSoftwareName(pilotAtcItem.get(35));
        otherInfo.setSoftwareVersion(pilotAtcItem.get(36));
        otherInfo.setAdministrativeVersion(pilotAtcItem.get(37));
        otherInfo.setAtcPilotVersion(pilotAtcItem.get(38));
        flightplan.setSecondndAlternateAerodrome(pilotAtcItem.get(39));
        flightplan.setTypeOfFlight(pilotAtcItem.get(40));
        flightplan.setPersonsOnBoard(pilotAtcItem.get(41));
        if (pilotAtcItem.size()>42) { //For pilot
            pilote.setOnGround(pilotAtcItem.get(42));
            pilote.setSimulator(pilotAtcItem.get(43));
            pilote.setPlane(pilotAtcItem.get(44));
        }
        pilote.setFlightplan(flightplan);
        pilotATC.setAtc(atc);
        pilotATC.setPilote(pilote);
        pilotATC.setOtherInfo(otherInfo);

        /*for (String item : pilotAtcItem) {
            logger.info("item: " + item + "index:"+pilotAtcItem.indexOf(item));
        }*/
        return pilotATC;
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
     * Get weather prevition for all the airport
     * @return list of weather prevition
     */
    private List<String> getPilotInfoList(){
        List<String> resultList = null;
        String pilotInfoList = null;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.ivao.aero/getdata/whazzup/whazzup.txt"))
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
}
