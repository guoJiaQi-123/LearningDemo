package com.tyut.pattern._02_structure_model.e07flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author OldGj 2024/02/29
 * @version v1.0
 * @apiNote 图形工厂类 - 享元工厂类 【单例实现】
 */
public class BoxFactory {

    private final Map<String, AbstractBox> map;
    private static final BoxFactory factory = new BoxFactory();

    private BoxFactory() {
        map = new HashMap<>();
        map.put("I", new IBox());
        map.put("O", new OBox());
        map.put("L", new LBox());
    }

    public static BoxFactory getInstance() {
        return factory;
    }

    public AbstractBox createBox(String name) {
        return map.get(name);
    }

}
