package com.tyut.pattern._01_creative_model.e03prototype.demo1;

/**
 * @author OldGj 2024/02/23
 * @version v1.0
 * @apiNote 使用BeanUtils实现浅拷贝 - 地址类
 */
public class Address {
    private String province;
    private String city;

    public Address() {
    }

    public Address(String province, String city) {
        this.province = province;
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
