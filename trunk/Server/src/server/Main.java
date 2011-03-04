
package server;

import java.net.ServerSocket;
import java.util.Scanner;
import java.net.Socket;
import java.lang.Runnable;
import java.lang.Thread;

public class Main implements Runnable {
        Thread thread = new Thread(this);
        static int PlayersConnected = 0;
        static Player players[] = new Player[0];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        ServerSocketNew ServerSock = new ServerSocketNew();
        ServerSock.Handle();
    }
    public void run(){
        Scanner keyboard = new Scanner(System.in);
        while(true){
        Commands.run(keyboard.nextLine());
        }
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
        System.out.println("Error : M2084 : Please contact the developers of this application for support.");
        //Pause = true;
        return oldArray;
        }
    }
    

    private static class ServerSocketNew {
            private ServerSocket ServerSock;
            private int port = 4444;
            public ServerSocketNew(){
                try {
                     ServerSock = new ServerSocket(port);
                } catch (Exception e) {System.out.println("Could not open connection to port 4444");}
            }
            public void Handle(){
                while(true){
                    try {
                        Socket socket = ServerSock.accept();
                         resizeArray(players, (java.lang.reflect.Array.getLength(players)) + 1);
                         players[java.lang.reflect.Array.getLength(players)] = CreatePlayer(socket);

                    }catch (Exception e) {System.out.println("Could not acception connection.");}
                }
            }
            public static Player CreatePlayer(Socket sock) {
                PlayersConnected += 1;
                Player NewPlayer = new Player(PlayersConnected);
                return NewPlayer;
            }

     }

}

    
