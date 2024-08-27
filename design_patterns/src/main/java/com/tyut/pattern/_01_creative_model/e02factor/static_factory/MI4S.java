package com.tyut.pattern._01_creative_model.e02factor.static_factory;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 小米4S店
 */
public class MI4S {

    /**
     * 订购小米SU7
     * @param type 订购类型（高配，低配）
     * @return （高配，低配）小米SU7
     */
    public XiaoMiSU7 orderXiaoMiSU7(String type) {
        XiaoMiSU7 xiaoMiSU7 = SimpleSU7Factory.createXiaoMiSU7(type);
        xiaoMiSU7.run();
        xiaoMiSU7.stop();
        return xiaoMiSU7;
    }
}
