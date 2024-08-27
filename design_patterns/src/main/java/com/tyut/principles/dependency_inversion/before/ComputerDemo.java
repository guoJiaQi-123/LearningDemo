package com.tyut.principles.dependency_inversion.before;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 测试类
 */
public class ComputerDemo {
    public static void main(String[] args) {
         // 创建电脑对象
        Computer computer = new Computer();
        // 创建组件对象
        IntelCpu cpu = new IntelCpu();
        KingstonMemory memory = new KingstonMemory();
        XiJieHardDisk disk = new XiJieHardDisk();
        computer.setCpu(cpu);
        computer.setDisk(disk);
        computer.setMemory(memory);
        computer.run();
    }
}
