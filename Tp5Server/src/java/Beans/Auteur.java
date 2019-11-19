/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Oumayma
 */
public class Auteur {
    private String nom;
    private String prenom;
    private boolean actif;

    
    public String getNom() {
        return nom;
    }

    
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    public String getPrenom() {
        return prenom;
    }

    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

   
    public boolean isActif() {
        return actif;
    }

   
    public void setActif(boolean actif) {
        this.actif = actif;
    }
    
}
