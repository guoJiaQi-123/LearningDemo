package com.tyut.principles.interface_isolation.before;

import com.tyut.principles.interface_isolation.before.impl.HxSafetyDoor;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 测试类
 */
public class Clint {
    public static void main(String[] args) {
        SafetyDoor door = new HxSafetyDoor();
        door.antiTheft();
        door.fireproof();
        door.waterproof();
    }
}
