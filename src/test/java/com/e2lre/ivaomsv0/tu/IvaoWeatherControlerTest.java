package com.e2lre.ivaomsv0.tu;

import com.e2lre.ivaomsv0.model.ivao.Atc;
import com.e2lre.ivaomsv0.model.ivao.Pilot;
import com.e2lre.ivaomsv0.service.IvaoWeatherService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IvaoWeatherControlerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IvaoWeatherService ivaoWeatherServiceMock;
    //constantes de test
    String WaetherObs1Const = "LFPO 040930Z 17005KT 100V230 9999 SCT034 SCT053 BKN150 19/11 Q1013 NOSIG";
    String WaetherObs2Const = "LFPG 041000Z 10004KT 040V150 9999 SCT036 SCT100 BKN260 20/10 Q1013 NOSIG";
    String WaetherPrev1Const = "LFPO 040500Z 0406/0512 16005KT CAVOK  TEMPO 0414/0419 -SHRA SCT035TCU PROB30  TEMPO 0503/0506 4000 -RA BKN050";
    String WaetherPrev2Const = "LFPG 040658Z 0406/0512 12005KT CAVOK TX21/0415Z TN14/0504Z PROB30  TEMPO 0412/0418 -SHRA SCT035TCU  BECMG 0420/0422 BKN040";
    String airport1Const = "LFPO";
    String whazuupConst ="{\"updatedAt\":\"1234\",\"servers\":[{\"id\":\"2\",\"hostname\":\"TITI\",\"ip\":null,\"description\":null,\"countryId\":null,\"currentConnections\":null,\"maximumConnections\":null},{\"id\":\"2\",\"hostname\":\"TITI\",\"ip\":null,\"description\":null,\"countryId\":null,\"currentConnections\":null,\"maximumConnections\":null}],\"voiceServers\":null,\"clients\":{\"pilots\":[{\"time\":null,\"id\":\"1234\",\"userId\":\"177513\",\"callsign\":\"Pilot Test\",\"serverId\":null,\"softwareTypeId\":null,\"softwareVersion\":null,\"rating\":\"abcd\",\"createdAt\":null,\"flightPlan\":null,\"pilotSession\":null,\"lastTrack\":null}],\"atcs\":[],\"followMe\":null,\"observers\":null},\"connections\":null}";
    String userIdPilotConst ="177513";
    String userIdATCConst = "671399";

    @Test
    public void getWeatherObsByAirportId_WhenAirportExist_weatherObsIsReturn() throws Exception {
        //Given
        Mockito.when(ivaoWeatherServiceMock.getWeatherObsByAirport(airport1Const)).thenReturn(WaetherObs1Const);
        //When
        //Then
        mockMvc.perform(get("/airportWeatherObs/"+airport1Const))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getWeatherObsByAirportId_WhenAirportNotExist_errorIsReturn() throws Exception {
        //Given
        Mockito.when(ivaoWeatherServiceMock.getWeatherObsByAirport(airport1Const)).thenReturn(null);
        //When
        //Then
        mockMvc.perform(get("/airportWeatherObs/"+airport1Const))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
    @Test
    public void getWeatherPrevByAirportId_WhenAirportExist_weatherPrevIsReturn() throws Exception {
        //Given
        Mockito.when(ivaoWeatherServiceMock.getWeatherPrevByAirport(airport1Const)).thenReturn(WaetherPrev1Const);
        //When
        //Then
        mockMvc.perform(get("/airportWeatherPrev/"+airport1Const))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getWeatherPrevByAirportId_WhenAirportNotExist_errorIsReturn() throws Exception {
        //Given
        Mockito.when(ivaoWeatherServiceMock.getWeatherPrevByAirport(airport1Const)).thenReturn(null);
        //When
        //Then
        mockMvc.perform(get("/airportWeatherPrev/"+airport1Const))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
    @Test
    public void getPilotInfoByVid_WhenVIDExist_pilotInfoIsReturn() throws Exception {
        //Given
        Pilot pilot = new Pilot();
        pilot.setUserId(userIdPilotConst);
        pilot.setCallsign("Pilot Test");
        pilot.setId("1234");
        pilot.setRating("abcd");
        Mockito.when(ivaoWeatherServiceMock.getPilotInfoByVid2(userIdPilotConst)).thenReturn(pilot);
        //When
        //Then
        mockMvc.perform(get("/pilotInfoVID/"+userIdPilotConst))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getPilotInfoByVid_WhenVIDNotExist_errorIsReturn() throws Exception {
        //Given
        Mockito.when(ivaoWeatherServiceMock.getWeatherPrevByAirport(userIdPilotConst)).thenReturn(null);
        //When
        //Then
        mockMvc.perform(get("/pilotInfoVID/"+userIdPilotConst))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
    @Test
    public void getAtcInfoByVid_WhenVIDExist_atcInfoIsReturn() throws Exception {
        //Given
        Atc atc = new Atc();
        atc.setUserId(userIdATCConst);
        atc.setCallsign("Atc Test");
        atc.setId("1234");
        atc.setRating("abcd");
        Mockito.when(ivaoWeatherServiceMock.getATCInfoByVid(userIdATCConst)).thenReturn(atc);
        //When
        //Then
        mockMvc.perform(get("/ATCInfoVID/"+userIdATCConst))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getAtcInfoByVid_WhenVIDNotExist_errorIsReturn() throws Exception {
        //Given
        Mockito.when(ivaoWeatherServiceMock.getATCInfoByVid(userIdATCConst)).thenReturn(null);
        //When
        //Then
        mockMvc.perform(get("/ATCInfoVID/"+userIdATCConst))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void printString_WhenPrintString_StringIsPrinted() throws Exception {
        //Given
        Mockito.when(ivaoWeatherServiceMock.printString(airport1Const)).thenReturn(airport1Const);
        //When
        //Then
        mockMvc.perform(get("/printString/"+airport1Const))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void printString_WhenTechnicalError_errorIsReturn() throws Exception {
        //Given
        Mockito.when(ivaoWeatherServiceMock.printString(airport1Const)).thenReturn(null);
        //When
        //Then
        mockMvc.perform(get("/printString/"+airport1Const))
                .andDo(print())
                .andExpect(status().isNotAcceptable());
    }
    @Test
    public void printStringPost_WhenPrintString_StringIsPrinted() throws Exception {
        //Given
        Mockito.when(ivaoWeatherServiceMock.printString(WaetherObs2Const)).thenReturn(WaetherObs2Const);
        //When
        //Then

        mockMvc.perform(post("/printString")
                        .content(WaetherObs2Const)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void printStringPost_WhenTechnicalError_errorIsReturn() throws Exception {
        //Given
        Mockito.when(ivaoWeatherServiceMock.printString(WaetherObs2Const)).thenReturn(null);
        //When
        //Then
        mockMvc.perform(post("/printString")
                        .content(WaetherObs2Const)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotAcceptable());
    }
    @Test
    public void testWazuup_WhenTAny_NotnullIsReturn() throws Exception {
        //Given
        //When
        //Then
        mockMvc.perform(get("/testWazuup"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
