/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import java.util.ArrayList;

/**
 *
 * @author student
 */
public class Locaties {
    private ArrayList<String> plaatsen;
              
    public Locaties(){
        plaatsen =new ArrayList<String>();
        plaatsen.add("Antwerpen");
        plaatsen.add("Mechelen");
        plaatsen.add("Leuven");
        plaatsen.add("Brussel");
        plaatsen.add("Oostende");
    }          
    public ArrayList<String> getLoc(){
        return plaatsen;
    }
}

