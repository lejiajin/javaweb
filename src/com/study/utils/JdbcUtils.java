package com.study.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static DruidDataSource dataSource;


    static {

        try {
            //创建数据库连接池
            Properties properties=new Properties();
            InputStream InputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(InputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
    * 获取数据库连接
    * */
    public static Connection getConnection() throws SQLException {
        Connection conn=null;
         conn = dataSource.getConnection();

        return conn;
    }



    public static void close(Connection conn) throws SQLException {
        if (conn!=null) {
            conn.close();
        }

    }
}
