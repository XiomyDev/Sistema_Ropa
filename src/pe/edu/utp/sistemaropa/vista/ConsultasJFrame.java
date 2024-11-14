/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pe.edu.utp.sistemaropa.vista;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.utp.sistemaropa.DaoImpl.ClienteDaoImpl;
import pe.edu.utp.sistemaropa.DaoImpl.FacturaDaoImpl;
import pe.edu.utp.sistemaropa.DaoImpl.HistorialDaoImpl;
import pe.edu.utp.sistemaropa.DaoImpl.ProductoDaoImpl;
import pe.edu.utp.sistemaropa.DaoImpl.ProveedorDaoImpl;
import pe.edu.utp.sistemaropa.DaoImpl.VendedorDaoImpl;
import pe.edu.utp.sistemaropa.dto.Cliente;
import pe.edu.utp.sistemaropa.dto.Factura;
import pe.edu.utp.sistemaropa.dto.Historial;
import pe.edu.utp.sistemaropa.dto.Producto;
import pe.edu.utp.sistemaropa.dto.Proveedor;
import pe.edu.utp.sistemaropa.dto.Vendedor;

/**
 *
 * @author Nayely
 */
public class ConsultasJFrame extends javax.swing.JFrame {

    Cliente c = new Cliente();
    ClienteDaoImpl cli = new ClienteDaoImpl();

    Producto p = new Producto();
    ProductoDaoImpl pro = new ProductoDaoImpl();

    Proveedor pv = new Proveedor();
    ProveedorDaoImpl prov = new ProveedorDaoImpl();

    Historial h = new Historial();
    HistorialDaoImpl hi = new HistorialDaoImpl();

    Factura f = new Factura();
    FacturaDaoImpl fdi = new FacturaDaoImpl();

    Vendedor v = new Vendedor();
    VendedorDaoImpl vende = new VendedorDaoImpl();

    DefaultTableModel modelo = new DefaultTableModel();

    /**
     * Creates new form ConsultasJFrame
     */
    public ConsultasJFrame() {
        initComponents();
        ListarCliente();
        ListarProducto();
        ListarProveedor();
        ListarHistorial();
        ListarFactura();
        ListarVendedor();
        
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        ConsultaClienteJFrame = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        ConsultaProductosJFrame = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        ConsultaProveedorJFrame = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProveedor = new javax.swing.JTable();
        ConsultaHistorialJFrame = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHistorial = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblFacturas = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbIVendedor = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Ink Free", 1, 48)); // NOI18N
        jLabel6.setText("Consultas");

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "APELLIDO", "DNI", "TELÉFONO", "DIRECCIÓN", "RUC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCliente.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbCliente);

        javax.swing.GroupLayout ConsultaClienteJFrameLayout = new javax.swing.GroupLayout(ConsultaClienteJFrame);
        ConsultaClienteJFrame.setLayout(ConsultaClienteJFrameLayout);
        ConsultaClienteJFrameLayout.setHorizontalGroup(
            ConsultaClienteJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultaClienteJFrameLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        ConsultaClienteJFrameLayout.setVerticalGroup(
            ConsultaClienteJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultaClienteJFrameLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CLIENTES", ConsultaClienteJFrame);

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "NOMBRE", "PRECIO", "STOCK", "PROVEEDOR", "FECHA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblProducto);

        javax.swing.GroupLayout ConsultaProductosJFrameLayout = new javax.swing.GroupLayout(ConsultaProductosJFrame);
        ConsultaProductosJFrame.setLayout(ConsultaProductosJFrameLayout);
        ConsultaProductosJFrameLayout.setHorizontalGroup(
            ConsultaProductosJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultaProductosJFrameLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        ConsultaProductosJFrameLayout.setVerticalGroup(
            ConsultaProductosJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultaProductosJFrameLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PRODUCTOS", ConsultaProductosJFrame);

        tblProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "NOMBRE", "TELÉFONO", "DIRECCIÓN", "NOMBRE DE RAZÓN", "RUC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProveedor.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tblProveedor);

        javax.swing.GroupLayout ConsultaProveedorJFrameLayout = new javax.swing.GroupLayout(ConsultaProveedorJFrame);
        ConsultaProveedorJFrame.setLayout(ConsultaProveedorJFrameLayout);
        ConsultaProveedorJFrameLayout.setHorizontalGroup(
            ConsultaProveedorJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultaProveedorJFrameLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        ConsultaProveedorJFrameLayout.setVerticalGroup(
            ConsultaProveedorJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultaProveedorJFrameLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PROVEEDOR", ConsultaProveedorJFrame);

        tblHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "NOMBRE", "DNI", "TOTAL PAGO", "TOTAL", "PAGO", "VUELTO", "FECHA Y HORA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHistorial.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblHistorial);

        javax.swing.GroupLayout ConsultaHistorialJFrameLayout = new javax.swing.GroupLayout(ConsultaHistorialJFrame);
        ConsultaHistorialJFrame.setLayout(ConsultaHistorialJFrameLayout);
        ConsultaHistorialJFrameLayout.setHorizontalGroup(
            ConsultaHistorialJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultaHistorialJFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        ConsultaHistorialJFrameLayout.setVerticalGroup(
            ConsultaHistorialJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultaHistorialJFrameLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("HISTORIAL", ConsultaHistorialJFrame);

        tblFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "DESCRIPCIÓN", "CANTIDAD", "PRECIO", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFacturas.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tblFacturas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("FACTURAS", jPanel3);

        tbIVendedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "NOMBRE", "PRECIO", "DNI", "TELÉFONO", "ROL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbIVendedor.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tbIVendedor);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("VENDEDORES", jPanel4);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/sistemaropa/img/regresar.png"))); // NOI18N
        btnSalir.setContentAreaFilled(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnSalir)
                        .addGap(210, 210, 210)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(btnSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        MenuVendedoresJFrame a = new MenuVendedoresJFrame();

        int confirm = JOptionPane.showConfirmDialog(a, "¿Desea salir?", "Confirmación de Salida", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            a.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    void ListarCliente() {
        DefaultTableModel modelo = (DefaultTableModel) tbCliente.getModel();
        modelo.setRowCount(0);
        modelo.setColumnCount(0);

        modelo.setColumnIdentifiers(new Object[]{"ID Cliente", "Nombre", "Apellido", "DNI", "Contacto", "Dirección", "RUC"});

        List<Cliente> listar = cli.readAll();
        for (Cliente cliente : listar) {
            Object[] ob = new Object[7];
            ob[0] = cliente.getIdcliente();
            ob[1] = cliente.getNombre();
            ob[2] = cliente.getApellido();
            ob[3] = cliente.getDni();
            ob[4] = cliente.getTelefono();
            ob[5] = cliente.getDireccion();
            ob[6] = cliente.getRuc();
            modelo.addRow(ob);
        }
    }

    void ListarProducto() {
        DefaultTableModel modelo = (DefaultTableModel) tblProducto.getModel();
        modelo.setRowCount(0);
        modelo.setColumnCount(0);

        modelo.setColumnIdentifiers(new Object[]{"ID Producto", "Nombre", "Stock", "Precio"});

        List<Producto> listar = pro.readAll();
        for (Producto producto : listar) {
            Object[] ob = new Object[4];
            ob[0] = producto.getIdproducto();
            ob[1] = producto.getNombre();
            ob[2] = producto.getStock();
            ob[3] = producto.getPrecio();
            modelo.addRow(ob);
        }
    }

    void ListarProveedor() {
        DefaultTableModel modelo = (DefaultTableModel) tblProveedor.getModel();
        modelo.setRowCount(0);
        modelo.setColumnCount(0);

        modelo.setColumnIdentifiers(new Object[]{"ID Proveedor", "Nombre", "Teléfono", "Dirección", "Razón", "RUC"});

        List<Proveedor> listar = prov.readAll();
        for (Proveedor proveedor : listar) {
            Object[] ob = new Object[6];
            ob[0] = proveedor.getIdProveedor();
            ob[1] = proveedor.getNombre();
            ob[2] = proveedor.getTelefono();
            ob[3] = proveedor.getDireccion();
            ob[4] = proveedor.getRazon();
            ob[5] = proveedor.getRuc();
            modelo.addRow(ob);
        }
    }

    void ListarHistorial() {
        DefaultTableModel modelo = (DefaultTableModel) tblHistorial.getModel();
        modelo.setRowCount(0);
        modelo.setColumnCount(0);

        modelo.setColumnIdentifiers(new Object[]{"Nombre", "Apellido", "DNI", "RUC", "Fecha", "Total", "Pago", "Vuelto"});

        List<Historial> listar = hi.readAll();
        for (Historial historial : listar) {
            Object[] ob = new Object[8];

            ob[0] = historial.getNombre();
            ob[1] = historial.getApellido();
            ob[2] = historial.getDNI();
            ob[3] = historial.getRuc();
            ob[4] = historial.getFecha();
            ob[5] = historial.getTotal();
            ob[6] = historial.getPago();
            ob[7] = historial.getVuelto();
            modelo.addRow(ob);
        }
    }

    void ListarFactura() {
        DefaultTableModel modelo = (DefaultTableModel) tblFacturas.getModel();
        modelo.setRowCount(0);
        modelo.setColumnCount(0);

        modelo.setColumnIdentifiers(new Object[]{"ID Factura", "Nombre", "DNI", "RUC", "Fecha", "Total", "Pago", "Vuelto"});

        List<Factura> listar = fdi.readAll();
        for (Factura factura : listar) {
            Object[] ob = new Object[8];
            ob[0] = factura.getIdFactura();
            ob[1] = factura.getNombre();
            ob[2] = factura.getDNI();
            ob[3] = factura.getRuc();
            ob[4] = factura.getFecha();
            ob[5] = factura.getTotal();
            ob[6] = factura.getPago();
            ob[7] = factura.getVuelto();
            modelo.addRow(ob);
        }
    }

    void ListarVendedor() {
        DefaultTableModel modelo = (DefaultTableModel) tbIVendedor.getModel();
        modelo.setRowCount(0);
        modelo.setColumnCount(0);

        modelo.setColumnIdentifiers(new Object[]{"ID VENDEDOR", "Nombre", "Apellido", "Contacto", "DNI", "ID USUARIO"});

        List<Vendedor> listar = vende.readAll();
        for (Vendedor vendedor : listar) {
            Object[] ob = new Object[6];
            ob[0] = vendedor.getIdVendedor();
            ob[1] = vendedor.getNombre();
            ob[2] = vendedor.getApellido();
            ob[3] = vendedor.getTelefono();
            ob[4] = vendedor.getDNI();
            ob[5] = vendedor.getIdUsuario();
            modelo.addRow(ob);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultasJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultasJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultasJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultasJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultasJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ConsultaClienteJFrame;
    private javax.swing.JPanel ConsultaHistorialJFrame;
    private javax.swing.JPanel ConsultaProductosJFrame;
    private javax.swing.JPanel ConsultaProveedorJFrame;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbCliente;
    private javax.swing.JTable tbIVendedor;
    private javax.swing.JTable tblFacturas;
    private javax.swing.JTable tblHistorial;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTable tblProveedor;
    // End of variables declaration//GEN-END:variables
}
