package com.tyut.pattern._02_structure_model.e02adapter.class_adapter;

/**
 * @author OldGj 2024/02/23
 * @version v1.0
 * @apiNote 目标接口实现类 - SDCard实现类
 */
public class SDCardImpl implements SDCard{
    @Override
    public void writeMsg(String msg) {
        System.out.println("write msg to sd card"+msg);
    }

    @Override
    public String readMsg() {
        return "read msg from sd card";
    }
}
