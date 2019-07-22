/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.model;

import domen.Taksista;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author BOJAN
 */
public class TaksistaTableModel extends AbstractTableModel{
    
    private List<Taksista> listaTaksista;
    private final String[] kolone = new String[]{"Ime", "Prezime","Kontakt","Ulica","Broj"};

    public TaksistaTableModel() {
    }

    public TaksistaTableModel(List<Taksista> listaTaksista) {
        this.listaTaksista = listaTaksista;
    }

    @Override
    public int getRowCount() {
        if (listaTaksista == null) {
            return 0;
        }
        return listaTaksista.size();
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
    
    public Taksista getTaksista(int red) {
        return listaTaksista.get(red);
    }
    
    public List<Taksista> getListaTaksista() {
        return listaTaksista;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Taksista t = listaTaksista.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return t.getIme();
            case 1:
                return t.getPrezime();
            case 2: 
                return t.getKontakt();
            case 3: 
                return t.getUlica();
            case 4: 
                return t.getBroj();
            default:
                return "n/a";
        }
    }
    
    public void obrisiRed(int red) {
        listaTaksista.remove(red);
        System.out.println("Taksista je obrisan!");
        fireTableDataChanged();
    }
    
}
