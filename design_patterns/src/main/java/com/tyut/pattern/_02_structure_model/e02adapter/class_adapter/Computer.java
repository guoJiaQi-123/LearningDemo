package com.tyut.pattern._02_structure_model.e02adapter.class_adapter;

/**
 * @author OldGj 2024/02/23
 * @version v1.0
 * @apiNote 电脑类
 */
public class Computer {


    // 向SD卡中写数据
    public void writeSD(SDCard sdCard, String msg) {
        sdCard.writeMsg(msg);
    }

    // 从SD卡中读取数据
    public String readSD(SDCard sdCard) {
        return sdCard.readMsg();
    }

}
