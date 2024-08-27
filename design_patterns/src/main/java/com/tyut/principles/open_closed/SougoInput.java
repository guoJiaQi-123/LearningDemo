package com.tyut.principles.open_closed;

/**
 * 搜狗输入法
 */
public class SougoInput {

    private AbstractSkin skin;

    public void setSkin(AbstractSkin skin) {
        this.skin = skin;
    }

    public void display(){
        skin.display();
    }
}
