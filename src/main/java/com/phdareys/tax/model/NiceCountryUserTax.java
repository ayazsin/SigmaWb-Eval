package com.phdareys.tax.model;

import com.phdareys.tax.exception.TaxException;

public class NiceCountryUserTax extends CountryUserTax{
    private Country pays = Country.NICECOUNTRY;

    public NiceCountryUserTax() {
        super();
    }

    public NiceCountryUserTax(String nom, double revenuAnnuel, CivilState etatCivil, int nombreDenfantsChargee) {
        super(nom, revenuAnnuel, etatCivil, nombreDenfantsChargee);
        calculDeLimpot();
    }

    @Override
    public double calculDeLimpot() {
        double n = 2;
        if (getEtatCivil() == CivilState.VEUF) try {
            throw (new TaxException("Le systeme n'accepte pas les personnes veuves!!!"));
        } catch (TaxException e) {
            e.getMessage();
        }
        if(getEtatCivil() == CivilState.MARIE) n += 1;
        if (getNombreDenfantsChargee() > 0) n += getNombreDenfantsChargee() * 0.5;
        double ri = getRevenuAnnuel() / n;
        double i = 0;

        if (ri < 9808) i = 0;
        else if (ri < 27087) i = (getRevenuAnnuel() * 0.14) - (1372.98 * n);
        else if (ri < 72618) i = (getRevenuAnnuel() * 0.30) - (5706.74 * n);
        else  i = (getRevenuAnnuel() * 0.41) - (13694.61 * n);

        setCalculDeLimpot(i);
        return getCalculDeLimpot();
    }

    @Override
    public String toString() {
        return "NiceCountryUserTax{" +
                " pays=" + pays +
                ", nom=" + getNom() +
                ", revenuAnnuel=" + getRevenuAnnuel() +
                ", etatCivil" + getEtatCivil() +
                ", nombreDenfant=" + getNombreDenfantsChargee() +
                ", impot=" + getCalculDeLimpot() +
                '}';
    }
}
