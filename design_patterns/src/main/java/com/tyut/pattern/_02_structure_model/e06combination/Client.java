package com.tyut.pattern._02_structure_model.e06combination;

/**
 * @author OldGj 2024/02/28
 * @version v1.0
 * @apiNote 客户端 - 测试类
 */
public class Client {
    public static void main(String[] args) {
        MenuComponent menu1 = new Menu("菜单管理",2);
        menu1.add(new MenuItem("页面访问",3));
        menu1.add(new MenuItem("展开菜单",3));
        MenuComponent menu2 = new Menu("权限配置",2);
        menu2.add(new MenuItem("页面访问",3));
        menu2.add(new MenuItem("提交保存",3));
        MenuComponent menu3 = new Menu("角色管理",2);
        menu3.add(new MenuItem("页面访问",3));
        menu3.add(new MenuItem("新增角色",3));

        MenuComponent component = new Menu("系统管理",1);
        component.add(menu1);
        component.add(menu2);
        component.add(menu3);

        component.print();
    }
}
