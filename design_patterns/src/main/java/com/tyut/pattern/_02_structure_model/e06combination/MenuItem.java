package com.tyut.pattern._02_structure_model.e06combination;

/**
 * @author OldGj 2024/02/28
 * @version v1.0
 * @apiNote 叶子节点 - 菜单项
 */
public class MenuItem extends MenuComponent {

    public MenuItem(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void print() {
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        System.out.println(name);
    }
}
