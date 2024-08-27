package com.tyut.pattern._01_creative_model.e02factor.factory_method;

import com.tyut.pattern._01_creative_model.e02factor.static_factory.SimpleSU7Factory;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 小米4S店
 */
public class MI4S {

    private XiaoMiSU7Factory factory;

    public void setFactory(XiaoMiSU7Factory factory) {
        this.factory = factory;
    }

    /**
     * 订购小米SU7
     *
     * @return 小米SU7
     */
    public XiaoMiSU7 orderXiaoMiSU7() {
        XiaoMiSU7 xiaoMiSU7 = factory.createXiaoMiSU7();
        xiaoMiSU7.run();
        xiaoMiSU7.stop();
        return xiaoMiSU7;
    }
}
