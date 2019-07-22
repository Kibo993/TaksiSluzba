/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika;

import db.DatabaseBroker;
import domen.EvidencijaVoznje;
import domen.OpstiDomenskiObjekat;
import domen.Sluzbenik;
import domen.TaksiStanica;
import domen.Taksista;
import domen.Vozilo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import so.OpstaSO;
import so.evidencijavoznje.SacuvajEvidencijeVoznjeSO;
import so.sluzbenik.NadjiSluzbenikaSO;
import so.taksista.KreirajNovogTaksistuSO;
import so.taksista.ObrisiTaksistuSO;
import so.taksista.PretraziTaksisteSO;
import so.taksista.UcitajTaksistuSO;
import so.taksista.UcitajTaksisteSO;
import so.taksista.ZapamtiTaksistuSO;
import so.taksistanica.UcitajTaksiStaniceSO;
import so.vozilo.KreirajNovoVoziloSO;
import so.vozilo.ObrisiVoziloSO;
import so.vozilo.PretraziVozilaSO;
import so.vozilo.UcitajVoziloSO;
import so.vozilo.UcitajVozilaSO;
import so.vozilo.ZapamtiVoziloSO;

/**
 *
 * @author BOJAN
 */
public class Kontroler {
    
    private KolekcijaTaksista kt;
    private KolekcijaVozila vz;
    private DatabaseBroker db;
    private static Kontroler instance;
    private Map<String, Object> map;
    
    private String operacije = "";
    
    private Kontroler() {
        kt = new KolekcijaTaksista();
        vz = new KolekcijaVozila();
        db = DatabaseBroker.getInstance();
        map = new HashMap<>();
        
    }
    
    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }
    
     public void put(String key, Object value) {
        map.put(key, value);
    }

    public Object get(String key) {
        return map.get(key);
    }

    public void remove(String key) {
        map.remove(key);
    }
    
    public int kreirajNovogTaksistu(Taksista t) throws Exception {
        OpstaSO kreirajNovogTaksistu = new KreirajNovogTaksistuSO();
        kreirajNovogTaksistu.izvrsenjeSO(t);
        this.operacije="kreirajNovogTaksistu\n"+operacije;
        return ((KreirajNovogTaksistuSO) kreirajNovogTaksistu).getId();
        
    }
    
    public boolean zapamtiTaksistu(Taksista t) throws Exception {
        OpstaSO zapamtiTaksistu = new ZapamtiTaksistuSO();
        zapamtiTaksistu.izvrsenjeSO(t);
        this.operacije="zapamtiTaksistu\n"+operacije;
        return ((ZapamtiTaksistuSO) zapamtiTaksistu).isZapamtio();
    }
    
    public List<OpstiDomenskiObjekat> pretraziTaksiste(String kriterijum) throws Exception {
        OpstaSO pretraziTaksiste = new PretraziTaksisteSO();
        pretraziTaksiste.izvrsenjeSO(kriterijum);
        this.operacije="pretraziTaksiste\n"+operacije;
        return ((PretraziTaksisteSO) pretraziTaksiste).getNadjeniTaksisti();
    }
    
    public List<OpstiDomenskiObjekat> vratiTaksiste() throws Exception {
        OpstaSO vratiTaksiste = new UcitajTaksisteSO();
        vratiTaksiste.izvrsenjeSO(new Taksista());
        this.operacije="vratiTaksiste\n"+operacije;
        return ((UcitajTaksisteSO) vratiTaksiste).getTaksisti();
    }
    
    public boolean obrisiTaksistu(Taksista pObrisi) throws Exception {
        OpstaSO obrisiTaksistu = new ObrisiTaksistuSO();
        obrisiTaksistu.izvrsenjeSO(pObrisi);
        this.operacije="obrisiTaksistu\n"+operacije;
        return ((ObrisiTaksistuSO) obrisiTaksistu).isObrisao();
    }
    
    public List<OpstiDomenskiObjekat> ucitajTaksistu(String kriterijum) throws Exception {
        OpstaSO vratiPodatkeTaksiste = new UcitajTaksistuSO();
        vratiPodatkeTaksiste.izvrsenjeSO(kriterijum);
        this.operacije="ucitajTaksistu\n"+operacije;
        return ((UcitajTaksistuSO) vratiPodatkeTaksiste).getTaksista();
    }
    
    public int kreirajNovoVozilo(Vozilo v) throws Exception {
        OpstaSO kreirajNovoVozilo = new KreirajNovoVoziloSO();
        kreirajNovoVozilo.izvrsenjeSO(v);
        this.operacije="kreirajNovoVozilo\n"+operacije;
        return ((KreirajNovoVoziloSO) kreirajNovoVozilo).getId();
        
    }
    
    public boolean zapamtiVozilo(Vozilo v) throws Exception {
        OpstaSO zapamtiVozilo = new ZapamtiVoziloSO();
        zapamtiVozilo.izvrsenjeSO(v);
        this.operacije="zapamtiVozilo\n"+operacije;
        return ((ZapamtiVoziloSO) zapamtiVozilo).isZapamtio();
    }
    
    public List<OpstiDomenskiObjekat> pretraziVozila(String kriterijum) throws Exception {
        OpstaSO pretraziVozila = new PretraziVozilaSO();
        pretraziVozila.izvrsenjeSO(kriterijum);
        this.operacije="pretraziVozila\n"+operacije;
        return ((PretraziVozilaSO) pretraziVozila).getNadjenaVozila();
    }
    
    public List<OpstiDomenskiObjekat> vratiVozila() throws Exception {
        OpstaSO vratiVozila = new UcitajVozilaSO();
        vratiVozila.izvrsenjeSO(new Vozilo());
        this.operacije="vratiVozila\n"+operacije;
        return ((UcitajVozilaSO) vratiVozila).getVozila();
    }
    
    public boolean obrisiVozilo(Vozilo pObrisi) throws Exception {
        OpstaSO obrisiVozilo = new ObrisiVoziloSO();
        obrisiVozilo.izvrsenjeSO(pObrisi);
        this.operacije="obrisiVozilo\n"+operacije;
        return ((ObrisiVoziloSO) obrisiVozilo).isObrisao();
    }
    
    public List<OpstiDomenskiObjekat> ucitajVozilo(String kriterijum) throws Exception {
        OpstaSO vratiPodatkeVozila = new UcitajVoziloSO();
        vratiPodatkeVozila.izvrsenjeSO(kriterijum);
        this.operacije="ucitajVozilo\n"+operacije;
        return ((UcitajVoziloSO) vratiPodatkeVozila).getVozilo();
    }
    
    public OpstiDomenskiObjekat nadjiSluzbenika(Sluzbenik Sluzbenik) throws Exception {
       OpstaSO nadjiSluzbenika = new NadjiSluzbenikaSO();
       nadjiSluzbenika.izvrsenjeSO(Sluzbenik);
        this.operacije="nadjiSluzbenika\n"+operacije;
       return ((NadjiSluzbenikaSO) nadjiSluzbenika).getAg();
    }
    
    public List<OpstiDomenskiObjekat> ucitajTaksiStanice() throws Exception {
        OpstaSO vratiTaksiStanice = new UcitajTaksiStaniceSO();
        vratiTaksiStanice.izvrsenjeSO(new TaksiStanica());
        this.operacije="ucitajTaksiStanice\n"+operacije;
        return ((UcitajTaksiStaniceSO) vratiTaksiStanice).getTaksiStanice();
    }

    public boolean sacuvajEvidencijeVoznje(List<EvidencijaVoznje> sveEvidencije) throws Exception {
        OpstaSO sacuvajEvidencijeVoznje = new SacuvajEvidencijeVoznjeSO();
        sacuvajEvidencijeVoznje.izvrsenjeSO(sveEvidencije);
        this.operacije="sacuvajEvidencijeVoznje\n"+operacije;
        return ((SacuvajEvidencijeVoznjeSO) sacuvajEvidencijeVoznje).isZapamtio();
    }
    
    public String getOperacije() {
        return operacije;
    }

    public void setOperacije(String operacije) {
        this.operacije = operacije;
    }
    
}
