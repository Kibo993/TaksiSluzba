/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.taksista;

import db.DatabaseBroker;
import domen.Taksista;
import so.OpstaSO;

/**
 *
 * @author BOJAN
 */
public class ZapamtiTaksistuSO extends OpstaSO {
    
    boolean zapamceno;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuSO(Object obj) throws Exception {
        try {
            DatabaseBroker.getInstance().izmeni((Taksista)obj);
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
