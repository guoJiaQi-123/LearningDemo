package com.tyut.principles.dependency_inversion.after;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 硬盘接口
 */
public interface HardDisk {

    //存储数据
    public void save(String data);
    // 获取数据
    public String get();
}
