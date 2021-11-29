package Bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    //MySql
    /*private Connection Con;
    private final String bdd = "jdbc:mysql://sql10.freesqldatabase.com/sql10445780";
    private final String usu = "sql10445780";
    private final String clave = "gc3Jp6Jrkz";
    private final String driver = "com.mysql.jdbc.Driver";*/
    
    //conexion para Sql Server
    private Connection Con;
    private final String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String bdd="jdbc:sqlserver://localhost:1433;databaseName=PruebasCFP31";
    private final String usu="prueba";
    private final String clave="1234";

    //constructor
    public Conexion(){
        Con = null;
        try {
            Class.forName(driver);
            Con = DriverManager.getConnection(bdd, usu, clave); //para SQL server
            //Con = DriverManager.getConnection(Bdd, Usu, Clave); //Para MySql
        } 
        catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No puede levantar el driver" + e);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión" + e);
        } 
    }
    
    //metodos
    public Connection MeConecto(){
        return Con;
    }
    
    public void MeDesconecto(){
        try {
            JOptionPane.showMessageDialog(null, "Cerrando la conexión");
            Con.close();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "No se pudo cerrar la base de datos" + e);
        }
    }
}