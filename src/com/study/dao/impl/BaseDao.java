package com.study.dao.impl;

import com.study.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public abstract class BaseDao {
    private QueryRunner queryRunner=new QueryRunner();

    public int update(String sql,Object ... args) throws SQLException {
        Connection connection= JdbcUtils.getConnection();;
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    public <T> T queryForOne(Class<T> type,String sql,Object... args) throws SQLException {
        Connection con= JdbcUtils.getConnection();;
        try {
            return queryRunner.query(con, sql, new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(con);
        }
        return null;
    }

  public <T>List<T> quertForList(Class<T> type,String sql,Object... args) throws SQLException {
      Connection con= JdbcUtils.getConnection();;
      try {
          return (List<T>) queryRunner.query(con, sql, new BeanHandler<T>(type),args);
      } catch (SQLException e) {
          e.printStackTrace();
      }finally {
          JdbcUtils.close(con);
      }
      return null;
  }


    public Object queryForSingleValue(String sql,Object ... args) throws SQLException {
        Connection conn=JdbcUtils.getConnection();
        try {
           return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

}
