/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika;

import domen.TaksiStanica;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BOJAN
 */
public class KolekcijaTaksiStanica {
    
    private List<TaksiStanica> stanice;
    
    public KolekcijaTaksiStanica() {
        stanice = new ArrayList<>();
    }
    
    public void dodajTaksiStanicu(TaksiStanica ts) {
        stanice.add(ts);
    }
    
    public List<TaksiStanica> vratiTaksiStanice() {
        return stanice;
    }
    
}
