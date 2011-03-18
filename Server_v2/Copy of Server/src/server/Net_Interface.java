/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.InetAddress;
/**
 *
 * @author AbelB
 */
public class Net_Interface {
    
    InetAddress localIP;
    public void UpdateLocalIP(InetAddress ip){
    localIP = ip;
    }

    //TODO: Change void to socket return type
    public static ServerSocket CreateConnection(int port) {
        try{
            return new ServerSocket(port);
        }catch (java.io.IOException e) {
            System.out.println("Could not establish connection on port: " + port);
            return null;
        }
    }
    //Close Server Socket
    public static void CloseConnection(ServerSocket connection){
        try{
        connection.close();
        }catch (java.io.IOException e){ }

    }
 }


