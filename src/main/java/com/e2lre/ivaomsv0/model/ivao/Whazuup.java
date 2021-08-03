package com.e2lre.ivaomsv0.model.ivao;

import java.util.List;

public class Whazuup {
    private String updatedAt;
    private List<Server> servers;
    //private Server[] servers;
    private List<VoiceServer> voiceServers;
    private Client clients;
    private Connections connections;

    public Whazuup() {
    }

    public Whazuup(String updatedAt, List<Server> servers, List<VoiceServer> voiceServers, Client clients, Connections connections) {
        this.updatedAt = updatedAt;
        this.servers = servers;
        this.voiceServers = voiceServers;
        this.clients = clients;
        this.connections = connections;
    }

    /*    public Whazuup(String updatedAt, Server[] servers, List<VoiceServer> voiceServers, Client clients) {
                this.updatedAt = updatedAt;
                this.servers = servers;
                this.voiceServers = voiceServers;
                this.clients = clients;
            }
        */
    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Server> getServers() {
        return servers;
    }

    public void setServers(List<Server> servers) {
        this.servers = servers;
    }

    /*  public Server[] getServers() {
            return servers;
        }

        public void setServers(Server[] servers) {
            this.servers = servers;
        }
    */
    public List<VoiceServer> getVoiceServers() {
        return voiceServers;
    }

    public void setVoiceServers(List<VoiceServer> voiceServers) {
        this.voiceServers = voiceServers;
    }

    public Client getClients() {
        return clients;
    }

    public void setClients(Client clients) {
        this.clients = clients;
    }

    public Connections getConnections() {
        return connections;
    }

    public void setConnections(Connections connections) {
        this.connections = connections;
    }

    @Override
    public String toString() {
        return "Whazuup{" +
                "updatedAt='" + updatedAt + '\'' +
                ", servers=" + servers +
                ", voiceServers=" + voiceServers +
                ", clients=" + clients +
                ", connections=" + connections +
                '}';
    }
}
