package com.e2lre.ivaomsv0.model.ivao;

public class Pilot {
    private String time;
    private String id;
    private String userId;
    private String callsign;
    private String serverId;
    private String softwareTypeId;
    private String softwareVersion;
    private String rating;
    private String createdAt;
    private FlightPlan flightPlan;
    private PilotSession pilotSession;
    private LastTrack lastTrack;

    public Pilot() {
    }

    public Pilot(String time, String id, String userId, String callsign, String serverId, String softwareTypeId, String softwareVersion, String rating, String createdAt, FlightPlan flightPlan, PilotSession pilotSession, LastTrack lastTrack) {
        this.time = time;
        this.id = id;
        this.userId = userId;
        this.callsign = callsign;
        this.serverId = serverId;
        this.softwareTypeId = softwareTypeId;
        this.softwareVersion = softwareVersion;
        this.rating = rating;
        this.createdAt = createdAt;
        this.flightPlan = flightPlan;
        this.pilotSession = pilotSession;
        this.lastTrack = lastTrack;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getSoftwareTypeId() {
        return softwareTypeId;
    }

    public void setSoftwareTypeId(String softwareTypeId) {
        this.softwareTypeId = softwareTypeId;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public FlightPlan getFlightPlan() {
        return flightPlan;
    }

    public void setFlightPlan(FlightPlan flightPlan) {
        this.flightPlan = flightPlan;
    }

    public PilotSession getPilotSession() {
        return pilotSession;
    }

    public void setPilotSession(PilotSession pilotSession) {
        this.pilotSession = pilotSession;
    }

    public LastTrack getLastTrack() {
        return lastTrack;
    }

    public void setLastTrack(LastTrack lastTrack) {
        this.lastTrack = lastTrack;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "time='" + time + '\'' +
                ", id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", callsign='" + callsign + '\'' +
                ", serverId='" + serverId + '\'' +
                ", softwareTypeId='" + softwareTypeId + '\'' +
                ", softwareVersion='" + softwareVersion + '\'' +
                ", rating='" + rating + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", flightPlan=" + flightPlan +
                ", pilotSession=" + pilotSession +
                ", lastTrack=" + lastTrack +
                '}';
    }
}
