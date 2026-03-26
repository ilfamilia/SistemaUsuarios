package controlador;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaRegistro;

public class ControladorPrincipal implements ActionListener {

    private VentanaPrincipal vistaPrincipal;
    private UsuarioDAO usuarioDAO;

    public ControladorPrincipal(VentanaPrincipal vistaPrincipal, UsuarioDAO usuarioDAO) {
        this.vistaPrincipal = vistaPrincipal;
        this.usuarioDAO = usuarioDAO;

        cargarUsuariosEnTabla();
        this.vistaPrincipal.getBtnNuevo().addActionListener(this);
        this.vistaPrincipal.getBtnActualizar().addActionListener(this);
    }

    private void cargarUsuariosEnTabla() {
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
            cargarUsuariosEnTabla();
        }
    }
}