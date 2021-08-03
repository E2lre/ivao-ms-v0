package com.e2lre.ivaomsv0.model.ivao;

public class Aircraft {
    private String icaoCode;
    private String model;
    private String wakeTurbulence;
    private String isMilitary;
    private String description;

    public Aircraft() {
    }

    public Aircraft(String icaoCode, String model, String wakeTurbulence, String isMilitary, String description) {
        this.icaoCode = icaoCode;
        this.model = model;
        this.wakeTurbulence = wakeTurbulence;
        this.isMilitary = isMilitary;
        this.description = description;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getWakeTurbulence() {
        return wakeTurbulence;
    }

    public void setWakeTurbulence(String wakeTurbulence) {
        this.wakeTurbulence = wakeTurbulence;
    }

    public String getIsMilitary() {
        return isMilitary;
    }

    public void setIsMilitary(String isMilitary) {
        this.isMilitary = isMilitary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "icaoCode='" + icaoCode + '\'' +
                ", model='" + model + '\'' +
                ", wakeTurbulence='" + wakeTurbulence + '\'' +
                ", isMilitary='" + isMilitary + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
