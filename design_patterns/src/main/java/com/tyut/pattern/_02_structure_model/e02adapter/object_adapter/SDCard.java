package com.tyut.pattern._02_structure_model.e02adapter.object_adapter;

/**
 * @author OldGj 2024/02/23
 * @version v1.0
 * @apiNote 目标接口 - SD卡接口
 */
public interface SDCard {

    // 向SD卡中写数据
    void writeMsg(String msg);

    // 从SD卡中读数据
    String readMsg();

}
