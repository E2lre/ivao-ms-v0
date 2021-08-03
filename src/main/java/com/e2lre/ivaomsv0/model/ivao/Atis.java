package com.e2lre.ivaomsv0.model.ivao;

import java.util.List;

public class Atis {
    private List<String> lines;
    private String revision;
    private String timestamp;

    public Atis() {
    }

    public Atis(List<String> lines, String revision, String timestamp) {
        this.lines = lines;
        this.revision = revision;
        this.timestamp = timestamp;
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Atis{" +
                "lines=" + lines +
                ", revision='" + revision + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
