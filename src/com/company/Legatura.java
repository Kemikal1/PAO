package com.company;
import com.company.Oras;

public class Legatura extends Oras
{
    private Ruta rute[];

    public Legatura(){}

    public Legatura(String nume,Ruta rute[])
    {
     super(nume,rute.length);
     this.rute=rute;

    }

   
}
