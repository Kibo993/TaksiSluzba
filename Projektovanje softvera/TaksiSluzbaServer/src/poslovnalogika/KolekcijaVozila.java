/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika;

import domen.Vozilo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BOJAN
 */
public class KolekcijaVozila {
    
    private List<Vozilo> vozila;
    
    public KolekcijaVozila() {
        vozila = new ArrayList<>();
    }
    
    public void dodajVozilo(Vozilo v) {
        vozila.add(v);
    }
    
    public List<Vozilo> vratiVozila() {
        return vozila;
    }
    
}
