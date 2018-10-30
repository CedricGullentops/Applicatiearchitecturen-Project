/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.ejb.Remote;

/**
 *
 * @author student
 */
@Remote
public interface BoonFullRemote {

    public void addTot(int prijs);

    public int getTotprijs();

    public int getTotaant();
    
    public void initPrijs();
    
}
