package PT_PCR;

import java.sql.*;
import Pertemuan11.AksesJdbcOdbc;

public class PegawaiHome {

    public boolean create(Pegawai dataPegawai) {
        AksesJdbcOdbc akses = new AksesJdbcOdbc("jdbc:mysql://localhost:3306/db_ardybpw", "root", "");
        try {
            String insert = "insert into pegawai values("
                    + "'" + dataPegawai.getNip() + "',"
                    + "'" + dataPegawai.getNama_pegawai() + "',"
                    + "'" + dataPegawai.getAlamat() + "',"
                    + "'" + dataPegawai.getJabatan() + "')";
            akses.connect();
            akses.executeUpdate(insert);
            akses.disconnect();
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
