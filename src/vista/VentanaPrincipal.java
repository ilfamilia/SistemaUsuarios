package vista;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName());

    public VentanaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        scrollTablaUsuarios = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Usuarios");
        setResizable(false);

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 47, 108));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("USUARIOS REGISTRADOS");

        tablaUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Teléfono", "Correo electrónico", "Usuario"
            }
        ));
        tablaUsuarios.setGridColor(new java.awt.Color(220, 220, 220));
        tablaUsuarios.setRowHeight(28);
        tablaUsuarios.setSelectionBackground(new java.awt.Color(30, 110, 160));
        tablaUsuarios.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaUsuarios.setShowHorizontalLines(true);
        scrollTablaUsuarios.setViewportView(tablaUsuarios);

        btnNuevo.setBackground(new java.awt.Color(0, 98, 152));
        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("Nuevo");

        btnActualizar.setBackground(new java.awt.Color(220, 220, 220));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(40, 40, 40));
        btnActualizar.setText("Actualizar");

        btnEliminar.setBackground(new java.awt.Color(220, 220, 220));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(40, 40, 40));
        btnEliminar.setText("Eliminar");

        btnCerrarSesion.setBackground(new java.awt.Color(220, 220, 220));
        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(40, 40, 40));
        btnCerrarSesion.setText("Cerrar sesión");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollTablaUsuarios)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblTitulo)
                .addGap(32, 32, 32)
                .addComponent(scrollTablaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrarSesion)
                    .addComponent(btnEliminar)
                    .addComponent(btnActualizar)
                    .addComponent(btnNuevo))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JScrollPane scrollTablaUsuarios;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTable getTablaUsuarios() {
        return tablaUsuarios;
    }

    public javax.swing.JButton getBtnNuevo() {
        return btnNuevo;
    }

    public javax.swing.JButton getBtnActualizar() {
        return btnActualizar;
    }

    public javax.swing.JButton getBtnEliminar() {
        return btnEliminar;
    }

    public javax.swing.JButton getBtnCerrarSesion() {
        return btnCerrarSesion;
    }
    
    public void configurarTabla() {
        DefaultTableCellRenderer renderFila = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable tabla, Object valor, boolean seleccionado, boolean enfocado, int fila, int columna) {
                Component celda = super.getTableCellRendererComponent(tabla, valor, seleccionado, enfocado, fila, columna);

                setHorizontalAlignment(SwingConstants.CENTER);

                if (seleccionado) {
                    celda.setBackground(tabla.getSelectionBackground());
                    celda.setForeground(tabla.getSelectionForeground());
                } else {
                    if (fila % 2 == 0) {
                        celda.setBackground(Color.WHITE);
                    } else {
                        celda.setBackground(new Color(245, 245, 245));
                    }
                    celda.setForeground(new Color(60, 60, 60));
                }

                return celda;
            }
        };

        for (int i = 0; i < tablaUsuarios.getColumnCount(); i++) {
            tablaUsuarios.getColumnModel().getColumn(i).setCellRenderer(renderFila);
        }

        tablaUsuarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

        TableColumn columnaNombre = tablaUsuarios.getColumnModel().getColumn(0);
        TableColumn columnaApellido = tablaUsuarios.getColumnModel().getColumn(1);
        TableColumn columnaTelefono = tablaUsuarios.getColumnModel().getColumn(2);
        TableColumn columnaCorreo = tablaUsuarios.getColumnModel().getColumn(3);
        TableColumn columnaUsuario = tablaUsuarios.getColumnModel().getColumn(4);

        columnaNombre.setPreferredWidth(110);
        columnaApellido.setPreferredWidth(110);
        columnaTelefono.setPreferredWidth(100);
        columnaCorreo.setPreferredWidth(180);
        columnaUsuario.setPreferredWidth(100);

        JTableHeader encabezado = tablaUsuarios.getTableHeader();
        encabezado.setReorderingAllowed(false);
        encabezado.setPreferredSize(new java.awt.Dimension(encabezado.getWidth(), 32));

        encabezado.setFont(new Font("Segoe UI", Font.BOLD, 14));

        encabezado.setBackground(new Color(245, 245, 245)); 

        encabezado.setForeground(new Color(60, 60, 60));

        DefaultTableCellRenderer renderEncabezado = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable tabla, Object valor, boolean seleccionado, boolean enfocado, int fila, int columna) {
                Component celda = super.getTableCellRendererComponent(tabla, valor, seleccionado, enfocado, fila, columna);

                setHorizontalAlignment(SwingConstants.CENTER);

                celda.setBackground(new Color(245, 245, 245));
                celda.setForeground(new Color(60, 60, 60));
                celda.setFont(new Font("Segoe UI", Font.BOLD, 14));

                setBorder(new EmptyBorder(5, 5, 5, 5));

                return celda;
            }
        };

        encabezado.setDefaultRenderer(renderEncabezado);

        tablaUsuarios.setRowHeight(28);

        tablaUsuarios.setShowVerticalLines(false);
        tablaUsuarios.setShowHorizontalLines(false);
        tablaUsuarios.setIntercellSpacing(new java.awt.Dimension(0, 0));

        tablaUsuarios.setBorder(null);

        scrollTablaUsuarios.setBorder(null);
        scrollTablaUsuarios.setViewportBorder(null);

        tablaUsuarios.getTableHeader().setBorder(null);
    }
}
