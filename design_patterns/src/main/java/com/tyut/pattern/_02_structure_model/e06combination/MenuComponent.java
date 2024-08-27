package com.tyut.pattern._02_structure_model.e06combination;

/**
 * @author OldGj 2024/02/28
 * @version v1.0
 * @apiNote 抽象根节点 - 菜单组件
 */
public abstract class MenuComponent {

    protected String name;
    protected int level;

    // 添加子菜单
    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    // 删除子菜单
    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    // 获取指定的子菜单
    public MenuComponent getChild(int index){
        throw new UnsupportedOperationException();
    }

    // 获取菜单名
    public String getName(){
        return name;
    }

    // 打印菜单即所有子菜单
    public abstract void print();

}
