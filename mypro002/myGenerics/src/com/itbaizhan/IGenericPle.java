package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/06
 *本类内容：泛型接口的实现类
 */

public class IGenericPle<T> implements IGeneric<T> {
    T name;
    @Override
    public T getName(T name) {
        return name;
    }


}
