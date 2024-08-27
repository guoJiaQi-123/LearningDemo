package com.tyut.pattern._02_structure_model.e04bridge;

/**
 * @author OldGj 2024/02/26
 * @version v1.0
 * @apiNote 操作系统类 - 抽象化角色
 */
public abstract class OperatingSystemVersion {

    protected VideoFile videoFile;

    public OperatingSystemVersion(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    public abstract void play(String fileName);


}
