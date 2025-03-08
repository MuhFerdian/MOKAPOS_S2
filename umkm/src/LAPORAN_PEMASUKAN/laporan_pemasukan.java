package LAPORAN_PEMASUKAN;

import BARANG.barang;
import LAPORAN_PENGELUARAN.laporan_pengeluaran;
import LOGIN.LOGIN;
import SUPPLIER.SUPPLIER;
import TRANSAKSI_BELI.TRANSAKSI_BELI;
import TRANSAKSI_JUAL.TRANSAKSI_JUAL;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import koneksi.konek;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class laporan_pemasukan extends javax.swing.JFrame {

    private Connection conn;

    public laporan_pemasukan() {
        initComponents();
        conn = konek.getConnection(); 
        tampilkanLaporan(); 
    }

    private void tampilkanLaporan() {
        DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
        model.setRowCount(0); 

        try {
            String sql = "SELECT * FROM laporan_transaksi_pemasukkan_2";
            try (PreparedStatement st = conn.prepareStatement(sql); ResultSet rs = st.executeQuery()) {
                int totalPemasukkan = 0; 
                DecimalFormat df = new DecimalFormat("#,###.##"); 

                while (rs.next()) {                 
                    String id_transaksi_penjualan = rs.getString("id_transaksi_penjualan");
                    String jenis_barang = rs.getString("jenis_barang");
                    String nama_barang = rs.getString("nama_barang");
                    String tanggal = rs.getString("tanggal"); 
                    int harga_jual = rs.getInt("harga_jual"); 
                    int jumlah_barang = rs.getInt("jumlah_barang");
                    int total_harga = rs.getInt("total_harga");
                    String id_barang = rs.getString("id_barang");
                   
                    Object[] rowData = {
                        id_transaksi_penjualan,
                        jenis_barang,
                        nama_barang,
                        tanggal,
                        "Rp " + df.format(harga_jual),
                        jumlah_barang,
                        "Rp " + df.format(total_harga),
                        id_barang
                    };
                    model.addRow(rowData);
                
                    totalPemasukkan += total_harga;
                }
       
                totallabel.setText("Total Pemasukkan: Rp " + df.format(totalPemasukkan));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(laporan_pemasukan.class.getName()).log(Level.SEVERE, null, e);
        }
    }

  private void filterData() {
    try {
        java.util.Date startDate = j_mulai.getDate();
        java.util.Date endDate = j_selesai.getDate();

        if (startDate != null && endDate != null) {
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String startDateString = sdf.format(startDate);
            String endDateString = sdf.format(endDate);

            String sql = "SELECT * FROM laporan_transaksi_pemasukkan_2 WHERE tanggal BETWEEN ? AND ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, startDateString);
            preparedStatement.setString(2, endDateString);
            ResultSet resultSet = preparedStatement.executeQuery();

            DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
            model.setRowCount(0);

            int totalPemasukkan = 0;
            DecimalFormat df = new DecimalFormat("#,###");

            ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();

            while (resultSet.next()) {
                Vector<String> row = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getString(i));
                }             
                totalPemasukkan += (int) Math.round(resultSet.getDouble("total_harga"));
                model.addRow(row);
            }

            totallabel.setText("Total Pemasukkan: Rp " + df.format(totalPemasukkan));

            resultSet.close();
            preparedStatement.close();
        } else {
            JOptionPane.showMessageDialog(this, "Silakan pilih tanggal mulai dan akhir.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mengambil data: " + ex.getMessage());
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        btn_tampilkan = new javax.swing.JButton();
        totallabel = new javax.swing.JLabel();
        btn_barang = new javax.swing.JButton();
        btn_supplier = new javax.swing.JButton();
        btn_transaksibeli = new javax.swing.JButton();
        btn_transaksijual = new javax.swing.JButton();
        btn_laporanpengeluaran = new javax.swing.JButton();
        t_cari = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        j_mulai = new com.toedter.calendar.JDateChooser();
        j_selesai = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 832));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_data.setBackground(new java.awt.Color(112, 158, 195));
        tbl_data.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id tr penjualan", "Jenis barang", "Nama barang", "Tanggal", "Harga jual", "Jumlah barang", "Total harga", "Id barang"
            }
        ));
        tbl_data.setToolTipText("");
        tbl_data.setRowHeight(40);
        jScrollPane1.setViewportView(tbl_data);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 950, 440));

        btn_tampilkan.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        btn_tampilkan.setBorder(null);
        btn_tampilkan.setBorderPainted(false);
        btn_tampilkan.setContentAreaFilled(false);
        btn_tampilkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tampilkanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tampilkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 110, 140, 30));

        totallabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        totallabel.setText("TOTAL PEMASUKAN :");
        getContentPane().add(totallabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 240, 20));

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
        getContentPane().add(btn_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 110, 40));

        btn_supplier.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        btn_supplier.setBorder(null);
        btn_supplier.setBorderPainted(false);
        btn_supplier.setContentAreaFilled(false);
        btn_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_supplierActionPerformed(evt);
            }
        });
        getContentPane().add(btn_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 110, 40));

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
        getContentPane().add(btn_transaksijual, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 150, 60));

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
        getContentPane().add(btn_laporanpengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 650, 170, 70));

        t_cari.setBackground(new java.awt.Color(217, 217, 217));
        t_cari.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        t_cari.setBorder(null);
        t_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_cariActionPerformed(evt);
            }
        });
        getContentPane().add(t_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 260, 130, 40));

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
        getContentPane().add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 260, 90, 40));

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
        getContentPane().add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 760, 120, 40));

        j_mulai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        j_mulai.setMaxSelectableDate(new java.util.Date(253370743278000L));
        getContentPane().add(j_mulai, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, 140, 30));

        j_selesai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(j_selesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 110, 140, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/IMAGE LAPORAN MASUK.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tampilkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tampilkanActionPerformed
        filterData();
    }//GEN-LAST:event_btn_tampilkanActionPerformed

    private void btn_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_barangActionPerformed
        barang halut = new barang();
                halut.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_btn_barangActionPerformed

    private void btn_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supplierActionPerformed
        SUPPLIER sp = new SUPPLIER();
        sp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_supplierActionPerformed

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

    String sql = "SELECT * FROM laporan_transaksi_pemasukkan_2 WHERE " + "jenis_barang LIKE ? OR " + "nama_barang LIKE ? OR " + "id_transaksi_penjualan LIKE ?"; 
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        for (int i = 1; i <= 3; i++) {
            stmt.setString(i, "%" + keyword + "%");
        }

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {                         
                String id_transaksi_penjualan = rs.getString("id_transaksi_penjualan");
                String jenis_barang = rs.getString("jenis_barang");
                String nama_barang = rs.getString("nama_barang");
                String tanggal = rs.getString("tanggal");
                String harga_jual = rs.getString("harga_jual");
                String jumlah_barang = rs.getString("jumlah_barang");
                String total_harga = rs.getString("total_harga");
                String id_barang = rs.getString("id_barang");
                          
                Object[] rowData = {
                    id_transaksi_penjualan, jenis_barang, nama_barang, tanggal, harga_jual, jumlah_barang,total_harga, id_barang
                };
                model.addRow(rowData);
            }
        }
    } catch (SQLException e) {
        Logger.getLogger(barang.class.getName()).log(Level.SEVERE, "Error saat mencari data", e);
        JOptionPane.showMessageDialog(this, 
            "Error saat mencari data: " + e.getMessage(), 
            "Error", JOptionPane.ERROR_MESSAGE);
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(laporan_pemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(laporan_pemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(laporan_pemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(laporan_pemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new laporan_pemasukan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_barang;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_laporanpengeluaran;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_supplier;
    private javax.swing.JButton btn_tampilkan;
    private javax.swing.JButton btn_transaksibeli;
    private javax.swing.JButton btn_transaksijual;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser j_mulai;
    private com.toedter.calendar.JDateChooser j_selesai;
    private javax.swing.JTextField t_cari;
    private javax.swing.JTable tbl_data;
    private javax.swing.JLabel totallabel;
    // End of variables declaration//GEN-END:variables

    private void getData() {
       
    }
}
