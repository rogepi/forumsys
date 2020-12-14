package com.service;

import com.bean.Comment;
import com.bean.Post;
import com.bean.User;
import com.dao.iCommentDAO;
import com.db.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO implements iCommentDAO {

  protected static final String FIELDS_INSERT = "id, post_id, author, content, date";
  protected static String INSERT_SQL =
      "insert into post (" + FIELDS_INSERT + ")" + "values(0,?,?,?,NOW())";
  protected static String SELECT_SQL = "select " + FIELDS_INSERT + " from post where id=?";
  protected static String SELECT_SQL2 = "select " + FIELDS_INSERT + " from post where post_id=?";
  protected static String UPDATE_SQL =
      "update post set" + " content=? where id=?";
  protected static String DELETE_SQL = "delete from post where id=?";

  @Override
  public void create(Comment comment) throws Exception {
    Connection conn;
    PreparedStatement pstm;
    conn = DBConn.getDBconnection();

    assert conn != null;
    pstm = conn.prepareStatement(INSERT_SQL);
    pstm.setInt(1, comment.getPost_id());
    pstm.setString(2, comment.getAuthor());
    pstm.setString(3, comment.getContent());
    pstm.executeUpdate();

    DBConn.closeDB(conn, pstm, null);
  }

  @Override
  public void remove(Comment comment) throws Exception {
    Connection conn;
    PreparedStatement pstm;
    conn = DBConn.getDBconnection();

    assert conn != null;
    pstm = conn.prepareStatement(DELETE_SQL);
    pstm.setInt(1, comment.getId());
    pstm.executeUpdate();
    DBConn.closeDB(conn, pstm, null);
  }

  @Override
  public Comment findById(Comment comment) throws Exception {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    Comment comment1 = null;
    conn = DBConn.getDBconnection();
    assert conn != null;
    pstm = conn.prepareStatement(SELECT_SQL);
    pstm.setInt(1, comment.getId());
    rs = pstm.executeQuery();
    if (rs.next()) {
      comment1 =
          new Comment(
              rs.getInt(1),
              rs.getInt(2),
              rs.getString(3),
              rs.getString(4),
              rs.getDate(6));
    }
    DBConn.closeDB(conn, pstm, rs);
    return comment1;
  }

  @Override
  public List<Comment> findByAuthor(User user) throws Exception {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    List<Comment> comments = new ArrayList<>();
    conn = DBConn.getDBconnection();
    assert conn != null;
    pstm = conn.prepareStatement("select * from comment where author=?");
    pstm.setString(1, user.getName());
    rs = pstm.executeQuery();
    while (rs.next()) {
      Comment comment =
          new Comment(
              rs.getInt(1),
              rs.getInt(2),
              rs.getString(3),
              rs.getString(4),
              rs.getDate(5));
      comments.add(comment);
    }
    DBConn.closeDB(conn, pstm, rs);
    return comments;
  }

  @Override
  public List<Comment> findByPostId(Post post) throws Exception {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    List<Comment> comments = new ArrayList<>();
    conn = DBConn.getDBconnection();
    assert conn != null;
    pstm = conn.prepareStatement("select * from comment where post_id=?");
    pstm.setInt(1, post.getId());
    rs = pstm.executeQuery();
    while (rs.next()) {
      Comment comment =
          new Comment(
              rs.getInt(1),
              rs.getInt(2),
              rs.getString(3),
              rs.getString(4),
              rs.getDate(5));
      comments.add(comment);
    }
    DBConn.closeDB(conn, pstm, rs);
    return comments;
  }

  @Override
  public List<Comment> findAll() throws Exception {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    List<Comment> comments = new ArrayList<>();
    conn = DBConn.getDBconnection();
    assert conn != null;
    pstm = conn.prepareStatement("select * from comment");
    rs = pstm.executeQuery();
    while (rs.next()) {
      Comment comment =
          new Comment(
              rs.getInt(1),
              rs.getInt(2),
              rs.getString(3),
              rs.getString(4),
              rs.getDate(5));
      comments.add(comment);
    }
    DBConn.closeDB(conn, pstm, rs);
    return comments;
  }

  @Override
  public void update(Comment comment) throws Exception {
    Connection conn;
    PreparedStatement pstm;
    conn = DBConn.getDBconnection();
    assert conn != null;
    pstm = conn.prepareStatement(UPDATE_SQL);
    pstm.setString(1, comment.getContent());
    int rowCount = pstm.executeUpdate();
    if (rowCount == 0) {
      throw new SQLException("Update Error:Post id:" + comment.getId());
    }
    DBConn.closeDB(conn, pstm, null);
  }
}
