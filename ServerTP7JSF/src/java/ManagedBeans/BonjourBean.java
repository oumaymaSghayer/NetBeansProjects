/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import javax.annotation.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Oumayma
 */
@Named(value = "bonjourBean")
//@RequestScoped
//@ManagedBean
public class BonjourBean {

    
    private String nom;
    
    public BonjourBean() {
    }
  
    public String getNom() {
        return nom;
    }
  
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String bienvenue() {return "Bienvenue";}
}
