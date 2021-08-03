package com.e2lre.ivaomsv0.model.ivao;

public class AtcSession {
    private String frequency;
    private String position;

    public AtcSession() {
    }

    public AtcSession(String frequency, String position) {
        this.frequency = frequency;
        this.position = position;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "AtcSession{" +
                "frequency='" + frequency + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
