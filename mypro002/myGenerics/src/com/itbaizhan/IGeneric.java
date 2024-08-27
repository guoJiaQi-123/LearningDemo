package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/06
 *本类内容：第一个泛型接口
 */

import org.omg.CORBA.PUBLIC_MEMBER;

public interface IGeneric <T>{
    T getName(T name);
}
