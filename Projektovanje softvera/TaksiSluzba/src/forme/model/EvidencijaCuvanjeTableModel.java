/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.model;

import domen.EvidencijaVoznje;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author BOJAN
 */
public class EvidencijaCuvanjeTableModel extends AbstractTableModel{
    private static ArrayList<EvidencijaVoznje> evidencije;
    private String[] kolone = {"Taksista", "Vozilo", "Kilometra\u017Ea od", "Kilometra\u017Ea do", "Zarada"};
    private final DateFormat dz = new SimpleDateFormat("dd.MM.yyyy");
    
    public EvidencijaCuvanjeTableModel(ArrayList<EvidencijaVoznje> evidencije) {
        this.evidencije = evidencije;
    }

    public EvidencijaCuvanjeTableModel() {
        evidencije = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        if(evidencije==null) return 0;
        return evidencije.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EvidencijaVoznje ev = evidencije.get(rowIndex);
        switch(columnIndex){
            case 0: return ev.getTaksistaID().toString();
            case 1: return ev.getVoziloID().toString();
            case 2: return ev.getKilometrazaOd();
            case 3: return ev.getKilometrazaDo();
            case 4: return ev.getZarada();
            default:return "N/A";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodajRed(EvidencijaVoznje evidencija) {
        evidencije.add(evidencija);
        fireTableDataChanged();
    }
    
    public void ObrisiRed(int red) {
        evidencije.remove(red);
        fireTableDataChanged();
    }

    public List<EvidencijaVoznje> vratiPodatke() {
        return evidencije;
    }
    
    public void izbrisiPodatke() {
        evidencije.clear();
        fireTableDataChanged();
    }
    
}
