package com.tyut.pattern._01_creative_model.e02factor.static_factory;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 小米SU7静态工厂
 */
public class SimpleSU7Factory {

    /**
     * 根据不同配置生产小米SU7 静态方法，直接通过类名打点调用即可
     * @param type 不同配置
     * @return 不同配置的小米SU7
     */
    public static XiaoMiSU7 createXiaoMiSU7(String type) {
        XiaoMiSU7 xiaoMiSU7 = null;
        if ("high".equals(type)) {
            xiaoMiSU7 = new HighConfigurationSU7();
        } else if ("low".equals(type)) {
            xiaoMiSU7 = new LowConfigurationSU7();
        }
        return xiaoMiSU7;
    }


}
