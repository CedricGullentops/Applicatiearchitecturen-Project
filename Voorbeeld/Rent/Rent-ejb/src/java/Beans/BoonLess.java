/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.ejb.Remote;
import javax.ejb.Stateless;


@Stateless
public class BoonLess implements BoonLessRemote {

    public int calcPrijs(int dprijs,int daant,int korting){
        return (int)((dprijs+10*daant-korting)*1.21);
    }
}
