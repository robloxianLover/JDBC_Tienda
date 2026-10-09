package mx.unison;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/tienda_db";
        String user = "developer";
        String password = "ADMIN";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexión establecida correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        }
    }
}
