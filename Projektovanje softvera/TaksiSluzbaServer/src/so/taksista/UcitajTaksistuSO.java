/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.taksista;

import db.DatabaseBroker;
import domen.EvidencijaVoznje;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author BOJAN
 */
public class UcitajTaksistuSO extends OpstaSO {
    
    private List<OpstiDomenskiObjekat> taksista;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuSO(Object obj) throws Exception {
        taksista = DatabaseBroker.getInstance().pretraziObjekte((String) obj, new EvidencijaVoznje());
    }
    
    public List<OpstiDomenskiObjekat> getTaksista() {
        return taksista;
    }
    
}
