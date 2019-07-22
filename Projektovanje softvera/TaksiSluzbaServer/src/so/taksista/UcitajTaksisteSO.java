/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.taksista;

import db.DatabaseBroker;
import domen.OpstiDomenskiObjekat;
import domen.Taksista;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author BOJAN
 */
public class UcitajTaksisteSO extends OpstaSO {
    
    private List<OpstiDomenskiObjekat> taksisti;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuSO(Object obj) throws Exception {
        taksisti = DatabaseBroker.getInstance().vratiSve((Taksista) obj);
    }

    public List<OpstiDomenskiObjekat> getTaksisti() {
        return taksisti;
    }
    
    
    
}
