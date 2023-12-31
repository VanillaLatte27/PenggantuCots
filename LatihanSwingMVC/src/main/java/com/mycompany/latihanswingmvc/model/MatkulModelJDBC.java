/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.latihanswingmvc.model;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import org.mariadb.jdbc.Statement;
import org.mariadb.jdbc.client.result.ResultSetMetaData;

/**
 *
 * @author helmy
 */
public class MatkulModelJDBC extends DefaultTableModel {

    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    public static final String[] TABEL_HEADER_MATKUL = {"KODE MATA KULIAH", "NAMA MATA KULIAH", "JUMLAH SKS"};
    JTable tabelmatkul;
    String jdbcUrl = "jdbc:mariadb://localhost:3306/jdbc_latihan";

    public MatkulModelJDBC() throws SQLException {
        

    }

    public ResultSet getAllData() throws SQLException {
        Connection con = DriverManager.getConnection(this.jdbcUrl, "root", "");
        if (con != null) {
            System.out.println("Koneksi database berhasil..!!");
        } else {
            System.out.println("Koneksi database gagal..!!");
        }
        Statement st = (Statement) con.createStatement();
        String sql = "select * from tabel_matkul";
        ResultSet datasql = st.executeQuery(sql);
        st.close();
        con.close();
        return datasql;

    }

    public DefaultTableModel matkulTabelModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metadata = (ResultSetMetaData) rs.getMetaData();
        DefaultTableModel model = null;

        Vector<String> namakolom = new Vector<>();//ambil nama kolom dari tabel matkul
        int jmlkolom = metadata.getColumnCount();
        for (int i = 1; i <= jmlkolom; i++) {
            namakolom.add(metadata.getColumnName(i));
        }

        Vector<Vector<Object>> data = new Vector<>(); //ambil data dari tabel matkul
        while (rs.next()) {
            Vector<Object> vektor = new Vector<Object>();
            for (int j = 1; j <= jmlkolom; j++) {
                vektor.add(rs.getObject(j));
            }
            data.add(vektor);
        }
        
        return new DefaultTableModel(data, namakolom);
    }
    
    public void addDataMatkul(String kode, String nama, int sks) throws SQLException{
        Connection con = DriverManager.getConnection(this.jdbcUrl, "root", "");
        if (con != null) {
            System.out.println("Koneksi database berhasil..!!");
        } else {
            System.out.println("Koneksi database gagal..!!");
        }
        String sql = "INSERT INTO tabel_matkul(kode_matkul,nama_matkul,sks) VALUES (?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ps.setString(2, nama);
        ps.setInt(3, sks);
        ps.executeUpdate();
       
        ps.close();
        con.close();
    }
    
    public int updateDataMatkul(String kode, String nama, int sks, String target) throws SQLException{
        // menghubungkan ke database
        Connection con = DriverManager.getConnection(this.jdbcUrl, "root", "");
        if (con != null) {
            System.out.println("Koneksi database berhasil..!!");
        } else {
            System.out.println("Koneksi database gagal..!!");
        }
        // query untuk update field pada tabel_matkul
        String sql = "UPDATE tabel_matkul SET kode_matkul = ?, nama_matkul = ?, sks = ? WHERE kode_matkul = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ps.setString(2, nama);
        ps.setInt(3, sks);
        ps.setString(4, target);
        
        // menyimpan perubahan row dalam database
        int ret = ps.executeUpdate();
       
        ps.close();
        con.close();
        
        // mengembalikan perubahan row dalam database
        return ret;
    }
    
    
    
    public int deleteDataMatkul(String kode) throws SQLException{
        Connection con = DriverManager.getConnection(this.jdbcUrl, "root", "");
        if (con != null) {
            System.out.println("Koneksi database berhasil..!!");
        } else {
            System.out.println("Koneksi database gagal..!!");
        }
        
        // query untuk delete tabel_matkul berdasarkan kode_matkulnya
        String sql = "DELETE FROM tabel_matkul WHERE kode_matkul = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        
        // menyimpan perubahan row dalam database
        int ret = ps.executeUpdate();
       
        ps.close();
        con.close();
        
        // mengembalikan perubahan row dalam database
        return ret;
    }
    
    

}
