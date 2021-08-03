package com.e2lre.ivaomsv0.model.ivao;

public class Observer {
    private String time;
    private String id;
    private String userId;
    private String callsign;
    private String serverId;
    private String softwareTypeId;
    private String softwareVersion;
    private String rating;
    private String createdAt;
    private AtcSession atcSession;
    private LastTrackAtc lastTrack;

    public Observer() {
    }

    public Observer(String time, String id, String userId, String callsign, String serverId, String softwareTypeId, String softwareVersion, String rating, String createdAt, AtcSession atcSession, LastTrackAtc lastTrack) {
        this.time = time;
        this.id = id;
        this.userId = userId;
        this.callsign = callsign;
        this.serverId = serverId;
        this.softwareTypeId = softwareTypeId;
        this.softwareVersion = softwareVersion;
        this.rating = rating;
        this.createdAt = createdAt;
        this.atcSession = atcSession;
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

    public AtcSession getAtcSession() {
        return atcSession;
    }

    public void setAtcSession(AtcSession atcSession) {
        this.atcSession = atcSession;
    }

    public LastTrackAtc getLastTrack() {
        return lastTrack;
    }

    public void setLastTrack(LastTrackAtc lastTrack) {
        this.lastTrack = lastTrack;
    }

    @Override
    public String toString() {
        return "Observer{" +
                "time='" + time + '\'' +
                ", id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", callsign='" + callsign + '\'' +
                ", serverId='" + serverId + '\'' +
                ", softwareTypeId='" + softwareTypeId + '\'' +
                ", softwareVersion='" + softwareVersion + '\'' +
                ", rating='" + rating + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", atcSession=" + atcSession +
                ", lastTrack=" + lastTrack +
                '}';
    }
}
