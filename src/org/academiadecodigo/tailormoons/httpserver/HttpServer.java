package org.academiadecodigo.tailormoons.httpserver;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static void main(String[] args) throws IOException {

        final ServerSocket serverSocket = new ServerSocket(8009);
        System.out.println("Starting server...");

        while (true) {
            final Socket socket = serverSocket.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());
            // socket.getInputStream();
            final OutputStream outputStream = socket.getOutputStream();
            final PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println("HTTP/1.0 200 OK");
            printWriter.println("Content-Length: 12");
            printWriter.println("");
            printWriter.println("Hello World!");
            printWriter.flush();
            System.out.println("Sent.");
            socket.close();
        }
    }
}
