package principal;

import controlador.ControladorLogin;
import javax.swing.SwingUtilities;
import modelo.UsuarioDAO;
import vista.VentanaLogin;

// Clase principal del sistema.
// Su función es iniciar la aplicación y mostrar la ventana de login.
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaLogin vistaLogin = new VentanaLogin();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            ControladorLogin controladorLogin = new ControladorLogin(vistaLogin, usuarioDAO);

            vistaLogin.setVisible(true);
        });
    }
}