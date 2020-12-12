package com.dao;

import com.bean.Post;
import java.util.List;

public interface IPostDAO {
  void create(Post post) throws Exception;
  void remove(Post post) throws Exception ;
  Post findById(Post post) throws Exception;
  Post findByTitle(Post post) throws Exception;
  List<Post> findByAuthor (String author) throws Exception;
  List<Post> findByType (String type) throws Exception;
  List<Post> findAll() throws Exception;
  void update(Post post) throws Exception;
}
