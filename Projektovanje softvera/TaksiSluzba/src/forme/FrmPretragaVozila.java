/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Sluzbenik;
import domen.Vozilo;
import forme.model.VoziloTableModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import komunikacija.Komunikacija;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Konstante;
import util.Util;

/**
 *
 * @author BOJAN
 */
public class FrmPretragaVozila extends javax.swing.JPanel {
    
    private static Sluzbenik sluzbenik;

    /**
     * Creates new form FrmPretragaVozila
     */
    public FrmPretragaVozila(Sluzbenik s) {
        initComponents();
        this.sluzbenik = s;
        srediTabelu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPretrazi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtxtPretraga = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblPrikazVozila = new javax.swing.JTable();
        btnObrisi = new javax.swing.JButton();
        btnDetalji = new javax.swing.JButton();

        btnPretrazi.setText("Pretra\u017Ei");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        jLabel1.setText("Kriterijum pretrage:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pregled svih vozila"));

        jtblPrikazVozila.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtblPrikazVozila);

        btnObrisi.setText("Obri\u0161i");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnDetalji.setText("Detalji");
        btnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btnObrisi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDetalji)
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnObrisi)
                    .addComponent(btnDetalji))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPretrazi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretrazi))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        if (jtxtPretraga.getText().trim().equals("")) {
           srediTabelu();
        } else {
            String vozilo = jtxtPretraga.getText().trim();
            
           
            try {
                TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
                toZahtev.setOperacija(Konstante.NADJI_VOZILA);
                toZahtev.setParametar(vozilo);
                Komunikacija.getInstance().posaljiZahtev(toZahtev);
                TransferObjekatOdgovor toOdgovor = Komunikacija.getInstance().primiOdgovor();
                
                List<Vozilo> listaPronadjenihVozila = (List<Vozilo>) toOdgovor.getRezultat();
                
                if (listaPronadjenihVozila.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Sistem ne mo\u017Ee da na\u0111e vozila po zadatim vrednostima!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
                }
                
                else {
                
                VoziloTableModel modelnadjeni = new VoziloTableModel(listaPronadjenihVozila);
                jtblPrikazVozila.setModel(modelnadjeni);
                System.out.println("Sistem je na\u0161ao vozila po zadatim vrednostima.");
                
                }
                
                
            } catch (Exception ex) {
                Logger.getLogger(FrmPretragaVozila.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }   
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        int red = jtblPrikazVozila.getSelectedRow();

        if (red == -1) {
            JOptionPane.showMessageDialog(this, "Morate odabrati red!", "Gre\u0161ka",JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            VoziloTableModel vpm = (VoziloTableModel) jtblPrikazVozila.getModel();
            List<Vozilo> listaV = vpm.getListaVozila();
            Vozilo v = listaV.get(red);

            try {
                TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
                toZahtev.setOperacija(Konstante.OBRISI_VOZILO);
                toZahtev.setParametar(v);
                Komunikacija.getInstance().posaljiZahtev(toZahtev);
                TransferObjekatOdgovor toOdgovor = Komunikacija.getInstance().primiOdgovor();

                boolean obrisao = (boolean) toOdgovor.getRezultat();

                if (obrisao) {
                    vpm.obrisiRed(red);
                    JOptionPane.showMessageDialog(this, "Sistem je obrisao vozilo");
                }
                else {
                    JOptionPane.showMessageDialog(this, "Sistem ne mo\u017Ee da obri\u0161e vozilo!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Sistem ne mo\u017Ee da obri\u0161e vozilo!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
                
            }

        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed
        int odabrani = jtblPrikazVozila.getSelectedRow();
        
        if (odabrani == -1) {
            JOptionPane.showMessageDialog(this, "Morate odabrati vozilo!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
        } else {
            VoziloTableModel vtm = (VoziloTableModel) jtblPrikazVozila.getModel();
            Vozilo v = vtm.getVozilo(odabrani);
            Util.getInstance().put("izabrano_vozilo", v);
            FrmDetaljiVozila frd = new FrmDetaljiVozila(sluzbenik);
            JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(this);
            dialog.dispose();
            frd.setVisible(true);
            frd.setDefaultCloseOperation(FrmUnosVozila.DISPOSE_ON_CLOSE);
            final Toolkit toolkit = Toolkit.getDefaultToolkit();
            final Dimension screenSize = toolkit.getScreenSize();
            final int x = (screenSize.width - frd.getWidth()) / 2;
            final int y = (screenSize.height - frd.getHeight()) / 2;
            frd.setLocation(x, y);
        }
    }//GEN-LAST:event_btnDetaljiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalji;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblPrikazVozila;
    private javax.swing.JTextField jtxtPretraga;
    // End of variables declaration//GEN-END:variables

    private void srediTabelu() {
        try {
            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.VRATI_VOZILA);
            Komunikacija.getInstance().posaljiZahtev(toZahtev);
            TransferObjekatOdgovor toOdgovor = Komunikacija.getInstance().primiOdgovor();
            
            if (toOdgovor.getIzuzetak() != null) {
                throw (Exception) toOdgovor.getIzuzetak();
            }
            
            List<Vozilo> listaVozila = (List<Vozilo>) toOdgovor.getRezultat();
            
            VoziloTableModel vtm = new VoziloTableModel(listaVozila);
            jtblPrikazVozila.setModel(vtm);
            
           
            
        } catch (Exception ex) {
            Logger.getLogger(FrmPretragaVozila.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
