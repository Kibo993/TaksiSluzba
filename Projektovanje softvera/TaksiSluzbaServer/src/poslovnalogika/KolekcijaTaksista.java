/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika;

import domen.Taksista;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BOJAN
 */
public class KolekcijaTaksista {
    
    private List<Taksista> taksisti;
    
    public KolekcijaTaksista() {
        taksisti = new ArrayList<>();
    }
    
    public void dodajTaksistu(Taksista t) {
        taksisti.add(t);
    }
    
    public List<Taksista> vratiTaksiste() {
        return taksisti;
    }
    
}
