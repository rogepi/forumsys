package com.service;

import com.bean.User;
import com.dao.IUserDAO;
import com.db.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
  protected static final String FIELDS_INSERT = "uid, name, passwd, sex, rtime";
  protected static String INSERT_SQL = "insert into user (" + FIELDS_INSERT+ ")" +"values(0,?,?,?,NOW())";
  protected static String SELECT_SQL = "select " + FIELDS_INSERT + " from user where uid=?";
  protected static String SELECT_SQL2 = "select " + FIELDS_INSERT + " from user where name=?";
  protected static String UPDATE_SQL = "update user set" + " name=?,passwd=?,sex=? where uid=?";
  protected static String DELETE_SQL = "delete from user where uid=?";


  @Override
  public void create(User user) throws Exception {
    Connection conn;
    PreparedStatement pstm;
    conn = DBConn.getDBconnection();

    assert conn != null;
    pstm = conn.prepareStatement(INSERT_SQL);
      pstm.setString(1, user.getName());
      pstm.setString(2,user.getPasswd());
      pstm.setString(3,user.getSex());
      pstm.executeUpdate();

    DBConn.closeDB(conn,pstm,null);
  }

  @Override
  public void remove(User user) throws Exception {
    Connection conn;
    PreparedStatement pstm;
    conn = DBConn.getDBconnection();
    assert conn != null;
    pstm = conn.prepareStatement(DELETE_SQL);
      pstm.setInt(1,user.getUid());
      pstm.executeUpdate();
      DBConn.closeDB(conn,pstm,null);
  }

  @Override
  public User findById(User user) throws Exception {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    User user2 = null;
    conn = DBConn.getDBconnection();
    assert conn != null;
    pstm = conn.prepareStatement(SELECT_SQL);
    pstm.setInt(1,user.getUid());
    rs = pstm.executeQuery();
    if (rs.next()){
      user2 = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5));
    }
    DBConn.closeDB(conn,pstm,rs);
    return user2;
  }

  @Override
  public User findByName(User user) throws Exception {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    User user2 = null;
    conn = DBConn.getDBconnection();
    assert conn != null;
    pstm = conn.prepareStatement(SELECT_SQL2);
      pstm.setString(1,user.getName());
      rs = pstm.executeQuery();
      if (rs.next()){
        user2 = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5));
      }
    DBConn.closeDB(conn,pstm,rs);
    return user2;
  }

  @Override
  public List<User> findAll() throws Exception {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    List<User> user = new ArrayList<>();
    conn = DBConn.getDBconnection();
    assert conn != null;
    pstm = conn.prepareStatement("select * from user");
      rs = pstm.executeQuery();
      while (rs.next()){
        User user1 = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5));
        user.add(user1);
      }
    DBConn.closeDB(conn,pstm,rs);
    return user;
  }

  @Override
  public void update(User user) throws Exception {
    Connection conn;
    PreparedStatement pstm;
    conn = DBConn.getDBconnection();
    assert conn != null;
    pstm = conn.prepareStatement(UPDATE_SQL);
    pstm.setString(1,user.getName());
    pstm.setString(2,user.getPasswd());
    pstm.setString(3,user.getSex());
    pstm.setInt(4,user.getUid());
      int rowCount = pstm.executeUpdate();
      if (rowCount == 0) {
        throw new SQLException("Update Error:User uid:" + user.getUid());
      }
    DBConn.closeDB(conn,pstm,null);
  }

  @Override
  public int check(User user) throws Exception{
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    conn = DBConn.getDBconnection();
    assert conn != null;
    pstm = conn.prepareStatement("select name,passwd from User where name=?");
    pstm.setString(1,user.getName());
    rs = pstm.executeQuery();
    User user1 = new User();
    if (rs.next()){
      user1.setName(rs.getString(1));
      user1.setPasswd(rs.getString(2));
    }
    if (!user.getName().equals(user1.getName())) {
      return -1; // 用户名不存在返回-1
    } else {
      if (!user.getPasswd().equals(user1.getPasswd())) {
        return 0; // 密码不正确返回0
      } else {
        return 1; // 正确返回1
      }
    }
  }

  public boolean check(String name) throws Exception {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    conn = DBConn.getDBconnection();
    assert conn != null;
    pstm = conn.prepareStatement("select name from User where name=?");
    pstm.setString(1,name);
    rs = pstm.executeQuery();
    User user1 = new User();
    if (rs.next()){
      user1.setName(rs.getString(1));
    }
    return !name.equals(user1.getName()); // 用户名存在返回0
  }
}
