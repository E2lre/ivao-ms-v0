package com.e2lre.ivaomsv0.service;

import com.e2lre.ivaomsv0.model.ivao.Atc;
import com.e2lre.ivaomsv0.model.ivao.Pilot;
import com.e2lre.ivaomsv0.model.ivao.Whazuup;

import java.util.HashMap;
import java.util.List;

public interface IvaoUtilService {
    //methode public for test only,
    public List<String> getWeatherObsAirportList();
    public HashMap<String, String> getMapFromList(List<String> myList, String separator, int keyPosition);
    Atc findAtcByVid(List<Atc> atcs, String vid);
    Atc findAtcByCallsign(List<Atc> atcs, String callsign);
    public Pilot findPilotByVid(List<Pilot> pilotes, String vid);
    public Whazuup getWhazuppFromJSON(String myJson);
    public  List<String> getWeatherPrevAirportList();
    public  List<String> getPilotInfoList();
    public  String getPilotInfoList2();



}
