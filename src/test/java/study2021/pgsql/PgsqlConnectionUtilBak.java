package study2021.pgsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description pg数据库连接工具
 * @Author WangZeJun
 * @Date 2021/06/24 17:23
 **/
public class PgsqlConnectionUtilBak {

    private String url = "jdbc:postgresql://127.0.0.1:5432/test001";

    private String username = "postgres";

    private String password = "postgres";

    private Connection connection = null;

    public Connection getConn() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            connection = DriverManager.getConnection(url, username, password);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ResultSet query(Connection conn, String sql) {
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public boolean queryUpdate(Connection conn, String sql) {
        PreparedStatement pStatement = null;
        int rs = 0;
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rs > 0) {
            return true;
        }
        return false;
    }

    public boolean createQuery(Connection conn, String sql) {
        PreparedStatement pStatement;
        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.execute();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws SQLException {
        PgsqlConnectionUtilBak pgUtil = new PgsqlConnectionUtilBak();
        Connection conn = pgUtil.getConn();
        boolean bool = pgUtil.createQuery(conn, "create table order_status (name varchar(100) null, code varchar(100) null)");
        System.out.println("执行结果：" + bool);
        conn.close();
    }

}