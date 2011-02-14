/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package server;
import java.net.*;
/**
 *
 * @author AbelB
 */
public class Net_Interface {
    private String localIP;

    public void UpdateLocalIP(String ip){
    localIP = ip;
    }

    //TODO: Change void to socket return type
    public void CreateConnection(String ip) {

    }
    //TODO: Add argument- Socket to Close
    public static void CloseConnection(){

    }
}
