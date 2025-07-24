package TCPSocket;
import java.io.*;
import java.net.*;
public class SocServer {
    public static void main(String[] args) throws Exception{
        int port =9999;  // creates a server socket that listen on port 9999
        //This port number must match yhe port the client connects to

        System.out.println("Server Started");

        ServerSocket ss = new ServerSocket(port);
        System.out.println("Server is waiting for client request");

        Socket s = ss.accept(); // waits here
        System.out.println("Client Connected");

        // read data from client , drops it in an inputStreamReader and then a bufferreader to read text


        BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String message;
        while((message = reader.readLine())!=null){  // read incoming  data line by line using readline()
            System.out.println("Received: "+message);

        }
        // The loop continues until the client closes the output stream (or socket) causing the readline() in return null
        s.close();
        ss.close();
        //closes the client socket and the server socket, releasing resources and ending the progress
        System.out.println("Connection closed");
    }
}
