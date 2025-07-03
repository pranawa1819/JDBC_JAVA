package Chapter5;

import java.net.URL;
import java.util.Scanner;

public class URL_Parser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ENTER A URL: ");
        String urlstring = scanner.nextLine();

        try {
            //Create a URL Object
            URL url = new URL(urlstring);

            //Display different parts of the URL
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());

            int port = url.getPort();
            if (port == -1) {
                System.out.println("PORT: (Default or not specified)");
            } else {
                System.out.println("PORT: " + port);
            }
            System.out.println("Path: " + url.getPath());

            String query = url.getQuery();
            if (query != null) {
                System.out.println("QUERY: " + query);
            } else {
                System.out.println("QUERY:(none)");
            }
        } catch (Exception e) {
            System.out.println("INVALID URL! PLEASE MAKE SURE THE FORMAT IS CORRECT");
        }
        scanner.close();

    }
}