package SUPPLIER;

import BARANG.barang;
import LAPORAN_PEMASUKAN.laporan_pemasukan;
import LAPORAN_PENGELUARAN.laporan_pengeluaran;
import LOGIN.LOGIN;
import TRANSAKSI_BELI.TRANSAKSI_BELI;
import TRANSAKSI_JUAL.TRANSAKSI_JUAL;
import koneksi.konek;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SUPPLIER extends javax.swing.JFrame {

    private Connection conn;
    
    public SUPPLIER() {
        initComponents();
        conn = konek.getConnection();
        if (conn != null){
        getData();        
    }
    }
    private void getData() {
    DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
    model.setRowCount(0);        
        try {
            String sql = "SELECT * FROM supplier";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
             while(rs.next()){
                String id_supplier = rs.getString("id_supplier");
                String nama_supplier = rs.getString("nama_supplier");
                String no_telp = rs.getString("no_telp");
                String alamat = rs.getString("alamat");
                String email = rs.getString("email");
                
                Object[] rowData = {id_supplier,nama_supplier,no_telp,alamat,email};
                model.addRow(rowData);
                
            }
            
            rs.close();
            st.close();
        } catch (Exception e){
            Logger.getLogger(SUPPLIER.class.getName()).log(Level.SEVERE, null, e);

        }
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        t_idsupplier = new javax.swing.JTextField();
        t_namasupplier = new javax.swing.JTextField();
        t_notelp = new javax.swing.JTextField();
        t_alamat = new javax.swing.JTextField();
        t_email = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_barang = new javax.swing.JButton();
        btn_transaksibeli = new javax.swing.JButton();
        btn_transaksijual = new javax.swing.JButton();
        btn_laporanpemasukan = new javax.swing.JButton();
        btn_laporanpengeluaran = new javax.swing.JButton();
        t_cari = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_idsupplier.setBackground(new java.awt.Color(217, 217, 217));
        t_idsupplier.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        t_idsupplier.setBorder(null);
        t_idsupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_idsupplierActionPerformed(evt);
            }
        });
        getContentPane().add(t_idsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 170, -1));

        t_namasupplier.setBackground(new java.awt.Color(217, 217, 217));
        t_namasupplier.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        t_namasupplier.setBorder(null);
        t_namasupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_namasupplierActionPerformed(evt);
            }
        });
        getContentPane().add(t_namasupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 170, -1));

        t_notelp.setBackground(new java.awt.Color(217, 217, 217));
        t_notelp.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        t_notelp.setBorder(null);
        t_notelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_notelpActionPerformed(evt);
            }
        });
        getContentPane().add(t_notelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 170, -1));

        t_alamat.setBackground(new java.awt.Color(217, 217, 217));
        t_alamat.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        t_alamat.setBorder(null);
        t_alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_alamatActionPerformed(evt);
            }
        });
        getContentPane().add(t_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 80, 180, -1));

        t_email.setBackground(new java.awt.Color(217, 217, 217));
        t_email.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        t_email.setBorder(null);
        t_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_emailActionPerformed(evt);
            }
        });
        getContentPane().add(t_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 130, 180, 20));

        btn_tambah.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        btn_tambah.setBorder(null);
        btn_tambah.setBorderPainted(false);
        btn_tambah.setContentAreaFilled(false);
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 770, 110, 50));

        btn_ubah.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        btn_ubah.setBorder(null);
        btn_ubah.setBorderPainted(false);
        btn_ubah.setContentAreaFilled(false);
        btn_ubah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ubahMouseClicked(evt);
            }
        });
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 770, 90, 50));

        btn_hapus.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        btn_hapus.setBorder(null);
        btn_hapus.setContentAreaFilled(false);
        btn_hapus.setDefaultCapable(false);
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 770, 100, 50));

        btn_barang.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        btn_barang.setBorder(null);
        btn_barang.setBorderPainted(false);
        btn_barang.setContentAreaFilled(false);
        btn_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_barangActionPerformed(evt);
            }
        });
        getContentPane().add(btn_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 120, 50));

        btn_transaksibeli.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        btn_transaksibeli.setBorder(null);
        btn_transaksibeli.setBorderPainted(false);
        btn_transaksibeli.setContentAreaFilled(false);
        btn_transaksibeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksibeliActionPerformed(evt);
            }
        });
        getContentPane().add(btn_transaksibeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 140, 60));

        btn_transaksijual.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        btn_transaksijual.setBorder(null);
        btn_transaksijual.setBorderPainted(false);
        btn_transaksijual.setContentAreaFilled(false);
        btn_transaksijual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksijualActionPerformed(evt);
            }
        });
        getContentPane().add(btn_transaksijual, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 140, 60));

        btn_laporanpemasukan.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        btn_laporanpemasukan.setBorder(null);
        btn_laporanpemasukan.setBorderPainted(false);
        btn_laporanpemasukan.setContentAreaFilled(false);
        btn_laporanpemasukan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laporanpemasukanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_laporanpemasukan, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, 130, 60));

        btn_laporanpengeluaran.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        btn_laporanpengeluaran.setBorder(null);
        btn_laporanpengeluaran.setBorderPainted(false);
        btn_laporanpengeluaran.setContentAreaFilled(false);
        btn_laporanpengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laporanpengeluaranActionPerformed(evt);
            }
        });
        getContentPane().add(btn_laporanpengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 660, 160, 50));

        t_cari.setBackground(new java.awt.Color(217, 217, 217));
        t_cari.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        t_cari.setBorder(null);
        t_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_cariActionPerformed(evt);
            }
        });
        getContentPane().add(t_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 300, 140, 20));

        btn_cari.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        btn_cari.setBorder(null);
        btn_cari.setBorderPainted(false);
        btn_cari.setContentAreaFilled(false);
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 290, 90, 40));

        btn_logout.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        btn_logout.setBorder(null);
        btn_logout.setBorderPainted(false);
        btn_logout.setContentAreaFilled(false);
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        getContentPane().add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 760, 130, 40));

        tbl_data.setBackground(new java.awt.Color(112, 158, 195));
        tbl_data.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id supplier", "Nama supplier", "No telp", "Alamat", "Email"
            }
        ));
        tbl_data.setRowHeight(40);
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_data);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 920, 340));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/IMAGE SUPPLIER 2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void t_namasupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_namasupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_namasupplierActionPerformed

    private void t_notelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_notelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_notelpActionPerformed

    private void t_alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_alamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_alamatActionPerformed

    private void t_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_emailActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
    String id_supplier = t_idsupplier.getText();
    String nama_supplier = t_namasupplier.getText();
    String no_telp = t_notelp.getText(); 
    String alamat = t_alamat.getText();
    String email = t_email.getText();

if (id_supplier.isEmpty() || nama_supplier.isEmpty() || no_telp.isEmpty() || alamat.isEmpty() || email.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Semua kolom harus diisi !", "Validasi", JOptionPane.ERROR_MESSAGE);
    return;
}

try {
    String sql = "INSERT INTO supplier (id_supplier, nama_supplier, no_telp, alamat, email) VALUES (?, ?, ?, ?, ?)";
    PreparedStatement st = conn.prepareStatement(sql);    
    st.setString(1, id_supplier);
    st.setString(2, nama_supplier);
    st.setString(3, no_telp);
    st.setString(4, alamat);  
    st.setString(5, email);  
    
    int rowInserted = st.executeUpdate();
    if (rowInserted > 0) {
        JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
        resetForm();
        getData();
    }
    
    st.close();
} catch (Exception e) {
    Logger.getLogger(SUPPLIER.class.getName()).log(Level.SEVERE, null, e);
}

    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        int selectedRow = tbl_data.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan di perbarui"); 
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin menghapus data ini ?","Konfirmasi",JOptionPane.YES_NO_OPTION );
        if(confirm == JOptionPane.YES_OPTION){
            String id = tbl_data.getValueAt(selectedRow, 0).toString();
            
            try {
                String sql = "DELETE FROM supplier WHERE id_supplier=?";
                PreparedStatement st = conn.prepareStatement(sql);{
                st.setString(1,id);
          
                int rowDelete = st.executeUpdate();
                if(rowDelete > 0){
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
                    resetForm();
                    getData();
                }
                }
                
                st.close();
            }catch (Exception e){
        Logger.getLogger(SUPPLIER.class.getName()).log(Level.SEVERE, null, e);
            }        
        } 
   
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
    int selectedRow = tbl_data.getSelectedRow();
    if (selectedRow == -1) { 
    JOptionPane.showMessageDialog(this, "Pilih tabel yang akan diubah");
    return;
}
    
String id_supplier = tbl_data.getValueAt(selectedRow, 0).toString();
String nama_supplier = t_namasupplier.getText();
String no_telp = t_notelp.getText();
String alamat = t_alamat.getText();
String email = t_email.getText();

if (id_supplier.isEmpty() || nama_supplier.isEmpty() || no_telp.isEmpty() || alamat.isEmpty() || email.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Harap lengkapi semua field sebelum mengubah data.");
    return;
}

try {
    String sql = "UPDATE supplier SET nama_supplier = ?, no_telp = ?, alamat = ?, email = ? WHERE id_supplier = ?";
    PreparedStatement st = conn.prepareStatement(sql);
    st.setString(1, nama_supplier);
    st.setString(2, no_telp);
    st.setString(3, alamat);
    st.setString(4, email);
    st.setString(5, id_supplier); 

    int rowsUpdated = st.executeUpdate();
    if (rowsUpdated > 0) {
        JOptionPane.showMessageDialog(this, "Data Supplier Berhasil Diubah");
        getData(); 
        resetForm(); 
    }

    st.close();
} catch (Exception e) {
    Logger.getLogger(SUPPLIER.class.getName()).log(Level.SEVERE, null, e);
    JOptionPane.showMessageDialog(this, "Error saat mengubah data: " + e.getMessage());
}

    }//GEN-LAST:event_btn_ubahActionPerformed

    private void btn_ubahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ubahMouseClicked

    }//GEN-LAST:event_btn_ubahMouseClicked

    private void t_idsupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_idsupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_idsupplierActionPerformed

    private void btn_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_barangActionPerformed
        barang halut = new barang();
                halut.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_btn_barangActionPerformed

    private void btn_transaksibeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksibeliActionPerformed
        TRANSAKSI_BELI tb = new TRANSAKSI_BELI();
        tb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_transaksibeliActionPerformed

    private void btn_transaksijualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksijualActionPerformed
         TRANSAKSI_JUAL tj = new TRANSAKSI_JUAL();
        tj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_transaksijualActionPerformed

    private void btn_laporanpemasukanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laporanpemasukanActionPerformed
        laporan_pemasukan masuk = new laporan_pemasukan();
        masuk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_laporanpemasukanActionPerformed

    private void btn_laporanpengeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laporanpengeluaranActionPerformed
         laporan_pengeluaran keluar = new laporan_pengeluaran();
        keluar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_laporanpengeluaranActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
    String keyword = t_cari.getText().trim(); 
    if (!keyword.isEmpty()) {
        searchData(keyword); 
        } else {
             getData(); 
    }
}

private void searchData(String keyword) {
    DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
    model.setRowCount(0); 

    String sql = "SELECT * FROM supplier WHERE id_supplier LIKE ? OR nama_supplier LIKE ? OR alamat LIKE ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {        
        stmt.setString(1, "%" + keyword + "%");
        stmt.setString(2, "%" + keyword + "%");
        stmt.setString(3, "%" + keyword + "%");

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String id_supplier = rs.getString("id_supplier");
                String nama_supplier = rs.getString("nama_supplier");
                String no_telp = rs.getString("no_telp");
                String alamat = rs.getString("alamat");
                String email = rs.getString("email");            
                Object[] rowData = {id_supplier,nama_supplier,  no_telp, alamat, email};
                model.addRow(rowData); 
            }
        }
    } catch (Exception e) {
        Logger.getLogger(barang.class.getName()).log(Level.SEVERE, null, e);
        JOptionPane.showMessageDialog(this, "Error saat mencari data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btn_cariActionPerformed

    private void t_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_cariActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        LOGIN halog = new LOGIN();
                halog.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
     int selectedRow = tbl_data.getSelectedRow();
   
    if (selectedRow >= 0) {              
        DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
          
        String id_supplier = model.getValueAt(selectedRow, 0).toString();
        String nama_supplier = model.getValueAt(selectedRow, 1).toString();
        String no_telp = model.getValueAt(selectedRow, 2).toString();
        String alamat = model.getValueAt(selectedRow, 3).toString();
        String email = model.getValueAt(selectedRow, 4).toString();

        t_idsupplier.setText(id_supplier);
        t_namasupplier.setText(nama_supplier);
        t_notelp.setText(no_telp);
        t_alamat.setText(alamat);
        t_email.setText(email);
    } else {
        JOptionPane.showMessageDialog(this, "Pilih baris terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
    }

    }//GEN-LAST:event_tbl_dataMouseClicked

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
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SUPPLIER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SUPPLIER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SUPPLIER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SUPPLIER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SUPPLIER().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_barang;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_laporanpemasukan;
    private javax.swing.JButton btn_laporanpengeluaran;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_transaksibeli;
    private javax.swing.JButton btn_transaksijual;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField t_alamat;
    private javax.swing.JTextField t_cari;
    private javax.swing.JTextField t_email;
    private javax.swing.JTextField t_idsupplier;
    private javax.swing.JTextField t_namasupplier;
    private javax.swing.JTextField t_notelp;
    private javax.swing.JTable tbl_data;
    // End of variables declaration//GEN-END:variables

    private void resetForm() {
        t_idsupplier.setText("");
        t_namasupplier.setText("");
        t_notelp.setText("");
        t_alamat.setText("");
        t_email.setText("");       
    }
}
