/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.latihanswingmvc.controller;

import com.mycompany.latihanswingmvc.model.MatkulModelJDBC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
 
public class UpdateMatkulController implements ActionListener {
    private JTable tableModel;
    private MatkulModelJDBC jdbc;
    
    private JTextField kodeMatkulBaru;
    private JTextField namaMatkulBaru;
    private JTextField sksBaru;
    
    
    public UpdateMatkulController(JTextField kodeMatkulBaru, JTextField namaMatkulBaru, JTextField sksBaru, JTable tableModel) throws SQLException {
        this.kodeMatkulBaru = kodeMatkulBaru;
        this.namaMatkulBaru = namaMatkulBaru;
        this.sksBaru = sksBaru;
        this.tableModel = tableModel;
        this.jdbc = new MatkulModelJDBC();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // mengambil nilai dari JTextField kodeMatkulBaru dan namaMatkulBaru
        String kodeMatkul = kodeMatkulBaru.getText();
        String namaMatkul = namaMatkulBaru.getText();
        
        // mendapatkan baris terpilih dari JTable dan indeks kolom kodeMatkul
        int row = tableModel.getSelectedRow();
        int col = 0; // kodeMatkul column index
        
        // mendapatkan nilai kodeMatkul dari baris terpilih
        String targetKode = tableModel.getValueAt(row, col).toString();
        
        try {
            // mengambil nilai SKS dari JTextField sksBaru
            int sks = Integer.parseInt(this.sksBaru.getText());
            
            // memanggil metode updateDataMatkul dari objek jdbc dengan parameter yang sesuai
            int ret = this.jdbc.updateDataMatkul(kodeMatkul, namaMatkul, sks, targetKode);
            
            // menampilkan dialog konfirmasi berdasarkan hasil operasi update
            // ret > 0, berarti operasi update berhasil dilakukan
            // ret <= 0, berarti operasi update gagal dilakukan karena tidak ada perubahan dalam database
            if (ret > 0) {
                JOptionPane.showConfirmDialog(null, "Matkul dengan kode " + targetKode + " berhasil diupdate", "Sukses",
                        JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showConfirmDialog(null, "Matkul dengan kode " + targetKode + " gagal diupdate", "Error",
                        JOptionPane.OK_OPTION);
            }
            
            // reset value text field
            kodeMatkulBaru.setText("Kode");
            namaMatkulBaru.setText("Nama Matkul");
            sksBaru.setText("SKS");
            
        } catch (Exception ex) {
            // menampilkan pesan error dan log exception jika terjadi kesalahan
            Logger.getLogger(UpdateMatkulController.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            JOptionPane.showConfirmDialog(null, ex.getMessage(), "Error",
                     JOptionPane.OK_OPTION);
        }

    
    }
}

 