package service;

import com.company.Legatura;
import com.company.Ruta;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class legaturaService {
    int nrLegaturi=0;
    String path="F:\\ex\\PAO\\legaturi.csv";

    public legaturaService(){}
    public legaturaService(String path)
    {
        this.path=path;
    }
    public Legatura[] citire()
    {
        List<Legatura> lLegaturi=new ArrayList<>();
        Legatura[] legaturi;
        try(BufferedReader br=new BufferedReader(new FileReader(path))){
            nrLegaturi= Integer.parseInt(br.readLine());
            rutaService rS=new rutaService();
            while (nrLegaturi>0)
            {
                String nume=br.readLine();
                Ruta[]r=rS.citire();
                lLegaturi.add(new Legatura(nume,r));
                nrLegaturi-=1;
            }

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        legaturi=lLegaturi.toArray(new Legatura[lLegaturi.size()]);

        return legaturi;
    }

    public void scriere(Legatura legaturi[],int nrlegaturi)
    {
        nrLegaturi=nrlegaturi;

        try(BufferedWriter bw=new BufferedWriter(new FileWriter(path)))
        {
            rutaService rS=new rutaService(path,bw);
            bw.append(String.valueOf(nrlegaturi));
            bw.append("\n");
            bw.append("\n");
            while (nrLegaturi>0) {
                bw.append(legaturi[nrLegaturi - 1].getNume());
                bw.append(",");

                Ruta[] r = legaturi[nrLegaturi - 1].getRute();
                for (int i = 0; i < r.length; i++){
                    bw.append(r[i].getNume());
                    bw.append(",");
                }
                // rS.scriere(r,r.length);
                nrLegaturi-=1;
                bw.append("\n");
                bw.append("\n");
            }

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
