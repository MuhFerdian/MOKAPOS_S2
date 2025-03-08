package BARANG;

import LAPORAN_PEMASUKAN.laporan_pemasukan;
import LAPORAN_PENGELUARAN.laporan_pengeluaran;
import LOGIN.LOGIN;
import SUPPLIER.SUPPLIER;
import TRANSAKSI_BELI.TRANSAKSI_BELI;
import TRANSAKSI_JUAL.TRANSAKSI_JUAL;
import koneksi.konek;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class barang extends javax.swing.JFrame {

    private Connection conn;
    
    public barang() {
        initComponents();
        conn = konek.getConnection();
        if (conn != null){
        getData();
        
    }
    }
    private void getData() {
    DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
    model.setRowCount(0); 

    model.setColumnIdentifiers(new Object[] { 
        "Id Barang", "Jenis Barang", "Nama Barang", "Stok", "Harga Beli", "Harga Jual", "Id Pedagang" 
    });

    try {
     String sql = "SELECT barang.id_barang, barang.jenis_barang, barang.nama_barang, barang.stok, "
           + "(SELECT transaksi_beli.harga_beli "
           + " FROM transaksi_beli "
           + " WHERE transaksi_beli.id_barang = barang.id_barang "
           + " ORDER BY transaksi_beli.harga_beli DESC LIMIT 1) AS harga_beli, "
           + "(SELECT transaksi_jual.harga_jual "
           + " FROM transaksi_jual "
           + " WHERE transaksi_jual.id_barang = barang.id_barang "
           + " ORDER BY transaksi_jual.harga_jual DESC LIMIT 1) AS harga_jual, "
           + "pedagang.id_pedagang "
           + "FROM barang "
           + "JOIN pedagang ON pedagang.id_pedagang = barang.id_pedagang";


        PreparedStatement st = conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            String id_barang = rs.getString("id_barang");
            String jenis_barang = rs.getString("jenis_barang");
            String nama_barang = rs.getString("nama_barang");
            int stok = rs.getInt("stok");
            int hargaBeli = rs.getInt("harga_beli");
            int hargaJual = rs.getInt("harga_jual");
            String idPenjual = rs.getString("id_pedagang"); 
          
            Object[] rowData = {id_barang, jenis_barang, nama_barang, stok, hargaBeli, hargaJual, idPenjual};
            model.addRow(rowData);
        }
       
//        rs.close();
//        st.close();

    } catch (SQLException e) {       
        Logger.getLogger(barang.class.getName()).log(Level.SEVERE, null, e);
        JOptionPane.showMessageDialog(null, "Gagal memuat data barang: " + e.getMessage());
    } catch (Exception e) {
        Logger.getLogger(barang.class.getName()).log(Level.SEVERE, null, e);
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_hapus = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JButton();
        t_cari = new javax.swing.JTextField();
        btn_supplier = new javax.swing.JButton();
        btn_transaksibeli = new javax.swing.JButton();
        btn_transaksijual = new javax.swing.JButton();
        btn_laporanpemasukan = new javax.swing.JButton();
        btn_laporanpengeluaran = new javax.swing.JButton();
        btn_cari = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 832));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_data.setBackground(new java.awt.Color(112, 158, 195));
        tbl_data.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id barang", "Jenis Barang", "Nama Barang", "Stok", "Harga Beli", "Harga Jual", "Id pedagang"
            }
        ));
        tbl_data.setGridColor(new java.awt.Color(153, 153, 153));
        tbl_data.setRowHeight(30);
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_data);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 940, 450));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("id barang");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 853, 444, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("nama_barang");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 914, 444, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("stok");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 1050, 444, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("jenis barang");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 977, 444, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("harga jual");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 1124, 444, -1));

        btn_hapus.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        btn_hapus.setBorder(null);
        btn_hapus.setBorderPainted(false);
        btn_hapus.setContentAreaFilled(false);
        btn_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hapusMouseClicked(evt);
            }
        });
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel1.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 780, 90, 30));

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
        jPanel1.add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 780, 100, 32));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("harga beli");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 1188, 444, -1));

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
        jPanel1.add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 780, 100, 30));

        t_cari.setBackground(new java.awt.Color(217, 217, 217));
        t_cari.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        t_cari.setBorder(null);
        t_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_cariActionPerformed(evt);
            }
        });
        jPanel1.add(t_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 290, 130, 20));

        btn_supplier.setBackground(new java.awt.Color(0,0,0,0));
        btn_supplier.setBorder(null);
        btn_supplier.setBorderPainted(false);
        btn_supplier.setContentAreaFilled(false);
        btn_supplier.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_supplierActionPerformed(evt);
            }
        });
        jPanel1.add(btn_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 130, 40));

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
        jPanel1.add(btn_transaksibeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 150, 60));

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
        jPanel1.add(btn_transaksijual, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 160, 60));

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
        jPanel1.add(btn_laporanpemasukan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 140, 60));

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
        jPanel1.add(btn_laporanpengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 650, 170, 60));

        btn_cari.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        btn_cari.setForeground(new java.awt.Color(0, 0, 0, 0)
        );
        btn_cari.setBorder(null);
        btn_cari.setBorderPainted(false);
        btn_cari.setContentAreaFilled(false);
        btn_cari.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 280, 90, 40));

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
        jPanel1.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 760, 110, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/BARANG.jpg"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
      
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
   
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
    
    }//GEN-LAST:event_tbl_dataMouseClicked

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
   
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_ubahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ubahMouseClicked
      
    }//GEN-LAST:event_btn_ubahMouseClicked

    private void btn_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hapusMouseClicked

    private void btn_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supplierActionPerformed
        SUPPLIER sp = new SUPPLIER();
        sp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_supplierActionPerformed

    private void btn_transaksijualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksijualActionPerformed
        TRANSAKSI_JUAL tj = new TRANSAKSI_JUAL();
        tj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_transaksijualActionPerformed

    private void btn_transaksibeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksibeliActionPerformed
        TRANSAKSI_BELI tb = new TRANSAKSI_BELI();
        tb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_transaksibeliActionPerformed

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

    String sql = "SELECT * FROM barang WHERE id_barang LIKE ? OR nama_barang LIKE ? OR jenis_barang LIKE ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, "%" + keyword + "%");
        stmt.setString(2, "%" + keyword + "%");
        stmt.setString(3, "%" + keyword + "%");

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String id_barang = rs.getString("id_barang");
                String stok = rs.getString("jenis_barang");
                String harga_jual = rs.getString("nama_barang");
                String harga_beli = rs.getString("stok");
                String nama_barang = rs.getString("harga_beli");
                String jenis_barang = rs.getString("harga_jual");
                String id_pedagang = rs.getString("id_pedagang");

                Object[] rowData = {id_barang, stok, harga_jual, harga_beli, nama_barang, jenis_barang,id_pedagang};
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_laporanpemasukan;
    private javax.swing.JButton btn_laporanpengeluaran;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_supplier;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_transaksibeli;
    private javax.swing.JButton btn_transaksijual;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t_cari;
    private javax.swing.JTable tbl_data;
    // End of variables declaration//GEN-END:variables

    private void resetForm() {
          
    }   
}
