package com.itbaizhan.domain;

public class Address {
    private String info;
    private String postcode;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "info='" + info + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}
