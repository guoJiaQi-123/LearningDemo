package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/27
 *本类内容：
 */

public class GetClassInfo {

    public static void main(String[] args) {
        Class<Users> usersClass = Users.class;

        //获取包名
        Package usersClassPackage = usersClass.getPackage();
        System.out.println(usersClassPackage);
        System.out.println(usersClassPackage.getName());

        //获取类名
        String usersClassName = usersClass.getName();
        System.out.println(usersClassName);

        //获取超类
        Class<? super Users> superclass = usersClass.getSuperclass();
        System.out.println(superclass.getName());

        //获取所有接口
        Class<?>[] classInterfaces = usersClass.getInterfaces();
        for(Class interfaces:classInterfaces){
            System.out.println(interfaces.getName());
        }
    }
}
