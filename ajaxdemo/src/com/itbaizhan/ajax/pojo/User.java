package com.itbaizhan.ajax.pojo;

public class User {

    private Integer id;
    private String username;
    private String password;
    private Double salary;
    private String birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public User(Integer id, String username, String password, Double salary, String birthday) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.salary = salary;
        this.birthday = birthday;
    }

    public User() {
    }
}
