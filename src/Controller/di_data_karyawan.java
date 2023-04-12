/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class di_data_karyawan {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    
    public String nip;
    public String nama;
    public String jabatan;
    public String jenis_kelamin;
    public String agama;
    public String status;
    public String alamat;
    
    public void simpan()throws SQLException {
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO input_data_karyawan(NIP,Nama,Jabatan,Jenis_Kelamin,Agama,Status,Alamat) VALUES (?,?,?,?,?,?,?);";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nip);
        pst.setString(2,nama);
        pst.setString(3,jabatan);
        pst.setString(4,jenis_kelamin);
        pst.setString(5,agama);
        pst.setString(6,status);
        pst.setString(7,alamat);
        pst.execute();
        pst.close();
    }
    
    public void ubah()throws SQLException {
        conn = Koneksi.getKoneksi();
        sql = "UPDATE input_data_karyawan set Nama=?,Jabatan=?,Jenis_Kelamin=?,Agama=?,Status=?,Alamat=?,NIP=?;";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nama);
        pst.setString(2,jabatan);
        pst.setString(3,jenis_kelamin);
        pst.setString(4,agama);
        pst.setString(5,status);
        pst.setString(6,alamat);
        pst.setString(7,nip);
        pst.execute();
        pst.close();
    }
    
    public void hapus()throws SQLException {
        conn = Koneksi.getKoneksi();
        String sql = "DELTE from input_data_karyawan where nip=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, nip);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet UpdateJTable()throws SQLException {
        conn = Koneksi.getKoneksi();
        sql = "select NIP,Nama,Jabatan,Jenis_Kelamin,Agama,Status,Alamat from input_data_karyawan";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        
        return rs;
    }
    
}
