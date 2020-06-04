package service;

import com.company.Masina;

import javax.print.DocFlavor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class masinaBazadate_Service {

    static final String USER = "grupa43proiect";
    static final String PASS = "bazededate";
    public void  masinaBazadate_Service(){}


    public Masina[] citire(){
        List<Masina> masini=new ArrayList<>();
        Masina[] rMasini;
        try{

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@193.226.51.37:1521:o11g", USER, PASS);
            Statement stmt=con.createStatement();

            String sql1="SELECT MAX (ID_MASINA) ID_MASINA from MASINA_ADU";
            ResultSet rs=stmt.executeQuery(sql1);
            rs.next();
            int id=rs.getInt("ID_MASINA");
            sql1="SELECT * from MASINA_ADU";
            rs = stmt.executeQuery(sql1);

            for (int i=0;i<id;i++) {
                rs.next();
                String marca = rs.getString("MARCA");

                String model = rs.getString("MODEL");

                int consum = Integer.valueOf(rs.getString("CONSUM"));

                int tonaj = Integer.valueOf(rs.getString("MASA_TRANSPORT"));
                masini.add(new Masina(marca,model,consum,tonaj));

            }
        }
        catch(Exception e){
            System.out.println(e);

        }
        rMasini=masini.toArray(new Masina[masini.size()]);
        return rMasini;
    }

    public void scriere(Masina masini[], int nrmasini)
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@193.226.51.37:1521:o11g", USER, PASS);
            Statement stmt=con.createStatement();

            String sql1="SELECT MAX (ID_MASINA) ID_MASINA from MASINA_ADU";
            ResultSet rs=stmt.executeQuery(sql1);
            rs.next();
            int id=rs.getInt("ID_MASINA");


            for (int i = 0;i<masini.length;i++)
            {
                id+=1;
                String sql = "INSERT INTO MASINA_ADU  VALUES (?,?,?,?,?)";
                        //"VALUES ("+Integer.toString(id)+","+masini[i].toString()+","+masini[i].caracteristici()+ ");";
                PreparedStatement ps= con.prepareStatement(sql);
                ps.setInt(1,id);
                String m=masini[i].toString();
                String[] m1=m.split(",");
                String ca=masini[i].caracteristici();
                String[] ca1=ca.split(",");

                ps.setString(2,m1[0]);
                ps.setString(3,m1[1]);
                ps.setString(4,ca1[0]);
                ps.setString(5,ca1[1]);
                ps.execute();
                ps.close();
                //rs=stmt.executeQuery(sql);

            }


        }


        catch(Exception e){
            System.out.println(e);
        }
    }
}
