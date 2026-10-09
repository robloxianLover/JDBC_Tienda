package mx.unison;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultarClientes {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/tienda_db";
        String user = "developer";
        String password = "ADMIN";

        String sql = "SELECT cliente_id, nombre, email, telefono, creado_en FROM tienda.clientes";

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {
            while (rs.next()) {
                int id = rs.getInt("cliente_id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                String creado_en = rs.getString("creado_en");


                System.out.println(id + " | " + nombre + " | " + email + " | " + telefono + " |" + creado_en + " |");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}