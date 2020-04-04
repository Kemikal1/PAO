package com.company;
import helper.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //
        //Daca oarasele nu au cate rute trb uitate la for din constructorii companiei
        //
        companie companie=new companieHelper().companieInitiala();
        System.out.println("Masinile sunt:"+Arrays.toString(companie.getMasini())+"\n");
        System.out.println("Rutele sunt"+Arrays.toString(companie.getRute()));
        System.out.println("Legaturile sunt"+Arrays.toString(companie.getLegaturi()));
        Masina masina=new Masina("Isuzu","Seria L",16,8);
        companie.MasinaNoua(masina);
        System.out.println("Masinile sunt:"+Arrays.toString(companie.getMasini()));
        System.out.println(companie.afisMasinile());
    }
}