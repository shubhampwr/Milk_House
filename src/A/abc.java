/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A;

import javax.swing.JApplet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemListener;
/*<applet code="abc.class" width=200 height=300 > */
public class abc extends JApplet {

   JCheckBox b1=null;
   JCheckBox b2=null;
   JCheckBox b3=null;
   
    public void init() 
    {
        b1=new JCheckBox("php");
        b2=new JCheckBox("javaa");
        b3=new JCheckBox("cpp");
        
        add(b1);
        add(b2);
        add(b3);

        b1.addItemListener((ItemListener) this);
        b2.addItemListener((ItemListener) this);
        b3.addItemListener((ItemListener) this);
   }

    public void paint(Graphics g)
    {
        g.drawString("php="+b1.getName(),20,80);
    }
}
