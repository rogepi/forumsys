package com.dao;

import com.bean.Comment;
import com.bean.Post;
import com.bean.User;
import java.util.List;

public interface iCommentDAO {
  void create(Comment comment) throws Exception;
  void remove(Comment comment) throws Exception ;
  Comment findById(Comment comment) throws Exception;
  List<Comment> findByAuthor(User user) throws Exception;
  List<Comment> findByPostId (Post post) throws Exception;
  List<Comment> findAll() throws Exception;
  void update(Comment comment) throws Exception;
}
