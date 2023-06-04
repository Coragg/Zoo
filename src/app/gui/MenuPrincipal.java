package app.gui;

import app.bd.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import java.util.Random;
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        this.setTitle("Menu Principal");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        // Código para llenar la JTable con los datos de la tabla "animalesZoo"
        try {
            // Crear una instancia de la clase Conexion para obtener la conexión a la base de datos
            Conexion conexion = new Conexion();
            Connection conn = conexion.getConexion();

            // Crear la sentencia SQL para seleccionar todos los registros de la tabla "animalesZoo"
            String sql = "SELECT * FROM animalesZoo";

            // Crear un objeto Statement para ejecutar la consulta SQL
            Statement statement = conn.createStatement();

            // Ejecutar la consulta SQL y obtener el resultado en un objeto ResultSet
            ResultSet resultSet = statement.executeQuery(sql);

            // Crear un modelo de tabla por defecto para almacenar los datos de la consulta
            DefaultTableModel model = new DefaultTableModel();

            // Agregar las columnas al modelo de tabla
            model.addColumn("Id");
            model.addColumn("nombre");
            model.addColumn("color");
            model.addColumn("peso");
            model.addColumn("tipo");
            model.addColumn("Categoria");
            model.addColumn("Atributo");
            model.addColumn("Atributo Secundario");
            // Añadir más columnas según sea necesario

            // Recorrer el resultado de la consulta y agregar los datos al modelo de tabla
            while (resultSet.next()) {
                // Obtener los valores de cada columna en una fila
                Object[] row = new Object[8]; // Cambiar el tamaño según el número de columnas
                row[0] = resultSet.getObject("Id");
                row[1] = resultSet.getObject("Nombre");
                row[2] = resultSet.getObject("Color");
                row[3] = resultSet.getObject("Peso");
                row[4] = resultSet.getObject("Tipo");
                row[5] = resultSet.getObject("Categoria");
                // Añadir más columnas según sea necesario
                
                // Determinar el valor de la columna "categoria" en función del valor de "tipo"
                String tipo = resultSet.getString("tipo");
                if (tipo.equals("Mamifero")) {
                    row[6] = resultSet.getObject("cantidadPatas");
                    row[7] = "Null";
                } else if (tipo.equals("Ave")) {
                    row[6] = resultSet.getObject("cantidadAlas");
                    row[7] = "Null";
                } else if (tipo.equals("Pez")) {
                    row[6] = resultSet.getObject("cantidadAletas");
                    row[7] = resultSet.getObject("escamas");
                } else if (tipo.equals("Anfibio")) {
                    row[6] = resultSet.getObject("piel");
                    row[7] = "Null";
                } else if (tipo.equals("Reptil")) {
                    row[6] = resultSet.getObject("tierraMar_ambos");
                    row[7] = "Null";
                } else if (tipo.equals("Antropodo")) {
                    row[6] = resultSet.getObject("cantidadParesPatas");
                    row[7] = resultSet.getObject("antenas");
                } else if (tipo.equals("Molusco")) {
                    row[6] = resultSet.getObject("erizo_o_estrella");
                    row[7] = "Null";
                } else if (tipo.equals("Equinodermo")) {
                    row[6] = resultSet.getObject("erizo_o_estrella");
                    row[7] = "Null";
                } else if (tipo.equals("Gusano")) {
                    row[6] = resultSet.getObject("tipoCuerpo");
                    row[7] = "Null";
                } else if (tipo.equals("Porifero")) {
                    row[6] = "Null";
                    row[7] = "Null";
                } else if (tipo.equals("Celentereo")) {
                    row[6] = resultSet.getObject("tentaculos");
                    row[7] = "Null";
                }
    

                // Agregar la fila al modelo de tabla
                model.addRow(row);
            }

            // Asignar el modelo de tabla a la JTable
            jTable1.setModel(model);

            // Cerrar la conexión y liberar los recursos
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            // Manejar el error en caso de que ocurra una excepción
            ex.printStackTrace();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkbox3 = new java.awt.Checkbox();
        jButton1 = new javax.swing.JButton();
        panel1 = new java.awt.Panel();
        checkbox1 = new java.awt.Checkbox();
        jLabel1 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        checkbox3.setLabel("Cantidad por tipo o grupo");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panel1.setBackground(new java.awt.Color(0, 102, 255));
        panel1.setName(""); // NOI18N

        checkbox1.setLabel("checkbox1");

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel1.setText("Menu Principal");

        button1.setLabel("button1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setEnabled(false);
        jTable1.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Cerrar Sesión");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cerrar Programa");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Reporte Animal");
        jButton4.setToolTipText("");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Crear Animal");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(283, 283, 283))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jButton5)
                        .addGap(48, 48, 48)
                        .addComponent(jButton4)
                        .addGap(46, 46, 46)
                        .addComponent(jButton2)
                        .addGap(42, 42, 42)
                        .addComponent(jButton3))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         Login call = new Login();
        
        call.setVisible(true); //se hace visible la variable
        
        this.dispose(); //se utiliza para no acumular ventanas
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        MenuSecundario call = new MenuSecundario();
        call.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Random random = new Random();
        int numeroAleatorio = random.nextInt(129) + 1;
        Formumario mamifero = new Formumario();
        mamifero.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Checkbox checkbox1;
    private java.awt.Checkbox checkbox3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
