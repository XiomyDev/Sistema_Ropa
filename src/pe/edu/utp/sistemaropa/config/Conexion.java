package pe.edu.utp.sistemaropa.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nayely
 */
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3308/mydb";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static Connection cx = null;
    
    public static Connection getConexion(){
        try {
           Class.forName(DRIVER);
           if (cx==null){
               cx = DriverManager.getConnection(URL, USER, PASS);
               System.out.println("Conectado");
           }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: "+e);
        }
        return cx;
    }
}