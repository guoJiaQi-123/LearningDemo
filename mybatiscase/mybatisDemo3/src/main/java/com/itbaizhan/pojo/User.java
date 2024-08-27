package com.itbaizhan.pojo;

/**
 * 用户实体类
 */
public class User {
    private int id;
    private String username;
    private String sex;
    private String address;

    public User(String username, String sex, String address) {
        this.username = username;
        this.sex = sex;
        this.address = address;
    }

    public User(int id, String username, String sex, String address) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.address = address;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}



