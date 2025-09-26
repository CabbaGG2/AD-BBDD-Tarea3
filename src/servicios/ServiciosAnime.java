package servicios;
import conexion.dbConnection;

import java.sql.Connection;

public class ServiciosAnime {

 public class insert(String url, String usuario, String contrasinal) {
            // Cambia estos valores por los de tu base de datos
           Connection connection = dbConnection.conectar();
           try( )
            connection.excutePreparedStatement("SELECT * FROM anime");

    }
}
