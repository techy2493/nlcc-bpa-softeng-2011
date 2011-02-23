
package server;

import java.net.ServerSocket;
import java.net.SocketException;
import java.io.IOException;
import java.io.Console;

public class Main {
        //Create Socket to accept connection queries
        static ServerSocket QuerySocket;
        static int PlayersConnected = 0;
        static boolean Pause = false;
        //Create Scanner Object
        static Scanner2 keyboard = new Scanner2(System.in);
        static Console console = System.console();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Finish creating ServerSocket : QuerySocket
//TODO: Change port 4444 to accept a port from args
        QuerySocket = Net_Interface.CreateConnection(4444);
        
        //try {
        //Set Timeout of ServerSocket : QuerySocket
        try {
        QuerySocket.setSoTimeout(1);
        }catch (SocketException e) {}
        //Declare Players Array - Used to store all player objects
        Player Players[] = new Player[0];
        //Keep the server running, run all maintenance methods.
        while(!Pause){
             //START: Accept a new player to connect
            Player NewPlayer = CreatePlayer();
             if (NewPlayer != null) {
             resizeArray(Players, (java.lang.reflect.Array.getLength(Players) + 1));
             Players[java.lang.reflect.Array.getLength(Players)] = NewPlayer;
             }
             //END

             //START: Check for input
             Commands.run(console.readLine());
             //System.out.println("running");
             //END
             }


         //}catch(Exception e) {
          // System.out.println("Error : 1337 : Please contact the developers of this application for support.");
         //   Pause = true;
        //}
    }

    public static Player CreatePlayer() {
        try {
            PlayersConnected += 1;
            Player NewPlayer = new Player(PlayersConnected, QuerySocket.accept());
            return NewPlayer;
        }catch(SocketException e){} catch (IOException e) {}
        return null;
    }
/**
* Reallocates an array with a new size, and copies the contents
* of the old array to the new array.
* @param oldArray  the old array, to be reallocated.
* @param newSize   the new array size.
* @return          A new array with the same contents.
* @author Christian d'Heureuse (www.source-code.biz, www.inventec.ch/chdh)
* License: Free / LGPL
*/
    private static Object resizeArray (Object oldArray, int newSize) {
        try {
            int oldSize = java.lang.reflect.Array.getLength(oldArray);
            Class elementType = oldArray.getClass().getComponentType();
            Object newArray = java.lang.reflect.Array.newInstance(
                 elementType,newSize);
            int preserveLength = Math.min(oldSize,newSize);
            if (preserveLength > 0)
                  System.arraycopy (oldArray,0,newArray,0,preserveLength);
            return newArray;
        }catch (Exception e) { 
        System.out.println("Error : 2001 : Please contact the developers of this application for support.");
        Pause = true;
        return oldArray;
        }
    }
}
