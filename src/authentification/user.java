/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authentification;

import Vue.HOME1;
import Vue.MENU;
import Vue.MENU1;
import db.db_Mysql;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.main_agence;




/**
 *
 * @author edmm
 */
public class user extends javax.swing.JFrame {

    /**
     * Creates new form user
     */
    public user() {
        initComponents();
        this.setLocationRelativeTo(null);
        //getContentPane().setBackground(Color.red);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nom_user = new javax.swing.JTextField();
        pass_user = new javax.swing.JPasswordField();
        connecter = new javax.swing.JButton();
        voir = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 400));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("AUTHENTIFICATION");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Nom d'utilisateur :");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Mot de Passe :");

        nom_user.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        pass_user.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        pass_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pass_userActionPerformed(evt);
            }
        });

        connecter.setBackground(new java.awt.Color(0, 204, 102));
        connecter.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        connecter.setForeground(new java.awt.Color(255, 255, 255));
        connecter.setText("Connecter");
        connecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connecterActionPerformed(evt);
            }
        });

        voir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(nom_user, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pass_user, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(voir))
            .addGroup(layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(connecter, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(nom_user, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(pass_user, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(voir)))
                .addGap(41, 41, 41)
                .addComponent(connecter, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pass_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pass_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pass_userActionPerformed

    private void connecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connecterActionPerformed
        PreparedStatement st, st1;
        ResultSet rs,rs1;
        
        String nom = nom_user.getText();
        String password = String.valueOf(pass_user.getPassword());
        
         String nom1 = nom_user.getText();
        String password1 = String.valueOf(pass_user.getPassword());
        
        String req ="select personne.nom,compte.mot_passe\n" +
"from personne,personnel,compte,fonction,personnel_fonction\n" +
"\n" +
"where personne.nom =? and compte.mot_passe =? and nom_fonction= 'DG'\n" +
"and fonction.idfonction = personnel_fonction.idfonction\n" +
"and personnel.idpersonnel = compte.idpersonnel\n" +
"and personne.idpersonne = personnel.idpersonne\n" +
"and personnel.idpersonnel = personnel_fonction.idpersonnel";
        
        String req1 ="select personne.nom,compte.mot_passe\n" +
"from personne,personnel,compte,fonction,personnel_fonction\n" +
"\n" +
"where personne.nom =? and compte.mot_passe =? and nom_fonction= 'SECRETAIRE'\n" +
"and fonction.idfonction = personnel_fonction.idfonction\n" +
"and personnel.idpersonnel = compte.idpersonnel\n" +
"and personne.idpersonne = personnel.idpersonne\n" +
"and personnel.idpersonnel = personnel_fonction.idpersonnel";
        st = db_Mysql.extraireData_Prepared(req);
        st1 = db_Mysql.extraireData_Prepared(req1);
         
        try {
            st.setString(1, nom);
            st.setString(2, password);
          rs = st.executeQuery();
          
          st1.setString(1, nom);
            st1.setString(2, password);
          rs1 = st1.executeQuery();
          
          
          if(rs.next())
          {
            HOME1 h1 = new HOME1();
            h1.setVisible(true);
            h1.pack();
            h1.setLocationRelativeTo(null);
            this.dispose();
           
          }
          
          else if(rs1.next())
          {
            MENU1 menu1 = new MENU1();
            menu1.setVisible(true);
            menu1.pack();
            menu1.setLocationRelativeTo(null);
            this.dispose();
           
          }else
          {
              JOptionPane.showMessageDialog(null, "nom_utilisateur incorrect", "erreur login", 2);
          }
          
        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_connecterActionPerformed

    private void voirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voirActionPerformed
         if(voir.isSelected())
        {
          pass_user.setEchoChar((char)0);
        }else
        {
         pass_user.setEchoChar('*');
        }
    }//GEN-LAST:event_voirActionPerformed

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
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connecter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nom_user;
    private javax.swing.JPasswordField pass_user;
    private javax.swing.JCheckBox voir;
    // End of variables declaration//GEN-END:variables
}
