package LOGIN;

import BARANG.barang;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import koneksi.konek;

public class LOGIN extends javax.swing.JFrame {
private Connection conn;
    
    public LOGIN() {
        initComponents();
        conn = konek.getConnection();
        if (conn != null){
        getData();
//        lb_showPassword.setVisible(true);
         lb_hidePassword.setVisible(false);
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtxtusername = new javax.swing.JTextField();
        btnlogin = new javax.swing.JButton();
        jtxpassword = new javax.swing.JPasswordField();
        btn_lupasandi = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lb_hidePassword = new javax.swing.JLabel();
        lb_showPassword = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtusername.setBackground(new java.awt.Color(217, 217, 217));
        jtxtusername.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jtxtusername.setBorder(null);
        jtxtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtusernameActionPerformed(evt);
            }
        });
        getContentPane().add(jtxtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 360, 310, 60));

        btnlogin.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        btnlogin.setToolTipText("");
        btnlogin.setBorder(null);
        btnlogin.setBorderPainted(false);
        btnlogin.setContentAreaFilled(false);
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        getContentPane().add(btnlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 660, 170, 60));

        jtxpassword.setBackground(new java.awt.Color(217, 217, 217));
        jtxpassword.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jtxpassword.setBorder(null);
        getContentPane().add(jtxpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 520, 250, 60));

        btn_lupasandi.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        btn_lupasandi.setBorder(null);
        btn_lupasandi.setBorderPainted(false);
        btn_lupasandi.setContentAreaFilled(false);
        btn_lupasandi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lupasandiActionPerformed(evt);
            }
        });
        getContentPane().add(btn_lupasandi, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 733, 180, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/Close Window.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 30, 30));

        lb_hidePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/Invisible.png"))); // NOI18N
        lb_hidePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_hidePasswordMouseClicked(evt);
            }
        });
        getContentPane().add(lb_hidePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 530, 40, 40));

        lb_showPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/Eye.png"))); // NOI18N
        lb_showPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_showPasswordMouseClicked(evt);
            }
        });
        getContentPane().add(lb_showPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 530, 40, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/LOGIN.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtusernameActionPerformed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        String enteredUsername = jtxtusername.getText();
        String enteredPassword = new String(jtxpassword.getPassword());  
        String sql = "SELECT * FROM akun WHERE username = ?"; 
        
try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    stmt.setString(1, enteredUsername); 
    try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
               String storedPassword = rs.getString("password");
            if (enteredPassword.equals(storedPassword)) {
                JOptionPane.showMessageDialog(this, "Login berhasil!");
                barang halut = new barang();
                halut.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Password salah!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Username tidak ditemukan!");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan dalam eksekusi query.");
    }
} catch (SQLException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(this, "Terjadi kesalahan pada koneksi atau query.");
}

    }//GEN-LAST:event_btnloginActionPerformed

    private void btn_lupasandiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lupasandiActionPerformed
    String username = JOptionPane.showInputDialog(this, "Masukkan Username Anda:");
        if (username != null && !username.trim().isEmpty()) {       
        resetPassword(username);
        } else {
        JOptionPane.showMessageDialog(this, "Username tidak boleh kosong!");
    }
    }//GEN-LAST:event_btn_lupasandiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lb_showPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_showPasswordMouseClicked
        lb_showPassword.setVisible(false);
        lb_hidePassword.setVisible(true);
        jtxpassword.setEchoChar((char)0);
        
    }//GEN-LAST:event_lb_showPasswordMouseClicked

    private void lb_hidePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_hidePasswordMouseClicked
        lb_showPassword.setVisible(true);
        lb_hidePassword.setVisible(false);
        jtxpassword.setEchoChar('*');
        
    }//GEN-LAST:event_lb_hidePasswordMouseClicked
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
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LOGIN().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_lupasandi;
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jtxpassword;
    private javax.swing.JTextField jtxtusername;
    private javax.swing.JLabel lb_hidePassword;
    private javax.swing.JLabel lb_showPassword;
    // End of variables declaration//GEN-END:variables
 
    private void getData() {
     try {            
            String sql = "SELECT * FROM akun";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
           
            while (rs.next()) {    
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
        }
    }

    private void resetPassword(String username) {
        String sql = "SELECT * FROM akun WHERE username = ?"; 
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {     
        stmt.setString(1, username);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {              
                String newPassword = JOptionPane.showInputDialog(this, "Masukkan Password Baru:");
                if (newPassword != null && !newPassword.trim().isEmpty()) {
                    if (newPassword.length() < 6) {
                        JOptionPane.showMessageDialog(this, "Password harus terdiri dari minimal 6 karakter.");
                        return;
                    }
        
                    String confirmPassword = JOptionPane.showInputDialog(this, "Konfirmasi Password Baru:");
                    if (confirmPassword != null && confirmPassword.equals(newPassword)) {                       
                        String updateSql = "UPDATE akun SET password = ? WHERE username = ?";
                        try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                            updateStmt.setString(1, newPassword);  
                            updateStmt.setString(2, username); 

                            int rowsUpdated = updateStmt.executeUpdate();
                            if (rowsUpdated > 0) {
                                JOptionPane.showMessageDialog(this, "Password berhasil diubah!");
                            } else {
                                JOptionPane.showMessageDialog(this, "Gagal mengubah password.");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Password baru dan konfirmasi password tidak cocok.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Password tidak boleh kosong!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Username tidak ditemukan.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan dalam koneksi atau eksekusi query.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan pada koneksi.");
    }
}
    }


