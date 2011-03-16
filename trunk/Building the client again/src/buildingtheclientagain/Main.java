/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package buildingtheclientagain;
import java.io.ObjectOutputStream; 
import java.net.InetAddress;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String Username, Password, Command, Player;
       Boolean Quit = false;
       
       Scanner scan = new Scanner(System.in);
       System.out.println("Username");
       Username = scan.nextLine();
       System.out.println("Password");
       Password = scan.nextLine();
      
       Quit = connect(Username, Password);

       
while(Quit == false)
{
        System.out.println("1.Attack, 2.Heal, 3.Roll Dice, 4.Skip Turn, 5.Quit");
        Command = scan.nextLine();
        Command.trim();
        if (Command.equals("1")){
            System.out.println("Attack Who, 1.Player1, 2.player2 and so on");
        Player = scan.nextLine();
        atkPlayer(Player);
        } else if (Command.equals("2")){
        heal();
        }else if (Command.equals("3")){
        Dice();
        }else if (Command.equals("4")){

        }else if (Command.equals("5")){
        Quit = true;
        }else{
        System.out.println("Error, Please try again");
        }
 }
 }
     private static void heal()
    {

     }
     private static void Dice()
    {

     }
    private static void atkPlayer(String Player)
    {
        try{
        byte Address[] = new byte[4];
        Address[0] = 10;
        Address[1] = 4;
        Address[2] = 111;
        Address[3] = 112;
       // InetAddress site = InetAddress.getByName("java.intellectualhotspot.com");
        InetAddress site = InetAddress.getByAddress(Address);
        Socket sock  = new Socket(site.getHostName(), 4444);

       ObjectOutputStream output = new ObjectOutputStream(sock.getOutputStream());
       output.writeObject("Attack: " + Player);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private static boolean connect(String Username, String Password)
    {

     try{
        byte Address[] = new byte[4];
        Address[0] = 10;
        Address[1] = 4;
        Address[2] = 111;
        Address[3] = 112;
       // InetAddress site = InetAddress.getByName("java.intellectualhotspot.com");
        InetAddress site = InetAddress.getByAddress(Address);
        Socket sock  = new Socket(site.getHostName(), 4444);
                 
       ObjectOutputStream output = new ObjectOutputStream(sock.getOutputStream());
       output.writeObject("This is the output comments");

       ObjectInputStream input = new ObjectInputStream(sock.getInputStream());
       String stringinput = (String) input.readObject();
       System.out.println("Input: " + stringinput);

       output.writeObject("Login: " + Username  + " , " + Password);


       
       output.close();
       input.close();
       return true;
      
     } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}



  


   
    