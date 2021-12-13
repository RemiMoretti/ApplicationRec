package com.example.myrecc.metier;

import java.time.LocalTime;
import java.util.ArrayList;
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
    private int alcool;
    private int soireeOuverte;
    private ArrayList<CompteUtilisateur> participants = new ArrayList<CompteUtilisateur>();

    //-----------------------------------------------------------------------
    //-------------------------------Constructeur----------------------------
    //-----------------------------------------------------------------------
    public Soiree(CompteUtilisateur orga, String adresse, String ville,int CP, String date, String heure, String description, int alcool, int soireeOuverte) {
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

    public static void remove(int position) {
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

    public int isAlcool() {
        return alcool;
    }

    public int isSoireeOuverte() {
        return soireeOuverte;
    }

    public ArrayList<CompteUtilisateur> getParticipants() {
        return participants;
    }

    //-----------------------------------------------------------------------
    //----------------------------Patricipants-------------------------------
    //-----------------------------------------------------------------------

    public void ajoutParticipants(CompteUtilisateur utilisateur){
        participants.add(utilisateur);
    }

    //-----------------------------------------------------------------------
    //----------------------------toString()-------------------------------
    //-----------------------------------------------------------------------

    @Override
    public String toString() {
        return "Soiree{" +
                "orga=" + orga +
                ", adresse='" + adresse + '\'' +
                ", CP=" + CP +
                ", ville='" + ville + '\'' +
                ", date='" + date + '\'' +
                ", heure='" + heure + '\'' +
                ", description='" + description + '\'' +
                ", alcool=" + alcool +
                ", soireeOuverte=" + soireeOuverte +
                '}';
    }
}
