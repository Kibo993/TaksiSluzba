/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.evidencijavoznje;

import db.DatabaseBroker;
import domen.EvidencijaVoznje;
import domen.Taksista;
import domen.Vozilo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import so.OpstaSO;

/**
 *
 * @author BOJAN
 */
public class SacuvajEvidencijeVoznjeSO extends OpstaSO {
    
    boolean zapamceno;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuSO(Object obj) throws Exception {
        long begin = System.currentTimeMillis();
        try {
            List<EvidencijaVoznje> evidencije = (List<EvidencijaVoznje>) obj;
            for (EvidencijaVoznje evidencijaVoznje : evidencije) {
                DatabaseBroker.getInstance().izmeni(evidencijaVoznje.getTaksistaID());
                DatabaseBroker.getInstance().izmeni(evidencijaVoznje.getVoziloID());
                DatabaseBroker.getInstance().sacuvaj(evidencijaVoznje);
            }
            zapamceno = true;
            
        } catch (Exception ex) {
            zapamceno = false;
            ex.printStackTrace();
        }
        long end = System.currentTimeMillis();
long dt = end - begin;
        System.out.println("Trebalo je "+dt+" milisekundi.");
    }
    
    public boolean isZapamtio() {
        return zapamceno;
    }
    
}
