package helper;
import com.company.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class companieHelper {
    public companieHelper(){}
    public companie companieInitiala()
    {
        String marci[]={"Hyundai","Iveco","Isuzu","Scania","Scania","Volvo"};
        String modele[]={"HD36L","S-way","Seria N","Seria P","Seria L","FE"};
        String marfa[]={"fiare","mancare","oi"};
        int consum[]={22,26,20,30,27,25};
        int masa[]={5,6,6,10,11,8};
        int distanta[]={440,600,700};

        String Orase[]={"Bucuresti","Braila","Galati","Constanta","Pitesti","Ploiesti","Brasov"};
        Oras Orase_ob[]=new Oras[Orase.length];
        for (int i=0;i<Orase.length;i++)
        {
            Orase_ob[i]=new Oras(Orase[i]);
        }
        Masina masini[]=new Masina[marci.length];
        for (int i=0;i<marci.length;i++)
        {
            masini[i]=new Masina(marci[i],modele[i],consum[i],masa[i]);
        }
        Ruta ruta[]=new Ruta[marfa.length];
        Masina ruta1[]=Arrays.copyOfRange(masini,0,2);
        Masina ruta2[]=Arrays.copyOfRange(masini,2,4);
        Masina ruta3[]=new Masina[1];
        ruta3[0]=masini[5];

        Oras oras1[]=Arrays.copyOfRange(Orase_ob,0,4);
        Oras oras2[]=Arrays.copyOfRange(Orase_ob,4,7);
        Oras oras3[]=new Oras[2];
        oras3[0]=Orase_ob[0];
        oras3[1]=Orase_ob[5];

        ruta[0]=new Ruta(ruta1,oras1,marfa[0],"Bucuresti Constanta",distanta[0],ruta1.length);
        ruta[1]=new Ruta(ruta2,oras2,marfa[1],"Constanta Pitesti Brasov",distanta[1],ruta2.length);
        ruta[2]=new Ruta(ruta3,oras3,marfa[2],"Bucuresti Ploiesti",distanta[2],ruta3.length);
        System.out.println(masini);
        return new companie(masini,Orase_ob,ruta,masini.length,ruta.length);
    }
}
