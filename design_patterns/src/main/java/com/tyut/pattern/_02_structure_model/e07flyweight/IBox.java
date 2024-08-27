package com.tyut.pattern._02_structure_model.e07flyweight;

/**
 * @author OldGj 2024/02/29
 * @version v1.0
 * @apiNote 具体享元类 - I图形
 */
public class IBox extends AbstractBox {

    @Override
    public String getSharp() {
        return "I";
    }
}
