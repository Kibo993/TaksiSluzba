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
public class ZapamtiVoziloSO extends OpstaSO {
    
    boolean zapamceno;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuSO(Object obj) throws Exception {
        try {
            DatabaseBroker.getInstance().izmeni((Vozilo)obj);
            zapamceno = true;
            
        } catch (Exception ex) {
            zapamceno = false;
            ex.printStackTrace();
            
        }
    }
    
    public boolean isZapamtio() {
        return zapamceno;
    }
    
}
