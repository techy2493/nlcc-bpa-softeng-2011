

package server;

import javax.swing.JOptionPane;

public class Calculations {

    public static double Attack(double Attack, double Health) {
double remaining;
remaining = Health - Attack;

if (remaining < 1)
            die();

return remaining;
   }

    public static void die()
    {
       JOptionPane.showMessageDialog(null, "You Have Died");
    }


    public static double Heal(double Health, double heal, double max){
            double newhealth;

            newhealth = Health + heal;

            if (newhealth > max)
                newhealth = max;

            return newhealth;
        }

    

}

