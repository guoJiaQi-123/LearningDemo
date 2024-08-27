package com.tyut.pattern._01_creative_model.e03prototype.demo1;

/**
 * @author OldGj 2024/02/23
 * @version v1.0
 * @apiNote 使用BeanUtils实现浅克隆 - 用户类
 */
public class User implements Cloneable{
    private String name;
    private String password;
    private Address address;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        User user = (User) super.clone();
        user.setAddress(new Address());
        return user;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
