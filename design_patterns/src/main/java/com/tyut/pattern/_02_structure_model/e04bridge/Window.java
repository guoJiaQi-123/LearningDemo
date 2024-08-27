package com.tyut.pattern._02_structure_model.e04bridge;

/**
 * @author OldGj 2024/02/26
 * @version v1.0
 * @apiNote window操作系统 - 扩展抽象化角色
 */
public class Window extends OperatingSystemVersion{

    public Window(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        System.out.println("window");
        videoFile.decode(fileName);
    }
}
