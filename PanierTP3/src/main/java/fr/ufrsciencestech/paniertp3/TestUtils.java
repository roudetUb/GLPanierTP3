/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.paniertp3;

import java.awt.Component;
import java.awt.Container;

/**
 *
 * @author celine
 */
public class TestUtils {
    
    public static Component getChildNamed(Component parent, String name) {
         // Debug line
         //System.out.println("Class: " + parent.getClass() +
         //    " Name: " + parent.getName());
         if (name.equals(parent.getName())) { return parent; }
   
         if (parent instanceof Container) {
            Component[] children = ((Container)parent).getComponents();
   
            for (int i = 0; i < children.length; ++i) {
               Component child = getChildNamed(children[i], name);
               if (child != null) { return child; }
            }
         }
         return null;
    }
}

