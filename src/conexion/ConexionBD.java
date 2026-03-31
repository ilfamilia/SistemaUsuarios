package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Clase encargada de centralizar la conexión con la base de datos MySQL.
// Su responsabilidad es proporcionar conexiones JDBC al resto del sistema.
// Esta centralización ayuda a mantener organizado el acceso a la base de datos.
public class ConexionBD {

    // URL de conexión a la base de datos sistema_usuarios.
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_usuarios";
   
    // Nombre del usuario de MySQL que se utilizará para la conexión.
    private static final String USUARIO = "root";
    
    // Contraseña del usuario de MySQL.
    private static final String CLAVE = "Altagracia@809";

    // Método que devuelve una conexión activa con la base de datos.
    // Lanza una excepción si ocurre un error durante la conexión.
    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}
