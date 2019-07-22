/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author BOJAN
 */
public class Vozilo implements OpstiDomenskiObjekat {
    private int voziloID;
    private Date datumPocetkaSluzbe;
    private String vin;
    private String registarskaOznaka;
    private String marka;
    private String model;
    private double ukupnaKilometraza;

    public Vozilo() {
    }

    public Vozilo(int voziloID, Date datumPocetkaSluzbe, String vin, String registarskaOznaka, String marka, String model, double ukupnaKilometraza) {
        this.voziloID = voziloID;
        this.datumPocetkaSluzbe = datumPocetkaSluzbe;
        this.vin = vin;
        this.registarskaOznaka = registarskaOznaka;
        this.marka = marka;
        this.model = model;
        this.ukupnaKilometraza = ukupnaKilometraza;
    }

    public int getVoziloID() {
        return voziloID;
    }

    public void setVoziloID(int voziloID) {
        this.voziloID = voziloID;
    }

    public Date getDatumPocetkaSluzbe() {
        return datumPocetkaSluzbe;
    }

    public void setDatumPocetkaSluzbe(Date datumPocetkaSluzbe) {
        this.datumPocetkaSluzbe = datumPocetkaSluzbe;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getRegistarskaOznaka() {
        return registarskaOznaka;
    }

    public void setRegistarskaOznaka(String registarskaOznaka) {
        this.registarskaOznaka = registarskaOznaka;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getUkupnaKilometraza() {
        return ukupnaKilometraza;
    }

    public void setUkupnaKilometraza(double ukupnaKilometraza) {
        this.ukupnaKilometraza = ukupnaKilometraza;
    }
    
    @Override
    public String toString() {
        return registarskaOznaka + " " + marka + " " + model;
    }

    @Override
    public String vratiNazivTabele() {
        return "vozilo";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        DateFormat dps = new SimpleDateFormat("yyyy-MM-dd");
        return "'"+ voziloID + "','"+dps.format(datumPocetkaSluzbe) + "','" + vin + "','" + registarskaOznaka + "','"+ marka + "','" + model + "','"+ ukupnaKilometraza +"'";
    }

    @Override
    public String vratiIDKolonu() {
        return "voziloID";
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "(voziloID,datumPocetkaSluzbe,vin,registarskaOznaka,marka,model,ukupnaKilometraza)";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajObjekte(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lv = new LinkedList<>();
            while (rs.next()) {
                int voziloID = rs.getInt("voziloID");
                Date datumPocetkaSluzbe = rs.getDate("datumPocetkaSluzbe");
                String vin = rs.getString("vin");
                String registarskaOznaka = rs.getString("registarskaOznaka");
                String marka = rs.getString("marka");
                String model = rs.getString("model");
                Double ukupnaKilometraza = rs.getDouble("ukupnaKilometraza");
                
                
                Vozilo v = new Vozilo(voziloID, datumPocetkaSluzbe, vin, registarskaOznaka, marka, model, ukupnaKilometraza);
                
                lv.add(v);
            }
            return lv;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "vin='" +vin+ "',registarskaOznaka='" +registarskaOznaka+ "',marka='" + marka + "',model='"+ model + "',ukupnaKilometraza='" + ukupnaKilometraza+ "'";
    }

    @Override
    public String vratiUslovZaPK() {
        return "voziloID="+voziloID;
    }

    @Override
    public String vratiUslovZaPretragu() {
        return "registarskaOznaka";
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekat(ResultSet rs) throws Exception {
        return new Vozilo();
    }

    @Override
    public String vratiUslovZaJoin() {
        return "";
    }

    @Override
    public String vratiUslovZaPretraguID() {
        return "";
    }
    
    @Override
    public String vratiKoloneZaPretragu() {
        return "*";
    }

    @Override
    public String vratiUslovZaRedosled() {
        return "voziloID";
    }
    
    
}
