package com.e2lre.ivaomsv0.model.ivao;

public class LastTrack {
    private String altitude;
    private String altitudeDifference;
    private String arrivalDistance;
    private String departureDistance;
    private String groundSpeed;
    private String heading;
    private String latitude;
    private String longitude;
    private String onGround;
    private String state;
    private String time;
    private String timestamp;
    private String transponder;
    private String transponderMode;

    public LastTrack() {
    }

    public LastTrack(String altitude, String altitudeDifference, String arrivalDistance, String departureDistance, String groundSpeed, String heading, String latitude, String longitude, String onGround, String state, String time, String timestamp, String transponder, String transponderMode) {
        this.altitude = altitude;
        this.altitudeDifference = altitudeDifference;
        this.arrivalDistance = arrivalDistance;
        this.departureDistance = departureDistance;
        this.groundSpeed = groundSpeed;
        this.heading = heading;
        this.latitude = latitude;
        this.longitude = longitude;
        this.onGround = onGround;
        this.state = state;
        this.time = time;
        this.timestamp = timestamp;
        this.transponder = transponder;
        this.transponderMode = transponderMode;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getAltitudeDifference() {
        return altitudeDifference;
    }

    public void setAltitudeDifference(String altitudeDifference) {
        this.altitudeDifference = altitudeDifference;
    }

    public String getArrivalDistance() {
        return arrivalDistance;
    }

    public void setArrivalDistance(String arrivalDistance) {
        this.arrivalDistance = arrivalDistance;
    }

    public String getDepartureDistance() {
        return departureDistance;
    }

    public void setDepartureDistance(String departureDistance) {
        this.departureDistance = departureDistance;
    }

    public String getGroundSpeed() {
        return groundSpeed;
    }

    public void setGroundSpeed(String groundSpeed) {
        this.groundSpeed = groundSpeed;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
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

    public String getOnGround() {
        return onGround;
    }

    public void setOnGround(String onGround) {
        this.onGround = onGround;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getTransponder() {
        return transponder;
    }

    public void setTransponder(String transponder) {
        this.transponder = transponder;
    }

    public String getTransponderMode() {
        return transponderMode;
    }

    public void setTransponderMode(String transponderMode) {
        this.transponderMode = transponderMode;
    }

    @Override
    public String toString() {
        return "LastTrack{" +
                "altitude='" + altitude + '\'' +
                ", altitudeDifference='" + altitudeDifference + '\'' +
                ", arrivalDistance='" + arrivalDistance + '\'' +
                ", departureDistance='" + departureDistance + '\'' +
                ", groundSpeed='" + groundSpeed + '\'' +
                ", heading='" + heading + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", onGround='" + onGround + '\'' +
                ", state='" + state + '\'' +
                ", time='" + time + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", transponder='" + transponder + '\'' +
                ", transponderMode='" + transponderMode + '\'' +
                '}';
    }
}
