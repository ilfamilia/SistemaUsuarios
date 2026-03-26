package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.VentanaLogin;
import vista.VentanaRegistro;
import vista.VentanaPrincipal;
import controlador.ControladorPrincipal;

public class ControladorLogin implements ActionListener {

    private VentanaLogin vistaLogin;
    private UsuarioDAO usuarioDAO;

    public ControladorLogin(VentanaLogin vistaLogin, UsuarioDAO usuarioDAO) {
        this.vistaLogin = vistaLogin;
        this.usuarioDAO = usuarioDAO;

        this.vistaLogin.getBtnIniciarSesion().addActionListener(this);
        this.vistaLogin.getBtnRegistrarse().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaLogin.getBtnIniciarSesion()) {
            iniciarSesion();
        }

        if (e.getSource() == vistaLogin.getBtnRegistrarse()) {
            VentanaRegistro vistaRegistro = new VentanaRegistro();
            ControladorRegistro controladorRegistro = new ControladorRegistro(vistaRegistro, usuarioDAO);
            vistaRegistro.setVisible(true);
        }
    }

    private void iniciarSesion() {
        String usuario = vistaLogin.getTxtUsuario().getText().trim();
        String contrasena = new String(vistaLogin.getTxtContrasena().getPassword()).trim();

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(
                    vistaLogin,
                    "debe ingresar su usuario y contraseña, si no está registrado debe registrarse"
            );
            return;
        }

        Usuario usuarioEncontrado = usuarioDAO.iniciarSesion(usuario, contrasena);

        if (usuarioEncontrado != null) {
            JOptionPane.showMessageDialog(vistaLogin, "Inicio de sesión correcto.");

            VentanaPrincipal vistaPrincipal = new VentanaPrincipal();
            ControladorPrincipal controladorPrincipal = new ControladorPrincipal(vistaPrincipal, usuarioDAO);

            vistaPrincipal.setVisible(true);
            vistaLogin.dispose();
        } else {
            JOptionPane.showMessageDialog(vistaLogin, "Usuario o contraseña incorrectos.");
        }
    }
}