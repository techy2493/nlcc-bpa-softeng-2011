/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package server;
import java.net.Socket;
import java.net.SocketException;
import java.io.IOException;
import java.io.Console;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.lang.Runnable;
import java.lang.Thread;
import java.io.EOFException;


/**
 *
 * @author AbelB
 */

public class Player extends Thread{

    //Item Sub-class
    private class Item {
        public int AddItem(int ID) {
            //TODO: ADD CODE TO STORE ITEM STATS
            
            //Return 0 for a valid execution
            return 0;
        }
    }
    private Socket sock;
    public Player(int UID, Socket sock){
        this.sock = sock;
        Thread thread = new Thread(this);
        thread.start();
    }
        public void run(){
      while(true){
          System.out.println("Running");
        try{
//
// Read a message sent by client application
//
    try{
        ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
        String message = (String) ois.readObject();
        System.out.println("Message Received: " + message);
    }catch(EOFException e) {};

    
    // Send a response information to the client applica    System.out.println("Message Received: " + message);tion
    ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
    oos.writeObject("Hi...");
    System.out.println("Waiting for client message...");
    } catch (Exception e) {
    System.out.println(e);
}

}
}
    //Player Items
    Item Items[];

}