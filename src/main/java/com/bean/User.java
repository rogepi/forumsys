package com.bean;

import java.util.Date;

public class User {
  private int uid;
  private String name;
  private String passwd;
  private String sex;
  private java.sql.Date rtime;

  public User(){
    this.sex = "man";
  }

  public User(int uid, String name, String passwd, String sex, java.sql.Date rtime) {
    this.uid = uid;
    this.name = name;
    this.passwd = passwd;
    this.sex = sex;
    this.rtime = rtime;
  }

  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public java.sql.Date getRtime() {
    return rtime;
  }

  public void setRtime(java.sql.Date rtime) {
    this.rtime = rtime;
  }

  @Override
  public String toString() {
    return "User{" +
        "uid=" + uid +
        ", name='" + name + '\'' +
        ", passwd='" + passwd + '\'' +
        ", sex='" + sex + '\'' +
        ", rtime=" + rtime +
        '}';
  }
}
