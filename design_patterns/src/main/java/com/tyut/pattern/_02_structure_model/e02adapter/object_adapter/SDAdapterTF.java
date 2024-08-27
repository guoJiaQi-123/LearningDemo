package com.tyut.pattern._02_structure_model.e02adapter.object_adapter;

/**
 * @author OldGj 2024/02/23
 * @version v1.0
 * @apiNote 适配器类 继承适配者类 实现目标接口
 */
public class SDAdapterTF implements SDCard {

    private TFCard tfCard;

    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public void writeMsg(String msg) {
        tfCard.writeMsg(msg);
    }

    @Override
    public String readMsg() {
        return tfCard.readMsg();
    }
}
