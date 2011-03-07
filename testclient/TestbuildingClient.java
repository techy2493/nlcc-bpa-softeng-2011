package testbuildingjavaclient;
import java.io.IOException;
import java.net.UnknownHostException;
import java.io.ObjectOutputStream; 
import java.net.InetAddress;
import java.io.ObjectInputStream;
import java.lang.ClassNotFoundException;
import java.net.Socket;
 

  
public class Main {

    public static void main(String[] args) {
        try{
        InetAddress site = InetAddress.getByName("java.intellectualhotspot.com");
        Socket sock  = new Socket(site.getHostName(), 4444);
                 
       ObjectOutputStream output = new ObjectOutputStream(sock.getOutputStream());
       output.writeObject("This is the output comments");

       ObjectInputStream input = new ObjectInputStream(sock.getInputStream());
       String stringinput = (String) input.readObject();
       System.out.println("Input: " + stringinput);
       
       output.close();
       input.close();
      
        } catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        }
    }
