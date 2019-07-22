/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika;

import domen.EvidencijaVoznje;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BOJAN
 */
public class KolekcijaEvidencija {
    
    private List<EvidencijaVoznje> evidencije;
    
    public KolekcijaEvidencija() {
        evidencije = new ArrayList<>();
    }
    
    public void dodajEvidenciju(EvidencijaVoznje ev) {
        evidencije.add(ev);
    }
    
    public List<EvidencijaVoznje> vratiEvidencije() {
        return evidencije;
    }
    
}
