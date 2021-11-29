package com.example.myrecc.metier;

public class Utilisateur {

    //-----------------------------------------------------------------------
    //---------------------Déclarations des variables------------------------
    //-----------------------------------------------------------------------
    private String nom;
    private String prenom;
    private int age;
    private String adresse;
    private int CP;
    private String mail;
    private String login;
    private String mdp;

    //-----------------------------------------------------------------------
    //-------------------------------Constructeur----------------------------
    //-----------------------------------------------------------------------
    public Utilisateur(String nom, String prenom, int age, String adresse, int CP, String mail, String login, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
        this.CP = CP;
        this.mail = mail;
        this.login = login;
        this.mdp = mdp;
    }


    //-----------------------------------------------------------------------
    //-------------------------------Getters---------------------------------
    //-----------------------------------------------------------------------
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getCP() {
        return CP;
    }

    public String getMail() {
        return mail;
    }

    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }
}
