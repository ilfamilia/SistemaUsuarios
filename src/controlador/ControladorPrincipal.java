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

public class ControladorPrincipal implements ActionListener {

    private VentanaPrincipal vistaPrincipal;
    private UsuarioDAO usuarioDAO;

    public ControladorPrincipal(VentanaPrincipal vistaPrincipal, UsuarioDAO usuarioDAO) {
        this.vistaPrincipal = vistaPrincipal;
        this.usuarioDAO = usuarioDAO;

        cargarUsuariosEnTabla();
        this.vistaPrincipal.getBtnNuevo().addActionListener(this);
        this.vistaPrincipal.getBtnActualizar().addActionListener(this);
        this.vistaPrincipal.getBtnEliminar().addActionListener(this);
        this.vistaPrincipal.getBtnCerrarSesion().addActionListener(this);
    }

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
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaPrincipal.getBtnNuevo()) {
            VentanaRegistro vistaRegistro = new VentanaRegistro();
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
    
    private void cerrarSesion() {
        VentanaLogin vistaLogin = new VentanaLogin();
        ControladorLogin controladorLogin = new ControladorLogin(vistaLogin, usuarioDAO);
        vistaLogin.setVisible(true);
        vistaPrincipal.dispose();
    }
    
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
    
    public void refrescarTablaUsuarios() {
        cargarUsuariosEnTabla();
    }
}