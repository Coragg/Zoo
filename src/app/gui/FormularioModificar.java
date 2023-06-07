package app.gui;

import app.bd.Conexion;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;



public class FormularioModificar extends javax.swing.JFrame {

    public int id;
    public String nombre;
    public String tipo;
    public String categoria;
    private double  pesoMinimo;
    private double pesoMaximo;
   
    


    public FormularioModificar() {
        initComponents();
        this.setTitle("Formulario de animales");
        this.setLocationRelativeTo(null);
        
        
        
        
        //conectar base de datos
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConexion();
        

        // Generar un número aleatorio para la id
        Random random = new Random();
        int numeroAleatorio = random.nextInt(129) + 1;

        try {
            // Crear un objeto PreparedStatement para ejecutar la consulta SQL
            PreparedStatement insertarDatosTabla = connection.prepareStatement("SELECT * FROM animal WHERE id=?");
            PreparedStatement obtencionId =  connection.prepareStatement("SELECT seq FROM sqlite_sequence WHERE name='animalesZoo'");

            // Establecer el valor de la id en el objeto PreparedStatement
            insertarDatosTabla.setInt(1, numeroAleatorio);

            // Ejecutar la consulta SQL
            ResultSet rs = insertarDatosTabla.executeQuery();
            ResultSet searchId = obtencionId.executeQuery();

            while(searchId.next()){
                this.id = searchId.getInt("seq");
                jTxIdAnimal.setText(String.valueOf(this.id + 1));
            }

            // Obtener los resultados
            while(rs.next()) {
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                String categoria = rs.getString("categoria");
                double minimo = rs.getDouble("min");
                double maximo = rs.getDouble("max");
                // poner datos en variables globales
                this.nombre = nombre;
                this.tipo = tipo;
                this.categoria = categoria;
                this.pesoMinimo = minimo;
                this.pesoMaximo = maximo;

                jTextNombreAnimal.setText(this.nombre);
                jTextTipo.setText(this.tipo);
                jTextCategoria.setText(this.categoria);
            }
            String nombreAnimalito = jTextNombreAnimal.getText();
            String directorio_fotos = "src\\image\\animales\\" + nombreAnimalito + ".jpg" ;
            ImageIcon imagen = new ImageIcon(directorio_fotos);
            Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(200, 200, 1));
            jLabelimagen.setIcon(icono);

            // Cerrar el objeto ResultSet, el objeto PreparedStatement y la conexión
            rs.close();
            searchId.close();
            insertarDatosTabla.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        jLabelAtributo3.setVisible(false);
        jComboBoxAtributo3.setVisible(false);
        switch (this.tipo) {
            case "Mamifero":
                jLabelAtributo2.setVisible(false);
                jComboBoxAtributo2.setVisible(false);
                jLabelAtributo1.setText("Cantidad de patas");
                break;
            case "Ave":
                jLabelAtributo2.setVisible(false);
                jComboBoxAtributo2.setVisible(false);
                jLabelAtributo1.setText("N° de Alas");
                
                break;
            case "Pez":
                jLabelAtributo1.setVisible(false);
                jTextAtributo1.setVisible(false);
                jLabelAtributo3.setVisible(true);
                jComboBoxAtributo3.setVisible(true);
                jLabelAtributo2.setText("N° de aletas");
                jLabelAtributo3.setText("Escamas");
                jComboBoxAtributo2.addItem("4");
                jComboBoxAtributo2.addItem("5");
                jComboBoxAtributo2.addItem("6");
                jComboBoxAtributo3.addItem("Si");
                jComboBoxAtributo3.addItem("No");
                break;
            case "Anfibio":
                jLabelAtributo1.setVisible(false);
                jTextAtributo1.setVisible(false);
                jLabelAtributo2.setText("Piel anfibio");
                jComboBoxAtributo2.addItem("si");
                jComboBoxAtributo2.addItem("no");
                break;
            case "Reptil":
                jLabelAtributo1.setVisible(false);
                jTextAtributo1.setVisible(false);
                jLabelAtributo2.setText("Habitat reptil");
                jComboBoxAtributo2.addItem("Tierra");
                jComboBoxAtributo2.addItem("Mar");
                jComboBoxAtributo2.addItem("Ambos");
                break;
            case "Artropodo":
                jLabelAtributo1.setText("N° pares de patas");
                jLabelAtributo2.setText("Antenas");
                jComboBoxAtributo2.addItem("Par de antenas");
                jComboBoxAtributo2.addItem("Sin antenas");
                break;
            case "Molusco":
                jLabelAtributo1.setVisible(false);
                jTextAtributo1.setVisible(false);
                jLabelAtributo2.setText("Tipo Cuerpo");
                jComboBoxAtributo2.addItem("Erizo");
                jComboBoxAtributo2.addItem("Estrella");
                break;
            case "Equinodermo":
                jLabelAtributo1.setVisible(false);
                jTextAtributo1.setVisible(false);
                jLabelAtributo2.setText("Tipo Cuerpo");
                jComboBoxAtributo2.addItem("Erizo");
                jComboBoxAtributo2.addItem("Estrella");
                break;
            case "Gusano":
                jLabelAtributo1.setVisible(false);
                jTextAtributo1.setVisible(false);
                jLabelAtributo2.setText("Cuerpo gusano");
                jComboBoxAtributo2.addItem("Si");
                jComboBoxAtributo2.addItem("No");
                break;
            case "Porifero":
                jLabelAtributo2.setVisible(false);
                jLabelAtributo1.setVisible(false);
                jComboBoxAtributo2.setVisible(false);
                jTextAtributo1.setVisible(false);
                break;
            case "Celentereo":
                jLabelAtributo1.setVisible(false);
                jTextAtributo1.setVisible(false);
                jLabelAtributo2.setText("Tentaculos");
                jComboBoxAtributo2.addItem("Contiene tentaculos");
                jComboBoxAtributo2.addItem("No contiene");
                break;
            default:
                break;
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
        jLabel5 = new javax.swing.JLabel();
        jTextTipo = new javax.swing.JTextField();
        jTextColor = new javax.swing.JTextField();
        jLabelAtributo1 = new javax.swing.JLabel();
        jTextAtributo1 = new javax.swing.JTextField();
        jLabelAtributo2 = new javax.swing.JLabel();
        jComboBoxAtributo2 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabelimagen = new javax.swing.JLabel();
        jTextCategoria = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabelAtributo3 = new javax.swing.JLabel();
        jComboBoxAtributo3 = new javax.swing.JComboBox<>();

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

        jTextNombreAnimal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextNombreAnimal.setEnabled(false);
        jTextNombreAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreAnimalActionPerformed(evt);
            }
        });

        jLabel4.setText("Color:");

        jLabel5.setText("Grupo o tipo:");

        jTextTipo.setEnabled(false);
        jTextTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTipoActionPerformed(evt);
            }
        });

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

        jLabelAtributo1.setText("Atributo1");

        jTextAtributo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextAtributo1ActionPerformed(evt);
            }
        });
        jTextAtributo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAtributo1KeyTyped(evt);
            }
        });

        jLabelAtributo2.setText("Atributo2");

        jPanel2.setPreferredSize(new java.awt.Dimension(200, 200));

        jLabelimagen.setText("imagen");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabelimagen)
                .addGap(0, 160, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabelimagen)
                .addGap(0, 184, Short.MAX_VALUE))
        );

        jTextCategoria.setEditable(false);
        jTextCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCategoriaActionPerformed(evt);
            }
        });

        jLabel6.setText("Categoria:");

        jLabelAtributo3.setText("Atributo3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabelAtributo1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextAtributo1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButGuardar)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextNombreAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxIdAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextColor, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelAtributo2)
                            .addComponent(jLabelAtributo3)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxAtributo3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxAtributo2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxIdAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAtributo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAtributo2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextNombreAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAtributo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAtributo3))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jTextCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAtributo1)
                            .addComponent(jTextAtributo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButGuardar))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCategoriaActionPerformed

    private void jTextAtributo1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAtributo1KeyTyped
        // TODO add your handling code here:
        char caracteres = evt.getKeyChar();
        if (caracteres < '0' || caracteres > '9'){
            evt.consume();}
    }//GEN-LAST:event_jTextAtributo1KeyTyped

    private void jTextAtributo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAtributo1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextAtributo1ActionPerformed

    private void jTextColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextColorKeyTyped
        // TODO add your handling code here:
        char limitarCaracteres = evt.getKeyChar();
        if((limitarCaracteres<'a'||limitarCaracteres>'z') && (limitarCaracteres<'A'||limitarCaracteres>'Z') && (limitarCaracteres<' '||limitarCaracteres>' '))evt.consume();

    }//GEN-LAST:event_jTextColorKeyTyped

    private void jTextColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextColorActionPerformed

    private void jTextTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTipoActionPerformed

    private void jTextNombreAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreAnimalActionPerformed

    private void BtSalir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalir
        // TODO add your handling code here:
        // cierre de esta ventana con vuelta al menu principal
        TablaAnimales mostrarTabla = new TablaAnimales();
        mostrarTabla.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtSalir

    private void jButGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButGuardarActionPerformed
        // TODO add your handling code here:
        // ESTE BOTÓN GENERARÁ EL ANIMAL ALEATORIO.
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConexion(); // generar coneccion a la base de datos

        if(jTxtPeso.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor en peso.");
        } else {
            String color = jTextColor.getText();
            double peso = Double.parseDouble(jTxtPeso.getText());

            if(peso < this.pesoMinimo || peso > this.pesoMaximo)
            JOptionPane.showMessageDialog(null, "Error. Ingrese un valor mayor que " + pesoMinimo + " y menor que " + pesoMaximo + " kilógramos(KG).");

            else if(jTextColor.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Debe ingresar un color.");

            else if ("Mamifero".equals(this.tipo)) {
                if (jTextAtributo1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Tiene que ingresar el número de patas del animal.");
                } 
                else if ((!"Delfin".equals(this.nombre) && !"Ballena".equals(this.nombre)) && Integer.parseInt(jTextAtributo1.getText()) < 1) {
                    JOptionPane.showMessageDialog(null, "El número de patas debe ser mayor a 0.");
                   }
                else if (Integer.parseInt(jTextAtributo1.getText()) > 4){
                    JOptionPane.showMessageDialog(null, "Error. El número de patas debe ser menor que 5.");
                    
                }
                
                else {
                    String nombreAnimal = this.nombre;
                    int cantidadPatas = Integer.parseInt(jTextAtributo1.getText());
                    try {
                        String sql = "INSERT INTO animalesZoo(nombre, color, peso, tipo, categoria, cantidadPatas) VALUES (?, ?, ?, ?, ?, ?)";
                        PreparedStatement statement = connection.prepareStatement(sql);

                        statement.setString(1, nombreAnimal);
                        statement.setString(2, color);
                        statement.setDouble(3, peso);
                        statement.setString(4, this.tipo);
                        statement.setString(5, this.categoria);
                        statement.setInt(6, cantidadPatas);

                        statement.executeUpdate();
                        System.out.println("Los datos han sido enviados");
                        MenuPrincipal menu =  new MenuPrincipal();
                        menu.setVisible(true);
                        this.dispose();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Weee, mandando datos a la base de datos. Sabía que no eras un idiota.");
                }
            }else if("Ave".equals(this.tipo)){
                if (jTextAtributo1.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Debe ingresar el N° de alas del ave.");
                else if(Integer.parseInt(jTextAtributo1.getText()) <= 0)
                JOptionPane.showMessageDialog(null, "Error. El número de alas debe mayor que 0.");
                else if(Integer.parseInt(jTextAtributo1.getText()) > 2)
                JOptionPane.showMessageDialog(null, "Error. El número de alas debe ser menor que 2.");
                else {
                    int cantidadAlas = Integer.parseInt(jTextAtributo1.getText());
                    try {
                        String sql = "INSERT INTO animalesZoo(nombre, color, peso, tipo, categoria, cantidadAlas) VALUES (?, ?, ?, ?, ?, ?)";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, this.nombre);
                        statement.setString(2, color);
                        statement.setDouble(3, peso);
                        statement.setString(4, this.tipo);
                        statement.setString(5, this.categoria);
                        statement.setInt(6, cantidadAlas);

                        statement.executeUpdate();
                        System.out.println("Los datos han sido enviados");
                        MenuPrincipal menu =  new MenuPrincipal();
                        menu.setVisible(true);
                        this.dispose();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Weee, mandando datos a la base de datos. Sabía que no eras un idiota.");

                }

            }else if("Pez".equals(this.tipo)){
                // para que mande a la base de datos

                String seleccionNumeroAletas = jComboBoxAtributo2.getSelectedItem().toString();
                int numeroAletas = Integer.parseInt(seleccionNumeroAletas);
                String tieneEscamas = jComboBoxAtributo3.getSelectedItem().toString();

                try {
                    String sql = "INSERT INTO animalesZoo(nombre, color, peso, tipo, categoria, cantidadAletas, escamas) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, this.nombre);
                    statement.setString(2, color);
                    statement.setDouble(3, peso);
                    statement.setString(4, this.tipo);
                    statement.setString(5, this.categoria);
                    statement.setInt(6, numeroAletas);
                    statement.setString(7, tieneEscamas);

                    statement.executeUpdate();
                    System.out.println("Los datos han sido enviados");
                    MenuPrincipal menu =  new MenuPrincipal();
                    menu.setVisible(true);
                    this.dispose();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }else if("Anfibio".equals(this.tipo)){
                String tienePiel = jComboBoxAtributo2.getSelectedItem().toString();

                try {
                    String sql = "INSERT INTO animalesZoo(nombre, color, peso, tipo, categoria, piel) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, this.nombre);
                    statement.setString(2, color);
                    statement.setDouble(3, peso);
                    statement.setString(4, this.tipo);
                    statement.setString(5, this.categoria);
                    statement.setString(6, tienePiel);

                    statement.executeUpdate();
                    System.out.println("Los datos han sido enviados");
                    MenuPrincipal menu =  new MenuPrincipal();
                    menu.setVisible(true);
                    this.dispose();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }else if("Reptil".equals(this.tipo)){
                String tierraMar_ambos = jComboBoxAtributo2.getSelectedItem().toString();

                try {
                    String sql = "INSERT INTO animalesZoo(nombre, color, peso, tipo, categoria, tierraMar_ambos) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, this.nombre);
                    statement.setString(2, color);
                    statement.setDouble(3, peso);
                    statement.setString(4, this.tipo);
                    statement.setString(5, this.categoria);
                    statement.setString(6, tierraMar_ambos);

                    statement.executeUpdate();
                    System.out.println("Los datos han sido enviados");
                    MenuPrincipal menu =  new MenuPrincipal();
                    menu.setVisible(true);
                    this.dispose();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }else if("Artropodo".equals(this.tipo)) {

                String paresPatas = jTextAtributo1.getText().toString();
                if(jTextAtributo1.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Ingrese un número de pares de patas.");
                else if(Integer.parseInt(paresPatas) < 1)
                JOptionPane.showMessageDialog(null, "Error. Ingrese un número valido de pares de patas.");
                else {
                    String NumeroAntenas = jComboBoxAtributo2.getSelectedItem().toString();
                    int cantidadParesPatas = Integer.parseInt(paresPatas);

                    try {
                        String sql = "INSERT INTO animalesZoo(nombre, color, peso, tipo, categoria, cantidadParesPatas,antenas) VALUES (?, ?, ?, ?, ?, ?,?)";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, this.nombre);
                        statement.setString(2, color);
                        statement.setDouble(3, peso);
                        statement.setString(4, this.tipo);
                        statement.setString(5, this.categoria);
                        statement.setInt(6, cantidadParesPatas);
                        statement.setString(7, NumeroAntenas);

                        statement.executeUpdate();
                        System.out.println("Los datos han sido enviados");
                        MenuPrincipal menu = new MenuPrincipal();
                        menu.setVisible(true);
                        this.dispose();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }else if ("Molusco".equals(this.tipo)){
                String erizo_o_estrella = jComboBoxAtributo2.getSelectedItem().toString();

                try {
                    String sql = "INSERT INTO animalesZoo(nombre, color, peso, tipo, categoria, erizo_o_estrella) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, this.nombre);
                    statement.setString(2, color);
                    statement.setDouble(3, peso);
                    statement.setString(4, this.tipo);
                    statement.setString(5, this.categoria);
                    statement.setString(6, erizo_o_estrella);

                    statement.executeUpdate();
                    System.out.println("Los datos han sido enviados");
                    MenuPrincipal menu = new MenuPrincipal();
                    menu.setVisible(true);
                    this.dispose();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }else if ("Equinodermo".equals(this.tipo)){
                String erizo_o_estrella = jComboBoxAtributo2.getSelectedItem().toString();

                try {
                    String sql = "INSERT INTO animalesZoo(nombre, color, peso, tipo, categoria, erizo_o_estrella) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, this.nombre);
                    statement.setString(2, color);
                    statement.setDouble(3, peso);
                    statement.setString(4, this.tipo);
                    statement.setString(5, this.categoria);
                    statement.setString(6, erizo_o_estrella);

                    statement.executeUpdate();
                    System.out.println("Los datos han sido enviados");
                    MenuPrincipal menu = new MenuPrincipal();
                    menu.setVisible(true);
                    this.dispose();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }else if ("Gusano".equals(this.tipo)){
                String tipoCuerpo = jComboBoxAtributo2.getSelectedItem().toString();

                try {
                    String sql = "INSERT INTO animalesZoo(nombre, color, peso, tipo,categoria, tipoCuerpo) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, this.nombre);
                    statement.setString(2, color);
                    statement.setDouble(3, peso);
                    statement.setString(4, this.tipo);
                    statement.setString(5, this.categoria);
                    statement.setString(6, tipoCuerpo);

                    statement.executeUpdate();
                    System.out.println("Los datos han sido enviados");
                    MenuPrincipal menu = new MenuPrincipal();
                    menu.setVisible(true);
                    this.dispose();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }else if ("Porifero".equals(this.tipo)){ // se verifica si los datos de porifero estan correctamente puesto para mandar los datos a la tabla animalesZoo

                try {
                    String sql = "INSERT INTO animalesZoo(nombre, color, peso, tipo, categoria) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, this.nombre);
                    statement.setString(2, color);
                    statement.setDouble(3, peso);
                    statement.setString(4, this.tipo);
                    statement.setString(5, this.categoria);

                    statement.executeUpdate();
                    System.out.println("Los datos han sido enviados");
                    MenuPrincipal menu = new MenuPrincipal();
                    menu.setVisible(true);
                    this.dispose();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }else if ("Celentereo".equals(this.tipo)){
                String tentaculos = jComboBoxAtributo2.getSelectedItem().toString();

                try {
                    String sql = "INSERT INTO animalesZoo(nombre, color, peso, tipo, categoria, tentaculos) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, this.nombre);
                    statement.setString(2, color);
                    statement.setDouble(3, peso);
                    statement.setString(4, this.tipo);
                    statement.setString(5, this.categoria);
                    statement.setString(6, tentaculos);

                    statement.executeUpdate();
                    System.out.println("Los datos han sido enviados");
                    MenuPrincipal menu = new MenuPrincipal();
                    menu.setVisible(true);
                    this.dispose();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }

    }//GEN-LAST:event_jButGuardarActionPerformed

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

    private void jTxtPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtPesoActionPerformed

    private void jTxIdAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxIdAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxIdAnimalActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioModificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup VertebradoOinvertebrado;
    private javax.swing.JButton jButGuardar;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBoxAtributo2;
    private javax.swing.JComboBox<String> jComboBoxAtributo3;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelAtributo1;
    private javax.swing.JLabel jLabelAtributo2;
    private javax.swing.JLabel jLabelAtributo3;
    private javax.swing.JLabel jLabelimagen;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextAtributo1;
    private javax.swing.JTextField jTextCategoria;
    private javax.swing.JTextField jTextColor;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextNombreAnimal;
    private javax.swing.JTextField jTextTipo;
    private javax.swing.JTextField jTxIdAnimal;
    private javax.swing.JTextField jTxtPeso;
    // End of variables declaration//GEN-END:variables
}
