/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author BOJAN
 */
public class TaksiStanica implements OpstiDomenskiObjekat {
    private int stanicaID;
    private String adresa;
    private String ptt;
    private String opstina;

    public TaksiStanica() {
    }

    public TaksiStanica(int stanicaID, String adresa, String ptt, String opstina) {
        this.stanicaID = stanicaID;
        this.adresa = adresa;
        this.ptt = ptt;
        this.opstina = opstina;
    }

    public int getStanicaID() {
        return stanicaID;
    }

    public void setStanicaID(int stanicaID) {
        this.stanicaID = stanicaID;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getPtt() {
        return ptt;
    }

    public void setPtt(String ptt) {
        this.ptt = ptt;
    }

    public String getOpstina() {
        return opstina;
    }

    public void setOpstina(String opstina) {
        this.opstina = opstina;
    }
    
    @Override
    public String toString() {
        return getAdresa() + " - " + getPtt() + " - " + getOpstina();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof TaksiStanica) {
            TaksiStanica ts = (TaksiStanica) obj;
            return ts.getOpstina().equals(getOpstina()) && ts.getPtt().equals(getPtt()) && ts.getAdresa().equals(getAdresa());
        }
        return false;
    }

    @Override
    public String vratiNazivTabele() {
        return "taksistanica";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return stanicaID+ ",'" + adresa + "','"+ ptt + "','" + opstina + "'";
    }

    @Override
    public String vratiIDKolonu() {
        return "stanicaID";
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajObjekte(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lts = new LinkedList<>();
            while (rs.next()) {
                int stanicaID = rs.getInt("stanicaID");
                String adresa = rs.getString("adresa");
                String ptt = rs.getString("ptt");
                String opstina = rs.getString("opstina");
                TaksiStanica ts = new TaksiStanica(stanicaID, adresa, ptt, opstina);
                lts.add(ts);
            }
            return lts;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "";
    }

    @Override
    public String vratiUslovZaPK() {
        return "";
    }

    @Override
    public String vratiUslovZaPretragu() {
        return "";
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekat(ResultSet rs) throws Exception {
        return new TaksiStanica();
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
        return "stanicaID";
    }
    
    
}
