/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentc;

import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author student
 */
public class GUI extends JFrame{
    JTextField tex;
    JButton but;
    JLabel lab;
    
    public GUI(){
        setLayout(new FlowLayout());
        tex = new JTextField("# Dagen",6);
        but = new JButton("bereken");
        lab = new JLabel("prijs");
        this.add(tex);
        this.add(lab);
        this.add(but);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
}
