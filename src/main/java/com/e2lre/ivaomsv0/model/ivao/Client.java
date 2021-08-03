package com.e2lre.ivaomsv0.model.ivao;

import java.util.List;

public class Client {
    private List<Pilot> pilots;
    private List<Atc> atcs;
    private List<FollowMe> followMe;
    private List<Observer> observers;



    public Client() {
    }

    public Client(List<Pilot> pilots, List<Atc> atcs, List<FollowMe> followMe, List<Observer> observers) {
        this.pilots = pilots;
        this.atcs = atcs;
        this.followMe = followMe;
        this.observers = observers;
    }

    public List<Pilot> getPilots() {
        return pilots;
    }

    public void setPilots(List<Pilot> pilots) {
        this.pilots = pilots;
    }

    public List<Atc> getAtcs() {
        return atcs;
    }

    public void setAtcs(List<Atc> atcs) {
        this.atcs = atcs;
    }

    public List<FollowMe> getFollowMe() {
        return followMe;
    }

    public void setFollowMe(List<FollowMe> followMe) {
        this.followMe = followMe;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public String toString() {
        return "Client{" +
                "pilots=" + pilots +
                ", atcs=" + atcs +
                ", followMe=" + followMe +
                ", observers=" + observers +
                '}';
    }
}
