package com.tyut.pattern._01_creative_model.e02factor.factory_method;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 低配小米SU7工厂
 */
public class LowXiaoMiSU7Factory implements XiaoMiSU7Factory {
    @Override
    public XiaoMiSU7 createXiaoMiSU7() {
        return new LowConfigurationSU7();
    }
}
