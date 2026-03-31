package controlador;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaRegistro;
import javax.swing.JOptionPane;
import vista.VentanaLogin;
import vista.VentanaActualizarUsuario;

// Controlador principal del sistema.
// Se encarga de gestionar la vista VentanaPrincipal y coordinar las operaciones
// de creación, actualización, eliminación y visualización de usuarios.
// Forma parte de la capa Controlador dentro de la arquitectura MVC.
public class ControladorPrincipal implements ActionListener {

    private VentanaPrincipal vistaPrincipal;
    private UsuarioDAO usuarioDAO;

    // Constructor que recibe la vista principal y el acceso a datos.
    // Inicializa la tabla de usuarios y registra los eventos de los botones.
    public ControladorPrincipal(VentanaPrincipal vistaPrincipal, UsuarioDAO usuarioDAO) {
        this.vistaPrincipal = vistaPrincipal;
        this.usuarioDAO = usuarioDAO;

        cargarUsuariosEnTabla();
        this.vistaPrincipal.getBtnNuevo().addActionListener(this);
        this.vistaPrincipal.getBtnActualizar().addActionListener(this);
        this.vistaPrincipal.getBtnEliminar().addActionListener(this);
        this.vistaPrincipal.getBtnCerrarSesion().addActionListener(this);
    }

    // Método que obtiene la lista de usuarios desde la base de datos
    // y la carga en el modelo de la tabla para mostrarla en la vista.
    public void cargarUsuariosEnTabla() {
        String[] columnas = {"Nombre", "Apellido", "Teléfono", "Correo electrónico", "Usuario"};

        DefaultTableModel modeloTabla = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        List<Usuario> listaUsuarios = usuarioDAO.listarUsuarios();

        for (Usuario usuario : listaUsuarios) {
            Object[] fila = {
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getTelefono(),
                usuario.getCorreoElectronico(),
                usuario.getUsuario()
            };

            modeloTabla.addRow(fila);
        }

        vistaPrincipal.getTablaUsuarios().setModel(modeloTabla);
        vistaPrincipal.configurarTabla();
    }
    
    // Método que maneja los eventos de los botones de la vista principal.
    // Permite abrir ventanas, actualizar la tabla, eliminar usuarios y cerrar sesión.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaPrincipal.getBtnNuevo()) {
            VentanaRegistro vistaRegistro = new VentanaRegistro();
            vistaRegistro.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    refrescarTablaUsuarios();
                }
            });

            ControladorRegistro controladorRegistro = new ControladorRegistro(vistaRegistro, usuarioDAO);
            vistaRegistro.setVisible(true);
        }

        if (e.getSource() == vistaPrincipal.getBtnActualizar()) {
            abrirVentanaActualizarUsuario();
        }
        
        if (e.getSource() == vistaPrincipal.getBtnEliminar()) {
            eliminarUsuarioSeleccionado();
        }
        
        if (e.getSource() == vistaPrincipal.getBtnCerrarSesion()) {
            cerrarSesion();
        }
    }
    
    // Método que elimina el usuario seleccionado en la tabla.
    // Solicita confirmación antes de realizar la eliminación y actualiza la vista.
    private void eliminarUsuarioSeleccionado() {
        int filaSeleccionada = vistaPrincipal.getTablaUsuarios().getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vistaPrincipal, "Debe seleccionar un usuario para eliminar.");
            return;
        }

        String usuario = vistaPrincipal.getTablaUsuarios().getValueAt(filaSeleccionada, 4).toString();

        int confirmacion = JOptionPane.showConfirmDialog(
                vistaPrincipal,
                "¿Está seguro de eliminar el usuario seleccionado?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            boolean eliminado = usuarioDAO.eliminarUsuarioPorUsuario(usuario);

            if (eliminado) {
                JOptionPane.showMessageDialog(vistaPrincipal, "Usuario eliminado correctamente.");
                cargarUsuariosEnTabla();
            } else {
                JOptionPane.showMessageDialog(vistaPrincipal, "No se pudo eliminar el usuario.");
            }
        }
    }
    
    // Método que cierra la sesión actual y regresa a la ventana de login.
    private void cerrarSesion() {
        VentanaLogin vistaLogin = new VentanaLogin();
        ControladorLogin controladorLogin = new ControladorLogin(vistaLogin, usuarioDAO);
        vistaLogin.setVisible(true);
        vistaPrincipal.dispose();
    }
    
    // Método que abre la ventana de actualización para el usuario seleccionado.
    // Obtiene los datos del usuario y los envía al controlador correspondiente.
    private void abrirVentanaActualizarUsuario() {
        int filaSeleccionada = vistaPrincipal.getTablaUsuarios().getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vistaPrincipal, "Debe seleccionar un usuario para actualizar.");
            return;
        }

        String usuario = vistaPrincipal.getTablaUsuarios().getValueAt(filaSeleccionada, 4).toString();
        Usuario usuarioSeleccionado = usuarioDAO.buscarUsuarioPorUsuario(usuario);

        if (usuarioSeleccionado != null) {
            VentanaActualizarUsuario vistaActualizarUsuario = new VentanaActualizarUsuario();
            ControladorActualizarUsuario controladorActualizarUsuario
                    = new ControladorActualizarUsuario(vistaActualizarUsuario, usuarioDAO, usuarioSeleccionado, this);
            vistaActualizarUsuario.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(vistaPrincipal, "No se encontró el usuario seleccionado.");
        }
    }
    
    // Método público que permite recargar la tabla de usuarios desde otros controladores.
    public void refrescarTablaUsuarios() {
        cargarUsuariosEnTabla();
    }
}