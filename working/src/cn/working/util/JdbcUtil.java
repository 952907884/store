package cn.working.util;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by 王 on 2017/11/24.
 */
public class JdbcUtil {

    private static ComboPooledDataSource dataSource=new ComboPooledDataSource();

    public static Connection getConnection(){
        Connection conn=null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
