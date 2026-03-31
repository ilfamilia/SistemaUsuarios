package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.VentanaActualizarUsuario;

// Controlador encargado de gestionar la actualización de usuarios.
// Recibe los datos del usuario seleccionado, los muestra en la vista,
// valida los cambios y actualiza la información en la base de datos.
// Forma parte de la capa Controlador en la arquitectura MVC.
public class ControladorActualizarUsuario implements ActionListener {

    private VentanaActualizarUsuario vistaActualizarUsuario;
    private UsuarioDAO usuarioDAO;
    private Usuario usuarioOriginal;
    private ControladorPrincipal controladorPrincipal;

    // Constructor que recibe la vista, el acceso a datos, el usuario original
    // y una referencia al controlador principal para actualizar la tabla.
    // También inicializa los eventos de la interfaz.
    public ControladorActualizarUsuario(VentanaActualizarUsuario vistaActualizarUsuario, UsuarioDAO usuarioDAO, Usuario usuarioOriginal, ControladorPrincipal controladorPrincipal) {
        this.vistaActualizarUsuario = vistaActualizarUsuario;
        this.usuarioDAO = usuarioDAO;
        this.usuarioOriginal = usuarioOriginal;
        this.controladorPrincipal = controladorPrincipal;

        cargarDatosUsuario();

        this.vistaActualizarUsuario.getBtnGuardarCambios().addActionListener(this);
        this.vistaActualizarUsuario.getBtnCancelar().addActionListener(this);
    }

    // Método que maneja los eventos de los botones de la vista.
    // Permite guardar cambios o cancelar la operación.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaActualizarUsuario.getBtnGuardarCambios()) {
            guardarCambios();
        }

        if (e.getSource() == vistaActualizarUsuario.getBtnCancelar()) {
            vistaActualizarUsuario.dispose();
        }
    }

    // Método que carga los datos del usuario seleccionado en los campos
    // de la interfaz para permitir su edición.
    private void cargarDatosUsuario() {
        vistaActualizarUsuario.getTxtUsuario().setText(usuarioOriginal.getUsuario());
        vistaActualizarUsuario.getTxtNombre().setText(usuarioOriginal.getNombre());
        vistaActualizarUsuario.getTxtApellido().setText(usuarioOriginal.getApellido());
        vistaActualizarUsuario.getTxtTelefono().setText(usuarioOriginal.getTelefono());
        vistaActualizarUsuario.getTxtCorreoElectronico().setText(usuarioOriginal.getCorreoElectronico());
        vistaActualizarUsuario.getTxtContrasena().setText(usuarioOriginal.getContrasena());
    }

    // Método que valida los datos modificados por el usuario,
    // verifica duplicados y actualiza la información en la base de datos.
    // Si la actualización es exitosa, refresca la tabla principal.
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
        
        if (usuarioDAO.existeOtroUsuarioOCorreo(usuarioOriginal.getId(), usuario, correoElectronico)) {
            JOptionPane.showMessageDialog(vistaActualizarUsuario, "El usuario o el correo electrónico ya están registrados en otro usuario.");
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