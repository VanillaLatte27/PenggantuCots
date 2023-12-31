/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.latihanswingmvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.mycompany.latihanswingmvc.helper.*;

/**
 *
 * @author helmy
 */
public class SearchMatkulController implements ActionListener {
    private JTextField searchText = new JTextField();
    private DefaultTableModel model;

    public SearchMatkulController(JTextField searchText, DefaultTableModel model) {
        this.searchText = searchText;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String searchString = this.searchText.getText();
        
        if (searchString != null && !searchString.equals("")) {
            if (searchString.trim().equals("*")) {
                model.setDataVector(DataDumies.DATA_MATKUL, DataDumies.TABEL_HEADER_MATKUL);
                return;
            }
            Object[][] newData = new Object[DataDumies.DATA_MATKUL.length][];
            int index = 0;
            for (Object[] objek : DataDumies.DATA_MATKUL) {
                if (String.valueOf(objek[1]).toUpperCase().contains(searchString.toUpperCase().trim())) {
                    newData[index++] = objek;
                }
            }
            model.setDataVector(newData, DataDumies.TABEL_HEADER_MATKUL); // data hasil pencarian
        } else {
            model.setDataVector(DataDumies.DATA_MATKUL, DataDumies.TABEL_HEADER_MATKUL); // jika search kosong maka
                                                                                         // munculkan lagi semua data
            JOptionPane.showConfirmDialog(null, "Tidak boleh kosong!! Silahkan isi lagi..", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
