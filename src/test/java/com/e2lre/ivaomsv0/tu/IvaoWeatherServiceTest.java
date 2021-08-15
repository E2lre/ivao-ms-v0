package com.e2lre.ivaomsv0.tu;

import com.e2lre.ivaomsv0.model.ivao.*;
import com.e2lre.ivaomsv0.service.IvaoPrintingService;
import com.e2lre.ivaomsv0.service.IvaoUtilService;
import com.e2lre.ivaomsv0.service.IvaoWeatherService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.print.PrintException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class IvaoWeatherServiceTest {
    @Autowired
    private IvaoWeatherService ivaoWeatherService;
    @Autowired
    private IvaoUtilService ivaoUtilService;
    @MockBean
    private IvaoUtilService ivaoUtilServiceMock;
    @MockBean
    private IvaoPrintingService ivaoPrintingServiceMock;

    //constantes de test
    String WaetherObs1Const = "LFPO 040930Z 17005KT 100V230 9999 SCT034 SCT053 BKN150 19/11 Q1013 NOSIG";
    String WaetherObs2Const = "LFPG 041000Z 10004KT 040V150 9999 SCT036 SCT100 BKN260 20/10 Q1013 NOSIG";
    String WaetherPrev1Const = "LFPO 040500Z 0406/0512 16005KT CAVOK  TEMPO 0414/0419 -SHRA SCT035TCU PROB30  TEMPO 0503/0506 4000 -RA BKN050";
    String WaetherPrev2Const = "LFPG 040658Z 0406/0512 12005KT CAVOK TX21/0415Z TN14/0504Z PROB30  TEMPO 0412/0418 -SHRA SCT035TCU  BECMG 0420/0422 BKN040";
    String whazuupConst ="{\"updatedAt\":\"1234\",\"servers\":[{\"id\":\"2\",\"hostname\":\"TITI\",\"ip\":null,\"description\":null,\"countryId\":null,\"currentConnections\":null,\"maximumConnections\":null},{\"id\":\"2\",\"hostname\":\"TITI\",\"ip\":null,\"description\":null,\"countryId\":null,\"currentConnections\":null,\"maximumConnections\":null}],\"voiceServers\":null,\"clients\":{\"pilots\":[{\"time\":null,\"id\":\"1234\",\"userId\":\"177513\",\"callsign\":\"Pilot Test\",\"serverId\":null,\"softwareTypeId\":null,\"softwareVersion\":null,\"rating\":\"abcd\",\"createdAt\":null,\"flightPlan\":null,\"pilotSession\":null,\"lastTrack\":null}],\"atcs\":[],\"followMe\":null,\"observers\":null},\"connections\":null}";
    String userIdPilotConst ="177513";
    String userIdATCConst = "671399";
    /*------------------------ findAll ---------------------------------*/
    @Test
    public void getWeatherObsByAirport_WhenAirportExist_WeatherObservationIsReturn(){
        //GIVEN
        String airportId = "LFPO";
        List<String> weatherAirportList = new ArrayList<>();
        weatherAirportList.add(WaetherObs1Const);
        weatherAirportList.add(WaetherObs2Const);
        HashMap<String, String> myMap = new HashMap<>();
        myMap.put(airportId, WaetherObs1Const);
        Mockito.when(ivaoUtilServiceMock.getWeatherObsAirportList()).thenReturn(weatherAirportList);
        Mockito.when(ivaoUtilServiceMock.getMapFromList(weatherAirportList," ",0)).thenReturn(myMap);//(myMap.get(airportId));

        //WHEN
        String result  =  ivaoWeatherService.getWeatherObsByAirport(airportId);
        //THEN
        assertThat(result).isNotEmpty();
        assertThat(result).isEqualTo(WaetherObs1Const);
    }
    @Test
    public void getWeatherObsByAirport_WhenAirportNotExist_nullIsReturn(){
        //GIVEN
        String airportId = "LFPO";
        List<String> weatherAirportList = new ArrayList<>();
        weatherAirportList.add(WaetherObs1Const);
        weatherAirportList.add(WaetherObs2Const);
        HashMap<String, String> myMap = new HashMap<>();
        myMap.put(airportId, WaetherObs1Const);
        Mockito.when(ivaoUtilServiceMock.getWeatherObsAirportList()).thenReturn(weatherAirportList);
        Mockito.when(ivaoUtilServiceMock.getMapFromList(weatherAirportList," ",0)).thenReturn(myMap);//(myMap.get(airportId));

        //WHEN
        String result  =  ivaoWeatherService.getWeatherObsByAirport(" ");
        //THEN
        assertThat(result).isNull();
    }
    @Test
    public void getWeatherPrevByAirport_WhenAirportExist_WeatherPrevisionIsReturn(){
        //GIVEN
        String airportId = "LFPO";
        List<String> weatherAirportList = new ArrayList<>();
        weatherAirportList.add(WaetherPrev1Const);
        weatherAirportList.add(WaetherPrev2Const);
        HashMap<String, String> myMap = new HashMap<>();
        myMap.put(airportId, WaetherPrev1Const);
        Mockito.when(ivaoUtilServiceMock.getWeatherPrevAirportList()).thenReturn(weatherAirportList);
        Mockito.when(ivaoUtilServiceMock.getMapFromList(weatherAirportList," ",0)).thenReturn(myMap);//(myMap.get(airportId));

        //WHEN
        String result  =  ivaoWeatherService.getWeatherPrevByAirport(airportId);
        //THEN
        assertThat(result).isNotEmpty();
        assertThat(result).isEqualTo(WaetherPrev1Const);
    }
    @Test
    public void getWeatherPrevByAirport_WhenAirportNotExist_nullIsReturn(){
        //GIVEN
        String airportId = "LFPO";
        List<String> weatherAirportList = new ArrayList<>();
        weatherAirportList.add(WaetherPrev1Const);
        weatherAirportList.add(WaetherPrev2Const);
        HashMap<String, String> myMap = new HashMap<>();
        myMap.put(airportId, WaetherPrev1Const);
        Mockito.when(ivaoUtilServiceMock.getWeatherPrevAirportList()).thenReturn(weatherAirportList);
        Mockito.when(ivaoUtilServiceMock.getMapFromList(weatherAirportList," ",0)).thenReturn(myMap);//(myMap.get(airportId));

        //WHEN
        String result  =  ivaoWeatherService.getWeatherPrevByAirport(" ");
        //THEN
        assertThat(result).isNull();

    }
    @Test
    public void getPilotInfoByVid2_WhenUserIdExist_pilotInfoIsReturn() {
        //GIVEN
        Whazuup whazuup = testWhazuup();
        List<Pilot> piloteResults =  whazuup.getClients().getPilots();
        Pilot pilot= ivaoUtilService.findPilotByVid(piloteResults,userIdPilotConst);

        Mockito.when(ivaoUtilServiceMock.getPilotInfoList2()).thenReturn(whazuupConst);

        Mockito.when(ivaoUtilServiceMock.getWhazuppFromJSON(whazuupConst)).thenReturn(whazuup);

        Mockito.when(ivaoUtilServiceMock.findPilotByVid(piloteResults,userIdPilotConst)).thenReturn(whazuup.getClients().getPilots().get(0));
        //WHEN
        Pilot result=  ivaoWeatherService.getPilotInfoByVid2(userIdPilotConst);
        //THEN
        assertThat(result).isNotNull();
        assertThat(result.getCallsign()).isEqualTo("Pilot Test");
    }
    @Test
    public void getPilotInfoByVid2_WhenUserIdNotExist_nullIsReturn() {
        //GIVEN
        Whazuup whazuup = testWhazuup();
        List<Pilot> piloteResults =  whazuup.getClients().getPilots();

        Mockito.when(ivaoUtilServiceMock.getPilotInfoList2()).thenReturn(whazuupConst);

        Mockito.when(ivaoUtilServiceMock.getWhazuppFromJSON(whazuupConst)).thenReturn(whazuup);

        Mockito.when(ivaoUtilServiceMock.findPilotByVid(piloteResults,userIdPilotConst)).thenReturn(whazuup.getClients().getPilots().get(0));
        //WHEN
        Pilot result=  ivaoWeatherService.getPilotInfoByVid2(" ");
        //THEN
        assertThat(result).isNull();
    }
    @Test
    public void getAtcInfoByVid2_WhenUserIdExist_atcInfoIsReturn() {
        //GIVEN
        Whazuup whazuup = testWhazuup();
        List<Atc> atcResults =  whazuup.getClients().getAtcs();

        Mockito.when(ivaoUtilServiceMock.getPilotInfoList2()).thenReturn(whazuupConst);

        Mockito.when(ivaoUtilServiceMock.getWhazuppFromJSON(whazuupConst)).thenReturn(whazuup);

        Mockito.when(ivaoUtilServiceMock.findAtcByVid(atcResults,userIdATCConst)).thenReturn(whazuup.getClients().getAtcs().get(0));
        //WHEN
        Atc result=  ivaoWeatherService.getATCInfoByVid(userIdATCConst);
        //THEN
        assertThat(result).isNotNull();
        assertThat(result.getCallsign()).isEqualTo("atc test");
    }
    @Test
    public void getAtcInfoByVid2_WhenUserIdNotExist_nullIsReturn() {
        //GIVEN
        Whazuup whazuup = testWhazuup();
        List<Atc> atcResults =  whazuup.getClients().getAtcs();

        Mockito.when(ivaoUtilServiceMock.getPilotInfoList2()).thenReturn(whazuupConst);

        Mockito.when(ivaoUtilServiceMock.getWhazuppFromJSON(whazuupConst)).thenReturn(whazuup);

        Mockito.when(ivaoUtilServiceMock.findAtcByVid(atcResults,userIdATCConst)).thenReturn(whazuup.getClients().getAtcs().get(0));
        //WHEN
        Atc result=  ivaoWeatherService.getATCInfoByVid(" ");
        //THEN
        assertThat(result).isNull();
    }
    @Test
    public void getATCInfoByCallsign_WhenUserIdExist_atcInfoIsReturn() {
        //GIVEN
        Whazuup whazuup = testWhazuup();
        List<Atc> atcResults =  whazuup.getClients().getAtcs();

        Mockito.when(ivaoUtilServiceMock.getPilotInfoList2()).thenReturn(whazuupConst);

        Mockito.when(ivaoUtilServiceMock.getWhazuppFromJSON(whazuupConst)).thenReturn(whazuup);

        Mockito.when(ivaoUtilServiceMock.findAtcByCallsign(atcResults,userIdATCConst)).thenReturn(whazuup.getClients().getAtcs().get(0));
        //WHEN
        Atc result=  ivaoWeatherService.getATCInfoByCallsign(userIdATCConst);
        //THEN
        assertThat(result).isNotNull();
        assertThat(result.getCallsign()).isEqualTo("atc test");
    }
    @Test
    public void getATCInfoByCallsign_WhenUserIdNotExist_nullIsReturn() {
        //GIVEN
        Whazuup whazuup = testWhazuup();
        List<Atc> atcResults =  whazuup.getClients().getAtcs();

        Mockito.when(ivaoUtilServiceMock.getPilotInfoList2()).thenReturn(whazuupConst);

        Mockito.when(ivaoUtilServiceMock.getWhazuppFromJSON(whazuupConst)).thenReturn(whazuup);

        Mockito.when(ivaoUtilServiceMock.findAtcByCallsign(atcResults,userIdATCConst)).thenReturn(whazuup.getClients().getAtcs().get(0));
        //WHEN
        Atc result=  ivaoWeatherService.getATCInfoByCallsign(" ");
        //THEN
        assertThat(result).isNull();
    }
    @Test
    public void printString_whenPrintString_stringPrintedIsReturn () throws IOException, PrintException {
        //Given
        Mockito.when(ivaoPrintingServiceMock.printInfo(WaetherObs1Const)).thenReturn(WaetherObs1Const);
        //WHEN
        String result = ivaoWeatherService.printString(WaetherObs1Const);
        //THEN
        assertThat(result).isEqualTo(WaetherObs1Const);

    }
    private Whazuup testWhazuup() {
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
        pilote.setUserId(userIdPilotConst);
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
