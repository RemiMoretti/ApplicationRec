package com.example.myrecc.metier;

import java.time.LocalTime;
import java.util.Date;

public class Soirée {
    //-----------------------------------------------------------------------
    //---------------------Déclarations des variables------------------------
    //-----------------------------------------------------------------------
    private Utilisateur orga;
    private String adresse;
    private int CP;
    private String ville;
    private Date date;
    private LocalTime heure;
    private String description;
    private boolean alcool;
    private boolean soireeOuverte;

    //-----------------------------------------------------------------------
    //-------------------------------Constructeur----------------------------
    //-----------------------------------------------------------------------
    public Soirée(Utilisateur orga, String adresse, int CP, String ville, Date date, LocalTime heure, String description, boolean alcool, boolean soireeOuverte) {
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
    public Utilisateur getOrga() {
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

    public Date getDate() {
        return date;
    }

    public LocalTime getHeure() {
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
