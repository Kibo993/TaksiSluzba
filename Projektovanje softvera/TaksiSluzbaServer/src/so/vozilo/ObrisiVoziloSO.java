/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.vozilo;

import db.DatabaseBroker;
import domen.Vozilo;
import so.OpstaSO;

/**
 *
 * @author BOJAN
 */
public class ObrisiVoziloSO extends OpstaSO{
    
    boolean obrisano;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuSO(Object obj) throws Exception {
        try {
            DatabaseBroker.getInstance().obrisi((Vozilo) obj);
            obrisano = true;
            
        } catch (Exception ex) {
            obrisano = false;
            ex.printStackTrace();
            
        }
    }
    
    public boolean isObrisao() {
        return obrisano;
    }
    
}
