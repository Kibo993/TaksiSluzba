/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;


import domen.OpstiDomenskiObjekat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BOJAN
 */
public class DatabaseBroker {
   private Connection connection;
    private static DatabaseBroker instance;
    private static String ipAdresa;
    private static String port;
    
    public static void setIp(String ip){
    ipAdresa=ip;
    }
    
    public static void setPort(String port){
    DatabaseBroker.port=port;
    }

    private DatabaseBroker() {
    }
    
    public static DatabaseBroker getInstance() {
        if (instance == null) {
            instance = new DatabaseBroker();
        }
        return instance;
    }
    
    

    public void ucitajDriver() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new Exception("Neuspesno ucitavanje drivera!", ex);
        }
    }

    public void otvoriKonekciju() throws Exception {
    	
        try {
            DatabaseBrokerUtil dbUtil = new DatabaseBrokerUtil();
            connection = DriverManager.getConnection("jdbc:mysql://"+ipAdresa+":"+port+"/NYaE0hpNOj?useUnicode=true&characterEncoding=utf-8&useSSL=false", dbUtil.getDBUser(), dbUtil.getDBPassword());
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            throw new Exception("Neuspesno otvaranje konekcije!", ex);
        }
    }

    public void commitTransakcije() throws Exception {
        try {
            connection.commit();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan commit transakcije!", ex);
        }
    }

    public void rollbackTransakcije() throws Exception {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan rollback transakcije!", ex);
        }
    }

    public void zatvoriKonekciju() throws Exception {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new Exception("Neuspesno zatvaranje konekcije!", ex);
        }
    }
    
    
    

    public void sacuvaj(OpstiDomenskiObjekat odo) throws Exception {
        try {
            String sql = "INSERT INTO "+odo.vratiNazivTabele()+odo.vratiNaziveKolonaZaInsert()+" VALUES ("+odo.vratiVrednostiZaInsert()+")";
            System.out.println(sql);
            Statement sqlStatement = connection.createStatement();
            sqlStatement.executeUpdate(sql);
           
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public OpstiDomenskiObjekat vratiObjekat(OpstiDomenskiObjekat odo) throws Exception {
        try{
        String sql = "SELECT "+odo.vratiKoloneZaPretragu()+" FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiUslovZaPK();
        System.out.println(sql);
        Statement sqlStatement = connection.createStatement();
        ResultSet rs = sqlStatement.executeQuery(sql);
        return odo.vratiObjekat(rs);
        }
        catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje objekta!", ex);
        }
        
        
    }
    
    public List<OpstiDomenskiObjekat> vratiSve(OpstiDomenskiObjekat odo) throws Exception { 
       
        try {
            String sql = "SELECT "+odo.vratiKoloneZaPretragu()+" FROM " + odo.vratiNazivTabele()+odo.vratiUslovZaJoin()+" ORDER BY "+odo.vratiUslovZaRedosled()+" ASC";
            System.out.println(sql);
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            return odo.ucitajObjekte(rs);
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje objekata!", ex);
        }
    }
    
    public int generisiSifru(OpstiDomenskiObjekat odo) throws Exception {
        int sifra = 0;
        
            String  sql = "SELECT max("+odo.vratiIDKolonu()+") as maks FROM " + odo.vratiNazivTabele();
       try {
           Statement sqlStatement = connection.createStatement();
           ResultSet rs = sqlStatement.executeQuery(sql);
           while (rs.next()) {
               sifra = rs.getInt("maks");
           }
       } catch (SQLException ex) {
           throw new Exception("Neuspesno ucitavanje sifre", ex);
       }
       
       return sifra;
    }
    
    public void izmeni(OpstiDomenskiObjekat odo) throws Exception{
        try {
        String sql = "UPDATE "+odo.vratiNazivTabele()+" SET "+odo.vratiVrednostiZaUpdate()+ " WHERE "+odo.vratiUslovZaPK();
        System.out.println(sql);
        Statement sqlStatement = connection.createStatement();
        sqlStatement.executeUpdate(sql);
        }
        catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public void obrisi(OpstiDomenskiObjekat odo) throws Exception {
       try {
           String sql = "DELETE FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiUslovZaPK();
           System.out.println(sql);
           Statement sqlStatement = connection.createStatement();
           sqlStatement.executeUpdate(sql);
       } catch (SQLException ex) {
           throw new Exception(ex);
       }
    }
    
    @SuppressWarnings("finally")
	public List<OpstiDomenskiObjekat> pretraziObjekte(String kriterijum, OpstiDomenskiObjekat odo) throws Exception  {    
        String sql = "";
        try{
        try{
            int id = Integer.parseInt(kriterijum);
            sql = "SELECT "+odo.vratiKoloneZaPretragu()+" FROM " + odo.vratiNazivTabele()+odo.vratiUslovZaJoin()+ " WHERE " + odo.vratiUslovZaPretraguID()+"='"+kriterijum+"' ORDER BY "+odo.vratiUslovZaRedosled()+" ASC";
            
        } catch (NumberFormatException e) {
            sql = "SELECT "+odo.vratiKoloneZaPretragu()+" FROM " + odo.vratiNazivTabele()+odo.vratiUslovZaJoin()+ " WHERE " + odo.vratiUslovZaPretragu()+"='"+kriterijum+"' ORDER BY "+odo.vratiUslovZaRedosled()+" ASC";
        }
        
        finally {
            System.out.println(sql);
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            return odo.ucitajObjekte(rs);
            
        }
        }
         catch (SQLException ex) {
            throw new Exception("NeuspeÅ¡no uÄ�itavanje objekata!", ex);
        }
        
        
        
        
        
        
//        try{
//        String sql = "SELECT * FROM " + odo.vratiNazivTabele()+odo.vratiUslovZaJoin()+ " WHERE " + odo.vratiUslovZaPretragu()+"='"+kriterijum+"'";
//        System.out.println(sql);
//        Statement sqlStatement = connection.createStatement();
//        ResultSet rs = sqlStatement.executeQuery(sql);
//        return odo.ucitajObjekte(rs);
//        }
//        catch (SQLException ex) {
//            throw new Exception("Neuspesno ucitavanje objekta!", ex);
//        }
    }
   
            public List<OpstiDomenskiObjekat> pretraziLike(String kriterijum, OpstiDomenskiObjekat odo) throws Exception { 
       String sql = null;
        try {
            
            String uslov = odo.vratiUslovZaPretragu();
            if(kriterijum.contains("_")){
                String[] uslovi = uslov.split("_");
                String uslov1 = uslovi[0];
                String uslov2 = uslovi[1];
                String[] kriterijumi = kriterijum.split("_");
                String kriterijum1 = kriterijumi[0];
                String kriterijum2 = kriterijumi[1];
            sql = "SELECT "+odo.vratiKoloneZaPretragu()+" FROM " + odo.vratiNazivTabele()+odo.vratiUslovZaJoin()+ " WHERE " + uslov1 +" LIKE '"+kriterijum1+"%' AND "+ uslov2 +" LIKE '"+kriterijum2+"%' ORDER BY "+odo.vratiUslovZaRedosled()+" ASC";
            }else{
                String uslov1;
                if(uslov.contains("_")){
                String[] uslovi = uslov.split("_");
                uslov1 = uslovi[0];
                }else{
                uslov1=uslov;
                }
            sql = "SELECT "+odo.vratiKoloneZaPretragu()+" FROM " + odo.vratiNazivTabele()+odo.vratiUslovZaJoin()+ " WHERE " + uslov1+" LIKE '"+kriterijum+"%' ORDER BY "+odo.vratiUslovZaRedosled()+" ASC";
            }
            System.out.println(sql);
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            return odo.ucitajObjekte(rs);
        } catch (SQLException ex) {
            throw new Exception("Neuspesno uÄ�itavanje objekata!", ex);
        }
    }
    
}
