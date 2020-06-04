package service;

import com.company.*;

import java.sql.*;

public class mDatabase_Service {

    public void mDatabase_Service(){}

    static final String USER = "grupa43proiect";
    static final String PASS = "bazededate";
    public void citire()
    {

       masinaBazadate_Service m=new masinaBazadate_Service();
       oraseDatabase_Service o=new oraseDatabase_Service();
       Masina[] masini=m.citire();
       Oras[]orase=o.citire();
        for (int i=0;i<orase.length;i++)
            System.out.println(orase[i]);
       for (int i=0;i<masini.length;i++)
        System.out.println(masini[i]);

    }





    public void scriere(companie comp){
        masinaBazadate_Service m=new masinaBazadate_Service();
        oraseDatabase_Service o=new oraseDatabase_Service();
        m.scriere(comp.getMasini(),comp.getNr_masini());
        o.scriere(comp.getHarta());
    }
    }