package com.bean;

public class Post {
  private int id;
  private String title;
  private String author;
  private String type;
  private String content;
  private java.sql.Date date;

  public Post() {}

  public Post(
      int id, String title, String author, String type, String content, java.sql.Date date) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.type = type;
    this.content = content;
    this.date = date;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public java.sql.Date getDate() {
    return date;
  }

  public void setDate(java.sql.Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "Post{"
        + "id="
        + id
        + ", title='"
        + title
        + '\''
        + ", author='"
        + author
        + '\''
        + ", type='"
        + type
        + '\''
        + ", content='"
        + content
        + '\''
        + ", date='"
        + date
        + '\''
        + '}';
  }
}
