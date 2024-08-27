package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/25
 *本类内容：
 */



public class Users{
    private String userName;
    public int userAge;

    private Users(String userName){
        this.userName = userName;
    }
    public Users(String userName, int userAge){
        this.userName = userName;
        this.userAge = userAge;
    }

    public Users(){

    }

    public Users(int userAge){
        this.userAge = userAge;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }


    private void sing(){
        System.out.println("郭家旗爱唱歌");
    }


    @Override
    public String toString() {
        return "Users{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
