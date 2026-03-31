package principal;

import controlador.ControladorLogin;
import javax.swing.SwingUtilities;
import modelo.UsuarioDAO;
import vista.VentanaLogin;

// Clase principal del sistema.
// Su función es iniciar la aplicación y mostrar la ventana de login.
public class Main {

    // Método principal que arranca la ejecución del sistema.
    // Se crea la vista de login, el acceso a datos y su controlador.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            
            // Se crea la vista de inicio de sesión.
            VentanaLogin vistaLogin = new VentanaLogin();
            
            // Se crea el objeto de acceso a datos para trabajar con la base de datos.
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            
            // Se conecta la vista con la lógica del sistema mediante el controlador.
            ControladorLogin controladorLogin = new ControladorLogin(vistaLogin, usuarioDAO);

            // Se muestra la ventana inicial al usuario.
            vistaLogin.setVisible(true);
        });
    }
}