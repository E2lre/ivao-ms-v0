package com.e2lre.ivaomsv0.model.ivao;

public class Connections {
    private String atc;
    private String followMe;
    private String observers;
    private String pilots;
    private String supervisors;
    private String total;
    private String worldTours;

    public Connections() {
    }

    public Connections(String atc, String followMe, String observers, String pilots, String supervisors, String total, String worldTours) {
        this.atc = atc;
        this.followMe = followMe;
        this.observers = observers;
        this.pilots = pilots;
        this.supervisors = supervisors;
        this.total = total;
        this.worldTours = worldTours;
    }

    public String getAtc() {
        return atc;
    }

    public void setAtc(String atc) {
        this.atc = atc;
    }

    public String getFollowMe() {
        return followMe;
    }

    public void setFollowMe(String followMe) {
        this.followMe = followMe;
    }

    public String getObservers() {
        return observers;
    }

    public void setObservers(String observers) {
        this.observers = observers;
    }

    public String getPilots() {
        return pilots;
    }

    public void setPilots(String pilots) {
        this.pilots = pilots;
    }

    public String getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(String supervisors) {
        this.supervisors = supervisors;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getWorldTours() {
        return worldTours;
    }

    public void setWorldTours(String worldTours) {
        this.worldTours = worldTours;
    }

    @Override
    public String toString() {
        return "Connections{" +
                "atc='" + atc + '\'' +
                ", followMe='" + followMe + '\'' +
                ", observers='" + observers + '\'' +
                ", pilots='" + pilots + '\'' +
                ", supervisors='" + supervisors + '\'' +
                ", total='" + total + '\'' +
                ", worldTours='" + worldTours + '\'' +
                '}';
    }
}
