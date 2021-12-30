package com.phdareys.tax.model;

import com.phdareys.tax.exception.TaxException;

public abstract class CountryUserTax {

    private String nom;
    private double revenuAnnuel;
    private CivilState etatCivil;
    private int nombreDenfantsChargee;
    private double calculDeLimpot;

    public CountryUserTax() {
    }

    public CountryUserTax(String nom, double revenuAnnuel, CivilState etatCivil, int nombreDenfantsChargee) {
        this.nom = nom;
        this.revenuAnnuel = revenuAnnuel;
        this.etatCivil = etatCivil;
        this.nombreDenfantsChargee = nombreDenfantsChargee;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getRevenuAnnuel() {
        return revenuAnnuel;
    }

    public void setRevenuAnnuel(double revenuAnnuel) {
        this.revenuAnnuel = revenuAnnuel;
    }

    public CivilState getEtatCivil() {
        return etatCivil;
    }

    public void setEtatCivil(CivilState etatCivil) {
        this.etatCivil = etatCivil;
    }

    public int getNombreDenfantsChargee() {
        return nombreDenfantsChargee;
    }

    public void setNombreDenfantsChargee(int nombreDenfantsChargee) {
        this.nombreDenfantsChargee = nombreDenfantsChargee;
    }

    public double getCalculDeLimpot() {
        return calculDeLimpot;
    }

    public void setCalculDeLimpot(double calculDeLimpot) {
        this.calculDeLimpot = calculDeLimpot;
    }

    public abstract double calculDeLimpot() throws TaxException;


    @Override
    public String toString() {
        return "CountryUserTax{" +
                "nom='" + nom + '\'' +
                ", revenuAnnuel=" + revenuAnnuel +
                ", etatCivil=" + etatCivil +
                ", nombreDenfantsChargee=" + nombreDenfantsChargee +
                ", calculDeLimpot=" + calculDeLimpot +
                '}';
    }
}
