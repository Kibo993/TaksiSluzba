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
public class PretraziTaksisteSO extends OpstaSO {
    
    private List<OpstiDomenskiObjekat> nadjeniTaksisti;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuSO(Object obj) throws Exception {
        nadjeniTaksisti = DatabaseBroker.getInstance().pretraziLike((String) obj, new Taksista());
    }

    public List<OpstiDomenskiObjekat> getNadjeniTaksisti() {
        return nadjeniTaksisti;
    }
    
    
    
}
