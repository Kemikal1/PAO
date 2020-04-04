package com.company;

public class Oras {
    protected String nume;
    protected int nr_rute=0;
    public Oras()
    {

    }
    public Oras(String nume)
    {
        this.nume=nume;
    }
    public Oras(String nume ,int x)
    {
        this.nume=nume;
        this.nr_rute=x;
    }
    public String NumeOras()
    {
        return nume;
    }
    public void adRuta()
    {
        nr_rute+=1;
    }
    public void adRuta(int x)
    {
        nr_rute+=x;
    }
    public int nrRute()
    {
        return nr_rute;
    }

    @Override
    public String toString() {
        return this.NumeOras()+"  numar rute:"+nr_rute;
    }
}
