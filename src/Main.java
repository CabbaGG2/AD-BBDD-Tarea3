import conexion.dbConnection;

import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/tu_base";
        String usuario = "tu_usuario";
        String contrasinal = "tu_contrasinal";

        dbConnection dbConn = new dbConnection();
        Connection conn = dbConn.conectar();;
    }
}