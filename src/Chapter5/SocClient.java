package Chapter5;

import java.io.PrintWriter;
import java.net.Socket;
import java.io.*;
import java.net.*;

public class SocClient {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("localhost",9999);
            PrintWriter out = new PrintWriter(s.getOutputStream(),true);

            //this is the stream you write to in order to send data from client to server
            // The second argument , true, means auto-flush is enabled. This is important in network programming so your message is

            out.println("Pranawa K.C");
            out.println("Hello, Server!");
            out.println("This is a one way message");
            out.println("Bye!");
            s.shutdownOutput(); // tell server we're done
            //I am done sending data - no more bytes will be send to the server

            s.close();


        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
