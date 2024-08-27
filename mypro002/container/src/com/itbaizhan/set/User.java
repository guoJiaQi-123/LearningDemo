package com.itbaizhan.set;/*
 *作者：郭家旗
 *时间：2023/09/09
 *本类内容：创建Users对象
 */
import java.util.Objects;

public class User implements Comparable<User>{
    private String User;
    private int UserAge;

    public User(String user, int userAge) {
        User = user;
        UserAge = userAge;
    }

    public User() {
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public int getUserAge() {
        return UserAge;
    }

    public void setUserAge(int userAge) {
        UserAge = userAge;
    }

    @Override//重写toString() 方法
    public String toString() {
        return "User{" +
                "User='" + User + '\'' +
                ", UserAge=" + UserAge +
                '}';
    }

    @Override//重写equals方法
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return UserAge == user.UserAge && Objects.equals(User, user.User);
    }

    @Override//重写hashCode() 方法
    public int hashCode() {
        return Objects.hash(User, UserAge);
    }

    @Override// //定义比较规则
    //正数：大，负数：小，0：相等
    public int compareTo(com.itbaizhan.set.User o) {
        if(this.UserAge>o.UserAge){
            return 1;
        }if(this.UserAge==o.UserAge){
            return this.User.compareTo(o.getUser());
        }
        return -1;
    }
}
