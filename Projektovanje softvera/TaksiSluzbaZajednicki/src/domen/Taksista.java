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
public class Taksista implements OpstiDomenskiObjekat {
    private int taksistaID;
    private Date datumZaposlenja;
    private String ime;
    private String prezime;
    private String jmbg;
    private String kontakt;
    private String ulica;
    private String broj;
    private double ukupnaZarada;
    private TaksiStanica stanicaID;

    public Taksista() {
    }

    public Taksista(int taksistaID, Date datumZaposlenja, String ime, String prezime, String jmbg, String kontakt, String ulica, String broj, double ukupnaZarada, TaksiStanica stanicaID) {
        this.taksistaID = taksistaID;
        this.datumZaposlenja = datumZaposlenja;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.kontakt = kontakt;
        this.ulica = ulica;
        this.broj = broj;
        this.ukupnaZarada = ukupnaZarada;
        this.stanicaID = stanicaID;
    }

    public int getTaksistaID() {
        return taksistaID;
    }

    public void setTaksistaID(int taksistaID) {
        this.taksistaID = taksistaID;
    }

    public Date getDatumZaposlenja() {
        return datumZaposlenja;
    }

    public void setDatumZaposlenja(Date datumZaposlenja) {
        this.datumZaposlenja = datumZaposlenja;
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

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public double getUkupnaZarada() {
        return ukupnaZarada;
    }

    public void setUkupnaZarada(double ukupnaZarada) {
        this.ukupnaZarada = ukupnaZarada;
    }

    public TaksiStanica getStanicaID() {
        return stanicaID;
    }

    public void setStanicaID(TaksiStanica stanicaID) {
        this.stanicaID = stanicaID;
    }
    
    @Override
    public String toString() {
        return taksistaID + " " + ime + " " + prezime;
    }

    @Override
    public String vratiNazivTabele() {
        return "taksista";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        DateFormat dps = new SimpleDateFormat("yyyy-MM-dd");
        return "'" + taksistaID + "','"+dps.format(datumZaposlenja) + "','" + ime + "','" + prezime + "','"+ jmbg + "','" + kontakt + "','"+ ulica + "','"+ broj +"','"+ ukupnaZarada +"'";
    }

    @Override
    public String vratiIDKolonu() {
        return "taksistaID";
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "(taksistaID,datumZaposlenja,imeTaksiste,prezimeTaksiste,jmbg,kontakt,ulica,broj,ukupnaZarada)";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajObjekte(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lt = new LinkedList<>();
            while (rs.next()) {
                int taksistaID = rs.getInt("taksistaID");
                Date datumZaposlenja = rs.getDate("datumZaposlenja");
                String ime = rs.getString("imeTaksiste");
                String prezime = rs.getString("prezimeTaksiste");
                String jmbg = rs.getString("jmbg");
                String kontakt = rs.getString("kontakt");
                String ulica = rs.getString("ulica");
                String broj = rs.getString("broj");
                Double ukupnaZarada = rs.getDouble("ukupnaZarada");
                
                
                int stanicaID = rs.getInt("stanicaID");
                String adresa = rs.getString("adresa");
                String ptt = rs.getString("ptt");
                String opstina = rs.getString("opstina");
                
                TaksiStanica ts = new TaksiStanica(stanicaID, adresa, ptt, opstina);
                
                Taksista t = new Taksista(taksistaID, datumZaposlenja, ime, prezime, jmbg, kontakt, ulica, broj, ukupnaZarada, ts);
                
                lt.add(t);
            }
            return lt;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "imeTaksiste='" + ime + "',prezimeTaksiste='" + prezime + "',jmbg='" +jmbg+ "',kontakt='" + kontakt + "',ulica='" + ulica + "',broj='" + broj + "',ukupnaZarada='" + ukupnaZarada + "',stanicaID="+stanicaID.getStanicaID();
    }

    @Override
    public String vratiUslovZaPK() {
        return "taksistaID="+taksistaID;
    }

    @Override
    public String vratiUslovZaPretragu() {
        return "imeTaksiste_prezimeTaksiste";
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekat(ResultSet rs) throws Exception {
        return new Taksista();
    }

    @Override
    public String vratiUslovZaJoin() {
        return " INNER JOIN taksistanica ON taksista.stanicaID=taksistanica.stanicaID";
    }

    @Override
    public String vratiUslovZaPretraguID() {
        return "taksistaID";
    }
    
    @Override
    public String vratiKoloneZaPretragu() {
        return "*";
    }

    @Override
    public String vratiUslovZaRedosled() {
        return "taksistaID";
    }
    
    
    
}
