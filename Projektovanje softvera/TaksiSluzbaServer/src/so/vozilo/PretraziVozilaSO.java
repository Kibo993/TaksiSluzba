/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.vozilo;

import db.DatabaseBroker;
import domen.OpstiDomenskiObjekat;
import domen.Vozilo;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author BOJAN
 */
public class PretraziVozilaSO extends OpstaSO {
    private List<OpstiDomenskiObjekat> nadjenaVozila;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuSO(Object obj) throws Exception {
        nadjenaVozila = DatabaseBroker.getInstance().pretraziLike((String) obj, new Vozilo());
    }

    public List<OpstiDomenskiObjekat> getNadjenaVozila() {
        return nadjenaVozila;
    }
    
    
}
