/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import forme.FrmServer;
import java.util.logging.Level;
import java.util.logging.Logger;
import poslovnalogika.Kontroler;

/**
 *
 * @author BOJAN
 */
public class NitOsvezi extends Thread{
    FrmServer fs;
    Boolean pokrenuta=false;

    @Override
    public void run() {
        while(pokrenuta){
        try {
            String operacije = Kontroler.getInstance().getOperacije();
            fs.vratiText().setText(operacije);
            
            
            sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(NitOsvezi.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    public NitOsvezi(FrmServer fs) {
        pokrenuta=true;
        this.fs = fs;
    }
    
    public void zaustaviNit() {
        pokrenuta=false;
    }
    
    
    
    
}
