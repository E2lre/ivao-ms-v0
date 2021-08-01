package com.e2lre.ivaomsv0.controler;

import com.e2lre.ivaomsv0.controler.exception.AirportIdtNotFoundException;
import com.e2lre.ivaomsv0.controler.exception.CallsignNotFoundException;
import com.e2lre.ivaomsv0.controler.exception.VidNotFoundException;
import com.e2lre.ivaomsv0.model.PilotATC;
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

    /*---------------------------  GET weather observation by airport id -----------------------------*/
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
    /*---------------------------  GET weather prevition by airport id -----------------------------*/
    @GetMapping(value = "airportWeatherPrev/{airportId}")
    @ResponseStatus(HttpStatus.OK)
    public String getWeatherPrevByAirportId(@PathVariable String airportId) throws AirportIdtNotFoundException {

        logger.info("getWeatherPrevByAirportId start-" + airportId);
        String result = null;
        try {
            result = ivaoWeatherService.getWeatherPrevByAirport(airportId);
            if (result == null) {
                logger.warn("The airport Id " + airportId + " does not exist");
                throw new AirportIdtNotFoundException("The airport Id " + airportId + " does not exist");
            }
        }
        catch (URISyntaxException e) {
            logger.info("getWeatherPrevByAirportId ERROR URISyntaxException");
            result = "ERROR";
        }
        catch (IOException e) {
            logger.info("getWeatherPrevByAirportId ERROR IOException");
            result = "ERROR";
        }
        catch (InterruptedException e) {
            logger.info("getWeatherPrevByAirportId ERROR InterruptedException");
            result = "ERROR";
        }
        logger.info("getWeatherPrevByAirportId finish");
        return result;
    }
    /*---------------------------  GET pilot Info by callsign -----------------------------*/
    @GetMapping(value = "pilotInfoCallsign/{callsign}")
    @ResponseStatus(HttpStatus.OK)
    public PilotATC getPilotInfoByCallsign(@PathVariable String callsign) throws CallsignNotFoundException {

        logger.info("getPilotInfoByCallsign start-" + callsign);
        PilotATC result = null;
            result = ivaoWeatherService.getPilotInfoByCallsign(callsign);
            if (result == null) {
                logger.warn("The callsign " + callsign + " does not exist or is not a Pilot");
                throw new CallsignNotFoundException("The callsign " + callsign + " does not exist or is not a Pilot");
            }
        logger.info("getPilotInfoByCallsign finish");
        return result;
    }
    /*---------------------------  GET pilot info by VID -----------------------------*/
    @GetMapping(value = "pilotInfoVID/{vid}")
    @ResponseStatus(HttpStatus.OK)
    public PilotATC getPilotInfoByVid(@PathVariable String vid) throws VidNotFoundException {

        logger.info("getPilotInfoByVid start-" + vid);
        PilotATC result = null;
        result = ivaoWeatherService.getPilotInfoByVid(vid);
        if (result == null) {
            logger.warn("The vid " + vid + " does not exist or is not a pilot");
            throw new VidNotFoundException("The vid " + vid + " does not exist  or is not a pilot\"");
        }
        logger.info("getPilotInfoByVid finish");
        return result;
    }
    /*---------------------------  GET ATIS info by VID -----------------------------*/
    @GetMapping(value = "ATISInfoVID/{vid}")
    @ResponseStatus(HttpStatus.OK)
    public PilotATC getATISInfoByVid(@PathVariable String vid) throws VidNotFoundException {

        logger.info("getATISInfoByVid start-" + vid);
        PilotATC result = null;
        result = ivaoWeatherService.getATISInfoByVid(vid);
        if (result == null) {
            logger.warn("The vid " + vid + " does not exist or is not a ATIS");
            throw new VidNotFoundException("The vid " + vid + " does not exist  or is not an ATIS");
        }
        logger.info("getATISInfoByVid finish");
        return result;
    }
    /*---------------------------  GET ATIS info by VID -----------------------------*/
    @GetMapping(value = "FOLMEInfoVID/{vid}")
    @ResponseStatus(HttpStatus.OK)
    public PilotATC getFOLMEInfoByVid(@PathVariable String vid) throws VidNotFoundException {

        logger.info("getFOLMEInfoByVid start-" + vid);
        PilotATC result = null;
        result = ivaoWeatherService.getFOLMEInfoByVid(vid);
        if (result == null) {
            logger.warn("The vid " + vid + " does not exist or is not a FOLME");
            throw new VidNotFoundException("The vid " + vid + " does not exist  or is not an FOLME");
        }
        logger.info("getFOLMEInfoByVid finish");
        return result;
    }
}
