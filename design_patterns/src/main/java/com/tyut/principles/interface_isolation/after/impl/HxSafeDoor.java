package com.tyut.principles.interface_isolation.after.impl;

import com.tyut.principles.interface_isolation.after.AntiTheft;
import com.tyut.principles.interface_isolation.after.Fireproof;
import com.tyut.principles.interface_isolation.after.Waterproof;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote Hx安全门
 */
public class HxSafeDoor implements AntiTheft, Fireproof, Waterproof {
    @Override
    public void antiTheft() {
        System.out.println("防盗");
    }

    @Override
    public void fireProof() {
        System.out.println("防火");
    }

    @Override
    public void waterproof() {
        System.out.println("防水");
    }
}
