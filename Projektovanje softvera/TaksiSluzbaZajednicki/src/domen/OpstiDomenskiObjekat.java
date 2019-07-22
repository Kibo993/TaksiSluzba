/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author BOJAN
 */
public interface OpstiDomenskiObjekat extends Serializable {
    
    public String vratiNazivTabele(); 

    public String vratiVrednostiZaInsert();
   
    public String vratiIDKolonu();
    
    public String vratiNaziveKolonaZaInsert();
    
    public List<OpstiDomenskiObjekat> ucitajObjekte(ResultSet rs) throws Exception;

    public String vratiVrednostiZaUpdate();

    public String vratiUslovZaPK();

    public String vratiUslovZaPretragu();
    
    public OpstiDomenskiObjekat vratiObjekat(ResultSet rs) throws Exception;

    public String vratiUslovZaJoin();

    public String vratiUslovZaPretraguID();
    
    public String vratiKoloneZaPretragu();
    
    public String vratiUslovZaRedosled();
}
