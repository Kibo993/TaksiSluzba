/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.EvidencijaVoznje;
import domen.Sluzbenik;
import domen.Taksista;
import domen.Vozilo;
import forme.model.EvidencijaCuvanjeTableModel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Konstante;

/**
 *
 * @author BOJAN
 */
public class FrmUnosEvidencija extends javax.swing.JPanel {
    
    private static Sluzbenik sluzbenik;    
    private final DateFormat dz = new SimpleDateFormat("dd.MM.yyyy");


    /**
     * Creates new form FrmUnosEvidencije
     */
    public FrmUnosEvidencija(Sluzbenik s) {
        initComponents();
        this.sluzbenik = s;
        srediFormu();
        srediTabelu();
        blokiraj();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtxtDatumVoznje1 = new javax.swing.JTextField();
        btnSacuvaj = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jtxtKilometrazaDo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtZarada = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jcbTaksista = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jcbVozilo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEvidencija = new javax.swing.JTable();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtxtDatumVoznje = new javax.swing.JTextField();
        btnIzaberiDatum = new javax.swing.JButton();
        btnPromeniDatum = new javax.swing.JButton();

        jButton2.setText("jButton1");

        jLabel4.setText("Datum vo\u017Enje:");

        btnSacuvaj.setText("Sa\u010Duvaj evidencije");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Podaci o vo\u017Enji"));

        jLabel5.setText("Kilometra\u017Ea:");

        jLabel6.setText("Zarada:");

        jLabel1.setText("Taksista:");

        jcbTaksista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Vozilo:");

        jcbVozilo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcbTaksista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbVozilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtKilometrazaDo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtZarada, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtxtKilometrazaDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtxtZarada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbTaksista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbVozilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap())
        );

        tblEvidencija.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblEvidencija);

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obri\u0161i");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        jLabel3.setText("Datum vo\u017Enje:");

        btnIzaberiDatum.setText("Izaberi datum");
        btnIzaberiDatum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzaberiDatumActionPerformed(evt);
            }
        });

        btnPromeniDatum.setText("Promeni datum");
        btnPromeniDatum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromeniDatumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(btnDodaj)
                                .addGap(345, 345, 345)
                                .addComponent(btnObrisi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(271, 271, 271)
                                .addComponent(btnSacuvaj))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxtDatumVoznje, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(btnIzaberiDatum)
                                .addGap(116, 116, 116)
                                .addComponent(btnPromeniDatum)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtDatumVoznje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnIzaberiDatum)
                    .addComponent(btnPromeniDatum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnObrisi))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnSacuvaj)
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents
Taksista taksista = null;
Vozilo vozilo = null;
Date datumVoznje;
    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            EvidencijaCuvanjeTableModel evc = (EvidencijaCuvanjeTableModel) tblEvidencija.getModel();
            List<EvidencijaVoznje> sveEvidencije = evc.vratiPodatke();
            
            if (sveEvidencije.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nije upisana nijedna evidencija.", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
            } else {
            
         TransferObjekatZahtev toZahtevEvidencija = new TransferObjekatZahtev();
         toZahtevEvidencija.setOperacija(Konstante.SACUVAJ_EVIDENCIJE);
         toZahtevEvidencija.setParametar(sveEvidencije);
         Komunikacija.getInstance().posaljiZahtev(toZahtevEvidencija);
         TransferObjekatOdgovor toOdgovorEvidencija = Komunikacija.getInstance().primiOdgovor();
        
         
         
         boolean sacuvano = (boolean) toOdgovorEvidencija.getRezultat();
         
         if (sacuvano) {
             
             JOptionPane.showMessageDialog(this, "Sistem je zapamtio evidencije vo\u017Enje.");
             isprazniPolja();
        EvidencijaCuvanjeTableModel ectm = new EvidencijaCuvanjeTableModel();
        ectm.izbrisiPodatke();
        tblEvidencija.removeAll();
        blokiraj();
         } else {
             JOptionPane.showMessageDialog(this, "Sistem ne mo\u017Ee da zapamti evidencije vo\u017Enje!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
         }
        } 
            
        } catch (Exception ex) {
            System.out.println(ex.toString());
             JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        try{
            taksista = (Taksista) jcbTaksista.getSelectedItem();            
            vozilo = (Vozilo) jcbVozilo.getSelectedItem();
            
            if (datumVoznje.before(taksista.getDatumZaposlenja())) {
                JOptionPane.showMessageDialog(this, "Datum vo\u017Enje mora biti posle datuma zaposlenja taksiste!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (datumVoznje.before(vozilo.getDatumPocetkaSluzbe())) {
                JOptionPane.showMessageDialog(this, "Datum vo\u017Enje mora biti posle datuma po\u010Detka slu\u017Ebe vozila!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
                return;
            }        
            
        if (jtxtKilometrazaDo.getText().trim().equals("") || jtxtZarada.getText().trim().equals("")){
                
                JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
                return;
            }
           String kilometrazaVozila;
            try {
                kilometrazaVozila = jtxtKilometrazaDo.getText().trim();
                if(kilometrazaVozila.contains(","))
                {
                kilometrazaVozila=kilometrazaVozila.replace(',', '.');
                }
                Double.parseDouble(kilometrazaVozila);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "U polje Kilometra\u017Ea Do morate uneti broj!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (Double.parseDouble(kilometrazaVozila)<vozilo.getUkupnaKilometraza()) {
                JOptionPane.showMessageDialog(this, "Unesite kilometra\u017Eu sa totalizatora!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (jtxtZarada.getText().trim().contains("-")) {
                JOptionPane.showMessageDialog(this, "Ne mo\u017Eete unositi negativne vrednosti!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String zaradaEvidencija;
            try {
                zaradaEvidencija = jtxtZarada.getText().trim();
                if(zaradaEvidencija.contains(","))
                {
                zaradaEvidencija=zaradaEvidencija.replace(',', '.');
                }
                Double.parseDouble(zaradaEvidencija);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "U polje Zarada morate uneti broj!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            TransferObjekatZahtev toZahtevVozilo = new TransferObjekatZahtev();
                toZahtevVozilo.setOperacija(Konstante.UCITAJ_VOZILO);
                toZahtevVozilo.setParametar(vozilo);
                Komunikacija.getInstance().posaljiZahtev(toZahtevVozilo);
                TransferObjekatOdgovor toOdgovorVozilo = Komunikacija.getInstance().primiOdgovor();

                List<EvidencijaVoznje> listaPrethodnihEvidencijaVozilo = (List<EvidencijaVoznje>) toOdgovorVozilo.getRezultat();
            
            for (EvidencijaVoznje evidencijaVoznje : listaPrethodnihEvidencijaVozilo) {
                if (datumVoznje.before(evidencijaVoznje.getDatumVoznje())) {
                JOptionPane.showMessageDialog(this, "Evidencije vo\u017Enje morate unositi pravilnim redosledom!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
                return;
            }
            }
            
            TransferObjekatZahtev toZahtevTaksista = new TransferObjekatZahtev();
                toZahtevTaksista.setOperacija(Konstante.UCITAJ_TAKSISTU);
                toZahtevTaksista.setParametar(taksista);
                Komunikacija.getInstance().posaljiZahtev(toZahtevTaksista);
                TransferObjekatOdgovor toOdgovorTaksista = Komunikacija.getInstance().primiOdgovor();

                List<EvidencijaVoznje> listaPrethodnihEvidencija = (List<EvidencijaVoznje>) toOdgovorTaksista.getRezultat();
            /*
            for (EvidencijaVoznje evidencijaVoznje : listaPrethodnihEvidencija) {
                if (datumVoznje.before(evidencijaVoznje.getDatumVoznje())) {
                JOptionPane.showMessageDialog(this, "Datume vo\u017Enje morate unositi pravilnim redosledom!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
                return;
            }
            }    
            */
            Double kilometrazaOd=vozilo.getUkupnaKilometraza();
            Double kilometrazaOdMax=0.0;
            EvidencijaCuvanjeTableModel evcuvanje = (EvidencijaCuvanjeTableModel) tblEvidencija.getModel();
            List<EvidencijaVoznje> sveEvidencije = evcuvanje.vratiPodatke();
            int brojSmena=0;
            if(!listaPrethodnihEvidencija.isEmpty()){
            for(EvidencijaVoznje evidencije : listaPrethodnihEvidencija){
                    if (dz.format(datumVoznje).equals(dz.format(evidencije.getDatumVoznje()))) {
                    brojSmena++;
                    if(brojSmena<1){
                    continue;
                    }else{
                    JOptionPane.showMessageDialog(this, "Ovaj taksista je ve\u0107 odradio jednu smenu za ovaj dan!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
                    return;
                    }
                }
                }
            }
            
            if(!sveEvidencije.isEmpty()){
            for(EvidencijaVoznje evidencije : sveEvidencije){
            
                if (taksista.getTaksistaID()==evidencije.getTaksistaID().getTaksistaID()) {
                    brojSmena++;
                    if(brojSmena<1){
                    continue;
                    }else{
                    JOptionPane.showMessageDialog(this, "Ovaj taksista je ve\u0107 odradio jednu smenu za ovaj dan!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
                    return;
                    }
                }
                if(vozilo.getVoziloID()==evidencije.getVoziloID().getVoziloID()&&kilometrazaOdMax<evidencije.getKilometrazaDo()){
                kilometrazaOdMax=evidencije.getKilometrazaDo();
                if (Double.parseDouble(kilometrazaVozila)<kilometrazaOdMax) {
                JOptionPane.showMessageDialog(this, "Unesite kilometra\u017Eu sa totalizatora!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
                return;
            }
                kilometrazaOd=kilometrazaOdMax;
            }
            }
            }
            Double kilometrazaDo = Double.parseDouble(kilometrazaVozila);
            Double zarada = Double.parseDouble(zaradaEvidencija);
            
            Double zaradaU = taksista.getUkupnaZarada()+zarada;
            Taksista t = new Taksista(taksista.getTaksistaID(), taksista.getDatumZaposlenja(), taksista.getIme(), taksista.getPrezime(), taksista.getJmbg(), taksista.getKontakt(), taksista.getUlica(), taksista.getBroj(), zaradaU, taksista.getStanicaID());
         Vozilo v = new Vozilo(vozilo.getVoziloID(), vozilo.getDatumPocetkaSluzbe(), vozilo.getVin(), vozilo.getRegistarskaOznaka(), vozilo.getMarka(), vozilo.getModel(), kilometrazaDo);
         EvidencijaVoznje evv = new EvidencijaVoznje(datumVoznje, t, v, kilometrazaOd, kilometrazaDo, zarada, sluzbenik);
         EvidencijaCuvanjeTableModel evcuv = (EvidencijaCuvanjeTableModel) tblEvidencija.getModel();
         evcuv.dodajRed(evv);
         isprazniPolja();
         
        } catch (Exception ex) {
            System.out.println(ex.toString());
             JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
      int red = tblEvidencija.getSelectedRow();
        if(red != -1){
            EvidencijaCuvanjeTableModel evcutm = (EvidencijaCuvanjeTableModel) tblEvidencija.getModel();
            EvidencijaVoznje ev = evcutm.vratiPodatke().get(red);
            Double maxKilometraza=0.0;
            for(EvidencijaVoznje evidencije : evcutm.vratiPodatke()){
            if(ev.getVoziloID().getVoziloID()==evidencije.getVoziloID().getVoziloID()&&maxKilometraza<evidencije.getKilometrazaDo()){
                maxKilometraza=evidencije.getKilometrazaDo();
            }
            }
            if (maxKilometraza!=ev.getKilometrazaDo()) {
                JOptionPane.showMessageDialog(this, "Mo\u017Eete obrisati samo poslednje unet podatak za ovo vozilo!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
                return;
            }
            evcutm.ObrisiRed(red);
        }else{
            JOptionPane.showMessageDialog(this, "Morate odabrati red!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
                return;
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnIzaberiDatumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzaberiDatumActionPerformed
        if (jtxtDatumVoznje.getText().trim().equals("")) {
            datumVoznje = new Date();
            jtxtDatumVoznje.setText(dz.format(datumVoznje));
            JOptionPane.showMessageDialog(this, "Upisan je dana\u0161nji datum.", "Datum", JOptionPane.INFORMATION_MESSAGE);
        } else {
       
            try {
               datumVoznje = dz.parse(jtxtDatumVoznje.getText().trim());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Format datuma neispravan (dd.MM.yyyy)", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (datumVoznje.after(new Date())) {
                JOptionPane.showMessageDialog(this, "Datum ne sme biti posle sada\u0161njeg", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        deblokiraj();
    }//GEN-LAST:event_btnIzaberiDatumActionPerformed

    private void btnPromeniDatumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniDatumActionPerformed
        isprazniPolja();
        EvidencijaCuvanjeTableModel ectm = new EvidencijaCuvanjeTableModel();
        ectm.izbrisiPodatke();
        tblEvidencija.removeAll();
        blokiraj();
    }//GEN-LAST:event_btnPromeniDatumActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzaberiDatum;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromeniDatum;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Object> jcbTaksista;
    private javax.swing.JComboBox<Object> jcbVozilo;
    private javax.swing.JTextField jtxtDatumVoznje;
    private javax.swing.JTextField jtxtDatumVoznje1;
    private javax.swing.JTextField jtxtKilometrazaDo;
    private javax.swing.JTextField jtxtZarada;
    private javax.swing.JTable tblEvidencija;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        //blokiraj();
        try {
            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.VRATI_TAKSISTE);
            Komunikacija.getInstance().posaljiZahtev(toZahtev);
            TransferObjekatOdgovor toOdgovor = Komunikacija.getInstance().primiOdgovor();
            
            if (toOdgovor.getIzuzetak() != null) {
                throw (Exception) toOdgovor.getIzuzetak();
            }
            
            
            
            List<Taksista> ts = (List<Taksista>) toOdgovor.getRezultat();
            jcbTaksista.removeAllItems();
            
            for (Taksista t: ts) {
                jcbTaksista.addItem(t);
            }
            
            TransferObjekatZahtev toZahtevVozila = new TransferObjekatZahtev();
            toZahtevVozila.setOperacija(Konstante.VRATI_VOZILA);
            Komunikacija.getInstance().posaljiZahtev(toZahtevVozila);
            TransferObjekatOdgovor toOdgovorVozila = Komunikacija.getInstance().primiOdgovor();
            
            if (toOdgovorVozila.getIzuzetak() != null) {
                throw (Exception) toOdgovorVozila.getIzuzetak();
            }
            
            List<Vozilo> vs = (List<Vozilo>) toOdgovorVozila.getRezultat();
            jcbVozilo.removeAllItems();
            
            for (Vozilo v: vs) {
                jcbVozilo.addItem(v);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(FrmUnosTaksista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void srediTabelu(){
    EvidencijaCuvanjeTableModel ectm = new EvidencijaCuvanjeTableModel();
    tblEvidencija.setModel(ectm);
    }
    
    private void isprazniPolja() {
        jtxtKilometrazaDo.setText("");
        jtxtZarada.setText("");
        jcbTaksista.setSelectedIndex(0);
        jcbVozilo.setSelectedIndex(0);
        srediFormu();
    }
    
    private void blokiraj() {
        jtxtDatumVoznje.setText("");
        jtxtDatumVoznje.setEditable(true);
        btnIzaberiDatum.setEnabled(true);
        btnPromeniDatum.setEnabled(false);
        jtxtKilometrazaDo.setEditable(false);
        jtxtZarada.setEditable(false);
        jcbTaksista.setEnabled(false);
        jcbVozilo.setEnabled(false);
        btnDodaj.setEnabled(false);
        btnObrisi.setEnabled(false);
        btnSacuvaj.setEnabled(false);
    }
    
    private void deblokiraj() {
        jtxtDatumVoznje.setEditable(false);
        btnIzaberiDatum.setEnabled(false);
        btnPromeniDatum.setEnabled(true);
        jtxtKilometrazaDo.setEditable(true);
        jtxtZarada.setEditable(true);
        jcbTaksista.setEnabled(true);
        jcbVozilo.setEnabled(true);
        btnDodaj.setEnabled(true);
        btnObrisi.setEnabled(true);
        btnSacuvaj.setEnabled(true);
    }
}
