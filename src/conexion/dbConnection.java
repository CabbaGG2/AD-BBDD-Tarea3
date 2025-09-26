package conexion;

import java.sql.*;

public class dbConnection {

    public Connection conectar() {
        Connection conn = null;
        String url = "jdbc:postgresql://10.0.9.104:5432/probas";
        String usuario = "postgres";
        String contrasinal = "admin";
        try {
             conn = DriverManager.getConnection(url,usuario, contrasinal);

            return conn;
        } catch (SQLException e) {
            System.out.println("Erro conectando a db "+e.getMessage());
            return conn;
        }
    }
}