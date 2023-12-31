/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.latihanswingmvc.model;

import javax.swing.table.DefaultTableModel;
import com.mycompany.latihanswingmvc.helper.*;

/**
 *
 * @author helmy
 */
public class MatkulModel extends DefaultTableModel{
    public MatkulModel(){
        super(DataDumies.DATA_MATKUL,DataDumies.TABEL_HEADER_MATKUL);
    }
    
}
