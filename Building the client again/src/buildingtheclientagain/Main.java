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
import java.util.Random;


public class Main {

    public static void main(String[] args) {
       String Username, Password, Command, Player;
       Boolean Quit = false;
       Integer Heal;
       
       Scanner scan = new Scanner(System.in);
       System.out.println("Username");
       Username = scan.nextLine();
       System.out.println("Password");
       Password = scan.nextLine();
      
       
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
       output.writeObject("Hi.");

       ObjectInputStream input = new ObjectInputStream(sock.getInputStream());
       String stringinput = (String) input.readObject();
       System.out.println("Input: " + stringinput);

      output.writeObject("Login: " + Username  + " , " + Password);

while(Quit == false)
{
        System.out.println("1.Attack, 2.Heal, 3.Roll Dice, 4.Skip Turn, 5.Quit");
        Command = scan.nextLine();
        Command.trim();
        if (Command.equals("1")){
            System.out.println("Attack Who, 1.Player1, 2.player2 and so on");
        Player = scan.nextLine();
        output.writeObject("Attack:" + Player);
        } else if (Command.equals("2")){
        System.out.println("Heal how much");
        Heal = scan.nextInt();
        System.out.println("You Healed by:" + Heal);


        }else if (Command.equals("3")){
        Dice();
        }else if (Command.equals("4")){

        }else if (Command.equals("5")){
        Quit = true;
        }else{
        System.out.println("Error, Please try again");
        }
 }
       
       output.close();
       input.close();
       
      Quit = false;
     } catch (Exception e) {
            System.out.println(e);
            Quit = true;
       }
       

 }
   
     private static void Dice()
    {
         Integer dice;
Random rand = new Random();
dice = rand.nextInt(12);
System.out.println("Dice roll: " + dice);
     }
   
    }
    
   
    





  


   
    