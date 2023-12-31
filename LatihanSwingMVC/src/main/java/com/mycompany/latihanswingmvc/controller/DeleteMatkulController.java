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

public class DeleteMatkulController implements ActionListener {
    
    private JTable tableModel;
    private MatkulModelJDBC jdbc;

    public DeleteMatkulController(JTable tableModel) throws SQLException  {
        this.tableModel = tableModel;
        this.jdbc = new MatkulModelJDBC();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // mendapatkan baris yang dipilih pada tabel dan indeks kolom kodeMatkul
        int row = tableModel.getSelectedRow();
        int col = 0; // kodeMatkul column index
        
        // mendapatkan nilai kodeMatkul dari baris yang dipilih
        String kodeMatkul = tableModel.getValueAt(row, col).toString();
        
        try {
            // memanggil metode deleteDataMatkul dari objek jdbc dengan parameter kodeMatkul
            int ret = this.jdbc.deleteDataMatkul(kodeMatkul);
            
            // menampilkan dialog konfirmasi berdasarkan hasil operasi penghapusan
            if (ret > 0) {
                JOptionPane.showConfirmDialog(null, "Matkul dengan kode " + kodeMatkul + " berhasil dihapus", "Sukses",
                        JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showConfirmDialog(null, "Matkul dengan kode " + kodeMatkul + " gagal dihapus", "Error",
                        JOptionPane.OK_OPTION);
            }
            
        } catch (SQLException ex) {
            // menangani sql error yang mungkin terjadi dengan menampilkannya dalam log
            Logger.getLogger(AddMatkulController.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
