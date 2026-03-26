package principal;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.SQLException;

public class PruebaConexion {

    public static void main(String[] args) {
        try {
            Connection conexion = ConexionBD.obtenerConexion();
            System.out.println("Conexión exitosa a la base de datos.");
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
