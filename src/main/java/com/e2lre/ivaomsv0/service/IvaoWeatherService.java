package com.e2lre.ivaomsv0.service;

import java.io.IOException;
import java.net.URISyntaxException;

public interface IvaoWeatherService {
    public String getWeatherObsByAirport(String airportId) throws URISyntaxException, IOException, InterruptedException;
    public String getWeatherPrevByAirport(String airportId) throws URISyntaxException, IOException, InterruptedException;
}
