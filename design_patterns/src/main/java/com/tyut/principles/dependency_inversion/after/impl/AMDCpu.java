package com.tyut.principles.dependency_inversion.after.impl;

import com.tyut.principles.dependency_inversion.after.Cpu;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote AMD处理器
 */
public class AMDCpu implements Cpu {
    @Override
    public void run() {
        System.out.println("AMD处理器");
    }
}
