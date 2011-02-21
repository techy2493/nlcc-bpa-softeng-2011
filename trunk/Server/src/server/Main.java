
package server;

import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.io.*;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Open Connection  Query
        ServerSocket QuerySocket = Net_Interface.CreateConnection(4444);
        try{
        QuerySocket.setSoTimeout(1);
        }catch(SocketException e) {}
        Player Players[] = new Player[0];
        while(true){
            QuerySocket.accept();
        }
        //Players[0] = new Player("test");


    }

}
