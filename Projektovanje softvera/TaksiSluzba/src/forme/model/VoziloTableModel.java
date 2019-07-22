/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.model;

import domen.Vozilo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author BOJAN
 */
public class VoziloTableModel extends AbstractTableModel{
    
    private List<Vozilo> listaVozila;
    private final String[] kolone = new String[]{"<html>Registarska<br>oznaka", "Marka", "Model","<html>Ukupna <br> kilometra\u017Ea"};

    public VoziloTableModel() {
    }

    public VoziloTableModel(List<Vozilo> listaVozila) {
        this.listaVozila = listaVozila;
    }
    
    @Override
    public int getRowCount() {
        if (listaVozila == null) {
            return 0;
        }
        return listaVozila.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public Vozilo getVozilo(int red) {
        return listaVozila.get(red);
    }
    
    public List<Vozilo> getListaVozila() {
        return listaVozila;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vozilo v = listaVozila.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return v.getRegistarskaOznaka();
            case 1:
                return v.getMarka();
            case 2: 
                return v.getModel();
            case 3: 
                return v.getUkupnaKilometraza();
            default:
                return "n/a";
        }
    }
    
    public void obrisiRed(int red) {
        listaVozila.remove(red);
        System.out.println("Vozilo je obrisano!");
        fireTableDataChanged();
    }
    
}
