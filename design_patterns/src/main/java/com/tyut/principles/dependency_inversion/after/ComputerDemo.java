package com.tyut.principles.dependency_inversion.after;

import com.tyut.principles.dependency_inversion.after.impl.AMDCpu;
import com.tyut.principles.dependency_inversion.after.impl.IntelCpu;
import com.tyut.principles.dependency_inversion.after.impl.KingstonMemory;
import com.tyut.principles.dependency_inversion.after.impl.XiJieHardDisk;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 测试类
 */
public class ComputerDemo {
    public static void main(String[] args) {
        // 创建计算机组件
        Cpu cpu = new IntelCpu();
        Memory memory = new KingstonMemory();
        HardDisk disk = new XiJieHardDisk();
        Cpu cpu2 = new AMDCpu();
        // 实例化计算机
        Computer computer = new Computer();
        computer.setCpu(cpu2);
        computer.setMemory(memory);
        computer.setHardDisk(disk);

        computer.run();
    }
}
