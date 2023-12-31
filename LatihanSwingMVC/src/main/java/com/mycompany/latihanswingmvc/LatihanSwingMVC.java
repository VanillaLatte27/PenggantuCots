/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.latihanswingmvc;

import com.mycompany.latihanswingmvc.helper.MariaDBConnect;
import com.mycompany.latihanswingmvc.view.MatkulView;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author helmy
 */
public class LatihanSwingMVC {

    public static void main(String[] args) throws SQLException {
        MatkulView gui = new MatkulView();
        gui.setVisible(true);

        //  MariaDBConnect db1 = new MariaDBConnect("localhost", 3306, "jdbc_latihan", "root", "");
        //db1.connectMaria();
    }
}
