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
public class Wagens {
    private ArrayList<String> wagens;
              
    public Wagens(){
        wagens =new ArrayList<String>();
        wagens.add("Wagen1");
        wagens.add("Wagen2");
        wagens.add("Wagen3");
        wagens.add("Wagen4");
        wagens.add("Wagen5");
    }          
    public ArrayList<String> getWag(){
        return wagens;
    }
}

