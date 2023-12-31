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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;

/**
 *
 * @author helmy
 */
public class AddMatkulController implements ActionListener {

    private JTextField kodematkul, namamatkul, sks = new JTextField();
    private DefaultTableModel model;
    private MatkulModelJDBC jdbc;

    public AddMatkulController(JTextField kodematkul, JTextField namamatkul, JTextField sks, DefaultTableModel model)
            throws SQLException {
        this.kodematkul = kodematkul;
        this.namamatkul = namamatkul;
        this.sks = sks;
        this.model = model;
        jdbc = new MatkulModelJDBC();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String kode = this.kodematkul.getText();
        String nama = this.namamatkul.getText();
        
        try {
            int sks = Integer.parseInt(this.sks.getText());

            if (kode != null && nama != null && sks != 0) {
                jdbc.addDataMatkul(kode, nama, sks);
                jdbc.matkulTabelModel(jdbc.getAllData());
                JOptionPane.showConfirmDialog(null, "Data baru berhasil disimpan di database..", "Sukses",
                        JOptionPane.OK_OPTION);

            } else {
                JOptionPane.showConfirmDialog(null, "Input Data tidak boleh kosong!! Silahkan isi dulu..", "Error",
                        JOptionPane.ERROR_MESSAGE);

            }

        } catch (NumberFormatException ex) {
            Logger.getLogger(AddMatkulController.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddMatkulController.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }
}
