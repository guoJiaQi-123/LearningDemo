package com.tyut.principles.open_closed;

/**
 * @version v1.0
 * @apiNote 客户端{测试}
 * @author HX
 */
public class Clint {
    public static void main(String[] args) {

        SougoInput input = new SougoInput();

        DefaultSkin defaultSkin = new DefaultSkin();
        TyutSkin tyutSkin = new TyutSkin();
        CustomizeSkin customizeSkin = new CustomizeSkin();

        input.setSkin(customizeSkin);
        input.display();
    }
}
