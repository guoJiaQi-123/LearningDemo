package com.tyut.pattern._02_structure_model.e02adapter.class_adapter;

/**
 * @author OldGj 2024/02/23
 * @version v1.0
 * @apiNote 具体适配者 - TFCard具体实现类
 */
public class TFCardImpl implements TFCard{
    @Override
    public void writeMsg(String msg) {
        System.out.println("write msg to tf card"+msg);
    }

    @Override
    public String readMsg() {
        return "read msg from tf card";
    }
}
