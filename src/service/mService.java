package service;
import com.company.*;
public class mService {


    String path_masini="F:\\ex\\PAO\\masini.csv";
    String path_rute="F:\\ex\\PAO\\rute.csv";
    String path_orase="F:\\ex\\PAO\\orase.csv";
    String path_legaturi="F:\\ex\\PAO\\legaturi.csv";




    public companie citire()
    {
        rutaService rs=new rutaService(path_rute);
        masiniService ms=new masiniService(path_masini);
        legaturaService lS=new legaturaService(path_legaturi);
        oraseService oS=new oraseService(path_orase);
        Ruta[] r=rs.citire();
        Masina[] m=ms.citire();
        companie Comp=new companie(m,oS.citire(),r,m.length,r.length);
        oS.Rclose();
        ms.Rclose();
        //rs.Rclose();
        return Comp;
    }

    public void scriere(companie comp)
    {
        rutaService rs=new rutaService(path_rute);
        masiniService ms=new masiniService(path_masini);
        legaturaService lS=new legaturaService(path_legaturi);
        oraseService oS=new oraseService(path_orase);

        rs.scriere(comp.getRute(),comp.getNr_rute());
        ms.scriere(comp.getMasini(),comp.getNr_masini());
        lS.scriere(comp.getLegaturi(),comp.getLegaturi().length);
        oS.scriere(comp.getHarta(),comp.getHarta().length);
        oS.Wclose();
        ms.Wclose();
        rs.Wclose();


    }

}
