/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package server;
import java.util.Random;
/**
 *
 * @author AbelB
 */
public class Map {
    //Map Control Variables
    int xSize;
    int ySize;
    int LandType;
    int Weather;
    Object[][] arrayMap;
    public Map(String Size){
        Random rand = new Random(3);
        Weather = rand.nextInt();
        rand.setSeed(5);
        LandType = rand.nextInt();
        if (Size.equals("Small")){
            rand.setSeed(25);
        }else if(Size.equals("Medium")){
            rand.setSeed(50);
        }else
            rand.setSeed(100);

        while (xSize < 15){
        xSize = rand.nextInt();
        }
        while (ySize < 15){
        ySize = rand.nextInt();
        }

        arrayMap = new Object[xSize][ySize];

        SeedMap();
    }
    private void SeedMap(){

    }
}
 