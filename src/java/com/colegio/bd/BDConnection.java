package com.colegio.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnection {
    Connection cnx;
    String bd = "bdagendadigitalmysql";
    String url = "jdbc:mysql://localhost:3306/"+bd;
    String user = "root";
    String password = "R20K10G4S8";
    
    public Connection conectarconBD(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Se conecto a la MariaDB - bdagendadigitalmysql");
        }catch (ClassNotFoundException|SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cnx;
    }
    
    public void desconectarBD(){
        try {
            cnx.close();
        } catch (SQLException ex) {
            System.out.println("Error al desconectar la BD.");
        }
    }
}
