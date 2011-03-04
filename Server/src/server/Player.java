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

/**
 *
 * @author AbelB
 */

public class Player {
private static class Handler implements Runnable{
    private Socket sock;
    public Handler(Socket sock){
        this.sock = sock;
        Thread thread = new Thread(this);
        thread.start();
    }
    public void run(){
      while(true){ 
        try{
//
// Read a message sent by client application
//

    ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
    String message = (String) ois.readObject();
    System.out.println("Message Received: " + message);
    // Send a response information to the client application
    ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
    oos.writeObject("Hi...");
    System.out.println("Waiting for client message...");
    } catch (IOException e) {
    e.printStackTrace();
    } catch (ClassNotFoundException e) {
    e.printStackTrace();
}

}
}
}
    //Item Sub-class
    private class Item {
        public int AddItem(int ID) {
            //TODO: ADD CODE TO STORE ITEM STATS
            
            //Return 0 for a valid execution
            return 0;
        }
    }
    public Player(int UID){
        //TODO: Load data from database
    }
    //Player Items
    Item Items[];

}
