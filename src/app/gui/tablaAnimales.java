/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app.gui;

import app.bd.Conexion;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class tablaAnimales extends javax.swing.JFrame {

    private int filaSeleccionada;

   
    public tablaAnimales() {
        initComponents();
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarAnimal();
            }
        });
        
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    filaSeleccionada = jTable1.getSelectedRow();
                }
            }
        });


        
        this.setTitle("Animales con sus caracteristicas");
        this.setLocationRelativeTo(null);
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
                } else if (tipo.equals("Artropodo")) {
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
            this.jTable1.setModel(model);

            // Cerrar la conexión y liberar los recursos
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            // Manejar el error en caso de que ocurra una excepción
            ex.printStackTrace();
        }
    }


    
    private void actualizarTablaAnimales() {
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
            } else if (tipo.equals("Artropodo")) {
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

        // Cerrar la conexión y liberar los recursos
        resultSet.close();
        statement.close();
        conn.close();

        // Establecer el modelo de tabla actualizado en la JTable
        jTable1.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        
    }
    
    
    


    
    private void eliminarAnimal() {
        // Obtiene la fila seleccionada en la tabla
        filaSeleccionada = jTable1.convertRowIndexToModel(jTable1.getSelectedRow());


        // Verifica si se ha seleccionado una fila
        if (filaSeleccionada >= 0) {
            // Obtén el valor del campo "Id" de la fila seleccionada
            String idAnimal = jTable1.getValueAt(filaSeleccionada, 0).toString();

            try {
                // Crea una instancia de la clase Conexion para obtener la conexión a la base de datos
                Conexion conexion = new Conexion();
                Connection conn = conexion.getConexion();

                // Crea la sentencia SQL para eliminar el animal con el Id correspondiente
                String sql = "DELETE FROM animalesZoo WHERE Id = ?";

                // Crea un objeto PreparedStatement para ejecutar la consulta SQL
                PreparedStatement statement = conn.prepareStatement(sql);

                // Establece el valor del parámetro en la sentencia SQL
                statement.setString(1, idAnimal);

                // Ejecuta la consulta SQL
                int filasAfectadas = statement.executeUpdate();

                if (filasAfectadas > 0) {
                    // Actualiza la tabla para reflejar los cambios
                    actualizarTablaAnimales();
                    JOptionPane.showMessageDialog(null, "Animal eliminado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null,"No se pudo eliminar el animal");
                }

                // Cierra la conexión y libera los recursos
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                // Maneja el error en caso de que ocurra una excepción
                ex.printStackTrace();
            }
        } else {
            System.out.println("No se ha seleccionado ninguna fila");
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonEliminar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jTable1.setAutoCreateRowSorter(true);
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
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTable1);
        jTable1.getTableHeader().setReorderingAllowed(false) ;

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel1.setText("Tabla Animales");

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonEliminar)
                                .addGap(30, 30, 30)
                                .addComponent(jButton1)
                                .addGap(23, 23, 23)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MenuSecundario MenuSecundario = new MenuSecundario();
        MenuSecundario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Modificar modificar = new Modificar();
        modificar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    

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
            java.util.logging.Logger.getLogger(tablaAnimales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tablaAnimales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tablaAnimales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tablaAnimales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tablaAnimales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
