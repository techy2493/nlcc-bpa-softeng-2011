
package server;

import java.net.ServerSocket;
import java.io.*;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Open Connection  Query
        try
        {
            ServerSocket QuerySocket = new ServerSocket(4444);
        } catch (IOException e) {
        System.out.println("Could not listen on port: 4444");
        System.exit(-1);
        }


    }

}
