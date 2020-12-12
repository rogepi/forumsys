package com.service;

import com.bean.Post;
import com.dao.IPostDAO;
import com.db.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDAO implements IPostDAO {

  protected static final String FIELDS_INSERT = "id, title, author, type, content, date";
  protected static String INSERT_SQL =
      "insert into post (" + FIELDS_INSERT + ")" + "values(0,?,?,?,?,NOW())";
  protected static String SELECT_SQL = "select " + FIELDS_INSERT + " from post where id=?";
  protected static String SELECT_SQL2 = "select " + FIELDS_INSERT + " from post where title=?";
  protected static String UPDATE_SQL =
      "update post set" + " title=?,author=?,type=?,content=? where id=?";
  protected static String DELETE_SQL = "delete from post where id=?";

  @Override
  public void create(Post post) throws Exception {
    Connection conn;
    PreparedStatement pstm;
    conn = DBConn.getDBconnection();

    assert conn != null;
    pstm = conn.prepareStatement(INSERT_SQL);
    pstm.setString(1, post.getTitle());
    pstm.setString(2, post.getAuthor());
    pstm.setString(3, post.getType());
    pstm.setString(4, post.getContent());
    pstm.executeUpdate();

    DBConn.closeDB(conn, pstm, null);
  }

  @Override
  public void remove(Post post) throws Exception {
    Connection conn;
    PreparedStatement pstm;
    conn = DBConn.getDBconnection();

    assert conn != null;
    pstm = conn.prepareStatement(DELETE_SQL);
    pstm.setInt(1, post.getId());
    pstm.executeUpdate();
    DBConn.closeDB(conn, pstm, null);
  }

  @Override
  public Post findById(Post post) throws Exception {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    Post post2 = null;
    conn = DBConn.getDBconnection();
    assert conn != null;
    pstm = conn.prepareStatement(SELECT_SQL);
    pstm.setInt(1, post.getId());
    rs = pstm.executeQuery();
    if (rs.next()) {
      post2 =
          new Post(
              rs.getInt(1),
              rs.getString(2),
              rs.getString(3),
              rs.getString(4),
              rs.getString(5),
              rs.getDate(6));
    }
    DBConn.closeDB(conn, pstm, rs);
    return post2;
  }

  @Override
  public Post findByTitle(Post post) throws Exception {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    Post post2 = null;
    conn = DBConn.getDBconnection();
    assert conn != null;
    pstm = conn.prepareStatement(SELECT_SQL2);
    pstm.setString(1, post.getTitle());
    rs = pstm.executeQuery();
    if (rs.next()) {
      post2 =
          new Post(
              rs.getInt(1),
              rs.getString(2),
              rs.getString(3),
              rs.getString(4),
              rs.getString(5),
              rs.getDate(6));
    }
    DBConn.closeDB(conn, pstm, rs);
    return post2;
  }

  @Override
  public List<Post> findByAuthor(String author) throws Exception {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    List<Post> posts = new ArrayList<>();
    conn = DBConn.getDBconnection();
    assert conn != null;
    pstm = conn.prepareStatement("select * from post where author=?");
    pstm.setString(1, author);
    rs = pstm.executeQuery();
    while (rs.next()) {
      Post post2 =
          new Post(
              rs.getInt(1),
              rs.getString(2),
              rs.getString(3),
              rs.getString(4),
              rs.getString(5),
              rs.getDate(6));
      posts.add(post2);
    }
    DBConn.closeDB(conn, pstm, rs);
    return posts;
  }

  @Override
  public List<Post> findByType(String type) throws Exception {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    List<Post> posts = new ArrayList<>();
    conn = DBConn.getDBconnection();
    assert conn != null;
    pstm = conn.prepareStatement("select * from post where type=?");
    pstm.setString(1, type);
    rs = pstm.executeQuery();
    while (rs.next()) {
      Post post2 =
          new Post(
              rs.getInt(1),
              rs.getString(2),
              rs.getString(3),
              rs.getString(4),
              rs.getString(5),
              rs.getDate(6));
      posts.add(post2);
    }
    DBConn.closeDB(conn, pstm, rs);
    return posts;
  }

  @Override
  public List<Post> findAll() throws Exception {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    List<Post> posts = new ArrayList<>();
    conn = DBConn.getDBconnection();
    assert conn != null;
    pstm = conn.prepareStatement("select * from post");
    rs = pstm.executeQuery();
    while (rs.next()) {
      Post post2 =
          new Post(
              rs.getInt(1),
              rs.getString(2),
              rs.getString(3),
              rs.getString(4),
              rs.getString(5),
              rs.getDate(6));
      posts.add(post2);
    }
    DBConn.closeDB(conn, pstm, rs);
    return posts;
  }

  @Override
  public void update(Post post) throws Exception {
    Connection conn;
    PreparedStatement pstm;
    conn = DBConn.getDBconnection();
    assert conn != null;
    pstm = conn.prepareStatement(UPDATE_SQL);
    pstm.setString(1, post.getTitle());
    pstm.setString(2, post.getAuthor());
    pstm.setString(3, post.getType());
    pstm.setString(4, post.getContent());
    pstm.setInt(5, post.getId());
    int rowCount = pstm.executeUpdate();
    if (rowCount == 0) {
      throw new SQLException("Update Error:Post id:" + post.getId());
    }
    DBConn.closeDB(conn, pstm, null);
  }
}
