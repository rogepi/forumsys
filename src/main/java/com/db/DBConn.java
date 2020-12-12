package com.db;

import java.sql.*;

public class DBConn {
  private static final String driverName = "com.mysql.cj.jdbc.Driver";
  private static final String userName = "root";
  private static final String userPwd = "root";
  private static final String dbName = "forumsys";

  public static Connection getDBconnection() {
    String url1 = "jdbc:mysql://localhost/" +dbName;
    String url2 = "?user="+userName+"&password=" +userPwd;
    String url3 = "&useUnicode=true&characterEncoding=UTF-8&&serverTimezone=UTC";
    String url = url1+url2 +url3;

    try{
      Class.forName(driverName);
      return DriverManager.getConnection(url);
    }catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void closeDB(Connection conn, PreparedStatement pstm, ResultSet rs) {
    try{
      if (rs!=null) rs.close();
      if (pstm!=null) pstm.close();
      if (conn!=null) conn.close();
    } catch (SQLException e){
      e.printStackTrace();
    }
  }
}
