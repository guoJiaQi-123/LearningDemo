package com.tyut.aircraft.pojo.domain;

import com.tyut.aircraft.common.GameObject;
import com.tyut.aircraft.util.GameUtil;

import java.awt.*;
import java.awt.event.KeyEvent;

//飞机类
public class Plane extends GameObject {
    boolean left, right, up, down;
    public boolean live = true;

    public void setLive(boolean live) {
        this.live = live;
    }

    @Override
    public void drawMySelf(Graphics g) {
        if (live == false) {
            return;
        }
        super.drawMySelf(g);
        if (left) x -= speed;
        if (right) x += speed;
        if (up) y -= speed;
        if (down) y += speed;

        if (x > GameUtil.FRAME_WIDTH - 20) {
            x = 10;
        }
        if (x < 10) {
            x = GameUtil.FRAME_WIDTH - 20;
        }
        if (y > GameUtil.FRAME_HEIGHT - 20) {
            y = 30;
        }
        if (y < 30) {
            y = GameUtil.FRAME_HEIGHT - 20;
        }
    }


    //增加键盘控制方向
    public void addDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: // 按下左键，方向向左移动
                left = true;
                break;
            case KeyEvent.VK_RIGHT: // 同上
                right = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
        }
    }

    public void minusDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: // 松开左键，方向不向左移动
                left = false;
                break;
            case KeyEvent.VK_RIGHT: // 同上
                right = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
        }
    }

    public Plane(Image img, int x, int y, int speed) {
        super(img, x, y, speed);
    }

    public Plane(Image img, boolean live, int x, int y, int speed) {
        super(img, x, y, speed);
        this.live = live;
    }

}
