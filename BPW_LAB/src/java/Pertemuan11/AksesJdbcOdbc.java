package Pertemuan11;

import java.sql.*;

public class AksesJdbcOdbc {

    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;
    private String dsn;
    private String login;
    private String pwd;

    public AksesJdbcOdbc(String dsn, String login, String pwd) {
        this.dsn = dsn;
        this.login = login;
        this.pwd = pwd;
    }

    public Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ardybpw", "root", "");
        stmt = con.createStatement();
        return con;
    }

    public int executeUpdate(String str) throws SQLException {
        return stmt.executeUpdate(str);
    }

    public ResultSet executeQuery(String str) throws SQLException {
        rs = stmt.executeQuery(str);
        return rs;
    }

    public void disconnect() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public Statement getStmt() {
        return stmt;
    }

    public ResultSet getRs() {
        return rs;
    }
    
    public PreparedStatement getPs(String srt) throws SQLException {
        ps = con.prepareStatement(srt);
        return ps;
    }
}
