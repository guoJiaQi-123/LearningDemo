package com.tyut.pattern._02_structure_model.e02adapter.object_adapter;

/**
 * @author OldGj 2024/02/23
 * @version v1.0
 * @apiNote 适配者 - TFCard
 */
public interface TFCard {

    // 向TF卡中写数据
    void writeMsg(String msg);

    // 从TF卡中读数据
    String readMsg();

}
