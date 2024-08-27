package com.tyut.principles.dependency_inversion.before;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 希捷硬盘实体类
 */
public class XiJieHardDisk {
    public void save(String data) {
        System.out.println("使用希捷硬盘存储数据" + data);
    }

    public String get() {
        System.out.println("使用希捷希捷硬盘取数据");
        return "数据";
    }
}
