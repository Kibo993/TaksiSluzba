/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.model;

import domen.EvidencijaVoznje;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author BOJAN
 */
public class EvidencijaTaksistaTableModel extends AbstractTableModel {
    
    private List<EvidencijaVoznje> listaEvidencija;
    private final String[] kolone = new String[]{"<html>&nbsp;<br>Vozilo<br>&nbsp;", "<html>Datum <br>vo\u017Enje","<html>Po\u010Detna <br>kilometra\u017Ea","<html>Kilometra\u017Ea<br> na kraju","Zarada","Uneo"};
    private final DateFormat dz = new SimpleDateFormat("dd.MM.yyyy.");
    
    public EvidencijaTaksistaTableModel() {
    }

    public EvidencijaTaksistaTableModel(List<EvidencijaVoznje> listaEvidencija) {
        this.listaEvidencija = listaEvidencija;
    }
    
    
    @Override
    public int getRowCount() {
        if (listaEvidencija == null) {
            return 0;
        }
        return listaEvidencija.size();
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
    
    public EvidencijaVoznje getEvidencija(int red) {
        return listaEvidencija.get(red);
    }
    
    public List<EvidencijaVoznje> getListaEvidencija() {
        return listaEvidencija;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EvidencijaVoznje ev = listaEvidencija.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return ev.getVoziloID();
            case 1:
                return dz.format(ev.getDatumVoznje());
            case 2: 
                return ev.getKilometrazaOd();
            case 3: 
                return ev.getKilometrazaDo();
            case 4: 
                return ev.getZarada();
            case 5: 
                return ev.getSluzbenikID();
            default:
                return "n/a";
        }
    }
}
