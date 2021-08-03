package com.e2lre.ivaomsv0.model;

public class Pilote {
    // All information are in https://wiki.ivao.aero/en/home/devops/api/whazuup/file-format
    private String groundSpeed; //Pilot
    private String transponderCode; //Pilot
    private String facilityType; //Pilot
    private String visualRange; //Pilot
    private String onGround; //Pilot
    private String simulator; //Pilot
    private String plane; //Pilot
    private Flightplan1 flightplan1;

    public Pilote() {
    }

    public Pilote(String groundSpeed, String transponderCode, String facilityType, String visualRange, String onGround, String simulator, String plane, Flightplan1 flightplan1) {
        this.groundSpeed = groundSpeed;
        this.transponderCode = transponderCode;
        this.facilityType = facilityType;
        this.visualRange = visualRange;
        this.onGround = onGround;
        this.simulator = simulator;
        this.plane = plane;
        this.flightplan1 = flightplan1;
    }

    public String getGroundSpeed() {
        return groundSpeed;
    }

    public void setGroundSpeed(String groundSpeed) {
        this.groundSpeed = groundSpeed;
    }

    public String getTransponderCode() {
        return transponderCode;
    }

    public void setTransponderCode(String transponderCode) {
        this.transponderCode = transponderCode;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public String getVisualRange() {
        return visualRange;
    }

    public void setVisualRange(String visualRange) {
        this.visualRange = visualRange;
    }

    public String getOnGround() {
        return onGround;
    }

    public void setOnGround(String onGround) {
        this.onGround = onGround;
    }

    public String getSimulator() {
        return simulator;
    }

    public void setSimulator(String simulator) {
        this.simulator = simulator;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public Flightplan1 getFlightplan1() {
        return flightplan1;
    }

    public void setFlightplan1(Flightplan1 flightplan1) {
        this.flightplan1 = flightplan1;
    }

    @Override
    public String toString() {
        return "Pilote{" +
                "groundSpeed='" + groundSpeed + '\'' +
                ", transponderCode='" + transponderCode + '\'' +
                ", facilityType='" + facilityType + '\'' +
                ", visualRange='" + visualRange + '\'' +
                ", onGround='" + onGround + '\'' +
                ", simulator='" + simulator + '\'' +
                ", plane='" + plane + '\'' +
                ", flightplan=" + flightplan1 +
                '}';
    }
}
