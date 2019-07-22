/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DatabaseBroker;
import domen.Sluzbenik;

/**
 *
 * @author BOJAN
 */
public abstract class OpstaSO {
    

    public final void izvrsenjeSO(Object obj) throws Exception {

        try {
            ucitajDriver(); 
            otvoriKonekciju();
            proveriPreduslov(obj);
            izvrsiKonkretnuSO(obj);
            commitTransakcije();
        } catch (Exception ex) {
            rollbackTransakcije();
        } finally {
            zatvoriKonekciju();
        }
    }
    
    
    private void ucitajDriver() throws Exception {
        DatabaseBroker.getInstance().ucitajDriver();
    }

    private void otvoriKonekciju() throws Exception {
        DatabaseBroker.getInstance().otvoriKonekciju();
    }

    protected abstract void proveriPreduslov(Object obj) throws Exception;
    
    protected abstract void izvrsiKonkretnuSO(Object obj) throws Exception;

    private void commitTransakcije() throws Exception {
        DatabaseBroker.getInstance().commitTransakcije();
    }

    private void rollbackTransakcije() throws Exception {
        DatabaseBroker.getInstance().rollbackTransakcije();
    }

    private void zatvoriKonekciju() throws Exception {
        DatabaseBroker.getInstance().zatvoriKonekciju();
    }
    
}
