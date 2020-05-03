package com.company;

public class Masina {
    private String marca;
    private String model;
    private int consum_perkm;
    private int masa_de_transport;  //tone
    public Masina(){}
    public Masina(String marca,String model,int consum_perkm,int masa_de_transport)
    {
        this.marca=marca;
        this.model=model;
        this.consum_perkm=consum_perkm;
        this.masa_de_transport=masa_de_transport;
    }

    @Override
    public String toString() {

        return marca+","+model;
    }
    public String caracteristici()
    {
        return String.valueOf(consum_perkm)+","+String.valueOf(masa_de_transport);
    }


}
