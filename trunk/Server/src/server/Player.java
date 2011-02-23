/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package server;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author AbelB
 */
public class Player {

    //Item Sub-class
    private class Item {
        public int AddItem(int ID) {
            //TODO: ADD CODE TO STORE ITEM STATS
            
            //Return 0 for a valid execution
            return 0;
        }
    }
    Socket PlayerSocket;
    public Player(int UID, Socket PlayerSock){
        //TODO: Load data from database
        PlayerSocket=PlayerSock;
    }
    //Player Items
    Item Items[];

}
