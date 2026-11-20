package com.mastery.linux.network;

public class PortValidator {

    public boolean isUserSpacePort(int port) {
        return port >= 1024 && port <= 65535;
    }
}
