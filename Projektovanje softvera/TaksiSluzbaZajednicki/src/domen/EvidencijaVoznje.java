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

public class EvidencijaVoznje implements OpstiDomenskiObjekat {
    private Date datumVoznje;
    private Taksista taksistaID;
    private Vozilo voziloID;
    private double kilometrazaOd;
    private double kilometrazaDo;
    private double zarada;
    private Sluzbenik sluzbenikID;

    public EvidencijaVoznje() {
    }

    public EvidencijaVoznje(Date datumVoznje, Taksista taksistaID, Vozilo voziloID, double kilometrazaOd, double kilometrazaDo, double zarada, Sluzbenik sluzbenikID) {
        this.datumVoznje = datumVoznje;
        this.taksistaID = taksistaID;
        this.voziloID = voziloID;
        this.kilometrazaOd = kilometrazaOd;
        this.kilometrazaDo = kilometrazaDo;
        this.zarada = zarada;
        this.sluzbenikID = sluzbenikID;
    }

    public Date getDatumVoznje() {
        return datumVoznje;
    }

    public void setDatumVoznje(Date datumVoznje) {
        this.datumVoznje = datumVoznje;
    }

    public Taksista getTaksistaID() {
        return taksistaID;
    }

    public void setTaksistaID(Taksista taksistaID) {
        this.taksistaID = taksistaID;
    }

    public Vozilo getVoziloID() {
        return voziloID;
    }

    public void setVoziloID(Vozilo voziloID) {
        this.voziloID = voziloID;
    }

    public double getKilometrazaOd() {
        return kilometrazaOd;
    }

    public void setKilometrazaOd(double kilometrazaOd) {
        this.kilometrazaOd = kilometrazaOd;
    }

    public double getKilometrazaDo() {
        return kilometrazaDo;
    }

    public void setKilometrazaDo(double kilometrazaDo) {
        this.kilometrazaDo = kilometrazaDo;
    }

    public double getZarada() {
        return zarada;
    }

    public void setZarada(double zarada) {
        this.zarada = zarada;
    }

    public Sluzbenik getSluzbenikID() {
        return sluzbenikID;
    }

    public void setSluzbenikID(Sluzbenik sluzbenikID) {
        this.sluzbenikID = sluzbenikID;
    }

    @Override
    public String vratiNazivTabele() {
        return "evidencijavoznje";
    }
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public String vratiVrednostiZaInsert() {
        
        return "'"+df.format(datumVoznje) + "',"+taksistaID.getTaksistaID() +","+ voziloID.getVoziloID() +","+ kilometrazaOd +","+ kilometrazaDo +"," + zarada +","+  sluzbenikID.getSluzbenikID();
    }

    @Override
    public String vratiIDKolonu() {
        return "datumVoznje";
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "(datumVoznje, taksistaID, voziloID, kilometrazaOd, kilometrazaDo, zarada, sluzbenikID)";
    }
    @Override
    public List<OpstiDomenskiObjekat> ucitajObjekte(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> ev = new LinkedList<>();
            while (rs.next()) {
                
                Date datumVoznjeVozilo = rs.getDate("datumVoznje");
                Double kilometrazaOdVozilo = rs.getDouble("kilometrazaOd");
                Double kilometrazaDoVozilo = rs.getDouble("kilometrazaDo");
                Double zaradaVozilo = rs.getDouble("zarada");
                 
                int sluzbenikIDVozilo = rs.getInt("sluzbenikID");
                int taksistaIDVozilo = rs.getInt("taksistaID");
                int voziloIDVozilo = rs.getInt("voziloID");
                
                String sluzbenikIme = rs.getString("ime");
                String sluzbenikPrezime = rs.getString("prezime");
                String sluzbenikKorisnickoIme = rs.getString("korisnickoIme");
                String sluzbenikKorisnickaSifra = rs.getString("korisnickaSifra");
                
                Date datumZaposlenjaTaksiste = rs.getDate("datumZaposlenja");
                String imeTaksiste = rs.getString("imeTaksiste");
                String prezimeTaksiste = rs.getString("prezimeTaksiste");
                String jmbgTaksiste = rs.getString("jmbg");
                String kontaktTaksiste = rs.getString("kontakt");
                String ulicaTaksiste = rs.getString("ulica");
                String brojTaksiste = rs.getString("broj");
                Double ukupnaZaradaTaksiste = rs.getDouble("ukupnaZarada");
                
                Date datumPocetkaSluzbeVozila = rs.getDate("datumPocetkaSluzbe");
                String vinVozila = rs.getString("vin");
                String registarskaOznakaVozila = rs.getString("registarskaOznaka");
                String markaVozila = rs.getString("marka");
                String modelVozila = rs.getString("model");
                Double ukupnaKilometrazaVozila = rs.getDouble("ukupnaKilometraza");
                
                int stanicaID = rs.getInt("stanicaID");
                String adresa = rs.getString("adresa");
                String ptt = rs.getString("ptt");
                String opstina = rs.getString("opstina");
                
                TaksiStanica ts = new TaksiStanica(stanicaID, adresa, ptt, opstina);
                
                Sluzbenik sluzbenik = new Sluzbenik(sluzbenikIDVozilo, sluzbenikIme, sluzbenikPrezime, sluzbenikKorisnickoIme, sluzbenikKorisnickaSifra);
                
                Taksista taksista = new Taksista(taksistaIDVozilo, datumZaposlenjaTaksiste, imeTaksiste, prezimeTaksiste, jmbgTaksiste, kontaktTaksiste, ulicaTaksiste, brojTaksiste, ukupnaZaradaTaksiste, ts);
                
                Vozilo vozilo = new Vozilo(voziloIDVozilo, datumPocetkaSluzbeVozila, vinVozila, registarskaOznakaVozila, markaVozila, modelVozila, ukupnaKilometrazaVozila);                
                
                EvidencijaVoznje voznja = new EvidencijaVoznje(datumVoznjeVozilo, taksista, vozilo, kilometrazaOdVozilo, kilometrazaDoVozilo, zaradaVozilo, sluzbenik);
                ev.add(voznja);
            }
            return ev;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "kilometrazaOd='" + kilometrazaOd+ "',kilometrazaDo='" + kilometrazaDo+ "',zarada='" +zarada+ "'";
    }

    @Override
    public String vratiUslovZaPK() {
        return "datumVoznje='"+df.format(datumVoznje)+"'";
    }

    @Override
    public String vratiUslovZaPretragu() {
        //return "v.registarskaOznaka_t.taksistaID";
        return "v.registarskaOznaka";
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekat(ResultSet rs) throws Exception {
        return new EvidencijaVoznje();
    }

    @Override
    public String vratiUslovZaJoin() {
        return " INNER JOIN Sluzbenik s ON evidencijavoznje.sluzbenikID=s.sluzbenikID INNER JOIN taksista t ON evidencijavoznje.taksistaID=t.taksistaID INNER JOIN taksistanica ts ON ts.stanicaID=t.stanicaID INNER JOIN vozilo v ON evidencijavoznje.voziloID=v.voziloID";
    }

    @Override
    public String vratiUslovZaPretraguID() {
        //return " evidencijavoznje.datumVoznje";
        return "t.taksistaID";
    }

    @Override
    public String vratiKoloneZaPretragu() {
        return " evidencijavoznje.datumVoznje , evidencijavoznje.taksistaID , evidencijavoznje.voziloID , evidencijavoznje.kilometrazaOd , evidencijavoznje.kilometrazaDo , evidencijavoznje.zarada , evidencijavoznje.sluzbenikID , s.ime , s.prezime , s.korisnickoIme , s.korisnickaSifra , t.datumZaposlenja , t.imeTaksiste , t.prezimeTaksiste , t.jmbg , t.kontakt , t.ulica, t.broj , t.ukupnaZarada , ts.stanicaID , ts.ptt , ts.adresa , ts.opstina , v.datumPocetkaSluzbe , v.vin , v.registarskaOznaka , v.marka , v.model , v.ukupnaKilometraza ";
    }

    @Override
    public String vratiUslovZaRedosled() {
        return " evidencijavoznje.datumVoznje";
    }
    
    
}
