package com.tyut.principles.dependency_inversion.after;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 电脑实体类
 */
public class Computer {
    private Cpu cpu;
    private HardDisk hardDisk;
    private Memory memory;

    public void run(){
        System.out.println("计算机工作");
        cpu.run();
        memory.save();
        String data = hardDisk.get();
        System.out.println("从硬盘中获取的数据为：" + data);
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }
}
