package com.tyut.pattern._02_structure_model.e06combination;

import java.util.ArrayList;
import java.util.List;

/**
 * @author OldGj 2024/02/28
 * @version v1.0
 * @apiNote 树枝节点 - 菜单类
 */
public class Menu extends MenuComponent {


    private final List<MenuComponent> menuComponentList = new ArrayList<>();

    public Menu(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponentList.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponentList.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int index) {
        return menuComponentList.get(index);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void print() {
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        System.out.println(name);
        for (MenuComponent menuComponent : menuComponentList) {
            menuComponent.print();
        }
    }
}
