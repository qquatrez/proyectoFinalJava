package Desarrollo;

import Bdd.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Abogados {
    
    private int nroMatricula;
    private String nombre;
    private String apellido;
    private String telefono;

    public Abogados() {
    }

    public Abogados(int nroMatricula, String nombre, String apellido, String telefono) {
        this.nroMatricula = nroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public int getNroMatricula() {
        return nroMatricula;
    }

    public void setNroMatricula(int nroMatricula) {
        this.nroMatricula = nroMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    private String altaAbogado= "insert into abogados(nroMatricula, nombre, apellido, telefono) values(?,?,?,?)";
    PreparedStatement ps;
    Conexion obj = new Conexion();
    
    public void AltaAbogado(){
        try{
            ps= obj.MeConecto().prepareStatement(altaAbogado);
            ps.setInt(1, this.nroMatricula);
            ps.setString(2, this.nombre);
            ps.setString(3, this.apellido);
            ps.setString(4, this.telefono);
            int resultado = ps.executeUpdate();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en alta de Abogado\n"+e);
        }
        finally{
            obj.MeDesconecto();
        }
    }
    
    
}
