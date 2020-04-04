package com.company;
import java.util.Arrays;
public class companie implements interfataCompanie {
    private Masina masini[];
    private Ruta rute[];
    private Legatura legaturi[];
    private int nr_masini;
    private int nr_rute;

    public companie(){}
    public companie(Masina masini[],Oras orase[],Ruta rute[],int nr_masini,int nr_rute)
    {
        this.masini=masini;
        this.rute=rute;
        this.nr_masini=nr_masini;
        this.nr_rute=nr_rute;
        int nr_legaturi=0;

        for(Ruta r:rute) {
           Oras o[] = r.Orase();
           for (Oras oras : o)
           {
               for (int i=0;i<orase.length;i++)
               {
                   if (orase[i].NumeOras() == oras.NumeOras())
                   {
                       orase[i].adRuta();
                       break;
                   }
               }

           }


        }
        for (Oras o:orase)
        {
            if(o.nrRute()>1)
            {
                Ruta rute_leg[]=new Ruta[0];
                Ruta ruta_c[];
                for(Ruta r:rute)
                {

                    for (Oras oras_ruta:r.Orase())
                    {
                        if(oras_ruta.NumeOras()==o.NumeOras())
                        {
                            ruta_c=new Ruta[rute_leg.length+1];
                            for (int i=0;i<rute_leg.length;i++)
                            {
                                ruta_c[i]=rute_leg[i];
                            }

                            ruta_c[rute_leg.length]=r;
                            rute_leg=ruta_c;
                            break;
                        }
                    }
                }

                Legatura legaturi_cop[]=new Legatura[nr_legaturi+1];
                for(int i=0;i<nr_legaturi;i++)
                {
                    legaturi_cop[i]=legaturi[i];
                }
                Legatura new_leg=new Legatura(o.NumeOras(),rute_leg);
                legaturi_cop[nr_legaturi]=new_leg;
                legaturi=legaturi_cop;
                nr_legaturi+=1;
            }
        }




    }
    public void MasinaNoua(Masina masina)
    {

        Masina masini_c[]=new Masina[nr_masini+1];
        for (int i=0;i<nr_masini;i++)
            masini_c[i]=this.masini[i];
        masini_c[nr_masini]=masina;
        this.nr_masini+=1;
        masini=masini_c;
    }
    public void RutaNoua(Ruta ruta)
    {
        Ruta rute_c[]=new Ruta[nr_rute+1];
        for (int i=0;i<nr_rute;i++)
            rute_c[i]=this.rute[i];
        rute_c[nr_rute]=ruta;
        rute=rute_c;

    }
    public Masina[] getMasini()
    {
        return masini;
    }
    public Ruta[] getRute()
    {
        return rute;
    }
    public Legatura[] getLegaturi()
    {
        return legaturi;
    }
    public int getNr_masini()
    {
        return nr_masini;
    }
    public int getNr_rute()
    {
        return nr_rute;
    }

    @Override
    public String afisRutele() {
        return "Rutele sunt: "+Arrays.toString(rute)+"\n";
    }

    @Override
    public String afisLegaturile() {
        return "Legaturile sunt:"+Arrays.toString(legaturi)+"\n";
    }

    @Override
    public String afisMasinile() {
        return "Masinile sunt:"+Arrays.toString(masini)+"n";
    }
}
