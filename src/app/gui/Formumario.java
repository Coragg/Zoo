package app.gui;

import app.bd.Conexion;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;



public class Formumario extends javax.swing.JFrame {

    private int id;
    public String nombre;
    private String tipo;
    private String categoria;
    private double  pesoMinimo;
    private double pesoMaximo;
    
   

    public Formumario() {
        initComponents();
        this.setTitle("Formulario de animales");
        this.setLocationRelativeTo(null);
        
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConexion();

        // Generar un número aleatorio para la id
        Random random = new Random();
        int numeroAleatorio = random.nextInt(129) + 1;

        try {
            // Crear un objeto PreparedStatement para ejecutar la consulta SQL
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM animal WHERE id=?");

            // Establecer el valor de la id en el objeto PreparedStatement
            ps.setInt(1, numeroAleatorio);

            // Ejecutar la consulta SQL
            ResultSet rs = ps.executeQuery();

            // Obtener los resultados
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                String categoria = rs.getString("categoria");
                double minimo = rs.getDouble("min");
                double maximo = rs.getDouble("max");
                this.id = id;
                this.nombre = nombre;
                this.tipo = tipo;
                this.categoria = categoria;
                this.pesoMinimo = minimo;
                this.pesoMaximo = maximo;

                jTextNombreAnimal.setText(this.nombre);
                jTextTipo.setText(this.tipo);
            }

            // Cerrar el objeto ResultSet, el objeto PreparedStatement y la conexión
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        VertebradoOinvertebrado = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jTextField16 = new javax.swing.JTextField();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTxIdAnimal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtPeso = new javax.swing.JTextField();
        jButGuardar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextNombreAnimal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jTextTipo = new javax.swing.JTextField();
        jLabelimagen = new javax.swing.JLabel();
        jTextColor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextNumeroPatas = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jTextNumeroAlas = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jBoxNumeroAletas = new javax.swing.JComboBox<>();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jScrollPane2.setViewportView(jEditorPane1);

        jTextField16.setText("jTextField16");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jLabel1.setText("Nombre:");

        jTxIdAnimal.setText("1");
        jTxIdAnimal.setEnabled(false);
        jTxIdAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxIdAnimalActionPerformed(evt);
            }
        });

        jLabel2.setText("Peso:");

        jTxtPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtPesoActionPerformed(evt);
            }
        });
        jTxtPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtPesoKeyTyped(evt);
            }
        });

        jButGuardar.setText("Guardar");
        jButGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButGuardarActionPerformed(evt);
            }
        });

        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalir(evt);
            }
        });

        jLabel3.setText("ID:");

        jTextNombreAnimal.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextNombreAnimal.setEnabled(false);
        jTextNombreAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreAnimalActionPerformed(evt);
            }
        });

        jLabel4.setText("Color:");

        jRadioButton1.setBackground(new java.awt.Color(0, 102, 255));
        VertebradoOinvertebrado.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButton1.setText("Vertebrado");
        jRadioButton1.setEnabled(false);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(0, 102, 255));
        VertebradoOinvertebrado.add(jRadioButton2);
        jRadioButton2.setText("Invertebrado");
        jRadioButton2.setEnabled(false);

        jLabel5.setText("Grupo o tipo:");

        jTextTipo.setEnabled(false);

        jLabelimagen.setText("imagen");

        jTextColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextColorActionPerformed(evt);
            }
        });
        jTextColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextColorKeyTyped(evt);
            }
        });

        jLabel8.setText("N° de Patas:");

        jTextNumeroPatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNumeroPatasActionPerformed(evt);
            }
        });
        jTextNumeroPatas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNumeroPatasKeyTyped(evt);
            }
        });

        jLabel9.setText("N° de Alas:");

        jLabel10.setText("N° de Aletas:");

        jLabel11.setText("Escamas:");

        jLabel12.setText("Piel anfibio:");

        jLabel13.setText("Tipo Reptil:");

        jTextField9.setText("(Tierra, mar o ambos.)");
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jLabel14.setText("N° pares de patas:");

        jTextField10.setText("(1 A 400 pares)");
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField10KeyTyped(evt);
            }
        });

        jLabel15.setText("Antenas:");

        jLabel16.setText("Tipo equinodermo:");

        jLabel17.setText("Cuerpo gusano:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Par de antenas", "Sin antenas" }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Erizo", "Estrella" }));

        jTextNumeroAlas.setEditable(false);
        jTextNumeroAlas.setText("2");
        jTextNumeroAlas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNumeroAlasActionPerformed(evt);
            }
        });
        jTextNumeroAlas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNumeroAlasKeyTyped(evt);
            }
        });

        jLabel18.setText("Tentáculos:");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contiene tentáculos", "No contiene" }));

        jBoxNumeroAletas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4", "5", "6" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(78, 78, 78)
                                .addComponent(jTxIdAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(60, 60, 60)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel13)
                                                    .addComponent(jLabel12))
                                                .addGap(45, 45, 45))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                            .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.TRAILING)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel5))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextNumeroAlas, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextNumeroPatas, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtPeso)
                                    .addComponent(jTextNombreAnimal)
                                    .addComponent(jTextColor)
                                    .addComponent(jTextTipo)
                                    .addComponent(jBoxNumeroAletas, 0, 152, Short.MAX_VALUE))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox4, 0, 1, Short.MAX_VALUE)
                                    .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jRadioButton2)
                        .addComponent(jRadioButton1)
                        .addComponent(jLabelimagen))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(50, 50, 50)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTxIdAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton2)
                        .addGap(110, 110, 110)
                        .addComponent(jLabelimagen))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextNombreAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel14)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextNumeroPatas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jTextNumeroAlas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel18)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBoxNumeroAletas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButGuardar)
                    .addComponent(jButton4))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxIdAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxIdAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxIdAnimalActionPerformed

    private void BtSalir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalir
        // TODO add your handling code here:
        // cierre de esta ventana con vuelta al menu principal
        MenuPrincipal vueltaMenu = new MenuPrincipal();
        vueltaMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtSalir

    private void jButGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButGuardarActionPerformed
        // TODO add your handling code here:
        // ESTE BOTÓN GENERARÁ EL ANIMAL ALEATORIO.
        
        if(jTxtPeso.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Es obligatorio colocar un valor en el peso.");
        } else {

            double peso = Double.parseDouble(jTxtPeso.getText());
            if(peso <= 0)
                JOptionPane.showMessageDialog(null, "Tiene que colocar un valor mayor a 0.");
            else if("Mamifero".equals(this.tipo)) {


                if(jTextNumeroPatas.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Tiene que ingresar el numero de patas del animal.");

                else if((this.nombre != "Delfin" || this.nombre != "Ballena" ) &&  Integer.parseInt(jTextNumeroPatas.getText()) < 1)
                    JOptionPane.showMessageDialog(null, "Tiene que ser mayor 0 a  el numero de patas.");
                else{
                    System.out.println("Weee, mandando datos a la base de datos. Sabia que no eras un idiota ");
                }

            }else if("Ave".equals(this.tipo)){
                if (jTextNumeroAlas.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Tiene que ingresar el numero de alas del animal.");
                else if(Integer.parseInt(jTextNumeroAlas.getText()) <= 0)
                    JOptionPane.showMessageDialog(null, "El numero de alas tiene que ser mayor a 0.");
                else {
                    System.out.println("Weee, mandando datos a la base de datos. Sabia que no eras un idiota ");
                }

            }else if("Pez".equals(this.tipo)){
                // para que mande a la base de datos


            }else if("Anfibio".equals(this.tipo)){

            }else if("Reptil".equals(this.tipo)){

            }else if("Artropodo".equals(this.tipo)){

            }else if ("Molusco".equals(this.tipo)){

            }else if ("Equinodermo".equals(this.tipo)){

            }else if ("Gusano".equals(this.tipo)){

            }else if ("Porifero".equals(this.tipo)){

            }else if ("Celentereo".equals(this.tipo)){

            }


        }
        

        
    }//GEN-LAST:event_jButGuardarActionPerformed

    private void jTxtPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtPesoActionPerformed

    private void jTxtPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtPesoKeyTyped
        // TODO add your handling code here:
        char caracteres = evt.getKeyChar();
        if(!Character.isDigit(caracteres) && caracteres != '.' && caracteres != KeyEvent.VK_BACK_SPACE){
            evt.consume();
        }
        // verificacion de un solo decimal
        if(caracteres == '.' && jTxtPeso.getText().contains(".")){
            evt.consume();
        }
    }//GEN-LAST:event_jTxtPesoKeyTyped

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jTextNombreAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreAnimalActionPerformed

    private void jTextColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextColorActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextNumeroPatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNumeroPatasActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextNumeroPatasActionPerformed

    private void jTextNumeroPatasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNumeroPatasKeyTyped
        // TODO add your handling code here:
        char caracteres = evt.getKeyChar();
        if (caracteres < '0' || caracteres > '9'){
            evt.consume();}
    }//GEN-LAST:event_jTextNumeroPatasKeyTyped

    private void jTextNumeroAlasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNumeroAlasKeyTyped
    char caracteres = evt.getKeyChar();
        if (caracteres < '0' || caracteres > '9'){
            evt.consume();
        }            // TODO add your handling code here:
    }//GEN-LAST:event_jTextNumeroAlasKeyTyped

    private void jTextField10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyTyped
    char caracteres = evt.getKeyChar();
        if (caracteres < '0' || caracteres > '9'){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10KeyTyped

    private void jTextNumeroAlasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNumeroAlasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNumeroAlasActionPerformed

    private void jTextColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextColorKeyTyped
        // TODO add your handling code here:
        char limitarCaracteres = evt.getKeyChar();
        if((limitarCaracteres<'a'||limitarCaracteres>'z') && (limitarCaracteres<'A'||limitarCaracteres>'Z') && (limitarCaracteres<' '||limitarCaracteres>' '))evt.consume();
        
    }//GEN-LAST:event_jTextColorKeyTyped

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
            java.util.logging.Logger.getLogger(Formumario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formumario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formumario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formumario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formumario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup VertebradoOinvertebrado;
    private javax.swing.JComboBox<String> jBoxNumeroAletas;
    private javax.swing.JButton jButGuardar;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelimagen;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextColor;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextNombreAnimal;
    private javax.swing.JTextField jTextNumeroAlas;
    private javax.swing.JTextField jTextNumeroPatas;
    private javax.swing.JTextField jTextTipo;
    private javax.swing.JTextField jTxIdAnimal;
    private javax.swing.JTextField jTxtPeso;
    // End of variables declaration//GEN-END:variables
}
