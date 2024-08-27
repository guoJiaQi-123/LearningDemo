package com.bjsxt.CglibProxy;

import net.sf.cglib.proxy.Enhancer;

public class KeHu {

    public static void main(String[] args) {
        //所有方法都在Enhancer中
        Enhancer enhancer = new Enhancer();
        //1.setSuperClass(真实是哪个类)  真实是哪个类，根据这个类创建代理对象，即FangDong的子类
        //设置被代理对象
        enhancer.setSuperclass(FangDong.class);
        //2.setCallBack(对象)    设置由哪个类作为增强实现类
        //设置代理方式对象
        enhancer.setCallback(new ZhongJie());
        //3.create()   创建代理对象，返回值为object类型，本质为代理对象
        FangDong fangDong = (FangDong) enhancer.create();
        fangDong.bigHouse();
    }

}
