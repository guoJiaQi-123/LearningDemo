package com.tyut.pattern._02_structure_model.e04bridge;

/**
 * @author OldGj 2024/02/26
 * @version v1.0
 * @apiNote MAC操作系统 - 扩展抽象化角色
 */
public class Mac extends OperatingSystemVersion{
    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        System.out.println("mac");
        videoFile.decode(fileName);
    }
}
