package service;

import com.company.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class oraseService {
    int nrOrase;
    String path_citire="F:\\ex\\PAO\\orase.csv";
    String path_scriere="F:\\ex\\PAO\\orase.csv";
    BufferedWriter BW;
    BufferedReader BR;
    public oraseService(){}
    public oraseService(String path,BufferedWriter BW){
        this.BW=BW;
        path_citire=path;
        path_scriere=path;
    }
    public oraseService(String path,BufferedReader BR){
        this.BR=BR;
        path_citire=path;
        path_scriere=path;
    }
    public oraseService(String path){
        path_citire=path;
        path_scriere=path;
    }
    public Oras[] citire()
    {
        List<Oras> Orase =new ArrayList<>();
        if(BR==null)
        {
            try{
                BR=new BufferedReader(new FileReader(path_scriere));
            }catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try{
            BufferedReader br=BR;
            //String s=br.readLine();
            String d=br.readLine();
            if(d.equals(""))
                nrOrase=Integer.parseInt(br.readLine());
            else
                nrOrase=Integer.parseInt(d);
            String oras;
            while(nrOrase>0)
            {
                oras=br.readLine();
                String[] Oras=oras.split(",");
                Orase.add(new Oras(Oras[0]));

                nrOrase-=1;
            }

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        return Orase.toArray(new Oras[Orase.size()]);
    }
    public void scriere( Oras orase[],int nrorase){
        nrOrase=nrorase;
        if(BW==null)
        {
            try{
                BufferedWriter Bw=new BufferedWriter(new FileWriter(path_scriere));
                BW=Bw;
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        BufferedWriter bw;
        try{
            bw=BW;
            bw.append("\n");
            bw.append(String.valueOf(nrorase));
            bw.append("\n");
            while(nrOrase>0)
            {
                String nume=orase[nrOrase-1].getNume();
                int nrRute=orase[nrOrase-1].getNr_rute();
                String oras=nume+","+String.valueOf(nrRute);
                bw.append(oras);
                bw.append(",");
                bw.append("\n");
                nrOrase-=1;
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public void Wclose()
    {
        try{
         BW.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }


    }
    public void Rclose()
    {
        try{
            BR.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
