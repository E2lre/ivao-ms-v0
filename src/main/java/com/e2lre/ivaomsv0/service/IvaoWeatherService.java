package com.e2lre.ivaomsv0.service;

import com.e2lre.ivaomsv0.model.PilotATC;

import java.io.IOException;
import java.net.URISyntaxException;

public interface IvaoWeatherService {
    public String getWeatherObsByAirport(String airportId) throws URISyntaxException, IOException, InterruptedException;
    public String getWeatherPrevByAirport(String airportId) throws URISyntaxException, IOException, InterruptedException;
    public PilotATC getPilotInfoByCallsign(String callsign);
    public PilotATC getPilotInfoByVid(String vid);
    public PilotATC getATISInfoByVid(String vid);
    public PilotATC getFOLMEInfoByVid(String vid);
}
