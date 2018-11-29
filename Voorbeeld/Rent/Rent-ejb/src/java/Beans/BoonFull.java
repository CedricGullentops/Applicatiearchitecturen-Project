/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.ejb.Stateful;


@Stateful
public class BoonFull implements BoonFullRemote {

    private int totprijs;
    private int totaant;
    
    public void addTot(int prijs){
        totaant++;
        totprijs += prijs;
    }
    public int getTotaant(){
    return totaant;
    }
    public int getTotprijs(){
        return totprijs;
    }
}
