package com.phdareys.tax.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaxUserFactory {

    private List<FrenchUserTax> frenchUserTaxList;
    private List <NiceCountryUserTax> niceCountryUserTaxList;


    public void userFactory() throws IOException {

        frenchUserTaxList = new ArrayList<FrenchUserTax>();
        niceCountryUserTaxList = new ArrayList<NiceCountryUserTax>();

        BufferedReader csvReader = new BufferedReader(
                new FileReader("/Users/ayse/eclipse-workspace/SigmaWb_2021_Eval/table.csv"));

        String row;


        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if (data[0].equals("FRANCE")) {
                frenchUserTaxList.add(new FrenchUserTax(data[1],Double.parseDouble(data[2]),CivilState.valueOf(data[3]),Integer.parseInt(data[4])));
            } else {
                niceCountryUserTaxList.add(new NiceCountryUserTax(data[1],Double.parseDouble(data[2]),CivilState.valueOf(data[3]),Integer.parseInt(data[4])));
            }

        }

        csvReader.close();
    }

    public List<FrenchUserTax> getFrenchUserTaxList() {
        return frenchUserTaxList;
    }

    public List<NiceCountryUserTax> getNiceCountryUserTaxList() {
        return niceCountryUserTaxList;
    }

    public void display(){
        try {
            userFactory();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (FrenchUserTax elt : frenchUserTaxList)
            System.out.println(elt);
        for (NiceCountryUserTax elt : niceCountryUserTaxList)
            System.out.println(elt);
    }

}
