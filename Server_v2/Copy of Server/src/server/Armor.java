/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

/**
 *
 * @author Techy
 */
public class Armor {
    private String Class = "Armor";
    private String Type;
    private String Material;
    private int Defense;
    private int Encumberance;
    private int Hardness;
    private int Thickness;

    public Armor(String ItemStats){
        String[] Attributes = ItemStats.split(",");
        String[] Stats = new String[Attributes.length];
        String[] Value = new String[Attributes.length];

    }
}
