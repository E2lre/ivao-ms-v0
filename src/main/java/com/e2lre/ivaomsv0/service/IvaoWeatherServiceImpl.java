package com.e2lre.ivaomsv0.service;

import com.e2lre.ivaomsv0.model.*;
import com.e2lre.ivaomsv0.model.ivao.Atc;
import com.e2lre.ivaomsv0.model.ivao.Pilot;
import com.e2lre.ivaomsv0.model.ivao.Whazuup;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

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
public class IvaoWeatherServiceImpl implements IvaoWeatherService {
    private static final Logger logger = LogManager.getLogger(IvaoWeatherServiceImpl.class);
    @Autowired
    private IvaoUtilService ivaoUtilService;

    @Override
    /**
     * give weather Observation for the airport  whith ivao API V1
     */
    public String getWeatherObsByAirport(String airportId) /*throws URISyntaxException, IOException, InterruptedException*/ {
        String result = null;
        //HashMap<String, String> weatherAirportMap = new HashMap<>();
        logger.info("getWeatherObsByAirport start-"+airportId);

        List<String> weatherAirportList = ivaoUtilService.getWeatherObsAirportList();
        if (weatherAirportList != null)  {
            result = ivaoUtilService.getMapFromList(weatherAirportList," ",0).get(airportId);
        }
        else {
            result = null;
        }
        logger.info("getWeatherObsByAirport Finish-"+airportId);
        return result;
    }

    @Override
    /**
     * give weather prevition for the airport  whith ivao API V1
     */
    public String getWeatherPrevByAirport(String airportId) /*throws URISyntaxException, IOException, InterruptedException*/ {
        String result = null;
        //HashMap<String, String> weatherAirportMap = new HashMap<>();
        logger.info("getWeatherPrevByAirport start-"+airportId);

        List<String> weatherAirportList = ivaoUtilService.getWeatherPrevAirportList();
        if (weatherAirportList != null)  {
            result = ivaoUtilService.getMapFromList(weatherAirportList," ",0).get(airportId);
        }
        else {
            result = null;
        }
        logger.info("getWeatherPrevByAirport Finish-"+airportId);
        return result;
    }

    /**
     * Give pilotinfo by callsign with ivao API V1
     * @param callsign pilot callsign
     * @return pilotatc
     */
    @Deprecated
    @Override
    public PilotATC getPilotInfoByCallsign(String callsign) {
        PilotATC piloteATCResults = null;
        List<String> pilotInfoList = ivaoUtilService.getPilotInfoList();
        if (pilotInfoList != null) {
            String result = ivaoUtilService.getMapFromList(pilotInfoList,":",0).get(callsign);
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

    /**
     * Give pilot information by vid with ivao API V1
     * @param vid pilot vid
     * @return pilot information
     */
    @Deprecated
    @Override
    public PilotATC getPilotInfoByVid(String vid) {
        PilotATC piloteATCResults = null;
        List<String> pilotInfoList = ivaoUtilService.getPilotInfoList();
        if (pilotInfoList != null) {
            String result = ivaoUtilService.getMapFromList(pilotInfoList,":",1).get(vid);
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

    /**
     * Give pilot information by vid with ivao API V2
     * @param vid pilot vid
     * @return pilot information
     */
    @Override
    public Pilot getPilotInfoByVid2(String vid) {
        Pilot piloteResult = null;
        String pilotInfoList = ivaoUtilService.getPilotInfoList2();
        if (pilotInfoList != null) {
            Whazuup whazuup = ivaoUtilService.getWhazuppFromJSON(pilotInfoList);
            if (whazuup != null) {
                List<Pilot> piloteResults =  whazuup.getClients().getPilots();
                piloteResult = ivaoUtilService.findPilotByVid(piloteResults,vid);

            }
        }
        return piloteResult;
    }

    /**
     * Give atc information by vid with ivao API V2
     * @param vid atc vid
     * @return atc information
     */
    @Override
    public Atc getATCInfoByVid(String vid) {
        Atc atcResult = null;
        String atcInfoList = ivaoUtilService.getPilotInfoList2();
        if (atcInfoList != null) {
            Whazuup whazuup = ivaoUtilService.getWhazuppFromJSON(atcInfoList);
            if (whazuup != null) {
                List<Atc> atcResults = whazuup.getClients().getAtcs();
                atcResult = ivaoUtilService.findAtcByVid(atcResults,vid);

            }
        }

        return atcResult;
    }

    /**
     * get ATIS  Info By Vid with ivao API V1
     * @param vid vid
     * @return ATIS info
     */
    @Deprecated
    @Override
    public PilotATC getATISInfoByVid(String vid) {
        PilotATC piloteATCResults = null;
        List<String> atcInfoList = ivaoUtilService.getPilotInfoList();
        if (atcInfoList != null) {
            String result = ivaoUtilService.getMapFromList(atcInfoList,":",1).get(vid);
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

    /**
     *  get FOLME Info By Vid with ivao API V1
     * @param vid vid
     * @return FOLME information
     */
    @Deprecated
    @Override
    public PilotATC getFOLMEInfoByVid(String vid) {
        PilotATC piloteATCResults = null;
        List<String> atcInfoList = ivaoUtilService.getPilotInfoList();
        if (atcInfoList != null) {
            String result = ivaoUtilService.getMapFromList(atcInfoList,":",1).get(vid);
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

/*
    private Atc findAtcByVid(List<Atc> atcs,String vid) {
        Atc atcResult = null;
        for (Atc a : atcs){
            if (a.getUserId().equals(vid)) {
                atcResult = a;
            }
        }
        return atcResult;
    }
    private Pilot findPilotByVid(List<Pilot> pilotes,String vid) {
        Pilot piloteResult = null;
        for (Pilot p : pilotes){
            if (p.getUserId().equals(vid)) {
                piloteResult = p;
            }
        }
        return piloteResult;
    }


    private  Whazuup  getWhazuppFromJSON(String myJson)  {
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
*/
    /**
     * Transfort list with separator to a map.the key map will be the first element of rach line
     * @param myList list to be transfort
     * @param separator list séparator
     * @return map from the list
     */
  /*  @Override
    public HashMap<String, String> getMapFromList(List<String> myList, String separator,int keyPosition) {
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
    }*/

    /**
     * convert pilotatc list from ivao API V1 in pilotATC object
     * @param pilotATCList pilotatc list from ivao API V1
     * @return pilotATC object
     */
    @Deprecated
    private PilotATC transfortStringToPilotATC(String pilotATCList) {
        PilotATC pilotATC = new PilotATC();
        ATC atc = new ATC();
        Flightplan1 flightplan1 =new Flightplan1();
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
        flightplan1.setAircraft(pilotAtcItem.get(9));
        flightplan1.setCruisingSpeed(pilotAtcItem.get(10));
        flightplan1.setDepartureAerodrome(pilotAtcItem.get(11));
        flightplan1.setCruisingLevel(pilotAtcItem.get(12));
        flightplan1.setDestinationAerodrome(pilotAtcItem.get(13));
        otherInfo.setServer(pilotAtcItem.get(14));
        otherInfo.setProtocol(pilotAtcItem.get(15));
        otherInfo.setCombinedRating(pilotAtcItem.get(16));
        pilote.setTransponderCode(pilotAtcItem.get(17));
        pilote.setFacilityType(pilotAtcItem.get(18));
        pilote.setVisualRange(pilotAtcItem.get(18));
        flightplan1.setRevision(pilotAtcItem.get(19));
        flightplan1.setFlightRules(pilotAtcItem.get(20));
        flightplan1.setDepartureTime(pilotAtcItem.get(21));
        flightplan1.setActualDepartureTime(pilotAtcItem.get(22));
        flightplan1.setEETHours(pilotAtcItem.get(23));
        flightplan1.setEETMinutes(pilotAtcItem.get(24));
        flightplan1.setEnduranceHours(pilotAtcItem.get(25));
        flightplan1.setEnduranceMinutes(pilotAtcItem.get(26));
        flightplan1.setAlternateAerodrome(pilotAtcItem.get(27));
        flightplan1.setOtherInfo(pilotAtcItem.get(28));
        flightplan1.setRoute(pilotAtcItem.get(29));
        otherInfo.setUnused1(pilotAtcItem.get(30));
        otherInfo.setUnused2(pilotAtcItem.get(31));
        atc.setAtis(pilotAtcItem.get(32));
        atc.setAtisTime(pilotAtcItem.get(33));
        otherInfo.setConnectionTime(pilotAtcItem.get(34));
        otherInfo.setSoftwareName(pilotAtcItem.get(35));
        otherInfo.setSoftwareVersion(pilotAtcItem.get(36));
        otherInfo.setAdministrativeVersion(pilotAtcItem.get(37));
        otherInfo.setAtcPilotVersion(pilotAtcItem.get(38));
        flightplan1.setSecondndAlternateAerodrome(pilotAtcItem.get(39));
        flightplan1.setTypeOfFlight(pilotAtcItem.get(40));
        flightplan1.setPersonsOnBoard(pilotAtcItem.get(41));
        if (pilotAtcItem.size()>42) { //For pilot
            pilote.setOnGround(pilotAtcItem.get(42));
            pilote.setSimulator(pilotAtcItem.get(43));
            pilote.setPlane(pilotAtcItem.get(44));
        }
        pilote.setFlightplan1(flightplan1);
        pilotATC.setAtc(atc);
        pilotATC.setPilote(pilote);
        pilotATC.setOtherInfo(otherInfo);

        return pilotATC;
    }
    /**
     * Get weather observation for all the airport
     * @return list of weather observation
     */
   /* @Override
    public List<String> getWeatherObsAirportList(){
        List<String> resultList = null;
        String airportList = null;
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("application");
            String url = bundle.getString("url.metar.apiv1");

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
*/
    /**
     * Get weather prevition for all the airport
     * @return list of weather prevition
     */
  /*  private List<String> getWeatherPrevAirportList(){
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
*/
    /**
     * Get weather prevition for all the airport from ivao API V1
     * @return list of weather prevition
     */
 /*   @Deprecated
    private List<String> getPilotInfoList(){
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
    }*/
    /**
     * Get weather prevition for all the airport from ivao API V2
     * @return list of weather prevition
     */
 /*   private String getPilotInfoList2(){
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
    }*/
}
