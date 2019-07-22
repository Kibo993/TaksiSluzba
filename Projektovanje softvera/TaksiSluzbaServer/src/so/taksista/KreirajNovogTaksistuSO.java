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
public class KreirajNovogTaksistuSO extends OpstaSO {
    
    int id;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuSO(Object obj) throws Exception {
        try {
            Taksista t = (Taksista) obj;
            int idtaks = DatabaseBroker.getInstance().generisiSifru((Taksista) obj);
            id = idtaks+1;
            t.setTaksistaID(id);
            DatabaseBroker.getInstance().sacuvaj(t);
        } catch (Exception e) {
            id = 0;
            e.printStackTrace();
        }
    }
    
    public int getId() {
        return id;
    }
    
}
