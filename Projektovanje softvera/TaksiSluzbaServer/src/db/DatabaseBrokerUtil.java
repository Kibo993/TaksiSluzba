/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import util.KonstanteDatabaseBroker;

/**
 *
 * @author BOJAN
 */
public class DatabaseBrokerUtil {
    
    Properties properties;

    public DatabaseBrokerUtil() throws FileNotFoundException, IOException {
        properties = new Properties();
        try{
        	InputStream stream = DatabaseBrokerUtil.class.getClassLoader().getResourceAsStream("db.config");
        	properties.load(stream);
    }catch(Exception ex) {
    	System.out.println("Nema db.config "+ex);
    }
        }

    public String getDBUser() {
        return properties.getProperty(KonstanteDatabaseBroker.USER);
    }

    public String getDBPassword() {
        return properties.getProperty(KonstanteDatabaseBroker.PASSWORD);
    }
    
}
