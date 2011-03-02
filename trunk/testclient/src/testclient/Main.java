
package testclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream; 
import java.lang.ClassNotFoundException; 
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException; 


public class Main {

   
    public static void main(String[] args) {
        InetAddress Site = InetAddress.getLocalHost();
        Socket sock = new Socket(Site.getHostName(), 4444);
                 
       ObjectOutputStream output = new ObjectOutputStream(sock.getOutputStream());
       output.writeObject("This is the output comments");

       ObjectInputStream input = new ObjectInputStream(sock.getInputStream());
       String stringinput = (String) input.readObject();
       System.out.println("Input: " + stringinput);

       
    }  
  
}


