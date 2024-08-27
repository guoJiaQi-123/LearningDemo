package com.tyut.aircraft.pojo.domain;

import com.tyut.aircraft.common.GameObject;
import com.tyut.aircraft.util.GameUtil;

import java.awt.*;

public class Shell extends GameObject {
    double degree;

    @Override
    public void drawMySelf(Graphics g) {

        Color oldColor = g.getColor();
        g.setColor(Color.yellow);

        g.fillOval(x, y, width, height);//画一个实心的球
        //实现随机方向移动
        x += (int) (speed * Math.cos(degree));
        y += (int) (speed * Math.sin(degree));

        //实现触碰边界反弹
        if (x > GameUtil.FRAME_WIDTH - 20 || x < 10) {
            degree = Math.PI - degree;
        }
        if (y > GameUtil.FRAME_HEIGHT - 20 || y < 0 + 30) {
            degree = -degree;
        }

        g.setColor(oldColor);
    }

    public Shell(int x, int y, int speed) {
        degree = Math.random() * Math.PI * 2;
        this.x = x;
        this.y = y;
        height = 10;
        width = 10;
        this.speed = speed;
    }

    public Shell(int x, int y, int height, int width, int speed) {
        degree = Math.random() * Math.PI * 2;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.speed = speed;
    }

}
