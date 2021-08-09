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

import javax.print.PrintException;
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
    @Autowired
    private IvaoPrintingService ivaoPrintingService;

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

    @Override
    public String printString(String info)  {
        String result = null;
        try {
            result = ivaoPrintingService.printInfo(info);
        } catch (PrintException e) {
            e.printStackTrace();
            logger.error("printString error : "+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("printString error : "+e.getMessage());
        }
        return result;
    }


}
