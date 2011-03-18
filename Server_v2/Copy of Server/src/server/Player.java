/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package server;
import java.net.Socket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.EOFException;

/**
 *
 * @author AbelB
 */

public class Player extends Thread{

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
        Commands.run("client."+message);
    }catch(EOFException e) {};
    } catch (Exception e) {
    System.out.println("Client Communication Error: "+e);
    try{
    sock.close();
    }catch(IOException ex){System.out.println(ex);}
    this.stop();
}

}
}
     public int sendMessage(String msg){
        //Send a response information to the client applicaion
         try{
        ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
        oos.writeObject(msg);
         }catch(Exception e){return 0;}
         return 0;
     }
     public void loadPlayer(){
         //Load all player data
     }
    //Player Items
    //Index corrolating to slot #
    Item Items[];
}
