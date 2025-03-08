package TRANSAKSI_BELI;

import BARANG.barang;
import LAPORAN_PEMASUKAN.laporan_pemasukan;
import LAPORAN_PENGELUARAN.laporan_pengeluaran;
import LOGIN.LOGIN;
import SUPPLIER.SUPPLIER;
import TRANSAKSI_JUAL.TRANSAKSI_JUAL;
import koneksi.konek;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TRANSAKSI_BELI extends javax.swing.JFrame {

    private Connection conn;
    
    public TRANSAKSI_BELI() {
        initComponents();
        initializeDatabaseConnection();
        sup();
    }

    private void initializeDatabaseConnection() {
        conn = konek.getConnection();
        if (conn != null) {
            getData();
        } else {
            JOptionPane.showMessageDialog(this, "Koneksi ke database gagal!", "Koneksi Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void getData() {
    DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
    model.setRowCount(0);

    try (PreparedStatement st = conn.prepareStatement("SELECT * FROM transaksi_beli");
         ResultSet rs = st.executeQuery()) {
   
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        while (rs.next()) {
            String idTransaksi = rs.getString("id_transaksi_pembelian");
            String jenisBarang = rs.getString("jenis_barang");
            String namaBarang = rs.getString("nama_barang");
            java.sql.Date tanggal = rs.getDate("tanggal");
         
            String formattedDate = (tanggal != null) ? dateFormat.format(tanggal) : "";

            int hargaBeli = rs.getInt("harga_beli");
            int jumlahBarang = rs.getInt("jumlah_barang");
            int totalHarga = rs.getInt("total_harga");
            String idSupplier = rs.getString("id_supplier");
            String idBarang = rs.getString("id_barang");

            Object[] rowData = {
                idTransaksi,
                jenisBarang,
                namaBarang,
                formattedDate,  
                hargaBeli,
                jumlahBarang,
                totalHarga,
                idSupplier,
                idBarang
            };
            model.addRow(rowData); 
        }
    } catch (Exception e) {
        Logger.getLogger(TRANSAKSI_BELI.class.getName()).log(Level.SEVERE, null, e);
    }
}
     private void sup() {
        try (PreparedStatement st = conn.prepareStatement("SELECT DISTINCT id_supplier, nama_supplier FROM supplier");
             ResultSet rs = st.executeQuery()) {

            c_supplier.removeAllItems();

            while (rs.next()) {
                String id_supplier = rs.getString("id_supplier");
                String Combined = id_supplier ;
                c_supplier.addItem(Combined);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TRANSAKSI_BELI.class.getName()).log(Level.SEVERE, "Error executing query", ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        t_idtransaksipembelian = new javax.swing.JTextField();
        t_jumlahbarang = new javax.swing.JTextField();
        t_totalharga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        btn_tambah = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_barang = new javax.swing.JButton();
        btn_supplier = new javax.swing.JButton();
        btn_transaksijual = new javax.swing.JButton();
        btn_laporanpemasukan = new javax.swing.JButton();
        btn_laporanpengeluaran = new javax.swing.JButton();
        t_cari = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        jcalender_beli = new com.toedter.calendar.JDateChooser();
        t_jenisbarang = new javax.swing.JTextField();
        t_namabarang = new javax.swing.JTextField();
        t_hargabeli = new javax.swing.JTextField();
        c_supplier = new javax.swing.JComboBox<>();
        btn_icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_idtransaksipembelian.setBackground(new java.awt.Color(217, 217, 217));
        t_idtransaksipembelian.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        t_idtransaksipembelian.setBorder(null);
        t_idtransaksipembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_idtransaksipembelianActionPerformed(evt);
            }
        });
        getContentPane().add(t_idtransaksipembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 100, -1));

        t_jumlahbarang.setBackground(new java.awt.Color(217, 217, 217));
        t_jumlahbarang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        t_jumlahbarang.setBorder(null);
        t_jumlahbarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_jumlahbarangMouseClicked(evt);
            }
        });
        t_jumlahbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_jumlahbarangActionPerformed(evt);
            }
        });
        getContentPane().add(t_jumlahbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 110, 30));

        t_totalharga.setBackground(new java.awt.Color(217, 217, 217));
        t_totalharga.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        t_totalharga.setBorder(null);
        t_totalharga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_totalhargaMouseClicked(evt);
            }
        });
        t_totalharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_totalhargaActionPerformed(evt);
            }
        });
        getContentPane().add(t_totalharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, 110, 30));

        tbl_data.setBackground(new java.awt.Color(112, 158, 195));
        tbl_data.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id tr pembelian", "Jenis barang", "Nama barang", "Tanggal", "Harga beli", "Jumlah barang", "Total harga", "Id supplier", "Id barang"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_data.setRowHeight(40);
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_data);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 950, 400));

        btn_tambah.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        btn_tambah.setBorder(null);
        btn_tambah.setBorderPainted(false);
        btn_tambah.setContentAreaFilled(false);
        btn_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tambahMouseClicked(evt);
            }
        });
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 780, 100, 30));

        btn_ubah.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        btn_ubah.setBorder(null);
        btn_ubah.setBorderPainted(false);
        btn_ubah.setContentAreaFilled(false);
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 780, 100, 30));

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
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 780, 110, 30));

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
        getContentPane().add(btn_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 130, 40));

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
        getContentPane().add(btn_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 130, 40));

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
        getContentPane().add(btn_transaksijual, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 150, 70));

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
        getContentPane().add(btn_laporanpemasukan, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 550, 160, 60));

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
        getContentPane().add(btn_laporanpengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 650, 160, 70));

        t_cari.setBackground(new java.awt.Color(217, 217, 217));
        t_cari.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        t_cari.setBorder(null);
        t_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_cariActionPerformed(evt);
            }
        });
        getContentPane().add(t_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 300, 140, -1));

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
        getContentPane().add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 290, 90, 40));

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
        getContentPane().add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 760, 110, 40));

        jcalender_beli.setBackground(new java.awt.Color(112, 158, 195));
        jcalender_beli.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(jcalender_beli, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 160, 40));

        t_jenisbarang.setBackground(new java.awt.Color(217, 217, 217));
        t_jenisbarang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        t_jenisbarang.setBorder(null);
        getContentPane().add(t_jenisbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, 110, 30));

        t_namabarang.setBackground(new java.awt.Color(217, 217, 217));
        t_namabarang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        t_namabarang.setBorder(null);
        t_namabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_namabarangActionPerformed(evt);
            }
        });
        getContentPane().add(t_namabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 120, 120, 30));

        t_hargabeli.setBackground(new java.awt.Color(217, 217, 217));
        t_hargabeli.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        t_hargabeli.setBorder(null);
        getContentPane().add(t_hargabeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 100, 30));

        c_supplier.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        c_supplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        getContentPane().add(c_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 210, 160, 45));

        btn_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/NEW IMAGE TRANSAKSI PEMBELIAN.jpg"))); // NOI18N
        btn_icon.setRequestFocusEnabled(false);
        getContentPane().add(btn_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 830));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void t_totalhargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_totalhargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_totalhargaActionPerformed
     
    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
    String idtransaksi_beli = t_idtransaksipembelian.getText().trim();

    if (idtransaksi_beli.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Masukkan ID Transaksi Pembelian yang akan dihapus.");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus transaksi ini?", 
                                                "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return;  
    }

    try {
        String sqlDeleteTransaksi = "DELETE FROM transaksi_beli WHERE id_transaksi_pembelian = ?";
              
        try (PreparedStatement pst = conn.prepareStatement(sqlDeleteTransaksi)) {
            pst.setString(1, idtransaksi_beli);
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {              
                JOptionPane.showMessageDialog(this, "Transaksi berhasil dihapus.");
                getData();  
                resetForm();  
            } else {               
                JOptionPane.showMessageDialog(this, "Transaksi dengan ID tersebut tidak ditemukan.");
            }
        }
    } catch (SQLException ex) {       
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus data: " + ex.getMessage());
    }

    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
String idtransaksi_beli = t_idtransaksipembelian.getText().trim();
String jenis_barang = t_jenisbarang.getText().trim();
String nama_barang = t_namabarang.getText().trim();
String jumlah_barangStr = t_jumlahbarang.getText().trim();
String hargaStr = t_hargabeli.getText().trim();
java.util.Date selectedDate = jcalender_beli.getDate();

if (selectedDate == null) {
    JOptionPane.showMessageDialog(this, "Pilih tanggal terlebih dahulu!");
    return;
}

String tanggalStr = new SimpleDateFormat("yyyy-MM-dd").format(selectedDate);

if (idtransaksi_beli.isEmpty() || jenis_barang.isEmpty() || nama_barang.isEmpty() || jumlah_barangStr.isEmpty() || hargaStr.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Semua kolom harus diisi.");
    return;
}

try {
    int jumlah_barang = Integer.parseInt(jumlah_barangStr);
    int hargaBeli = Integer.parseInt(hargaStr.replace("Rp ", "").trim());

    if (jumlah_barang <= 0 || hargaBeli <= 0) {
        JOptionPane.showMessageDialog(this, "Jumlah atau harga harus lebih besar dari 0.");
        return;
    }

    String selectedSupplier = (String) c_supplier.getSelectedItem();
    if (selectedSupplier == null || selectedSupplier.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Pilih supplier terlebih dahulu!");
        return;
    }

    String sqlGetSupplierId = "SELECT id_supplier FROM supplier WHERE id_supplier = ?";
    String idSupplier = "";
    try (PreparedStatement pst = conn.prepareStatement(sqlGetSupplierId)) {
        pst.setString(1, selectedSupplier);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            idSupplier = rs.getString("id_supplier");
        } else {
            JOptionPane.showMessageDialog(this, "Supplier tidak ditemukan.");
            return;
        }
    }
        String idPedagang = "";
        String sqlGetPedagangId = "SELECT id_pedagang FROM pedagang LIMIT 1";
        try (PreparedStatement pstPedagang = conn.prepareStatement(sqlGetPedagangId)) {
            ResultSet rs = pstPedagang.executeQuery();
            if (rs.next()) {
                idPedagang = rs.getString("id_pedagang");
            } else {
                JOptionPane.showMessageDialog(this, "Pedagang tidak ditemukan.");
                return;
            }
        }

    long idBarang = -1;
    String sqlCheckBarang = "SELECT id_barang, stok, harga_beli FROM barang WHERE nama_barang = ? AND jenis_barang = ?";
    try (PreparedStatement pstCheck = conn.prepareStatement(sqlCheckBarang)) {
        pstCheck.setString(1, nama_barang);
        pstCheck.setString(2, jenis_barang);
        try (ResultSet rs = pstCheck.executeQuery()) {
            if (rs.next()) {
                idBarang = rs.getLong("id_barang");
                int stokLama = rs.getInt("stok");
                int hargaLama = rs.getInt("harga_beli");
              
                if (hargaLama != hargaBeli) {
                    String sqlUpdateHarga = "UPDATE barang SET harga_beli = ? WHERE id_barang = ?";
                    try (PreparedStatement pstUpdateHarga = conn.prepareStatement(sqlUpdateHarga)) {
                        pstUpdateHarga.setInt(1, hargaBeli);
                        pstUpdateHarga.setLong(2, idBarang);
                        pstUpdateHarga.executeUpdate();
                    }
                }
                
            } else {               
                String sqlInsertBarang = "INSERT INTO barang (nama_barang, jenis_barang, stok, harga_beli, id_pedagang) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement pstInsert = conn.prepareStatement(sqlInsertBarang, PreparedStatement.RETURN_GENERATED_KEYS)) {
                    pstInsert.setString(1, nama_barang);
                    pstInsert.setString(2, jenis_barang);
                    pstInsert.setInt(3, jumlah_barang);
                    pstInsert.setInt(4, hargaBeli);
                    pstInsert.setString(5, idPedagang);
                    pstInsert.executeUpdate();

                    try (ResultSet generatedKeys = pstInsert.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            idBarang = generatedKeys.getLong(1);
                        } else {
                            throw new SQLException("Gagal mendapatkan ID barang baru.");
                        }
                    }
                }
            }
        }
    }
    
    String sqlInsertTransaksi = "INSERT INTO transaksi_beli (id_transaksi_pembelian, tanggal, id_supplier, id_barang, nama_barang, jenis_barang, harga_beli, jumlah_barang, total_harga) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement pstTransaksi = conn.prepareStatement(sqlInsertTransaksi)) {
        pstTransaksi.setString(1, idtransaksi_beli);
        pstTransaksi.setDate(2, java.sql.Date.valueOf(tanggalStr));
        pstTransaksi.setString(3, idSupplier);
        pstTransaksi.setLong(4, idBarang);
        pstTransaksi.setString(5, nama_barang);
        pstTransaksi.setString(6, jenis_barang);
        pstTransaksi.setInt(7, hargaBeli);
        pstTransaksi.setInt(8, jumlah_barang);
        pstTransaksi.setInt(9, hargaBeli * jumlah_barang);
        pstTransaksi.executeUpdate();
    }

    getData();
    JOptionPane.showMessageDialog(this, "Transaksi berhasil ditambahkan.");
    resetForm();

} catch (NumberFormatException ex) {
    JOptionPane.showMessageDialog(this, "Format jumlah atau harga salah.");
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menambahkan data: " + ex.getMessage());
}

    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
    String idTransaksiBeli = t_idtransaksipembelian.getText().trim();
    String jenisBarang = t_jenisbarang.getText().trim();
    String namaBarang = t_namabarang.getText().trim();
    String jumlahBarangStr = t_jumlahbarang.getText().trim();
    String hargaBeliStr = t_hargabeli.getText().trim();
    java.util.Date selectedDate = jcalender_beli.getDate();

    if (idTransaksiBeli.isEmpty() || jenisBarang.isEmpty() || namaBarang.isEmpty() || 
        jumlahBarangStr.isEmpty() || hargaBeliStr.isEmpty() || selectedDate == null) {
        JOptionPane.showMessageDialog(this, "Harap lengkapi semua data!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int jumlahBarang;
    int hargaBeli;

    try {
        jumlahBarang = Integer.parseInt(jumlahBarangStr);
        hargaBeli = Integer.parseInt(hargaBeliStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Jumlah barang dan harga beli harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int totalHarga = jumlahBarang * hargaBeli;

    java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());

    try (PreparedStatement st = conn.prepareStatement(
            "UPDATE transaksi_beli SET jenis_barang = ?, nama_barang = ?, tanggal = ?, harga_beli = ?, jumlah_barang = ?, total_harga = ? WHERE id_transaksi_pembelian = ?")) {
        st.setString(1, jenisBarang);
        st.setString(2, namaBarang);
        st.setDate(3, sqlDate);
        st.setInt(4, hargaBeli);
        st.setInt(5, jumlahBarang);
        st.setInt(6, totalHarga);
        st.setString(7, idTransaksiBeli);

        int rowsUpdated = st.executeUpdate();

        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(this, "Data berhasil diubah!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            getData();
            resetForm();
            
        } else {
            JOptionPane.showMessageDialog(this, "Data gagal diubah!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException ex) {
        Logger.getLogger(TRANSAKSI_BELI.class.getName()).log(Level.SEVERE, "Error updating data", ex);
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mengubah data!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btn_ubahActionPerformed

    private void btn_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseClicked
  
    }//GEN-LAST:event_btn_hapusMouseClicked

    private void btn_tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tambahMouseClicked

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
    int row = tbl_data.getSelectedRow(); 
    if (row != -1) {
       
        String idTransaksi = tbl_data.getValueAt(row, 0).toString();
        String jenisBarang = tbl_data.getValueAt(row, 1).toString();
        String namaBarang = tbl_data.getValueAt(row, 2).toString();
        String tanggal = tbl_data.getValueAt(row, 3).toString();
        String hargaBeli = tbl_data.getValueAt(row, 4).toString();
        String jumlahBarang = tbl_data.getValueAt(row, 5).toString();
        String totalHarga = tbl_data.getValueAt(row, 6).toString();
        String idSupplier = tbl_data.getValueAt(row, 7).toString();  
        String idBarang = tbl_data.getValueAt(row, 8).toString();
     
        hargaBeli = hargaBeli.replace("Rp", "").replace(".", "").trim();
        
        totalHarga = totalHarga.replace("Rp", "").replace(".", "").trim();

        try {
            int harga_Beli = Integer.parseInt(hargaBeli);  
            int jumlah = Integer.parseInt(jumlahBarang.trim());
       
            int totalBeli = harga_Beli * jumlah;

            String totalFormatted = String.format("%d", totalBeli);  

            t_namabarang.setText(namaBarang); 
            t_jenisbarang.setText(jenisBarang); 
            t_jumlahbarang.setText(jumlahBarang);
            t_hargabeli.setText(String.format("%d", harga_Beli)); 
            t_totalharga.setText(totalFormatted); 
         
            t_idtransaksipembelian.setText(idTransaksi); 
         
            try {               
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");  
                java.util.Date date = sdf.parse(tanggal);  
                jcalender_beli.setDate(date);  
            } catch (ParseException ex) {
                System.err.println("Error parsing date: " + ex.getMessage());
                JOptionPane.showMessageDialog(this, "Error parsing date: " + ex.getMessage());
            }

            for (int i = 0; i < c_supplier.getItemCount(); i++) {
                if (c_supplier.getItemAt(i).equals(idSupplier)) {
                    c_supplier.setSelectedIndex(i);
                    break;  
                }
            }
        } catch (NumberFormatException ex) {          
            JOptionPane.showMessageDialog(this, "Error parsing harga or jumlah: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Pilih baris terlebih dahulu.");
    }
    
    }//GEN-LAST:event_tbl_dataMouseClicked

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
    java.util.Date startDate = jcalender_beli.getDate(); 
    java.util.Date endDate = jcalender_beli.getDate(); 

    if (!keyword.isEmpty() || startDate != null || endDate != null) {
        searchData(keyword, startDate, endDate); 
    } else {
        getData(); 
    }
}

private void searchData(String keyword, java.util.Date startDate, java.util.Date endDate) {
    DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
    model.setRowCount(0); 

    String sql = "SELECT * FROM transaksi_beli WHERE " +
                 "(id_transaksi_pembelian LIKE ? OR jenis_barang LIKE ? OR nama_barang LIKE ?)";
    if (startDate != null) sql += " AND tanggal >= ?";
    if (endDate != null) sql += " AND tanggal <= ?";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        int paramIndex = 1;
        
        stmt.setString(paramIndex++, "%" + keyword + "%");
        stmt.setString(paramIndex++, "%" + keyword + "%");
        stmt.setString(paramIndex++, "%" + keyword + "%");

        if (startDate != null) {
            java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
            stmt.setDate(paramIndex++, sqlStartDate);
        }

        if (endDate != null) {
            java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
            stmt.setDate(paramIndex++, sqlEndDate);
        }

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String idTransaksiPembelian = rs.getString("id_transaksi_pembelian");
                String jenisBarang = rs.getString("jenis_barang");
                String namaBarang = rs.getString("nama_barang");
                String tanggal = rs.getString("tanggal");
                int hargaBeli = rs.getInt("harga_beli");
                int jumlahBarang = rs.getInt("jumlah_barang");
                int totalHarga = rs.getInt("total_harga");
                String idSupplier = rs.getString("id_supplier");
                String idBarang = rs.getString("id_barang");

                Object[] rowData = {
                    idTransaksiPembelian,
                    jenisBarang,
                    namaBarang,
                    tanggal,
                    hargaBeli,
                    jumlahBarang,
                    totalHarga,
                    idSupplier,
                    idBarang
                };
                model.addRow(rowData); 
            }
        }
    } catch (SQLException e) {
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

    private void t_idtransaksipembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_idtransaksipembelianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_idtransaksipembelianActionPerformed

    private void t_totalhargaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_totalhargaMouseClicked

    }//GEN-LAST:event_t_totalhargaMouseClicked

    private void t_jumlahbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_jumlahbarangActionPerformed
    String jumlahStr = t_jumlahbarang.getText().trim();  
    String hargaBeliStr = t_hargabeli.getText().trim();  

    if (jumlahStr.isEmpty() || hargaBeliStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Jumlah dan harga beli harus diisi.");
        return;
    }

    try {       
        int jumlah = Integer.parseInt(jumlahStr);
        int hargaBeli = Integer.parseInt(hargaBeliStr.trim()); 
        
        int totalBeli = hargaBeli * jumlah;
        
        t_totalharga.setText(String.valueOf(totalBeli)); 

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Input jumlah atau harga tidak valid.");
    }

    }//GEN-LAST:event_t_jumlahbarangActionPerformed

    private void t_jumlahbarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_jumlahbarangMouseClicked

    }//GEN-LAST:event_t_jumlahbarangMouseClicked

    private void t_namabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_namabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_namabarangActionPerformed

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
            java.util.logging.Logger.getLogger(TRANSAKSI_BELI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TRANSAKSI_BELI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TRANSAKSI_BELI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TRANSAKSI_BELI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TRANSAKSI_BELI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_barang;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JLabel btn_icon;
    private javax.swing.JButton btn_laporanpemasukan;
    private javax.swing.JButton btn_laporanpengeluaran;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_supplier;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_transaksijual;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JComboBox<String> c_supplier;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jcalender_beli;
    private javax.swing.JTextField t_cari;
    private javax.swing.JTextField t_hargabeli;
    private javax.swing.JTextField t_idtransaksipembelian;
    private javax.swing.JTextField t_jenisbarang;
    private javax.swing.JTextField t_jumlahbarang;
    private javax.swing.JTextField t_namabarang;
    private javax.swing.JTextField t_totalharga;
    private javax.swing.JTable tbl_data;
    // End of variables declaration//GEN-END:variables
private void resetForm() {
    t_idtransaksipembelian.setText("");
    t_jenisbarang.setText("");
    t_namabarang.setText("");
    t_jumlahbarang.setText("");
    t_hargabeli.setText("");
    t_totalharga.setText("");
    jcalender_beli.setDate(null);
    c_supplier.setSelectedIndex(-1);
}
}
