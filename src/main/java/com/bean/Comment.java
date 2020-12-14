package com.bean;

import java.sql.Date;

public class Comment {
  private int id;
  private int post_id;
  private String author;
  private String content;
  private java.sql.Date date;

  public Comment() {}

  public Comment(int id, int post_id, String author, String content, Date date) {
    this.id = id;
    this.post_id = post_id;
    this.author = author;
    this.content = content;
    this.date = date;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getPost_id() {
    return post_id;
  }

  public void setPost_id(int post_id) {
    this.post_id = post_id;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "comment{" +
        "id=" + id +
        ", post_id=" + post_id +
        ", author='" + author + '\'' +
        ", content='" + content + '\'' +
        ", date=" + date +
        '}';
  }
}
