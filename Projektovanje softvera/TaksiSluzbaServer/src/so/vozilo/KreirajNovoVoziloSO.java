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
public class KreirajNovoVoziloSO extends OpstaSO{
    
    int id;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuSO(Object obj) throws Exception {
        try {
            Vozilo v = (Vozilo) obj;
            int idvoz = DatabaseBroker.getInstance().generisiSifru((Vozilo) obj);
            id = idvoz+1;
            v.setVoziloID(id);
            DatabaseBroker.getInstance().sacuvaj(v);
        } catch (Exception e) {
            id = 0;
            e.printStackTrace();
        }
    }
    
    public int getId() {
        return id;
    }
    
}
