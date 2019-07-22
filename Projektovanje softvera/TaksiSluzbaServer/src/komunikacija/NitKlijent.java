/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import domen.EvidencijaVoznje;
import domen.OpstiDomenskiObjekat;
import domen.Sluzbenik;
import domen.Taksista;
import domen.Vozilo;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import poslovnalogika.Kontroler;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Konstante;

/**
 *
 * @author BOJAN
 */
public class NitKlijent extends Thread {
    
    private Socket socket;
    private boolean aktivan;
    
    public NitKlijent(Socket socket) {
        this.socket = socket;
        this.aktivan = true;
    }
    
    @Override
    public void run() {
        try {
            izvrsenjeOperacija();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Nit je zavrsila sa radom.");
    }

    private void izvrsenjeOperacija() throws IOException, ClassNotFoundException {
        while (aktivan) {
                ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
                TransferObjekatZahtev toZahtev = (TransferObjekatZahtev) inSocket.readObject();
                TransferObjekatOdgovor toOdgovor = new TransferObjekatOdgovor();
            try {                
                System.out.println("O: " + toZahtev.getOperacija());
                switch (toZahtev.getOperacija()) {
                    
                    case Konstante.VRATI_TAKSISTE:
                        
                        List<OpstiDomenskiObjekat> t = Kontroler.getInstance().vratiTaksiste();
                        toOdgovor.setRezultat(t);
                        toOdgovor.setPoruka("Taksisti su ucitani.");
                                
                        break;
                    
                    case Konstante.VRATI_VOZILA:
                        
                        List<OpstiDomenskiObjekat> v = Kontroler.getInstance().vratiVozila();
                        toOdgovor.setRezultat(v);
                        toOdgovor.setPoruka("Vozila su ucitana.");
                                
                        break;
                        
                    case Konstante.KREIRAJ_TAKSISTU:
                        Taksista taksista = (Taksista) toZahtev.getParametar();
                        int id = Kontroler.getInstance().kreirajNovogTaksistu(taksista);
                        toOdgovor.setRezultat(id);
                       
                        break;
                        
                    case Konstante.ZAPAMTI_TAKSISTU:
                        Taksista taksistaz = (Taksista) toZahtev.getParametar();
                        boolean zapamtio = Kontroler.getInstance().zapamtiTaksistu(taksistaz);
                        toOdgovor.setRezultat(zapamtio);
                   
                        break;
                        
                    case Konstante.NADJI_TAKSISTE:
                        String kriterijum = (String) toZahtev.getParametar();
                        List<OpstiDomenskiObjekat> nadjeniTaksisti = Kontroler.getInstance().pretraziTaksiste(kriterijum);
                        toOdgovor.setRezultat(nadjeniTaksisti);
                       
                        break;
                                         
                    case Konstante.OBRISI_TAKSISTU:
                        Taksista obrisit = (Taksista) toZahtev.getParametar();
                        boolean obrisaoT = Kontroler.getInstance().obrisiTaksistu(obrisit);
                        toOdgovor.setRezultat(obrisaoT);
                       
                        break;
                        
                    case Konstante.UCITAJ_TAKSISTU:
                        String kriterijumPretrage = toZahtev.getParametar().toString();
                            String[] kriterijumi = kriterijumPretrage.split(" ");
                            List<OpstiDomenskiObjekat> nadjeneEvidencijeTaksista = Kontroler.getInstance().ucitajTaksistu(kriterijumi[0]);
                            toOdgovor.setRezultat(nadjeneEvidencijeTaksista);
                        
                        break;
                        
                    case Konstante.VRATI_TAKSI_STANICE:
                       List<OpstiDomenskiObjekat> ts = Kontroler.getInstance().ucitajTaksiStanice();
                       toOdgovor.setRezultat(ts);
                       toOdgovor.setPoruka("Taksi stanice su ucitane.");
                     
                       break;
                       
                    case Konstante.KREIRAJ_VOZILO:
                        Vozilo vozilo = (Vozilo) toZahtev.getParametar();
                        int idv = Kontroler.getInstance().kreirajNovoVozilo(vozilo);
                        toOdgovor.setRezultat(idv);
                       
                        break;
                        
                    case Konstante.ZAPAMTI_VOZILO:
                        Vozilo voziloz = (Vozilo) toZahtev.getParametar();
                        boolean zapamtiov = Kontroler.getInstance().zapamtiVozilo(voziloz);
                        toOdgovor.setRezultat(zapamtiov);
                   
                        break;
                        
                    case Konstante.NADJI_VOZILA:
                        String kriterijumv = (String) toZahtev.getParametar();
                        List<OpstiDomenskiObjekat> nadjenaVozila = Kontroler.getInstance().pretraziVozila(kriterijumv);
                        toOdgovor.setRezultat(nadjenaVozila);
                       
                        break; 
                       
                    case Konstante.OBRISI_VOZILO:
                        Vozilo obrisiv = (Vozilo) toZahtev.getParametar();
                        boolean obrisaoV = Kontroler.getInstance().obrisiVozilo(obrisiv);
                        toOdgovor.setRezultat(obrisaoV);
                       
                        break;
                        
                    case Konstante.UCITAJ_VOZILO:
                        String kriterijumPretrageVozila = toZahtev.getParametar().toString();
                            String[] kriterijumiVozila = kriterijumPretrageVozila.split(" ");
                            List<OpstiDomenskiObjekat> nadjeneEvidencijeVozila = Kontroler.getInstance().ucitajVozilo(kriterijumiVozila[0]);
                            toOdgovor.setRezultat(nadjeneEvidencijeVozila);
                        
                        break;

                    case Konstante.SACUVAJ_EVIDENCIJE:
                        List<EvidencijaVoznje> evidencije = (List<EvidencijaVoznje>) toZahtev.getParametar();
                        boolean zapamtioEV = Kontroler.getInstance().sacuvajEvidencijeVoznje(evidencije);
                        toOdgovor.setRezultat(zapamtioEV);
                       
                        break;
                      
                    case Konstante.NADJI_SLUZBENIKA:
                        Sluzbenik sluzbenik = (Sluzbenik) toZahtev.getParametar();
                        OpstiDomenskiObjekat verifikovaniSluzbenik = Kontroler.getInstance().nadjiSluzbenika(sluzbenik);
                        Sluzbenik ver = (Sluzbenik) verifikovaniSluzbenik;
                        if (ver.getKorisnickoIme()==null) {
                           ver.setKorisnickoIme("LoseLogovanje");
                        }
                        toOdgovor.setRezultat(ver);
                        
                        break;
                        
                    case Konstante.KRAJ:
                        aktivan = false;
                        break;
                }
            } catch (Exception ex) {
                toOdgovor.setPoruka(ex.getMessage());
                toOdgovor.setIzuzetak(ex);
            }
            
            posaljiOdgovor(toOdgovor);
            
        }
    }
    
    public void zaustaviNit(){
        aktivan=false;
    }
    
    private void posaljiOdgovor(TransferObjekatOdgovor toOdgovor) throws IOException {
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(toOdgovor);
    }
    
}
