/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.sluzbenik;

import db.DatabaseBroker;
import domen.OpstiDomenskiObjekat;
import domen.Sluzbenik;
import so.OpstaSO;

/**
 *
 * @author BOJAN
 */
public class NadjiSluzbenikaSO extends OpstaSO {
    
    private OpstiDomenskiObjekat ag;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuSO(Object obj) throws Exception {
        ag = DatabaseBroker.getInstance().vratiObjekat((Sluzbenik)obj);
    }
    
    public OpstiDomenskiObjekat getAg() {
        return ag;
    }
    
}
