package com.tyut.principles.dependency_inversion.before;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 电脑实体类
 */
public class Computer {
    private IntelCpu cpu;
    private KingstonMemory memory;
    private XiJieHardDisk hardDisk;

    public void run(){
        System.out.println("计算机工作");
        cpu.run();
        memory.save();
        String data = hardDisk.get();
        System.out.println("从硬盘中获取的数据为：" + data);
    }

    public IntelCpu getCpu() {
        return cpu;
    }

    public void setCpu(IntelCpu cpu) {
        this.cpu = cpu;
    }

    public KingstonMemory getMemory() {
        return memory;
    }

    public void setMemory(KingstonMemory memory) {
        this.memory = memory;
    }

    public XiJieHardDisk getDisk() {
        return hardDisk;
    }

    public void setDisk(XiJieHardDisk disk) {
        this.hardDisk = disk;
    }
}
