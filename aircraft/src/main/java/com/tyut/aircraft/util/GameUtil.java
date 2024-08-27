package com.tyut.aircraft.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class GameUtil {
    public static final int FRAME_WIDTH = 900;  //窗口宽度
    public static final int FRAME_HEIGHT = 900;//窗口高度

    //构造器私有
    private GameUtil() {
    }


    /**
     * 加载图片放大
     * @param path 图片路径
     * @return
     */
    public static Image getImage(String path) {
        Image img = null;
        URL url = GameUtil.class.getClassLoader().getResource(path);
        try {
            img = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;


    }
}
