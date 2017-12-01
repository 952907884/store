package store.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by 王 on 2017/11/7.
 * 获取数据库连接池和连接对象
 */
public class JdbcUtil {
    private static ComboPooledDataSource dataSource=new ComboPooledDataSource();

    /**
     * 获取数据库连接对象
     * @return
     */
    public static Connection getConnection(){
        Connection conn=null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 获取数据库连接池对象
     * @return
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

}
