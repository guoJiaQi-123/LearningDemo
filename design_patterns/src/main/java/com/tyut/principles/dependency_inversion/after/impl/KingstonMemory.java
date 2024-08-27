package com.tyut.principles.dependency_inversion.after.impl;

import com.tyut.principles.dependency_inversion.after.Memory;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 金士顿内存条
 */
public class KingstonMemory implements Memory {
    @Override
    public void save() {
        System.out.println("金士顿内存条");
    }
}
