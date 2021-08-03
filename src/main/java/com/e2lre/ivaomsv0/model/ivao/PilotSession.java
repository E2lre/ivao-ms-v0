package com.e2lre.ivaomsv0.model.ivao;

public class PilotSession {
        private String  simulatorId;
        private String textureId;
        public PilotSession() {
        }

        public PilotSession(String simulatorId, String textureId) {
                this.simulatorId = simulatorId;
                this.textureId = textureId;
        }

        public String getSimulatorId() {
                return simulatorId;
        }

        public void setSimulatorId(String simulatorId) {
                this.simulatorId = simulatorId;
        }

        public String getTextureId() {
                return textureId;
        }

        public void setTextureId(String textureId) {
                this.textureId = textureId;
        }

        @Override
        public String toString() {
                return "PilotSession{" +
                        "simulatorId='" + simulatorId + '\'' +
                        ", textureId='" + textureId + '\'' +
                        '}';
        }
}
