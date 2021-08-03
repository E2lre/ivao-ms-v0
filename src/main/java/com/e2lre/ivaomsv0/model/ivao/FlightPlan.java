package com.e2lre.ivaomsv0.model.ivao;

public class FlightPlan {
    private String id;
    private String sessionId;
    private String revision;
    private String aircraftId;
    private String aircraftNumber;
    private String departureId;
    private String arrivalId;
    private String alternativeId;
    private String alternative2Id;
    private String route;
    private String remarks;
    private String speed;
    private String level;
    private String flightRules;
    private String flightType;
    private String eet;
    private String endurance;
    private String departureTime;
    private String actualDepartureTime;
    private String peopleOnBoard;
    private String createdAt;
    private String updatedAt;
    private String aircraftEquipments;
    private String aircraftTransponderTypes;
    private Aircraft aircraft;

    public FlightPlan() {
    }

    public FlightPlan(String id, String sessionId, String revision, String aircraftId, String aircraftNumber, String departureId, String arrivalId, String alternativeId, String alternative2Id, String route, String remarks, String speed, String level, String flightRules, String flightType, String eet, String endurance, String departureTime, String actualDepartureTime, String peopleOnBoard, String createdAt, String updatedAt, String aircraftEquipments, String aircraftTransponderTypes, Aircraft aircraft) {
        this.id = id;
        this.sessionId = sessionId;
        this.revision = revision;
        this.aircraftId = aircraftId;
        this.aircraftNumber = aircraftNumber;
        this.departureId = departureId;
        this.arrivalId = arrivalId;
        this.alternativeId = alternativeId;
        this.alternative2Id = alternative2Id;
        this.route = route;
        this.remarks = remarks;
        this.speed = speed;
        this.level = level;
        this.flightRules = flightRules;
        this.flightType = flightType;
        this.eet = eet;
        this.endurance = endurance;
        this.departureTime = departureTime;
        this.actualDepartureTime = actualDepartureTime;
        this.peopleOnBoard = peopleOnBoard;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.aircraftEquipments = aircraftEquipments;
        this.aircraftTransponderTypes = aircraftTransponderTypes;
        this.aircraft = aircraft;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(String aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getAircraftNumber() {
        return aircraftNumber;
    }

    public void setAircraftNumber(String aircraftNumber) {
        this.aircraftNumber = aircraftNumber;
    }

    public String getDepartureId() {
        return departureId;
    }

    public void setDepartureId(String departureId) {
        this.departureId = departureId;
    }

    public String getArrivalId() {
        return arrivalId;
    }

    public void setArrivalId(String arrivalId) {
        this.arrivalId = arrivalId;
    }

    public String getAlternativeId() {
        return alternativeId;
    }

    public void setAlternativeId(String alternativeId) {
        this.alternativeId = alternativeId;
    }

    public String getAlternative2Id() {
        return alternative2Id;
    }

    public void setAlternative2Id(String alternative2Id) {
        this.alternative2Id = alternative2Id;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getFlightRules() {
        return flightRules;
    }

    public void setFlightRules(String flightRules) {
        this.flightRules = flightRules;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public String getEet() {
        return eet;
    }

    public void setEet(String eet) {
        this.eet = eet;
    }

    public String getEndurance() {
        return endurance;
    }

    public void setEndurance(String endurance) {
        this.endurance = endurance;
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

    public String getPeopleOnBoard() {
        return peopleOnBoard;
    }

    public void setPeopleOnBoard(String peopleOnBoard) {
        this.peopleOnBoard = peopleOnBoard;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getAircraftEquipments() {
        return aircraftEquipments;
    }

    public void setAircraftEquipments(String aircraftEquipments) {
        this.aircraftEquipments = aircraftEquipments;
    }

    public String getAircraftTransponderTypes() {
        return aircraftTransponderTypes;
    }

    public void setAircraftTransponderTypes(String aircraftTransponderTypes) {
        this.aircraftTransponderTypes = aircraftTransponderTypes;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    @Override
    public String toString() {
        return "FlightPlan{" +
                "id='" + id + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", revision='" + revision + '\'' +
                ", aircraftId='" + aircraftId + '\'' +
                ", aircraftNumber='" + aircraftNumber + '\'' +
                ", departureId='" + departureId + '\'' +
                ", arrivalId='" + arrivalId + '\'' +
                ", alternativeId='" + alternativeId + '\'' +
                ", alternative2Id='" + alternative2Id + '\'' +
                ", route='" + route + '\'' +
                ", remarks='" + remarks + '\'' +
                ", speed='" + speed + '\'' +
                ", level='" + level + '\'' +
                ", flightRules='" + flightRules + '\'' +
                ", flightType='" + flightType + '\'' +
                ", eet='" + eet + '\'' +
                ", endurance='" + endurance + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", actualDepartureTime='" + actualDepartureTime + '\'' +
                ", peopleOnBoard='" + peopleOnBoard + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", aircraftEquipments='" + aircraftEquipments + '\'' +
                ", aircraftTransponderTypes='" + aircraftTransponderTypes + '\'' +
                ", aircraft=" + aircraft +
                '}';
    }
}
