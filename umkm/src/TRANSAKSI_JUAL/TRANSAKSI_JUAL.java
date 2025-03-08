package TRANSAKSI_JUAL;

import BARANG.barang;
import LAPORAN_PEMASUKAN.laporan_pemasukan;
import LAPORAN_PENGELUARAN.laporan_pengeluaran;
import LOGIN.LOGIN;
import SUPPLIER.SUPPLIER;
import TRANSAKSI_BELI.TRANSAKSI_BELI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.konek;

public class TRANSAKSI_JUAL extends javax.swing.JFrame {

    private Connection conn;

    public TRANSAKSI_JUAL() {
        initComponents();
        initializeDatabaseConnection();
         id();
         pdg();
         
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

    String sql = "SELECT * FROM transaksi_jual"; 
    try (PreparedStatement st = conn.prepareStatement(sql); 
         ResultSet rs = st.executeQuery()) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        while (rs.next()) {          
            String idTransaksi = rs.getString("id_transaksi_penjualan");
            String jenisBarang = rs.getString("jenis_barang");
            String namaBarang = rs.getString("nama_barang");
            java.sql.Date tanggal = rs.getDate("tanggal");
            
            String formattedDate = (tanggal != null) ? dateFormat.format(tanggal) : "";
            
            int hargaJual = rs.getInt("harga_jual");
            int jumlahBarang = rs.getInt("jumlah_barang");
            int totalHarga = rs.getInt("total_harga");          
            String idBarang = rs.getString("id_barang");
            String idPedagang = rs.getString("id_pedagang");

            Object[] rowData = {
                idTransaksi,
                jenisBarang,
                namaBarang,
                formattedDate,
                hargaJual,
                jumlahBarang,
                totalHarga,
                idBarang,
                idPedagang,
            };

            model.addRow(rowData);
        }
    } catch (SQLException e) {
        Logger.getLogger(TRANSAKSI_JUAL.class.getName()).log(Level.SEVERE, "Error fetching data", e);
    }
}

private void id() {
    String sql = "SELECT DISTINCT id_barang, jenis_barang, nama_barang, id_pedagang FROM barang";
    try (PreparedStatement st = conn.prepareStatement(sql);
         ResultSet rs = st.executeQuery()) {

        c_transaksijual.removeAllItems();  

        while (rs.next()) {
            String idBarang = rs.getString("id_barang");
            String jenisBarang = rs.getString("jenis_barang");
            String namaBarang = rs.getString("nama_barang");
            String combined = idBarang + "     |     " + jenisBarang + "     |     " + namaBarang;

           
            c_transaksijual.addItem(combined); 
        }
    } catch (SQLException ex) {
        Logger.getLogger(TRANSAKSI_JUAL.class.getName()).log(Level.SEVERE, "Error executing query", ex);
    }
}

private void pdg() {
    String sql = "SELECT DISTINCT id_pedagang FROM barang";
    try (PreparedStatement st = conn.prepareStatement(sql);
         ResultSet rs = st.executeQuery()) {

        c_pedagang.removeAllItems();  

        while (rs.next()) {
            String idPedagang = rs.getString("id_pedagang");
            
        c_pedagang.addItem(idPedagang); 
        }
    } catch (SQLException ex) {
        Logger.getLogger(TRANSAKSI_JUAL.class.getName()).log(Level.SEVERE, "Error executing query", ex);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        t_idtransaksipenjualan = new javax.swing.JTextField();
        t_jumlahbarang = new javax.swing.JTextField();
        t_totalharga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        btn_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        btn_barang = new javax.swing.JButton();
        btn_supplier = new javax.swing.JButton();
        btn_transaksibeli = new javax.swing.JButton();
        btn_laporanpemasukan = new javax.swing.JButton();
        btn_laporanpengeluaran = new javax.swing.JButton();
        t_cari = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        c_transaksijual = new javax.swing.JComboBox<>();
        jcalender_jual = new com.toedter.calendar.JDateChooser();
        t_hargajual = new javax.swing.JTextField();
        c_pedagang = new javax.swing.JComboBox<>();
        frameicon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_idtransaksipenjualan.setBackground(new java.awt.Color(217, 217, 217));
        t_idtransaksipenjualan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        t_idtransaksipenjualan.setBorder(null);
        getContentPane().add(t_idtransaksipenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 100, 30));

        t_jumlahbarang.setBackground(new java.awt.Color(217, 217, 217));
        t_jumlahbarang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        t_jumlahbarang.setBorder(null);
        t_jumlahbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_jumlahbarangActionPerformed(evt);
            }
        });
        getContentPane().add(t_jumlahbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 100, -1));

        t_totalharga.setBackground(new java.awt.Color(217, 217, 217));
        t_totalharga.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        t_totalharga.setBorder(null);
        t_totalharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_totalhargaActionPerformed(evt);
            }
        });
        getContentPane().add(t_totalharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 110, -1));

        tbl_data.setBackground(new java.awt.Color(112, 158, 195));
        tbl_data.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id tr penjualan", "Jenis barang", "Nama barang", "Tanggal", "Harga jual", "Jumlah barang", "Total harga", "Id barang", "Id pedagang"
            }
        ));
        tbl_data.setRowHeight(40);
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_dataMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_data);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 940, 400));

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
        getContentPane().add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 780, 100, 30));

        btn_hapus.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        btn_hapus.setBorder(null);
        btn_hapus.setBorderPainted(false);
        btn_hapus.setContentAreaFilled(false);
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 780, 110, 30));

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
        getContentPane().add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 780, 100, 30));

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
        getContentPane().add(btn_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 120, 40));

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
        getContentPane().add(btn_transaksibeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 130, 60));

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
        getContentPane().add(btn_laporanpemasukan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 140, 60));

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
        getContentPane().add(btn_laporanpengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 650, 170, 60));

        t_cari.setBackground(new java.awt.Color(217, 217, 217));
        t_cari.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        t_cari.setBorder(null);
        t_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_cariActionPerformed(evt);
            }
        });
        getContentPane().add(t_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 294, 130, -1));

        btn_cari.setForeground(new java.awt.Color(0, 0, 0, 0)
        );
        btn_cari.setBorder(null);
        btn_cari.setBorderPainted(false);
        btn_cari.setContentAreaFilled(false);
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 290, 90, 30));

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

        c_transaksijual.setBackground(new java.awt.Color(112, 158, 195));
        c_transaksijual.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        c_transaksijual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_transaksijualMouseClicked(evt);
            }
        });
        c_transaksijual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_transaksijualActionPerformed(evt);
            }
        });
        getContentPane().add(c_transaksijual, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 120, 290, 30));

        jcalender_jual.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(jcalender_jual, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 160, 40));

        t_hargajual.setBackground(new java.awt.Color(217, 217, 217));
        t_hargajual.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        t_hargajual.setBorder(null);
        t_hargajual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_hargajualActionPerformed(evt);
            }
        });
        getContentPane().add(t_hargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 120, 30));

        c_pedagang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(c_pedagang, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 200, 160, 40));

        frameicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/NEW IMAGE TRANSAKSI PENJUALAN.jpg"))); // NOI18N
        frameicon.setName(""); // NOI18N
        getContentPane().add(frameicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
    String idTransaksi = t_idtransaksipenjualan.getText().trim();
    String jumlahStr = t_jumlahbarang.getText().trim();
    String hargaStr = t_hargajual.getText().trim();
    java.util.Date selectedDate = jcalender_jual.getDate();

    if (selectedDate == null) {
        JOptionPane.showMessageDialog(this, "Pilih tanggal terlebih dahulu.");
        return;
    }
    
    String tanggalStr = new SimpleDateFormat("yyyy-MM-dd").format(selectedDate);

    if (idTransaksi.isEmpty() || jumlahStr.isEmpty() || hargaStr.isEmpty() || tanggalStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Semua kolom harus diisi.");
        return;
    }

    int jumlah_barang = parseInteger(jumlahStr, "Jumlah_barang");
    int hargaJual = parseHarga(hargaStr);
    
    if (jumlah_barang <= 0 || hargaJual <= 0) {
        return;  
    }
    
    String[] barangParts = parseBarang((String) c_transaksijual.getSelectedItem());
    if (barangParts == null) {
        return;  
    }
    String idBarang = barangParts[0];
    String jenisBarang = barangParts[2];
    String namaBarang = barangParts[4];

    String idPedagang = (String) c_pedagang.getSelectedItem();
    if (idPedagang == null) {
        JOptionPane.showMessageDialog(this, "Pilih pedagang terlebih dahulu.");
        return;  
    }

    String sqlCheckStock = "SELECT stok FROM barang WHERE id_barang = ?";
    try (PreparedStatement stCheck = conn.prepareStatement(sqlCheckStock)) {
        stCheck.setString(1, idBarang);
        try (ResultSet rs = stCheck.executeQuery()) {
            if (rs.next()) {
                int stokBarang = rs.getInt("stok");
                if (jumlah_barang > stokBarang) {
                    JOptionPane.showMessageDialog(null, "Stok barang tidak mencukupi.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Barang dengan ID tersebut tidak ditemukan.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Kesalahan koneksi database saat memeriksa stok: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(TRANSAKSI_JUAL.class.getName()).log(Level.SEVERE, null, e);
        return;
    }

    String sqlInsert = "INSERT INTO transaksi_jual (id_transaksi_penjualan, jenis_barang, nama_barang, tanggal, harga_jual, jumlah_barang, total_harga, id_barang, id_pedagang) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement pst = conn.prepareStatement(sqlInsert)) {
        pst.setString(1, idTransaksi);
        pst.setString(2, jenisBarang);
        pst.setString(3, namaBarang);
        pst.setDate(4, java.sql.Date.valueOf(tanggalStr));
        pst.setInt(5, hargaJual);
        pst.setInt(6, jumlah_barang);
        pst.setInt(7, hargaJual * jumlah_barang);
        pst.setString(8, idBarang);
        pst.setString(9, idPedagang);
        pst.executeUpdate();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menambahkan data: " + ex.getMessage());
        return;  
    }
    
    getData();
    JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan.");

    clearForm();
}

private int parseInteger(String value, String fieldName) {
    try {
        return Integer.parseInt(value);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, fieldName + " tidak valid.");
        return -1;  
    }
}

private int parseHarga(String hargaStr) {
    try {
        return Integer.parseInt(hargaStr.replace("Rp ", "").trim());
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Harga tidak valid.");
        return -1;  // Return invalid value
    }
}

private String[] parseBarang(String selectedBarang) {
    if (selectedBarang == null || selectedBarang.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Pilih barang terlebih dahulu.");
        return null;  
    }

    String[] barangParts = selectedBarang.split("     |     ");
    if (barangParts.length < 3) {
        JOptionPane.showMessageDialog(this, "Format item barang tidak valid.");
        return null;  
    }

    return barangParts;
    
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
    int selectedRow = tbl_data.getSelectedRow();  
    if (selectedRow != -1) {  
        DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();

        String idTransaksi = model.getValueAt(selectedRow, 0).toString();
        String jenisBarang = model.getValueAt(selectedRow, 1).toString();
        String namaBarang = model.getValueAt(selectedRow, 2).toString();
        Object tanggalObj = model.getValueAt(selectedRow, 3);
        int hargaJual = Integer.parseInt(model.getValueAt(selectedRow, 4).toString());
        int jumlahBarang = Integer.parseInt(model.getValueAt(selectedRow, 5).toString());
        int totalHarga = Integer.parseInt(model.getValueAt(selectedRow, 6).toString());
        String idBarang = model.getValueAt(selectedRow, 7).toString();
        String idPedagang = model.getValueAt(selectedRow, 8).toString();

        t_idtransaksipenjualan.setText(idTransaksi);
        t_jumlahbarang.setText(String.valueOf(jumlahBarang));
        t_totalharga.setText(String.valueOf(totalHarga));

        if (tanggalObj != null) {
            try {
                java.util.Date utilDate = null;
                if (tanggalObj instanceof java.sql.Date) {
                    utilDate = new java.util.Date(((java.sql.Date) tanggalObj).getTime());
                    
                } else if (tanggalObj instanceof String) {                   
                    String tanggalStr = (String) tanggalObj;
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    utilDate = sdf.parse(tanggalStr);  
                }

                if (utilDate != null) {
                    jcalender_jual.setDate(utilDate);  
                }
            } catch (Exception ex) {
                System.err.println("Error setting date: " + ex.getMessage());
                JOptionPane.showMessageDialog(this, "Error setting date: " + ex.getMessage());
            }
        }
      
        String combinedItem = idBarang + "     |     " + jenisBarang + "     |     " + namaBarang;
        boolean itemFound = false;
      
        for (int i = 0; i < c_transaksijual.getItemCount(); i++) {
            if (c_transaksijual.getItemAt(i).equals(combinedItem)) {
                c_transaksijual.setSelectedIndex(i);
                itemFound = true;
                break;
            }
        }
      
        if (!itemFound) {
            c_transaksijual.addItem(combinedItem);
            c_transaksijual.setSelectedItem(combinedItem);
        }

        for (int i = 0; i < c_pedagang.getItemCount(); i++) {
            if (c_pedagang.getItemAt(i).equals(idPedagang)) {
                c_pedagang.setSelectedIndex(i);
                break;
            }
        }

        t_hargajual.setText(String.valueOf(hargaJual));
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

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
    int selectedRow = tbl_data.getSelectedRow();

    if (selectedRow != -1) {  
        DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
              
        String idTransaksiPenjualan = model.getValueAt(selectedRow, 0).toString();

        int confirm = JOptionPane.showConfirmDialog(this, 
            "Apakah Anda yakin ingin menghapus data ini?", 
            "Konfirmasi Hapus", 
            JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {          
            String sqlDelete = "DELETE FROM transaksi_jual WHERE id_transaksi_penjualan = ?";

            try (PreparedStatement pstDelete = conn.prepareStatement(sqlDelete)) {
                pstDelete.setString(1, idTransaksiPenjualan);
              
                int rowsDeleted = pstDelete.executeUpdate();

                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
                    getData(); 
                    clearForm(); 
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal menghapus data!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(TRANSAKSI_JUAL.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
            }
        }
    } else {        
        JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!");
    }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
    int selectedRow = tbl_data.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Pilih baris data yang ingin diubah.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();

    String idTransaksi = t_idtransaksipenjualan.getText().trim();
    String jumlahStr = t_jumlahbarang.getText().trim();
    String hargaStr = t_hargajual.getText().trim();
    java.util.Date selectedDate = jcalender_jual.getDate();

    try {
        java.sql.Date tanggal = new java.sql.Date(selectedDate.getTime());
        int hargaJual = Integer.parseInt(hargaStr);
        int jumlahBarang = Integer.parseInt(jumlahStr);
        int totalHarga = hargaJual * jumlahBarang;

        String jenisBarang = model.getValueAt(selectedRow, 1).toString();
        String namaBarang = model.getValueAt(selectedRow, 2).toString();

        String sql = "UPDATE transaksi_jual SET jenis_barang = ?, nama_barang = ?, tanggal = ?, harga_jual = ?, jumlah_barang = ?, total_harga = ? WHERE id_transaksi_penjualan = ?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, jenisBarang);
        st.setString(2, namaBarang);
        st.setDate(3, tanggal);
        st.setInt(4, hargaJual);
        st.setInt(5, jumlahBarang);
        st.setInt(6, totalHarga);
        st.setString(7, idTransaksi);

        int rowsUpdated = st.executeUpdate();
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(null, "Data berhasil diubah.");
            getData(); 
            clearForm();
            
        } else {
            JOptionPane.showMessageDialog(null, "Tidak ada perubahan yang terjadi.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }

        st.close();
    } catch (Exception e) {
        Logger.getLogger(TRANSAKSI_JUAL.class.getName()).log(Level.SEVERE, null, e);
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mengubah data.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btn_ubahActionPerformed

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

    String sql = "SELECT * FROM transaksi_jual WHERE id_transaksi_penjualan LIKE ? OR jenis_barang LIKE ? OR nama_barang LIKE ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, "%" + keyword + "%");
        stmt.setString(2, "%" + keyword + "%");
        stmt.setString(3, "%" + keyword + "%");

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String idTransaksiPenjualan = rs.getString("id_transaksi_penjualan");
                String jenisBarang = rs.getString("jenis_barang");
                String namaBarang = rs.getString("nama_barang");
                String tanggal = rs.getString("tanggal"); 
                int hargaJual = rs.getInt("harga_jual");
                int jumlahBarang = rs.getInt("jumlah_barang");
                int totalHarga = rs.getInt("total_harga");               
                String idBarang = rs.getString("id_barang");
                String idpedagang = rs.getString("id_pedagang");

                Object[] rowData = {
                    idTransaksiPenjualan,
                    jenisBarang,
                    namaBarang,
                    tanggal,
                    hargaJual,
                    jumlahBarang,
                    totalHarga,                   
                    idBarang,
                    idpedagang,
                    
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

    private void t_totalhargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_totalhargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_totalhargaActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
    LOGIN halog = new LOGIN();
                halog.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void tbl_dataMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_dataMouseEntered

    private void t_jumlahbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_jumlahbarangActionPerformed
    String jumlahStr = t_jumlahbarang.getText().trim();  
    String hargaJualStr = t_hargajual.getText().trim();  

    if (jumlahStr.isEmpty() || hargaJualStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Jumlah dan harga jual harus diisi.");
        return;
    }

    try {     
        int jumlah_barang = Integer.parseInt(jumlahStr);
        int hargaJual = Integer.parseInt(hargaJualStr.trim()); 
        
        int totalBeli = hargaJual * jumlah_barang;

        t_totalharga.setText(String.valueOf(totalBeli)); 

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Input jumlah atau harga tidak valid.");
    }
    }//GEN-LAST:event_t_jumlahbarangActionPerformed

    private void c_transaksijualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_transaksijualMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_c_transaksijualMouseClicked

    private void c_transaksijualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_transaksijualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_transaksijualActionPerformed

    private void t_hargajualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_hargajualActionPerformed
    String idBarang = c_transaksijual.getSelectedItem().toString();

    try {
        String query = "SELECT harga_beli FROM barang WHERE id_barang = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, idBarang);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {            
            int hargaBeli = rs.getInt("harga_beli");
      
            t_hargajual.setText(String.valueOf(hargaBeli)); 
        } else {
            JOptionPane.showMessageDialog(this, "Harga beli untuk barang yang dipilih tidak ditemukan.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }

        rs.close();
        stmt.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Kesalahan saat mengambil harga beli: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
    }
   
    }//GEN-LAST:event_t_hargajualActionPerformed

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
            java.util.logging.Logger.getLogger(TRANSAKSI_JUAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TRANSAKSI_JUAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TRANSAKSI_JUAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TRANSAKSI_JUAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TRANSAKSI_JUAL().setVisible(true);
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
    private javax.swing.JButton btn_supplier;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_transaksibeli;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JComboBox<String> c_pedagang;
    private javax.swing.JComboBox<String> c_transaksijual;
    private javax.swing.JLabel frameicon;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jcalender_jual;
    private javax.swing.JTextField t_cari;
    private javax.swing.JTextField t_hargajual;
    private javax.swing.JTextField t_idtransaksipenjualan;
    private javax.swing.JTextField t_jumlahbarang;
    private javax.swing.JTextField t_totalharga;
    private javax.swing.JTable tbl_data;
    // End of variables declaration//GEN-END:variables
   
private void clearForm() {
    t_idtransaksipenjualan.setText("");
    t_jumlahbarang.setText("");
    t_hargajual.setText("");
    t_totalharga.setText("");
    jcalender_jual.setDate(null);  // Reset the date picker
    c_transaksijual.setSelectedIndex(-1);  // Reset the ComboBox for barang
    c_pedagang.setSelectedIndex(-1);  // Reset the ComboBox for pedagang
}
}
