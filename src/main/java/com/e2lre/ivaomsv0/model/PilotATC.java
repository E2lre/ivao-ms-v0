package com.e2lre.ivaomsv0.model;

public class PilotATC {
    // All information are in https://wiki.ivao.aero/en/home/devops/api/whazuup/file-format
    private OtherInfo otherInfo;
    private ATC atc;
    private Pilote pilote;

    public PilotATC() {
    }

    public PilotATC(OtherInfo otherInfo, ATC atc, Pilote pilote) {
        this.otherInfo = otherInfo;
        this.atc = atc;
        this.pilote = pilote;
    }

    public OtherInfo getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(OtherInfo otherInfo) {
        this.otherInfo = otherInfo;
    }

    public ATC getAtc() {
        return atc;
    }

    public void setAtc(ATC atc) {
        this.atc = atc;
    }

    public Pilote getPilote() {
        return pilote;
    }

    public void setPilote(Pilote pilote) {
        this.pilote = pilote;
    }

    @Override
    public String toString() {
        return "PilotATC{" +
                "otherInfo=" + otherInfo +
                ", atc=" + atc +
                ", pilote=" + pilote +
                '}';
    }
}
