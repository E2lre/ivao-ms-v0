package com.e2lre.ivaomsv0.model.ivao;

public class VoiceServer {
    private String id;
    private String hostname;
    private String ip;
    private String description;
    private String countryId;
    private String currentConnections;
    private String maximumConnections;

    public VoiceServer() {
    }

    public VoiceServer(String id, String hostname, String ip, String description, String countryId, String currentConnections, String maximumConnections) {
        this.id = id;
        this.hostname = hostname;
        this.ip = ip;
        this.description = description;
        this.countryId = countryId;
        this.currentConnections = currentConnections;
        this.maximumConnections = maximumConnections;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCurrentConnections() {
        return currentConnections;
    }

    public void setCurrentConnections(String currentConnections) {
        this.currentConnections = currentConnections;
    }

    public String getMaximumConnections() {
        return maximumConnections;
    }

    public void setMaximumConnections(String maximumConnections) {
        this.maximumConnections = maximumConnections;
    }

    @Override
    public String toString() {
        return "VoiceServer{" +
                "id='" + id + '\'' +
                ", hostname='" + hostname + '\'' +
                ", ip='" + ip + '\'' +
                ", description='" + description + '\'' +
                ", countryId='" + countryId + '\'' +
                ", currentConnections='" + currentConnections + '\'' +
                ", maximumConnections='" + maximumConnections + '\'' +
                '}';
    }
}
