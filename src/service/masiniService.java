package service;
import com.company.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class masiniService {
    int nrMasini=0;
    BufferedWriter BW;
    BufferedReader BR;
    String path_citire="F:\\ex\\PAO\\masini.csv";
    String path_scriere="F:\\ex\\PAO\\masini.csv";
    public masiniService(String path){

        path_citire=path;
        path_scriere=path;
    }

    public masiniService(String path,BufferedWriter BW){
        this.BW=BW;


        path_citire=path;
        path_scriere=path;
    }
    public masiniService(String path,BufferedReader BR){
        this.BR=BR;
        path_citire=path;
        path_scriere=path;
    }
    public Masina[] citire(){
        Masina[] rMasini;
        List<Masina> masini=new ArrayList<>();
        if(BR==null)
        {
            try{
                BR=new BufferedReader(new FileReader(path_scriere));
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try
        {
            BufferedReader br;
            br=BR;
            nrMasini=Integer.parseInt(br.readLine());
            String masina;
            while(nrMasini>0){
                masina=br.readLine();
                String[] masinaD=masina.split(",");
                int consum;
                int m_transport;
                consum=Integer.parseInt(masinaD[2]);
                m_transport=Integer.parseInt(masinaD[3]);
                masini.add(new Masina(masinaD[0],masinaD[1],consum,m_transport));
                nrMasini-=1;
               // String s= br.readLine();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        rMasini=masini.toArray(new Masina[masini.size()]);

        return rMasini;

    }

    public void scriere(Masina masini[],int nrmasini){

        if(BW==null)
        {
            try{BufferedWriter Bw=new BufferedWriter(new FileWriter(path_scriere));
                BW=Bw;
            }

            catch (IOException ex) {
            ex.printStackTrace();
        }
        }
        BufferedWriter bw;
        try{
            bw=BW;
            bw.append(String.valueOf(nrmasini));
            bw.append("\n");
            while(nrmasini>0)
            {
                String append=masini[nrmasini-1].toString()+","+masini[nrmasini-1].caracteristici();
                bw.append(append);
                bw.append("\n");
                nrmasini-=1;
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public void Wclose()
    {
        try {
            BW.close();

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public void Rclose(){
        try {
            BR.close();

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
