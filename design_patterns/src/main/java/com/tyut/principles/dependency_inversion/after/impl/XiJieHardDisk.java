package com.tyut.principles.dependency_inversion.after.impl;

import com.tyut.principles.dependency_inversion.after.HardDisk;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 希捷硬盘
 */
public class XiJieHardDisk implements HardDisk {
    @Override
    public void save(String data) {
        System.out.println("使用希捷硬盘存储数据");
    }

    @Override
    public String get() {
        System.out.println("使用希捷硬盘获取数据");
        return "数据";
    }
}
