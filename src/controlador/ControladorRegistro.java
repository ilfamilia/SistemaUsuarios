package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.VentanaRegistro;

// Controlador encargado de gestionar la lógica del registro de usuarios.
// Conecta la vista VentanaRegistro con el modelo UsuarioDAO.
// Implementa ActionListener para manejar los eventos de los botones.
// Forma parte de la capa Controlador dentro de la arquitectura MVC.
public class ControladorRegistro implements ActionListener {

    private VentanaRegistro vistaRegistro;
    private UsuarioDAO usuarioDAO;

    // Constructor que recibe la vista de registro y el acceso a datos.
    // Aquí se asocian los eventos de los botones de la interfaz.
    public ControladorRegistro(VentanaRegistro vistaRegistro, UsuarioDAO usuarioDAO) {
        this.vistaRegistro = vistaRegistro;
        this.usuarioDAO = usuarioDAO;

        this.vistaRegistro.getBtnRegistrar().addActionListener(this);
        this.vistaRegistro.getBtnCancelar().addActionListener(this);
    }

    // Método que maneja los eventos generados por los botones de la vista.
    // Permite registrar un usuario o cerrar la ventana de registro.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaRegistro.getBtnRegistrar()) {
            registrarUsuario();
        }

        if (e.getSource() == vistaRegistro.getBtnCancelar()) {
            vistaRegistro.dispose();
        }
    }

    // Método que valida los datos ingresados en el formulario,
    // verifica duplicados y registra al nuevo usuario en la base de datos.
    private void registrarUsuario() {
        String usuario = vistaRegistro.getTxtUsuario().getText().trim();
        String nombre = vistaRegistro.getTxtNombre().getText().trim();
        String apellido = vistaRegistro.getTxtApellido().getText().trim();
        String telefono = vistaRegistro.getTxtTelefono().getText().trim();
        String correoElectronico = vistaRegistro.getTxtCorreoElectronico().getText().trim();
        String contrasena = new String(vistaRegistro.getTxtContrasena().getPassword()).trim();
        String confirmarContrasena = new String(vistaRegistro.getTxtConfirmarContrasena().getPassword()).trim();

        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(vistaRegistro, "Debe ingresar el usuario.");
            return;
        }

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(vistaRegistro, "Debe ingresar el nombre.");
            return;
        }

        if (apellido.isEmpty()) {
            JOptionPane.showMessageDialog(vistaRegistro, "Debe ingresar el apellido.");
            return;
        }

        if (telefono.isEmpty()) {
            JOptionPane.showMessageDialog(vistaRegistro, "Debe ingresar el teléfono.");
            return;
        }

        if (correoElectronico.isEmpty()) {
            JOptionPane.showMessageDialog(vistaRegistro, "Debe ingresar el correo electrónico.");
            return;
        }

        if (contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(vistaRegistro, "Debe ingresar la contraseña.");
            return;
        }

        if (confirmarContrasena.isEmpty()) {
            JOptionPane.showMessageDialog(vistaRegistro, "Debe confirmar la contraseña.");
            return;
        }

        if (!contrasena.equals(confirmarContrasena)) {
            JOptionPane.showMessageDialog(vistaRegistro, "La contraseña y la confirmación no coinciden.");
            return;
        }
        
        if (usuarioDAO.existeUsuarioOCorreo(usuario, correoElectronico)) {
            JOptionPane.showMessageDialog(vistaRegistro, "El usuario o el correo electrónico ya están registrados.");
            return;
        }

        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.setUsuario(usuario);
        usuarioNuevo.setNombre(nombre);
        usuarioNuevo.setApellido(apellido);
        usuarioNuevo.setTelefono(telefono);
        usuarioNuevo.setCorreoElectronico(correoElectronico);
        usuarioNuevo.setContrasena(contrasena);

        boolean registrado = usuarioDAO.registrarUsuario(usuarioNuevo);

        if (registrado) {
            JOptionPane.showMessageDialog(vistaRegistro, "Usuario registrado correctamente.");
            limpiarCampos();
            vistaRegistro.dispose();
        } else {
            JOptionPane.showMessageDialog(vistaRegistro, "No se pudo registrar el usuario.");
        }
    }

    // Método auxiliar que limpia los campos del formulario después de un registro exitoso.
    private void limpiarCampos() {
        vistaRegistro.getTxtUsuario().setText("");
        vistaRegistro.getTxtNombre().setText("");
        vistaRegistro.getTxtApellido().setText("");
        vistaRegistro.getTxtTelefono().setText("");
        vistaRegistro.getTxtCorreoElectronico().setText("");
        vistaRegistro.getTxtContrasena().setText("");
        vistaRegistro.getTxtConfirmarContrasena().setText("");
    }
}