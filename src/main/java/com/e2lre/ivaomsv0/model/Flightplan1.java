/*package com.e2lre.ivaomsv0.model;

public class Flightplan1 {
    // All information are in https://wiki.ivao.aero/en/home/devops/api/whazuup/file-format
    private String aircraft; //Pilot
    private String cruisingSpeed; //Pilot
    private String departureAerodrome; //Pilot
    private String cruisingLevel; //Pilot
    private String destinationAerodrome; //Pilot
    private String revision; //Pilot
    private String flightRules; //Pilot
    private String departureTime; //Pilot
    private String actualDepartureTime; //Pilot
    private String EETHours; //Pilot
    private String EETMinutes; //Pilot
    private String enduranceHours; //Pilot
    private String enduranceMinutes; //Pilot
    private String alternateAerodrome; //Pilot
    private String otherInfo; //Pilot
    private String route; //Pilot
    private String secondndAlternateAerodrome; //Pilot
    private String TypeOfFlight; //Pilot
    private String PersonsOnBoard; //Pilot

    public Flightplan1() {
    }

    public Flightplan1(String aircraft, String cruisingSpeed, String departureAerodrome, String cruisingLevel, String destinationAerodrome, String revision, String flightRules, String departureTime, String actualDepartureTime, String EETHours, String EETMinutes, String enduranceHours, String enduranceMinutes, String alternateAerodrome, String otherInfo, String route, String secondndAlternateAerodrome, String typeOfFlight, String personsOnBoard) {
        this.aircraft = aircraft;
        this.cruisingSpeed = cruisingSpeed;
        this.departureAerodrome = departureAerodrome;
        this.cruisingLevel = cruisingLevel;
        this.destinationAerodrome = destinationAerodrome;
        this.revision = revision;
        this.flightRules = flightRules;
        this.departureTime = departureTime;
        this.actualDepartureTime = actualDepartureTime;
        this.EETHours = EETHours;
        this.EETMinutes = EETMinutes;
        this.enduranceHours = enduranceHours;
        this.enduranceMinutes = enduranceMinutes;
        this.alternateAerodrome = alternateAerodrome;
        this.otherInfo = otherInfo;
        this.route = route;
        this.secondndAlternateAerodrome = secondndAlternateAerodrome;
        TypeOfFlight = typeOfFlight;
        PersonsOnBoard = personsOnBoard;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public String getCruisingSpeed() {
        return cruisingSpeed;
    }

    public void setCruisingSpeed(String cruisingSpeed) {
        this.cruisingSpeed = cruisingSpeed;
    }

    public String getDepartureAerodrome() {
        return departureAerodrome;
    }

    public void setDepartureAerodrome(String departureAerodrome) {
        this.departureAerodrome = departureAerodrome;
    }

    public String getCruisingLevel() {
        return cruisingLevel;
    }

    public void setCruisingLevel(String cruisingLevel) {
        this.cruisingLevel = cruisingLevel;
    }

    public String getDestinationAerodrome() {
        return destinationAerodrome;
    }

    public void setDestinationAerodrome(String destinationAerodrome) {
        this.destinationAerodrome = destinationAerodrome;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getFlightRules() {
        return flightRules;
    }

    public void setFlightRules(String flightRules) {
        this.flightRules = flightRules;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getActualDepartureTime() {
        return actualDepartureTime;
    }

    public void setActualDepartureTime(String actualDepartureTime) {
        this.actualDepartureTime = actualDepartureTime;
    }

    public String getEETHours() {
        return EETHours;
    }

    public void setEETHours(String EETHours) {
        this.EETHours = EETHours;
    }

    public String getEETMinutes() {
        return EETMinutes;
    }

    public void setEETMinutes(String EETMinutes) {
        this.EETMinutes = EETMinutes;
    }

    public String getEnduranceHours() {
        return enduranceHours;
    }

    public void setEnduranceHours(String enduranceHours) {
        this.enduranceHours = enduranceHours;
    }

    public String getEnduranceMinutes() {
        return enduranceMinutes;
    }

    public void setEnduranceMinutes(String enduranceMinutes) {
        this.enduranceMinutes = enduranceMinutes;
    }

    public String getAlternateAerodrome() {
        return alternateAerodrome;
    }

    public void setAlternateAerodrome(String alternateAerodrome) {
        this.alternateAerodrome = alternateAerodrome;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getSecondndAlternateAerodrome() {
        return secondndAlternateAerodrome;
    }

    public void setSecondndAlternateAerodrome(String secondndAlternateAerodrome) {
        this.secondndAlternateAerodrome = secondndAlternateAerodrome;
    }

    public String getTypeOfFlight() {
        return TypeOfFlight;
    }

    public void setTypeOfFlight(String typeOfFlight) {
        TypeOfFlight = typeOfFlight;
    }

    public String getPersonsOnBoard() {
        return PersonsOnBoard;
    }

    public void setPersonsOnBoard(String personsOnBoard) {
        PersonsOnBoard = personsOnBoard;
    }

    @Override
    public String toString() {
        return "Flightplan{" +
                "aircraft='" + aircraft + '\'' +
                ", cruisingSpeed='" + cruisingSpeed + '\'' +
                ", departureAerodrome='" + departureAerodrome + '\'' +
                ", cruisingLevel='" + cruisingLevel + '\'' +
                ", destinationAerodrome='" + destinationAerodrome + '\'' +
                ", revision='" + revision + '\'' +
                ", flightRules='" + flightRules + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", actualDepartureTime='" + actualDepartureTime + '\'' +
                ", EETHours='" + EETHours + '\'' +
                ", EETMinutes='" + EETMinutes + '\'' +
                ", enduranceHours='" + enduranceHours + '\'' +
                ", enduranceMinutes='" + enduranceMinutes + '\'' +
                ", alternateAerodrome='" + alternateAerodrome + '\'' +
                ", otherInfo='" + otherInfo + '\'' +
                ", route='" + route + '\'' +
                ", secondndAlternateAerodrome='" + secondndAlternateAerodrome + '\'' +
                ", TypeOfFlight='" + TypeOfFlight + '\'' +
                ", PersonsOnBoard='" + PersonsOnBoard + '\'' +
                '}';
    }
}


 */
