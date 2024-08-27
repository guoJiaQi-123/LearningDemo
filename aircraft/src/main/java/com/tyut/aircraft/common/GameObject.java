package com.tyut.aircraft.common;

import java.awt.*;

public class GameObject {
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    Image img; // 物体对应的图片
    public int x;
    public int y; // 坐标
    public int speed; // 移动速度
    public int width;
    public int height; // 宽高

    //画自己
    public void drawMySelf(Graphics g) {
        g.drawImage(img, x, y, width, height, null);
    }

    //返回物体对应矩形区域，便于后续在碰撞检测中使用
    public Rectangle getRec() {
        return new Rectangle(x, y, width, height);
    }


    //构造器
    public GameObject() {

    }

    public GameObject(Image img, int x, int y, int speed) {
        this(img, x, y);
        this.speed = speed;
    }

    public GameObject(Image img, int x, int y) {
        this(img);
        this.x = x;
        this.y = y;
    }

    public GameObject(Image img) {
        this.img = img;
        if (this.img != null) {
            width = img.getWidth(null);
            height = img.getHeight(null);
        }
    }


}
