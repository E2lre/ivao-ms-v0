package com.e2lre.ivaomsv0.model.ivao;

public class LastTrackAtc {
    private String distance;
    private String latitude;
    private String longitude;
    private String time;
    private String timestamp;

    public LastTrackAtc() {
    }

    public LastTrackAtc(String distance, String latitude, String longitude, String time, String timestamp) {
        this.distance = distance;
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
        this.timestamp = timestamp;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "lastTrackAtc{" +
                "distance='" + distance + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", time='" + time + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
