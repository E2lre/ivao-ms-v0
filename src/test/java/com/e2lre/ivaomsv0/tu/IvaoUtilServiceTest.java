package com.e2lre.ivaomsv0.tu;

import com.e2lre.ivaomsv0.model.ivao.Atc;
import com.e2lre.ivaomsv0.model.ivao.FlightPlan;
import com.e2lre.ivaomsv0.model.ivao.Pilot;
import com.e2lre.ivaomsv0.model.ivao.Whazuup;
import com.e2lre.ivaomsv0.service.IvaoUtilService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class IvaoUtilServiceTest {
    @Autowired
    private IvaoUtilService ivaoUtilService;
    //constantes de test
    String WeatherObs1Const = "LFPO 040930Z 17005KT 100V230 9999 SCT034 SCT053 BKN150 19/11 Q1013 NOSIG";
    String WeatherObs2Const = "LFPG 041000Z 10004KT 040V150 9999 SCT036 SCT100 BKN260 20/10 Q1013 NOSIG";
    String WeatherPrev1Const = "LFPO 040500Z 0406/0512 16005KT CAVOK  TEMPO 0414/0419 -SHRA SCT035TCU PROB30  TEMPO 0503/0506 4000 -RA BKN050";
    String WeatherPrev2Const = "LFPG 040658Z 0406/0512 12005KT CAVOK TX21/0415Z TN14/0504Z PROB30  TEMPO 0412/0418 -SHRA SCT035TCU  BECMG 0420/0422 BKN040";
    String whazuupConst ="{\"updatedAt\":\"1234\",\"servers\":[{\"id\":\"2\",\"hostname\":\"TITI\",\"ip\":null,\"description\":null,\"countryId\":null,\"currentConnections\":null,\"maximumConnections\":null},{\"id\":\"2\",\"hostname\":\"TITI\",\"ip\":null,\"description\":null,\"countryId\":null,\"currentConnections\":null,\"maximumConnections\":null}],\"voiceServers\":null,\"clients\":{\"pilots\":[{\"time\":null,\"id\":\"1234\",\"userId\":\"177513\",\"callsign\":\"Pilot Test\",\"serverId\":null,\"softwareTypeId\":null,\"softwareVersion\":null,\"rating\":\"abcd\",\"createdAt\":null,\"flightPlan\":null,\"pilotSession\":null,\"lastTrack\":null}],\"atcs\":[],\"followMe\":null,\"observers\":null},\"connections\":null}";
    String userIdPilotConst ="177513";
    String userIdATCConst = "671399";
    String WeatherObsConst = WeatherObs1Const + "\n" +WeatherObs2Const;

    @Test
    public void getMapFromList_whenCorrectDataIsGiven_hashMapIsReturn () {
        //Given
        List<String> weatherObsList = new ArrayList<>();
        weatherObsList.add(WeatherObs1Const);
        weatherObsList.add(WeatherObs2Const);
        //When
        HashMap<String, String> result = ivaoUtilService.getMapFromList(weatherObsList," ",0);
        //Then
        assertThat(result).isNotEmpty();
        assertThat(result.size()).isEqualTo(weatherObsList.size());
    }
    @Test
    public void findAtcByVid_WhenATCExist_ReturnACT (){
        //Given
        List<Atc> atcs = new ArrayList<>();
        Atc atc = new Atc();
        atc.setId("1234");
        atc.setUserId(userIdATCConst);
        atc.setCallsign("ABCD");
        atcs.add(atc);
        Atc atc2 = new Atc();
        atc2.setId("9876");
        atc2.setUserId(userIdPilotConst);
        atc2.setCallsign("ZYXW");
        atcs.add(atc2);
        Atc result = ivaoUtilService.findAtcByVid(atcs,userIdATCConst);
        assertThat(result).isNotNull();
        assertThat(result.getCallsign()).isEqualTo("ABCD");
    }
    @Test
    public void findPilotByVid_WhenPilotExist_ReturnACT (){
        //Given
        List<Pilot> pilots = new ArrayList<>();
        Pilot pilot = new Pilot();
        pilot.setId("1234");
        pilot.setUserId(userIdATCConst);
        pilot.setCallsign("ABCD");
        FlightPlan flightPlan = new FlightPlan();
        flightPlan.setAircraftId("A320");
        pilot.setFlightPlan(flightPlan);
        pilots.add(pilot);
        Pilot pilot2 = new Pilot();
        pilot2.setId("9876");
        pilot2.setUserId(userIdPilotConst);
        pilot2.setCallsign("ZYXW");
        pilots.add(pilot2);
        String test = pilot.toString();
        test = flightPlan.toString();
        //When
        Pilot result = ivaoUtilService.findPilotByVid(pilots,userIdPilotConst);
        //Then
        assertThat(result).isNotNull();
        assertThat(result.getCallsign()).isEqualTo("ZYXW");
    }

    @Test
    public void getWhazuppFromJSON_whenJsonIsCorrect_WhazuupIsReturn(){
        //Given
        //When
        Whazuup whazuup = ivaoUtilService.getWhazuppFromJSON(whazuupConst);
        //Then
        assertThat(whazuup).isNotNull();
    }
}
