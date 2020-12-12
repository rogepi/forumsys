package com.dao;

import com.bean.User;
import java.util.List;

public interface IUserDAO {
  void create(User user) throws Exception;
  void remove(User user) throws Exception ;
  User findById(User user) throws Exception;
  User findByName(User user) throws Exception;
  List<User> findAll() throws Exception;
  void update(User user) throws Exception;
  int check(User user) throws Exception;
  boolean check(String name) throws Exception;
}
