/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.taksistanica;

import db.DatabaseBroker;
import domen.OpstiDomenskiObjekat;
import domen.TaksiStanica;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author BOJAN
 */
public class UcitajTaksiStaniceSO extends OpstaSO {
    
    private List<OpstiDomenskiObjekat> taksiStanice;


    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuSO(Object obj) throws Exception {
        taksiStanice = DatabaseBroker.getInstance().vratiSve((TaksiStanica) obj);
    }

    public List<OpstiDomenskiObjekat> getTaksiStanice() {
        return taksiStanice;
    }
    
}
