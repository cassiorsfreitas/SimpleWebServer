package org.academiadecodigo.tailormoons.simplewebserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {


    private ServerSocket s;

    public void start(int port) {

        System.out.println("Webserver starting up on port 8080");
        System.out.println("(press ctrl-c to exit)");

        try {
            // create the main server socket
            s = new ServerSocket(port);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return;
        }

        System.out.println("Waiting for connection");
        receiveRequest();
    }

    private void receiveRequest() {
        try {
            // wait for a connection
            Socket remote = s.accept();
            // remote is now the connected socket
            System.out.println("Connection, sending data.");
            BufferedReader in = new BufferedReader(new InputStreamReader(remote.getInputStream()));
            PrintWriter out = new PrintWriter(remote.getOutputStream());


            String checkRequest = in.readLine();

            /*
            while (!checkRequest.isEmpty()) {
                System.out.println(checkRequest);
                checkRequest = in.readLine();
            }
             */

            // Send the response
            Responses response = new Responses();
            if(checkRequest.startsWith("GET")) {
                String[] path = checkRequest.split(" ");
                if (path[1].equals("/")){
                    out.println(response.getText());
                }
            }

            out.flush();
            remote.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
