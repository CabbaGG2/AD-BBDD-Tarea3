package servicios;
import conexion.dbConnection;

import javax.swing.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ServiciosAnime {

 /*public class insert(String url, String usuario, String contrasinal) {
            // Cambia estos valores por los de tu base de datos
           Connection connection = dbConnection.conectar();
           try( )
            connection.excutePreparedStatement("SELECT * FROM anime");

    }

  */

    public static void insertarEntrada(String nome, String descripcion, String data, double puntuacion) {

        String sql = "INSERT INTO anime (nome, descripcion, data, puntuacion) VALUES (?, ?, ?, ?)";
        try (Connection conn = dbConnection.conectar();
             PreparedStatement toInsert = conn.prepareStatement(sql)) {

            toInsert.setString(1, nome);
            toInsert.setString(2, descripcion);
            toInsert.setDate(3, new ServiciosAnime().stringToDate(data));
            toInsert.setDouble(4, puntuacion);
            toInsert.executeUpdate();
            System.out.println("Entrada insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar la entrada: " + e.getMessage());
        }
    }

    public static void ejecutarSQL() {
        String sql  = "SELECT * FROM anime";
        try (Connection conn = dbConnection.conectar();
             PreparedStatement toRead = conn.prepareStatement(sql);
             ResultSet resultSet = toRead.executeQuery()) {
            while (resultSet.next()) {
                System.out.println(
                        "Nombre: " + resultSet.getString("nome") +
                        ", Descripción: " + resultSet.getString("descripcion") +
                        ", Fecha: " + resultSet.getDate("data") +
                        ", Puntuación: " + resultSet.getDouble("puntuacion"));

            }
        } catch(SQLException e){
            System.out.println("Error al ejecutar el comando SQL: " + e.getMessage());
        }
    }

    public static void ejecutarConsultaSegunPuntuacion(double puntuacionMinima) {
        String sql = "SELECT * FROM anime WHERE puntuacion >= ?";
        try (Connection conn = dbConnection.conectar();
             PreparedStatement toRead = conn.prepareStatement(sql)) {

            toRead.setDouble(1, puntuacionMinima);
            try (ResultSet resultSet = toRead.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println(
                            "Nombre: " + resultSet.getString("nome") +
                            ", Descripción: " + resultSet.getString("descripcion") +
                            ", Fecha: " + resultSet.getDate("data") +
                            ", Puntuación: " + resultSet.getDouble("puntuacion"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
    }

    public static void actualizarEntrada(String nombre, String novoNome, String novaDescripcion, String novaData, double novaPuntuacion) {
        String sql = "UPDATE anime SET nome = ?, descripcion = ?, data = ?, puntuacion = ? WHERE nome = ?";
        try (Connection conn = dbConnection.conectar();
             PreparedStatement toUpdate = conn.prepareStatement(sql)) {

            toUpdate.setString(1, novoNome);
            toUpdate.setString(2, novaDescripcion);
            toUpdate.setDate(3, new ServiciosAnime().stringToDate(novaData));
            toUpdate.setDouble(4, novaPuntuacion);
            toUpdate.setString(5, nombre);

            int filasAfectadas = toUpdate.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Entrada actualizada correctamente.");
            } else {
                System.out.println("No se encontró ninguna entrada con el nombre proporcionado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar la entrada: " + e.getMessage());
        }
    }

    public Date stringToDate(String dataStr) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        try {
            java.util.Date dataUtil = formato.parse(dataStr);
            return new Date(dataUtil.getTime());
        } catch (ParseException e) {
            System.out.println("petou " + e.getMessage());
            return null;
        }
    }


}
