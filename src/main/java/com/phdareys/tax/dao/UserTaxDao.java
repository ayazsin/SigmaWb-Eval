package com.phdareys.tax.dao;

import com.phdareys.tax.model.CivilState;
import com.phdareys.tax.model.CountryUserTax;
import com.phdareys.tax.model.FrenchUserTax;
import com.phdareys.tax.model.NiceCountryUserTax;
import com.phdareys.tax.utilities.ConfigReader;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class UserTaxDao {

    private static Connection conn = null;
    private ArrayList<CountryUserTax> countryUserTaxArrayList;


    public static Connection getConnection() {

        String url = ConfigReader.getProperty("dburl");
        String user = ConfigReader.getProperty("user");
        String password = ConfigReader.getProperty("password");
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
    }

    public ArrayList get() throws SQLException {

        Statement st1 = getConnection().createStatement();
        countryUserTaxArrayList = new ArrayList<>();
        String q1 = "SELECT * FROM Impot.users;";
        ResultSet rs1 = st1.executeQuery(q1);
        int i = 0;
        while (rs1.next()) {
            if(rs1.getString(2).equals("FRANCE"))
            countryUserTaxArrayList.add(new FrenchUserTax( rs1.getString(3) , rs1.getInt(4), CivilState.valueOf(rs1.getString(5)) ,rs1.getInt(6)));
            else countryUserTaxArrayList.add(new NiceCountryUserTax( rs1.getString(3) , rs1.getInt(4), CivilState.valueOf(rs1.getString(5)) ,rs1.getInt(6)));

            add(countryUserTaxArrayList.get(i),i+1);
            i++;

        }

        closeStatement(st1);
        closeConnection();
        closeResultSet(rs1);

        return countryUserTaxArrayList;
    }

    public boolean add(CountryUserTax o, int i) throws SQLException {
        Statement st1 = getConnection().createStatement();
        String q = "UPDATE Impot.users SET impot = " + o.getCalculDeLimpot() + " WHERE (idnew_table = " + i +")";
        st1.executeUpdate(q);

        closeStatement(st1);
        closeConnection();
        return false;
    }

    public void display() throws SQLException {
       get();
       for ( CountryUserTax elt : countryUserTaxArrayList) {
           System.out.println(elt);
       }

    }




}
