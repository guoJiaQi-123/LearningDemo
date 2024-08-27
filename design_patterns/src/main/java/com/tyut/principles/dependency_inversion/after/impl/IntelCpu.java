package com.tyut.principles.dependency_inversion.after.impl;

import com.tyut.principles.dependency_inversion.after.Cpu;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 英特尔CPU
 */
public class IntelCpu implements Cpu {
    @Override
    public void run() {
        System.out.println("英特尔CPU");
    }
}
