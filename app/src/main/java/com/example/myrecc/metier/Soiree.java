package com.example.myrecc.metier;

import java.time.LocalTime;
import java.util.Date;

public class Soiree {
    //-----------------------------------------------------------------------
    //---------------------Déclarations des variables------------------------
    //-----------------------------------------------------------------------
    private CompteUtilisateur orga;
    private String adresse;
    private int CP;
    private String ville;
    private String date;
    private String heure;
    private String description;
    private boolean alcool;
    private boolean soireeOuverte;

    //-----------------------------------------------------------------------
    //-------------------------------Constructeur----------------------------
    //-----------------------------------------------------------------------
    public Soiree(CompteUtilisateur orga, String adresse, String ville,int CP, String date, String heure, String description, boolean alcool, boolean soireeOuverte) {
        this.orga = orga;
        this.adresse = adresse;
        this.CP = CP;
        this.ville = ville;
        this.date = date;
        this.heure = heure;
        this.description = description;
        this.alcool = alcool;
        this.soireeOuverte = soireeOuverte;
    }
    //-----------------------------------------------------------------------
    //-------------------------------Getters---------------------------------
    //-----------------------------------------------------------------------
    public CompteUtilisateur getOrga() {
        return orga;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getCP() {
        return CP;
    }

    public String getVille() {
        return ville;
    }

    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAlcool() {
        return alcool;
    }

    public boolean isSoireeOuverte() {
        return soireeOuverte;
    }
}
