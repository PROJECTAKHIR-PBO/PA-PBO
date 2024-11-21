/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import javax.swing.JOptionPane;
import model.Database;
import model.User;

/**
 *
 * @author Regar
 */
public class Login extends javax.swing.JFrame {
    /**
     * Creates new form Login
     */
    public Login() {
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

        inputNim = new javax.swing.JTextField();
        inputPassword = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inputNim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputNim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNimActionPerformed(evt);
            }
        });
        getContentPane().add(inputNim, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 150, -1));

        inputPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(inputPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 150, -1));

        loginButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        loginButton.setText("LOGIN");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NIM");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 37, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Silahkan Login Dengan NIM");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/Container.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 300, 240));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/MainBG.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputNimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNimActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        try {
            String nimText = inputNim.getText();
            String password = inputPassword.getText();
            
            if (nimText.isEmpty() && password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NIM atau Password tidak boleh kosong");
                return;
            }
            
//            Konversi String NIM menjadi Long
            long nim;
            try {
                nim = Long.parseLong(nimText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "NIM harus berupa angka");
                return;
            }
            
//            Mengecek Data
            if (Database.con != null) {
                if (User.loginUser(nim, password)) {
                    User currentUser = User.getLoggedUser();
                    
                    JOptionPane.showMessageDialog(null, "Login Berhasil, Selamat datang " + currentUser.getNamaUser() + " Role : " + currentUser.getRole());
                    
                    switch (currentUser.getRole()) {
                        case "Admin":
                            new AdminMenu().setVisible(true);
                            break;
                        case "Panitia":
                            new PanitiaMenu().setVisible(true);
                            break;
                        case "Bindam":
                            new PenilaianIndex().setVisible(true);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "User Tidak Memiliki Role");
                    }
                    this.dispose(); 
                } else {
                    JOptionPane.showMessageDialog(null, "Login Gagal");
                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Database belum Terhubung");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan!" + e.getMessage());
        }
    }//GEN-LAST:event_loginButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField inputNim;
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton loginButton;
    // End of variables declaration//GEN-END:variables
}