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
public class UcitajVozilaSO extends OpstaSO {
    
    private List<OpstiDomenskiObjekat> vozila;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuSO(Object obj) throws Exception {
        vozila = DatabaseBroker.getInstance().vratiSve((Vozilo) obj);
    }

    public List<OpstiDomenskiObjekat> getVozila() {
        return vozila;
    }
    
    
}
