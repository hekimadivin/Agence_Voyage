/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

/**
 *
 * @author edmm
 */
public class MENU1 extends javax.swing.JFrame {

    /**
     * Creates new form MENU1
     */
    public MENU1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        P_agence = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        txt_nom_agence = new javax.swing.JTextField();
        b_add_agence = new javax.swing.JButton();
        b_modifier_agence = new javax.swing.JButton();
        b_delete_agence = new javax.swing.JButton();
        b_actualiser_actuliser_agence = new javax.swing.JButton();
        jScrollPane17 = new javax.swing.JScrollPane();
        table_agence = new javax.swing.JTable();
        txt_id_agence = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        com_adresse_agence = new javax.swing.JComboBox();
        jLabel70 = new javax.swing.JLabel();
        txt_telephone_agence = new javax.swing.JTextField();
        jp_sous_agence_personnel = new javax.swing.JPanel();
        txt_id_idagence_personnel = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        b_actualiser_agence_personnel = new javax.swing.JButton();
        b_delete_agence_personnel = new javax.swing.JButton();
        b_modifier_agence_personnel = new javax.swing.JButton();
        b_add_agence_personnel = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        com_agenc_personnel = new javax.swing.JComboBox();
        com_agence = new javax.swing.JComboBox();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        table_agence_personnel = new javax.swing.JTable();
        b_fermer_agence_personnel = new javax.swing.JButton();
        b_sous_agence_personnel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        P_agence.setBackground(new java.awt.Color(255, 255, 255));
        P_agence.setPreferredSize(new java.awt.Dimension(1200, 750));

        jLabel67.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel67.setText("Nom de l'Agence : ");

        txt_nom_agence.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        b_add_agence.setText("Add");
        b_add_agence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_add_agenceActionPerformed(evt);
            }
        });

        b_modifier_agence.setText("Update");
        b_modifier_agence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_modifier_agenceActionPerformed(evt);
            }
        });

        b_delete_agence.setText("Delete");
        b_delete_agence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_delete_agenceActionPerformed(evt);
            }
        });

        b_actualiser_actuliser_agence.setText("Actualiser");
        b_actualiser_actuliser_agence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_actualiser_actuliser_agenceActionPerformed(evt);
            }
        });

        table_agence.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N°", "Nom de l'Agence", "Téléphone", "Adresse"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane17.setViewportView(table_agence);

        jLabel68.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel68.setText("N° : ");

        jLabel69.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel69.setText("Noms : ");

        com_adresse_agence.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel70.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel70.setText("Téléphone : ");

        txt_telephone_agence.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jp_sous_agence_personnel.setLayout(null);
        jp_sous_agence_personnel.add(txt_id_idagence_personnel);
        txt_id_idagence_personnel.setBounds(150, 80, 194, 28);

        jLabel44.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel44.setText("N° : ");
        jp_sous_agence_personnel.add(jLabel44);
        jLabel44.setBounds(40, 80, 60, 30);

        b_actualiser_agence_personnel.setText("Actualiser");
        b_actualiser_agence_personnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_actualiser_agence_personnelActionPerformed(evt);
            }
        });
        jp_sous_agence_personnel.add(b_actualiser_agence_personnel);
        b_actualiser_agence_personnel.setBounds(310, 250, 80, 31);

        b_delete_agence_personnel.setText("Delete");
        b_delete_agence_personnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_delete_agence_personnelActionPerformed(evt);
            }
        });
        jp_sous_agence_personnel.add(b_delete_agence_personnel);
        b_delete_agence_personnel.setBounds(220, 250, 80, 31);

        b_modifier_agence_personnel.setText("Update");
        b_modifier_agence_personnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_modifier_agence_personnelActionPerformed(evt);
            }
        });
        jp_sous_agence_personnel.add(b_modifier_agence_personnel);
        b_modifier_agence_personnel.setBounds(130, 250, 80, 31);

        b_add_agence_personnel.setText("Add");
        b_add_agence_personnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_add_agence_personnelActionPerformed(evt);
            }
        });
        jp_sous_agence_personnel.add(b_add_agence_personnel);
        b_add_agence_personnel.setBounds(30, 250, 80, 31);

        jLabel45.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel45.setText("Employé : ");
        jp_sous_agence_personnel.add(jLabel45);
        jLabel45.setBounds(31, 133, 84, 30);

        com_agenc_personnel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jp_sous_agence_personnel.add(com_agenc_personnel);
        com_agenc_personnel.setBounds(150, 133, 194, 32);

        com_agence.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jp_sous_agence_personnel.add(com_agence);
        com_agence.setBounds(150, 190, 194, 32);

        jLabel46.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel46.setText("Agence : ");
        jp_sous_agence_personnel.add(jLabel46);
        jLabel46.setBounds(30, 190, 75, 30);

        table_agence_personnel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N°", "Nom", "Agence", "Date d'Affectation"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane10.setViewportView(table_agence_personnel);

        jp_sous_agence_personnel.add(jScrollPane10);
        jScrollPane10.setBounds(512, 40, 630, 240);

        b_fermer_agence_personnel.setText("Fermer");
        b_fermer_agence_personnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_fermer_agence_personnelActionPerformed(evt);
            }
        });

        b_sous_agence_personnel.setText("Fermer");
        b_sous_agence_personnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_sous_agence_personnelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout P_agenceLayout = new javax.swing.GroupLayout(P_agence);
        P_agence.setLayout(P_agenceLayout);
        P_agenceLayout.setHorizontalGroup(
            P_agenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_agenceLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(P_agenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(P_agenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P_agenceLayout.createSequentialGroup()
                            .addComponent(jLabel67)
                            .addGap(21, 21, 21)
                            .addGroup(P_agenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(com_adresse_agence, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_nom_agence, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_id_agence, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(P_agenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(P_agenceLayout.createSequentialGroup()
                                .addComponent(jLabel70)
                                .addGap(69, 69, 69)
                                .addComponent(txt_telephone_agence, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(P_agenceLayout.createSequentialGroup()
                                .addGroup(P_agenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(P_agenceLayout.createSequentialGroup()
                                        .addComponent(b_add_agence, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(b_modifier_agence, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(b_sous_agence_personnel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(P_agenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(P_agenceLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(b_delete_agence, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(b_actualiser_actuliser_agence, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(P_agenceLayout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(b_fermer_agence_personnel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
            .addGroup(P_agenceLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jp_sous_agence_personnel, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        P_agenceLayout.setVerticalGroup(
            P_agenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P_agenceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_agenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(P_agenceLayout.createSequentialGroup()
                        .addGroup(P_agenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_id_agence, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(P_agenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(com_adresse_agence, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(P_agenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(P_agenceLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txt_nom_agence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(P_agenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_telephone_agence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(P_agenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b_add_agence, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_modifier_agence, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_delete_agence, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_actualiser_actuliser_agence, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(P_agenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_sous_agence_personnel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_fermer_agence_personnel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jp_sous_agence_personnel, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P_agence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(P_agence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_add_agenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_add_agenceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_add_agenceActionPerformed

    private void b_modifier_agenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_modifier_agenceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_modifier_agenceActionPerformed

    private void b_delete_agenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_delete_agenceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_delete_agenceActionPerformed

    private void b_actualiser_actuliser_agenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_actualiser_actuliser_agenceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_actualiser_actuliser_agenceActionPerformed

    private void b_actualiser_agence_personnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_actualiser_agence_personnelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_actualiser_agence_personnelActionPerformed

    private void b_delete_agence_personnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_delete_agence_personnelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_delete_agence_personnelActionPerformed

    private void b_modifier_agence_personnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_modifier_agence_personnelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_modifier_agence_personnelActionPerformed

    private void b_add_agence_personnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_add_agence_personnelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_add_agence_personnelActionPerformed

    private void b_fermer_agence_personnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_fermer_agence_personnelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_fermer_agence_personnelActionPerformed

    private void b_sous_agence_personnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_sous_agence_personnelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_sous_agence_personnelActionPerformed

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
            java.util.logging.Logger.getLogger(MENU1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MENU1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MENU1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MENU1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MENU1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel P_agence;
    public javax.swing.JButton b_actualiser_actuliser_agence;
    public javax.swing.JButton b_actualiser_agence_personnel;
    public javax.swing.JButton b_add_agence;
    public javax.swing.JButton b_add_agence_personnel;
    public javax.swing.JButton b_delete_agence;
    public javax.swing.JButton b_delete_agence_personnel;
    public javax.swing.JButton b_fermer_agence_personnel;
    public javax.swing.JButton b_modifier_agence;
    public javax.swing.JButton b_modifier_agence_personnel;
    public javax.swing.JButton b_sous_agence_personnel;
    public javax.swing.JComboBox com_adresse_agence;
    public javax.swing.JComboBox com_agenc_personnel;
    public javax.swing.JComboBox com_agence;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane17;
    public javax.swing.JPanel jp_sous_agence_personnel;
    public javax.swing.JTable table_agence;
    public javax.swing.JTable table_agence_personnel;
    public javax.swing.JTextField txt_id_agence;
    public javax.swing.JTextField txt_id_idagence_personnel;
    public javax.swing.JTextField txt_nom_agence;
    public javax.swing.JTextField txt_telephone_agence;
    // End of variables declaration//GEN-END:variables
}