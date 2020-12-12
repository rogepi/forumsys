package com;

import com.bean.Post;
import com.dao.IPostDAO;
import com.service.PostDAO;
import java.util.List;

public class Test {
  public static void main(String[] args) throws Exception {
    IPostDAO iPostDAO = new PostDAO();
    List<Post> posts = iPostDAO.findAll();
    for (Post post : posts) {
      System.out.println(post.toString());
    }
  }
}