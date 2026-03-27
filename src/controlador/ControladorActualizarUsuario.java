package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.VentanaActualizarUsuario;

public class ControladorActualizarUsuario implements ActionListener {

    private VentanaActualizarUsuario vistaActualizarUsuario;
    private UsuarioDAO usuarioDAO;
    private Usuario usuarioOriginal;
    private ControladorPrincipal controladorPrincipal;

    public ControladorActualizarUsuario(VentanaActualizarUsuario vistaActualizarUsuario, UsuarioDAO usuarioDAO, Usuario usuarioOriginal, ControladorPrincipal controladorPrincipal) {
        this.vistaActualizarUsuario = vistaActualizarUsuario;
        this.usuarioDAO = usuarioDAO;
        this.usuarioOriginal = usuarioOriginal;
        this.controladorPrincipal = controladorPrincipal;

        cargarDatosUsuario();

        this.vistaActualizarUsuario.getBtnGuardarCambios().addActionListener(this);
        this.vistaActualizarUsuario.getBtnCancelar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaActualizarUsuario.getBtnGuardarCambios()) {
            guardarCambios();
        }

        if (e.getSource() == vistaActualizarUsuario.getBtnCancelar()) {
            vistaActualizarUsuario.dispose();
        }
    }

    private void cargarDatosUsuario() {
        vistaActualizarUsuario.getTxtUsuario().setText(usuarioOriginal.getUsuario());
        vistaActualizarUsuario.getTxtNombre().setText(usuarioOriginal.getNombre());
        vistaActualizarUsuario.getTxtApellido().setText(usuarioOriginal.getApellido());
        vistaActualizarUsuario.getTxtTelefono().setText(usuarioOriginal.getTelefono());
        vistaActualizarUsuario.getTxtCorreoElectronico().setText(usuarioOriginal.getCorreoElectronico());
        vistaActualizarUsuario.getTxtContrasena().setText(usuarioOriginal.getContrasena());
    }

    private void guardarCambios() {
        String usuario = vistaActualizarUsuario.getTxtUsuario().getText().trim();
        String nombre = vistaActualizarUsuario.getTxtNombre().getText().trim();
        String apellido = vistaActualizarUsuario.getTxtApellido().getText().trim();
        String telefono = vistaActualizarUsuario.getTxtTelefono().getText().trim();
        String correoElectronico = vistaActualizarUsuario.getTxtCorreoElectronico().getText().trim();
        String contrasena = new String(vistaActualizarUsuario.getTxtContrasena().getPassword()).trim();

        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(vistaActualizarUsuario, "Debe ingresar el usuario.");
            return;
        }

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(vistaActualizarUsuario, "Debe ingresar el nombre.");
            return;
        }

        if (apellido.isEmpty()) {
            JOptionPane.showMessageDialog(vistaActualizarUsuario, "Debe ingresar el apellido.");
            return;
        }

        if (telefono.isEmpty()) {
            JOptionPane.showMessageDialog(vistaActualizarUsuario, "Debe ingresar el teléfono.");
            return;
        }

        if (correoElectronico.isEmpty()) {
            JOptionPane.showMessageDialog(vistaActualizarUsuario, "Debe ingresar el correo electrónico.");
            return;
        }

        if (contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(vistaActualizarUsuario, "Debe ingresar la contraseña.");
            return;
        }

        Usuario usuarioActualizado = new Usuario();
        usuarioActualizado.setUsuario(usuario);
        usuarioActualizado.setNombre(nombre);
        usuarioActualizado.setApellido(apellido);
        usuarioActualizado.setTelefono(telefono);
        usuarioActualizado.setCorreoElectronico(correoElectronico);
        usuarioActualizado.setContrasena(contrasena);

        boolean actualizado = usuarioDAO.actualizarUsuario(usuarioOriginal, usuarioActualizado);

        if (actualizado) {
            JOptionPane.showMessageDialog(vistaActualizarUsuario, "Usuario actualizado correctamente.");
            controladorPrincipal.refrescarTablaUsuarios();
            vistaActualizarUsuario.dispose();
        } else {
            JOptionPane.showMessageDialog(vistaActualizarUsuario, "No se pudo actualizar el usuario.");
        }
    }
}