/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package server;
import java.io.PrintWriter;
/**
 *
 * @author AbelB
 */
public class Logging {
    public static void log(String msg){
        try{
        PrintWriter logfile = new PrintWriter("Logs.txt");
        logfile.append(msg);
        System.out.println(msg);
        }catch (Exception e){System.out.println("Error accessing log file, logs could not be written.");}
    }
}
