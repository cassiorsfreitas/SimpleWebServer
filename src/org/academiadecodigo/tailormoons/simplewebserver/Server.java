package org.academiadecodigo.tailormoons.simplewebserver;

public class Server {

    public static void main(String args[]) {
        WebServer ws = new WebServer();
        ws.start(8080);
    }
}

