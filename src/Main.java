import conexion.dbConnection;
import servicios.ServiciosAnime;

import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        dbConnection dbConn = new dbConnection();
        Connection conn = dbConn.conectar();;
        if (conn != null) {
            System.out.println("Conexión exitosa a la base de datos.");
        } else {
            System.out.println("Fallo en la conexión a la base de datos.");
        }
        //ServiciosAnime.insertarEntrada("Naruto", "Un ninja que busca reconocimiento", "2002/01/01", 9.0);
        ServiciosAnime.ejecutarSQL();
        ServiciosAnime.ejecutarConsultaSegunPuntuacion(95.0);
        ServiciosAnime.actualizarEntrada("Naruto", "Naruto Shippuden", "La continuación de Naruto", "2007/02/15", 9.5);
    }

}