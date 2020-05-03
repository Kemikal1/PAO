package service;
import com.company.*;
import com.company.Ruta;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class rutaService {

    int nrRute = 0;
    BufferedReader BR;
    BufferedWriter BW;
    String path_scriere = "F:\\ex\\PAO\\rute.csv";
    String path_citire = "F:\\ex\\PAO\\rute.csv";

    public rutaService() {
    }

    public rutaService(String path, BufferedReader BR) {
        this.BR = BR;
        path_citire = path;
        path_scriere = path;
    }

    public rutaService(String path, BufferedWriter BW) {
        this.BW = BW;
        path_citire = path;
        path_scriere = path;
    }

    public rutaService(String path) {
        path_citire = path;
        path_scriere = path;
    }

    public Ruta[] citire() {
        List<Ruta> lRute = new ArrayList<>();
        Ruta rute[];
        try (BufferedReader br = new BufferedReader(new FileReader(path_citire))) {
            nrRute = Integer.parseInt(br.readLine());
            oraseService oS = new oraseService(path_citire, br);
            masiniService mS = new masiniService(path_citire, br);
            while (nrRute > 0) {
                String nume = br.readLine();
                Masina[] masini = mS.citire();

                String ultimu_rand = br.readLine();
                String[] ur = ultimu_rand.split(",");
                System.out.println(ultimu_rand);
                String marfa = ur[0];
                int distanta = Integer.parseInt(ur[1]);
                int nr_masini = Integer.parseInt(ur[2]);
                nrRute -= 1;
                Oras[] orase = oS.citire();
                lRute.add(new Ruta(masini, orase, marfa, nume, distanta, nr_masini));
                String s = br.readLine();
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        }


        rute = lRute.toArray(new Ruta[lRute.size()]);
        return rute;
    }

    public void scriere(Ruta[] rute, int nrrute) {
        nrRute = nrrute;
        if (BW == null) {
            System.out.println("aaaaaaa");
            try {
                BW = new BufferedWriter(new FileWriter(path_scriere));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try {
            BufferedWriter bw = BW;
            masiniService mS = new masiniService(path_scriere, bw);
            oraseService oS = new oraseService(path_scriere, bw);
            bw.append(String.valueOf(nrrute));
            bw.append("\n");
            while (nrRute > 0) {
                String nume = rute[nrRute - 1].getNume();
                String marfa = rute[nrRute - 1].getMarfa();
                int distanta = rute[nrRute - 1].getDistanta();
                int nr_masini = rute[nrRute - 1].getNr_masini();
                Oras[] orase = rute[nrRute - 1].Orase();
                Masina[] masini = rute[nrRute - 1].getMasini();
                bw.append(nume);
                bw.append("\n");
                mS.scriere(masini, masini.length);
                bw.append(marfa);
                bw.append(",");
                bw.append(String.valueOf(distanta));
                bw.append(",");
                bw.append(String.valueOf(nr_masini));
                oS.scriere(orase, orase.length);
                bw.append("\n");
                nrRute -= 1;


            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void Wclose() {
        try {
            BW.close();

        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }
    public void Rclose() {
        try {

            BR.close();
        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }
}
