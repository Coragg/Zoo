package app.bd;


import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModificarAnimales {
    private final Conexion conexion;

    public ModificarAnimales(){
        conexion = new Conexion();
    }

    public boolean mamifero(int id, String nombre, String color, double peso, String tipo, String categoria, int cantidadPatas){
        try {
            String query = "UPDATE animalesZoo SET nombre = ?, color = ?, peso = ?, tipo = ?, categoria = ?, cantidadPatas = ? WHERE id = " + id;
            PreparedStatement sentenciaP = conexion.getConexion().prepareStatement(query);
            sentenciaP.setString(1, nombre);
            sentenciaP.setString(2, color);
            sentenciaP.setDouble(3, peso);
            sentenciaP.setString(4, tipo);
            sentenciaP.setString(5, categoria);
            sentenciaP.setInt(6, cantidadPatas);

            sentenciaP.executeUpdate();
            sentenciaP.close();
            return true;
        } catch (SQLException error) {
            System.out.println("Error modificarAnimal: " + error.getMessage());
            return false;
        }
    }

    public boolean ave(int id, String nombre, String color, double peso, String tipo, String categoria, int cantidadAlas){

        try {
            String query = "UPDATE animalesZoo SET nombre = ?, color = ?, peso = ?, tipo = ?, categoria = ?, cantidadAlas = ? WHERE id = " + id;
            PreparedStatement sentenciaP = conexion.getConexion().prepareStatement(query);
            sentenciaP.setString(1, nombre);
            sentenciaP.setString(2, color);
            sentenciaP.setDouble(3, peso);
            sentenciaP.setString(4, tipo);
            sentenciaP.setString(5, categoria);
            sentenciaP.setInt(6, cantidadAlas);

            sentenciaP.executeUpdate();
            sentenciaP.close();
            return true;
        } catch (SQLException error) {
            System.out.println("Error modificarAnimal: " + error.getMessage());
            return false;
        }

    }

    public boolean pez(int id, String nombre, String color, double peso, String tipo, String categoria, int cantidadAletas, String escamas){

        try {
            String sql = "UPDATE animalesZoo SET nombre = ?, color = ?, peso = ?, tipo = ?, categoria = ?, cantidadAletas = ?, escamas = ? WHERE id = " + id;
            PreparedStatement sentenciaPreparedStament = conexion.getConexion().prepareStatement(sql);
            sentenciaPreparedStament.setString(1, nombre);
            sentenciaPreparedStament.setString(2, color);
            sentenciaPreparedStament.setDouble(3, peso);
            sentenciaPreparedStament.setString(4, tipo);
            sentenciaPreparedStament.setString(5, categoria);
            sentenciaPreparedStament.setInt(6, cantidadAletas);
            sentenciaPreparedStament.setString(7, escamas);

            sentenciaPreparedStament.executeUpdate();
            sentenciaPreparedStament.close();
            return true;
        } catch (SQLException error) {
            System.out.println("Error modificarAnimal: " + error.getMessage());
            return false;
        }

    }


    public boolean anfibio(int id, String nombre, String color, double peso, String tipo, String categoria, String piel){
        try {
            String sql = "UPDATE animalesZoo SET nombre = ?, color = ?, peso = ?, tipo = ?, categoria = ?, piel = ? WHERE id = " + id;
            PreparedStatement sentenciaPreparedStament = conexion.getConexion().prepareStatement(sql);
            sentenciaPreparedStament.setString(1, nombre);
            sentenciaPreparedStament.setString(2, color);
            sentenciaPreparedStament.setDouble(3, peso);
            sentenciaPreparedStament.setString(4, tipo);
            sentenciaPreparedStament.setString(5, categoria);
            sentenciaPreparedStament.setString(6, piel);

            sentenciaPreparedStament.executeUpdate();
            sentenciaPreparedStament.close();
            return true;
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error modificarAnimal: " + error.getMessage());
            return false;
        }
    }


    public boolean reptil(int id, String nombre, String color, double peso, String tipo, String categoria, String tierraMarAmbos) {
        try {
            String sql = "UPDATE animalesZoo SET nombre = ?, color = ?, peso = ?, tipo = ?, categoria = ?, tierraMar_ambos = ? WHERE id = " + id;
            PreparedStatement sentenciaPreparedStament = conexion.getConexion().prepareStatement(sql);
            sentenciaPreparedStament.setString(1, nombre);
            sentenciaPreparedStament.setString(2, color);
            sentenciaPreparedStament.setDouble(3, peso);
            sentenciaPreparedStament.setString(4, tipo);
            sentenciaPreparedStament.setString(5, categoria);
            sentenciaPreparedStament.setString(6, tierraMarAmbos);

            sentenciaPreparedStament.executeUpdate();
            sentenciaPreparedStament.close();
            return true;
        } catch (SQLException error) {
            System.out.println("Error modificarAnimal: " + error.getMessage());
            return false;
        }
    }



    public boolean artropodo(int id, String nombre, String color, double peso, String tipo, String categoria, int cantidadParesPatas, String numeroAntenas) {

        try {
            String sql = "UPDATE animalesZoo SET nombre = ?, color = ?, peso = ?, tipo = ?, categoria = ?, WHERE id = " + id;
            PreparedStatement sentenciaPreparedStament = conexion.getConexion().prepareStatement(sql);
            sentenciaPreparedStament.setString(1, nombre);
            sentenciaPreparedStament.setString(2, color);
            sentenciaPreparedStament.setDouble(3, peso);
            sentenciaPreparedStament.setString(4, tipo);
            sentenciaPreparedStament.setString(5, categoria);
            sentenciaPreparedStament.setInt(6, cantidadParesPatas);
            sentenciaPreparedStament.setString(7, numeroAntenas);

            sentenciaPreparedStament.executeUpdate();
            sentenciaPreparedStament.close();
            return true;
        } catch(SQLException error) {
            JOptionPane.showMessageDialog(null, "Error modificarAnimal: " + error.getMessage());
            return false;
        }
    }


    public boolean molusco(int id, String nombre, String color, double peso, String tipo, String categoria, String erizoEstrella) {
        try {
            String sql = "UPDATE animalesZoo SET nombre = ?, color = ?, peso = ?, tipo = ?, categoria = ?, erizo_o_estrella = ? WHERE id = " + id;
            PreparedStatement sentenciaPreparedStament = conexion.getConexion().prepareStatement(sql);
            sentenciaPreparedStament.setString(1, nombre);
            sentenciaPreparedStament.setString(2, color);
            sentenciaPreparedStament.setDouble(3, peso);
            sentenciaPreparedStament.setString(4, tipo);
            sentenciaPreparedStament.setString(5, categoria);
            sentenciaPreparedStament.setString(6, erizoEstrella);

            sentenciaPreparedStament.executeUpdate();
            sentenciaPreparedStament.close();
            return true;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error modificarAnimal: " + error.getMessage());
            return false;
        }
    }


    public boolean equinodermo(int id, String nombre, String color, double peso, String tipo, String categoria, String erizoEstrella){
        try{
            String sql = "UPDATE animalesZoo SET nombre = ?, color = ?, peso = ?, tipo = ?, categoria = ?, erizo_o_estrella = ? WHERE id = " + id;
            PreparedStatement sentenciaPreparedStament = conexion.getConexion().prepareStatement(sql);
            sentenciaPreparedStament.setString(1, nombre);
            sentenciaPreparedStament.setString(2, color);
            sentenciaPreparedStament.setDouble(3, peso);
            sentenciaPreparedStament.setString(4, tipo);
            sentenciaPreparedStament.setString(5, categoria);
            sentenciaPreparedStament.setString(6, erizoEstrella);

            sentenciaPreparedStament.executeUpdate();
            sentenciaPreparedStament.close();
            return true;
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error modificarAnimal: " + error.getMessage());
            return false;
        }
    }


    public boolean gusano(int id, String nombre, String color, double peso, String tipo, String categoria, String tipoCuerpo){
        try {
            String sql = "UPDATE animalesZoo SET nombre = ?, color = ?, peso = ?, tipo = ?, categoria = ?, tipoCuerpo = ? WHERE id = " + id;
            PreparedStatement sentenciaPreparedStament = conexion.getConexion().prepareStatement(sql);
            sentenciaPreparedStament.setString(1, nombre);
            sentenciaPreparedStament.setString(2, color);
            sentenciaPreparedStament.setDouble(3, peso);
            sentenciaPreparedStament.setString(4, tipo);
            sentenciaPreparedStament.setString(5, categoria);
            sentenciaPreparedStament.setString(6, tipoCuerpo);

            sentenciaPreparedStament.executeUpdate();
            sentenciaPreparedStament.close();
            return true;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error modificarAnimal: " + error.getMessage());
            return false;
        }
    }

    public boolean porifero(int id, String nombre, String color, double peso, String tipo, String categoria){
        try {
            String sql = "UPDATE animalesZoo SET nombre = ?, color = ?, peso = ?, tipo = ?, categoria = ? WHERE id = " + id;
            PreparedStatement sentenciaPreparedStament = conexion.getConexion().prepareStatement(sql);
            sentenciaPreparedStament.setString(1, nombre);
            sentenciaPreparedStament.setString(2, color);
            sentenciaPreparedStament.setDouble(3, peso);
            sentenciaPreparedStament.setString(4, tipo);
            sentenciaPreparedStament.setString(5, categoria);

            sentenciaPreparedStament.executeUpdate();
            sentenciaPreparedStament.close();
            return true;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error modificarAnimal: " + error.getMessage());
            return false;
        }

    }

    public boolean celentereo(int id, String nombre, String color, double peso, String tipo, String categoria, String tentaculos){
        try {
            String sql = "UPDATE animalesZoo SET nombre = ?, color = ?, peso = ?, tipo = ?, categoria = ?, tentaculos = ? WHERE id = " + id;
            PreparedStatement sentenciaPreparedStament = conexion.getConexion().prepareStatement(sql);
            sentenciaPreparedStament.setString(1, nombre);
            sentenciaPreparedStament.setString(2, color);
            sentenciaPreparedStament.setDouble(3, peso);
            sentenciaPreparedStament.setString(4, tipo);
            sentenciaPreparedStament.setString(5, categoria);
            sentenciaPreparedStament.setString(6, tentaculos);

            sentenciaPreparedStament.executeUpdate();
            sentenciaPreparedStament.close();
            return true;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error modificarAnimal: " + error.getMessage());
            return false;
        }
    }




}
