package org.academiadecodigo.tailormoons.simplewebserver;

public class Responses {

    public String getText() {

        return "HTTP/1.0 200 Document Follows\r\n" +
                "Content-Type: text/html; charset=UTF-8\r\n" +
                "Content-Length: <file_byte_size> \r\n" +
                "\r\n" + "<H1>Welcome code cadet!</H1>";
    }

}

