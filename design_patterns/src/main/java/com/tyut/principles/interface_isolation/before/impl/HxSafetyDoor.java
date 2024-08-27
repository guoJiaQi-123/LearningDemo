package com.tyut.principles.interface_isolation.before.impl;

import com.tyut.principles.interface_isolation.before.SafetyDoor;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote hx安全门
 */
public class HxSafetyDoor implements SafetyDoor {

    @Override
    public void antiTheft() {
        System.out.println("防盗");
    }

    @Override
    public void fireproof() {
        System.out.println("防火");
    }

    @Override
    public void waterproof() {
        System.out.println("防水");
    }
}
