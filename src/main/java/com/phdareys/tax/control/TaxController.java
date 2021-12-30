package com.phdareys.tax.control;

import com.phdareys.tax.dao.UserTaxDao;
import com.phdareys.tax.model.TaxUserFactory;

import java.io.IOException;
import java.sql.SQLException;

public class TaxController {


    public static void main(String[] args) throws SQLException {

        System.out.println("===========>Avec CSV<===========");
        TaxUserFactory taxUserFactory = new TaxUserFactory();
        taxUserFactory.display();

        System.out.println();
        System.out.println("===========>Avec SQL<===========");
        UserTaxDao userTaxDao = new UserTaxDao();
        userTaxDao.display();

    }
}
