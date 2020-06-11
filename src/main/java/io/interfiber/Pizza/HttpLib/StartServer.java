package io.interfiber.Pizza.HttpLib;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Scanner;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class StartServer {

    public static void start(int serverPort, String mainFile) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);
        server.createContext("/main", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            File mainFileData = new File("test.html");
            Scanner s = new Scanner(mainFileData);
            String htmlData = "";
            while(s.hasNext()){
                    htmlData = s.nextLine().concat("\n");
            }
            String response = htmlData;
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}