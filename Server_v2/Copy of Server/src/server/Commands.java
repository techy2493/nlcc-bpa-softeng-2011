/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

/**
 *
 * @author AbelB
 */
public class Commands {
    //Run our commands
    public static int run(String cmd){
        String[] Command = cmd.split(":");
        String[] Args = Command[3].split(",");
        //Is the command from the server
        if (Command[1].equals("Server")){
             if(Command[2].equals("Login")){ try{ Login(Args); }catch(Exception e){Logging.log(Command[1]+":"+Command[2]+" Error");return 3;}}
             else if(Command[2].equals("Logout")){ try{ Logout(Args);}catch(Exception e){Logging.log(Command[1]+":"+Command[2]+" Error");return 3;}}
             else return 2;
        //Else, is the command from a client
        }else if (Command[1].equals("Client")){

        //Else, don't know where it came from, report a problem to calling method
        }else{
            return 1;
        }
        return 0;
    }
    public static void Login(String[] Args){
        
    }
    public static void Logout(String[] Args){
        
    }

}