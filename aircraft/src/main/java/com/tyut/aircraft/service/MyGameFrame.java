package com.tyut.aircraft.service;

import com.tyut.aircraft.pojo.domain.Plane;
import com.tyut.aircraft.pojo.domain.Shell;
import com.tyut.aircraft.pojo.dto.ResultDTO;
import com.tyut.aircraft.util.Explode;
import com.tyut.aircraft.util.GameUtil;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import static com.tyut.aircraft.util.GameUtil.FRAME_HEIGHT;
import static com.tyut.aircraft.util.GameUtil.FRAME_WIDTH;

public class MyGameFrame extends Frame {

    public MyGameFrame(Integer shellNum) {
        this.shells = new Shell[shellNum];
    }

    int plane_x = 200;
    int plane_y = 200;
    // 加载背景图片
    Image bg = GameUtil.getImage("static/images/bg.jpg");
    // 加载飞机图片
    Image planeImg = GameUtil.getImage("static/images/Plane.png");
    String result;
    Plane plane = new Plane(planeImg, true, 200, 200, 15);//飞机对象
    Shell[] shells = null;//炮弹对象
    Explode explode;//爆炸对象
    Date startTime;
    Date endTime;
    Date stopStartTime;
    Date stopEndTime;
    int period;
    boolean stop = true;

    public void printInfo(Graphics g, int x, int y, int size, String str, Color color) {
        Color oldColor = g.getColor();
        Font oldFont = g.getFont();

        Font font = new Font("宋体", Font.BOLD, size);
        g.setFont(font);
        g.setColor(color);
        g.drawString(str, x, y);

        g.setColor(oldColor);
        g.setFont(oldFont);
    }//打印字体

    //键盘监听类  通过按下和抬起键盘的方式控制飞机的方向
    class KeyMonitor extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            plane.addDirection(e);                          //按下键盘时加方向
            this.stop(e);                                   //按下空格时暂停
        }

        boolean first = true;

        private void stop(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                stop = !stop;
                if (stop) {
                    plane.setSpeed(0);  // 速度设置为0
                    for (Shell shell : shells) {
                        shell.setSpeed(0); //速度设置为0
                    }
                    stopStartTime = new Date(); // 记录暂停开始的时间
                    System.out.println("暂停开始的时间" + stopStartTime.getTime() / 1000);
                } else {
                    for (Shell shell : shells) {
                        shell.setSpeed(shellOldSpeed); // 速度设置为原来速度
                    }
                    plane.setSpeed(planeOldSpeed); // 速度设置为原来速度
                    if (first) {
                        startTime = new Date();
                        first = false;
                    }
                    if (stopStartTime != null) {
                        stopEndTime = new Date(); // 记录暂停结束的时间
                        System.out.println("暂停结束的时间" + stopEndTime.getTime() / 1000);
                        int stopTime = (int) ((stopEndTime.getTime() - stopStartTime.getTime()) / 1000); // 计算暂停时间
                        period -= stopTime; // 在总时间中减去暂停时间
                    }
                }
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            plane.minusDirection(e);                        //抬起键盘时减方向
        }
    }

    //初始化窗口
    public ResultDTO launchFrame() {
        this.setTitle("飞机大战--真男人就撑过20秒");//在游戏窗口打印标题
        this.setVisible(true);//窗口默认不可见，设为可见
        this.setLocation(100, 100);//窗口左上角顶点的坐标位置
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);//窗口大小：宽度500，高度500

        //启动键盘监听
        addKeyListener(new KeyMonitor());

        //增加关闭窗口监听，这样用户点击右上角关闭图标，可以关闭游戏程序
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MyGameFrame.this.dispose();
            }
        });
        //初始化50个炮弹
        for (int i = 0; i < shells.length; i++) {
            shells[i] = new Shell(400, 400, 8, 8, 7);
            shellOldSpeed = shells[0].getSpeed();
        }
        if (stop) {
            plane.setSpeed(0);  // 速度设置为0
            for (Shell shell : shells) {
                shell.setSpeed(0); //速度设置为0
            }
        }
        //启动窗口绘制线程
        PaintThread paintThread = new PaintThread();
        paintThread.start();
        try {
            paintThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ResultDTO.builder()
                .persistTime(period)
                .result(result)
                .build();
    }

    int planeOldSpeed = plane.getSpeed();
    int shellOldSpeed;

    /**
     * 图形的绘制
     * @param g the specified Graphics window
     */
    @Override  //绘制图片，背景和飞机,炮弹,爆炸
    public void paint(Graphics g) {    //paint方法作用是：画出整个窗口及内部内容。被系统自动调用。
        g.drawImage(bg, 0, 0, FRAME_WIDTH, FRAME_HEIGHT, null);
        // 绘制飞机
        plane.drawMySelf(g);
        for (int i = 0; i < shells.length; i++) {
            if (shells[i] != null) {


                shells[i].drawMySelf(g);
                // 碰撞检测
                boolean peng = shells[i].getRec().intersects(plane.getRec());
                if (peng && plane.live) {
                    plane.live = false;

                    if (explode == null) {
                        explode = new Explode(plane.x, plane.y);
                    }
                    explode.draw(g);
                    endTime = new Date();
                    period += (int) ((endTime.getTime() - startTime.getTime()) / 1000);
                }
            }
        }

        if (!plane.live) {
            printInfo(g, 330, 90, 20, "游戏时间：" + period + "秒", Color.white);
            if (period > 20) {
                printInfo(g, 330, 70, 20, "真男人，成功通关", Color.green);
                result = "通关成功";
            } else {
                printInfo(g, 330, 70, 20, "游戏失败，未达到20秒通关条件", Color.red);
                result = "通关失败";
            }
            flag = false;
        }
    }

    private boolean flag = true;

    //重画线程  内部类
    class PaintThread extends Thread {
        @Override
        public void run() {
            while (flag) {
                repaint();
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }


    //双缓冲技术解决闪烁问题
    private Image offScreenImage = null;

    public void update(Graphics g) {
        if (offScreenImage == null)
            offScreenImage = this.createImage(FRAME_WIDTH, FRAME_HEIGHT);//这是游戏窗口的宽度和高度

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

}
