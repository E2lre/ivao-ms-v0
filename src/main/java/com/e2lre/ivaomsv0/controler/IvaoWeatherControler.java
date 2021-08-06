package com.e2lre.ivaomsv0.controler;

import com.e2lre.ivaomsv0.controler.exception.AirportIdtNotFoundException;
import com.e2lre.ivaomsv0.controler.exception.CallsignNotFoundException;
import com.e2lre.ivaomsv0.controler.exception.PrintException;
import com.e2lre.ivaomsv0.controler.exception.VidNotFoundException;
import com.e2lre.ivaomsv0.model.PilotATC;
import com.e2lre.ivaomsv0.model.ivao.*;
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
import java.util.ArrayList;
import java.util.List;

@RestController
public class IvaoWeatherControler {
    private static final Logger logger = LogManager.getLogger(IvaoWeatherControler.class);
    @Autowired
    private IvaoWeatherService ivaoWeatherService;

    /*---------------------------  GET weather observation by airport id -----------------------------*/

    /**
     * Get Weather Observation By Airport Id
     * @param airportId airportId
     * @return Weather Observation
     * @throws AirportIdtNotFoundException if airportId not found
     */
    @GetMapping(value = "airportWeatherObs/{airportId}")
    @ResponseStatus(HttpStatus.OK)
    public String getWeatherObsByAirportId(@PathVariable String airportId) throws AirportIdtNotFoundException {

        logger.info("getWeatherObsByAirportId start-" + airportId);
        String result = null;
       // try {
            result = ivaoWeatherService.getWeatherObsByAirport(airportId);
            if (result == null) {
                logger.warn("The airport Id " + airportId + " does not exist");
                throw new AirportIdtNotFoundException("The airport Id " + airportId + " does not exist");
            }
       // }
      /*  catch (URISyntaxException e) {
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
        }*/
        logger.info("getWeatherObsByAirportId finish");
        return result;
    }
    /*---------------------------  GET weather prevition by airport id -----------------------------*/

    /**
     * Get Weather Previtions By Airport Id
     * @param airportId airportId
     * @return Weather Previtions
     * @throws AirportIdtNotFoundException if airportId not found
     */
    @GetMapping(value = "airportWeatherPrev/{airportId}")
    @ResponseStatus(HttpStatus.OK)
    public String getWeatherPrevByAirportId(@PathVariable String airportId) throws AirportIdtNotFoundException {

        logger.info("getWeatherPrevByAirportId start-" + airportId);
        String result = null;
        //try {
            result = ivaoWeatherService.getWeatherPrevByAirport(airportId);
            if (result == null) {
                logger.warn("The airport Id " + airportId + " does not exist");
                throw new AirportIdtNotFoundException("The airport Id " + airportId + " does not exist");
            }
        //}
        /*
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
        }*/
        logger.info("getWeatherPrevByAirportId finish");
        return result;
    }
    /*---------------------------  GET pilot Info by callsign -----------------------------*/
    @Deprecated
    @GetMapping(value = "pilotInfoCallsignOLD/{callsign}")
    @ResponseStatus(HttpStatus.OK)
    public PilotATC getPilotInfoByCallsignOLD(@PathVariable String callsign) throws CallsignNotFoundException {

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
    @Deprecated
    @GetMapping(value = "pilotInfoVIDOLD/{vid}")
    @ResponseStatus(HttpStatus.OK)
    public PilotATC getPilotInfoByVidOLD(@PathVariable String vid) throws VidNotFoundException {

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
    /*---------------------------  GET pilot info by VID -----------------------------*/

    /**
     * Get Pilot Information By Vid
     * @param vid VID
     * @return Pilot Information
     * @throws VidNotFoundException if vid not found
     */
    @GetMapping(value = "pilotInfoVID/{vid}")
    @ResponseStatus(HttpStatus.OK)
    public Pilot getPilotInfoByVid(@PathVariable String vid) throws VidNotFoundException {

        logger.info("getPilotInfoByVid start-" + vid);
        Pilot result = null;
        //result = ivaoWeatherService.getPilotInfoByVid(vid);
        result = ivaoWeatherService.getPilotInfoByVid2(vid);
        if (result == null) {
            logger.warn("The vid " + vid + " does not exist or is not a pilot");
            throw new VidNotFoundException("The vid " + vid + " does not exist  or is not a pilot\"");
        }
        logger.info("getPilotInfoByVid finish");
        return result;
    }
    /*---------------------------  GET ATC info by VID -----------------------------*/

    /**
     * Get ATC Information By Vid
     * @param vid VID
     * @return ATC Information
     * @throws VidNotFoundException if vid not found
     */
    @GetMapping(value = "ATCInfoVID/{vid}")
    @ResponseStatus(HttpStatus.OK)
    public Atc getATCInfoByVid(@PathVariable String vid) throws VidNotFoundException {

        logger.info("getATCInfoByVid start-" + vid);
        Atc result = null;
        result = ivaoWeatherService.getATCInfoByVid(vid);
        if (result == null) {
            logger.warn("The vid " + vid + " does not exist or is not a ATC");
            throw new VidNotFoundException("The vid " + vid + " does not exist  or is not an ATC");
        }
        logger.info("getATCInfoByVid finish");
        return result;
    }
    /*---------------------------  Print information string -----------------------------*/


    @GetMapping(value = "printString/{info}")
    @ResponseStatus(HttpStatus.OK)
    public String printString(@PathVariable String info) throws PrintException {

        logger.info("print start-" + info);
        String result = null;
        if (info.isEmpty()){
            logger.warn("Print String error. No data to print" );
            throw new PrintException("Print String error. No data to print");
        }
        result = ivaoWeatherService.printString(info);
        if (result == null) {
            logger.warn("Print String error. Please, look for application logs" );
            throw new PrintException("Print String error. Please, look for application logs");
        }
        logger.info("print finish");
        return result;
    }

    /*---------------------------  GET ATIS info by VID -----------------------------*/
    @Deprecated
    @GetMapping(value = "ATISInfoVIDOLD/{vid}")
    @ResponseStatus(HttpStatus.OK)
    public PilotATC getATISInfoByVidOLD(@PathVariable String vid) throws VidNotFoundException {

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
    @Deprecated
    @GetMapping(value = "FOLMEInfoVIDOLD/{vid}")
    @ResponseStatus(HttpStatus.OK)
    public PilotATC getFOLMEInfoByVidOLD(@PathVariable String vid) throws VidNotFoundException {

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

    /*---------------------------  Test whazuup -----------------------------*/

    /**
     * test json generation
     * @return whazuup json
     */
    @GetMapping(value = "testWazuup")
    @ResponseStatus(HttpStatus.OK)
    public Whazuup testWazuup(){

        logger.info("TestWazuup start" );
       Whazuup whazuupResult = new Whazuup();
       whazuupResult.setUpdatedAt("1234");
        Server server = new Server();
        server.setId("1");
        server.setHostname("TOTO");
        List<Server> servers = new ArrayList<>();
        servers.add(server);
        server.setId("2");
        server.setHostname("TITI");
        servers.add(server);
        whazuupResult.setServers(servers);
        Pilot pilote = new Pilot();
        pilote.setCallsign("Pilot Test");
        pilote.setUserId("177513");
        pilote.setId("1234");
        pilote.setRating("abcd");
        List<Pilot> pilots = new ArrayList<>();
        pilots.add(pilote);
        Atc atc = new Atc();
        atc.setUserId("671399");
        atc.setCallsign("atc test");
        atc.setId("9876");
        atc.setRating("XYZ");
        List<Atc> atcs = new ArrayList<>();
        atcs.add(atc);
        Client client = new Client();
        client.setPilots(pilots);
        client.setAtcs(atcs);
        whazuupResult.setClients(client);

        return whazuupResult;
    }
}
