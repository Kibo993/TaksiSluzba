/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author BOJAN
 */
public class Sluzbenik implements OpstiDomenskiObjekat {
    private int sluzbenikID;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String korisnickaSifra;

    public Sluzbenik() {
    }

    public Sluzbenik(int sluzbenikID, String ime, String prezime, String korisnickoIme, String korisnickaSifra) {
        this.sluzbenikID = sluzbenikID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.korisnickaSifra = korisnickaSifra;
    }

    public int getSluzbenikID() {
        return sluzbenikID;
    }

    public void setSluzbenikID(int sluzbenikID) {
        this.sluzbenikID = sluzbenikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getKorisnickaSifra() {
        return korisnickaSifra;
    }

    public void setKorisnickaSifra(String korisnickaSifra) {
        this.korisnickaSifra = korisnickaSifra;
    }
    
    @Override
    public String toString() {
        return ime+ " "+prezime;
    }

    @Override
    public String vratiNazivTabele() {
        return "Sluzbenik";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "";
    }

    @Override
    public String vratiIDKolonu() {
        return "sluzbenikID";
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajObjekte(ResultSet rs) throws Exception {
        return null;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "";
    }

    @Override
    public String vratiUslovZaPK() {
        return "KorisnickoIme= '" + korisnickoIme + "' AND KorisnickaSifra= '" + korisnickaSifra + "'";
    }

    @Override
    public String vratiUslovZaPretragu() {
        return "";
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekat(ResultSet rs) throws Exception {
        try {
            Sluzbenik ag = new Sluzbenik();
            while(rs.next()) {
                int id = rs.getInt("sluzbenikID");
                ag.setSluzbenikID(id);
                String ime = rs.getString("ime");
                ag.setIme(ime);
                String prezime = rs.getString("prezime");
                ag.setPrezime(prezime);
                String un = rs.getString("korisnickoIme");
                ag.setKorisnickoIme(un) ;
                String pw = rs.getString("korisnickaSifra");
                ag.setKorisnickaSifra(pw);
                
            }
            
            return ag;
        }
        
        catch (Exception ex) {
            throw ex;
        }
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
        return "sluzbenikID";
    }
    
}
