
package server;

import java.net.ServerSocket;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     try {
    serverSocket = new ServerSocket(4444);
} catch (IOException e) {
    System.out.println("Could not listen on port: 4444");
    System.exit(-1);
}


    }

}
