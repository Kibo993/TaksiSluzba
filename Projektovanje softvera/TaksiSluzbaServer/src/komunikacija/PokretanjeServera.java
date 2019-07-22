/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.net.ServerSocket;
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
public class PokretanjeServera extends Thread{
    private boolean kraj = false;
    private ServerSocket ss;
    private NitKlijent nit;
    @Override
    public void run() {
        try {
            kraj = true;
            ss = new ServerSocket(9000);
            System.out.println("Server je pokrenut.");
            while (kraj) {
                Socket socket = ss.accept();
                System.out.println("Klijent se povezao.");
                nit = new NitKlijent(socket);
                nit.start();
            }   
        } catch (IOException ex) {
            //Logger.getLogger(PokretanjeServera.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Server je zaustavljen.");
        }
    
    
    
   
    }
    
    public void zaustaviServer() throws IOException{
            kraj = false;
            ss.close();
            if(nit!=null){
            nit.zaustaviNit();
            nit.interrupt();
            }
    }

    
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        new PokretanjeServera().pokreniServer();
//    }
}
