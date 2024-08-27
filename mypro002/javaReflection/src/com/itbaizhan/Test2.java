package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/27
 *本类内容：
 */

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) throws Exception{
        Class<Users> usersClass = Users.class;
        Users users = usersClass.getConstructor(null).newInstance();
        Field userName = usersClass.getDeclaredField("userName");
        //忽略安全检查
        userName.setAccessible(true);
        userName.set(users,"郭家旗");
        Object o = userName.get(users);
        System.out.println(o);

        Method sing = usersClass.getDeclaredMethod("sing");
        //忽略安全检查
        sing.setAccessible(true);
        sing.invoke(users);

    }
}
