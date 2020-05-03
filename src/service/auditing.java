package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class auditing {

    String Path="F:\\ex\\PAO\\audit.csv";
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    public auditing(){}
    public void rutaNoua()
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(Path)))
        {
            bw.append("Ruta_noua");
            bw.append(",");
            bw.append(dateFormat.format(date));
            bw.append("\n");
        }
         catch(IOException ex) {
        ex.printStackTrace();
        }

    }
    public void masinaNoua()
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(Path)))
        {
            bw.append("Masina_Noua");
            bw.append(",");
            bw.append(dateFormat.format(date));
            bw.append("\n");
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
