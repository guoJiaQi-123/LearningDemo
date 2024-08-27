package com.bjsxt;

import javax.swing.*;
import java.awt.*;
public class BallGame extends JFrame{
    //导入照片
    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.png");
    //绘制窗口
    double x = 200;
    double y = 200;
    double degree = 3.14/3;
    public void paint(Graphics g){
        System.out.println("窗口被画了一次！");
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int)x,(int)y,null);
        x = x + 10*Math.cos(degree);
        y = y + 10*Math.sin(degree);
        //实现反弹
        if (y>501-40-30||y<0+40+30) {
            degree = -degree;
        }
        if (x>856-40-30||x<0+40){
            degree = 3.14 - degree;
        }
    }
    //创建窗口
    void launchFrame(){
        setSize(856,501);
        setLocation(100,100);
        setVisible(true);
        //实现动画，每秒绘制多少次
        while (true){
            repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main (String[] args){
        System.out.println("我的小游戏开始啦！");
        BallGame game = new BallGame();
        game.launchFrame();
    }
}