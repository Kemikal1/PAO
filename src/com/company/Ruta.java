package com.company;

import java.util.Arrays;

public class Ruta {

    private Masina masini[];
    private Oras orase[];
    private String marfa;
    private String nume;
    private int distanta;
    private int nr_masini;

    public Ruta() {
    }

    public Ruta(Masina masini[], Oras orase[], String marfa, String nume, int distanta, int nr_masini) {
        this.masini = masini;
        this.orase = orase;
        this.marfa = marfa;
        this.nume = nume;
        this.distanta = distanta;
        this.nr_masini = nr_masini;
    }

    public Oras[] Orase() {
        return orase;
    }

    @Override
    public String toString() {
        return "masini:"+ Arrays.toString(masini) +" \n orase:"+Arrays.toString(orase)+"\n distanta:"+distanta+"\n nr masini:"
        +nr_masini+"\n marfa:"+marfa+"\n\n";
    }
}