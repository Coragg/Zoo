package app.bd;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {



   //String url = "D:\\documentos\\universidad\\paradigmas\\tareas\\tarea2\\Zoo\\animales.db";

    //String url = "D:\\documentos\\universidad\\paradigmas\\tareas\\tarea2\\Zoo\\animales.db";
   // String url = "C:\\Users\\maxor\\OneDrive\\Escritorio\\Zoo\\Zoo\\animales.db";

   String url = "C:\\Users\\maxor\\OneDrive\\Escritorio\\Zoo\\Zoo\\animales.db";

    //String url = "D:\\documentos\\universidad\\paradigmas\\tareas\\tarea2\\Zoo\\animales.db";
   // String url = "C:\\Users\\maxor\\OneDrive\\Escritorio\\Zoo\\Zoo\\animales.db";
   //String url = "C:\\Users\\rafis\\OneDrive\\Escritorio\\tarea 2\\Zoo\\animales.db";
   //String url = "C:\\Users\\nicox\\OneDrive\\Escritorio\\Zoo\\animales.db";
    //String url = "C:\\Users\\Nico\\Desktop\\github\\Zoo\\animales.db";


    Connection conexion;
    public Connection getConexion(){
        try{
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:" + url);
            // System.out.println("Me he conectado, hijos de puta ");
            return conexion;
        } catch (SQLException excepcion){
            System.out.println("No se ha podido establecer la conexion " + excepcion.getMessage());
            System.exit(-1);
        } catch (ClassNotFoundException error){
            System.out.println("No se ha encontrado el driver por esto: " + error.getMessage());
        }

        return null;
    }

    public void cerrar(){
        try {
            conexion.close();
        } catch (SQLException excepcion){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }
}

            