package service;

import com.company.Masina;
import com.company.Oras;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class oraseDatabase_Service {
    public void oraseDatabase_Service(){}
    static final String USER = "grupa43proiect";
    static final String PASS = "bazededate";
    public Oras[] citire()
    {
        List<Oras> orase=new ArrayList<>();
        Oras [] o;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@193.226.51.37:1521:o11g", USER, PASS);
            Statement stmt=con.createStatement();

            String sql1="SELECT MAX (ID_ORAS) ID_ORAS from ORAS_ADU";
            ResultSet rs=stmt.executeQuery(sql1);
            rs.next();
            int id=rs.getInt("ID_ORAS");
            String sql="SELECT * FROM ORAS_ADU";
            rs=stmt.executeQuery(sql);
            for (int i=0;i<id;i++)
            {
                rs.next();
                int id1=rs.getInt("ID_ORAS");
                String nume=rs.getString("NUME");
                int nr_rute=rs.getInt("NR_RUTE");

                orase.add(new Oras(nume,nr_rute));
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
        o=orase.toArray(new Oras[orase.size()]);
        return o;

    }
    public void scriere(Oras []orase)
    {
        try{

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@193.226.51.37:1521:o11g", USER, PASS);
            Statement stmt=con.createStatement();
            String sql1="SELECT MAX (ID_ORAS) ID_ORAS from ORAS_ADU";
            ResultSet rs=stmt.executeQuery(sql1);
            rs.next();
            int id=rs.getInt("ID_ORAS");

            for (int i = 0;i<orase.length;i++)
            {
                id+=1;
                String sql = "INSERT INTO ORAS_ADU  VALUES (?,?,?)";
                PreparedStatement ps= con.prepareStatement(sql);
                ps.setString(1,orase[i].NumeOras());
                ps.setInt(2,orase[i].getNr_rute());
                ps.setInt(3,id);
                ps.execute();
                ps.close();

            }
        }

        catch (Exception e){
            System.out.println(e);
        }

    }
}
