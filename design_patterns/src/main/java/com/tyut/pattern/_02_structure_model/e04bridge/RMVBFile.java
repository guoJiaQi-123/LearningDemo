package com.tyut.pattern._02_structure_model.e04bridge;

/**
 * @author OldGj 2024/02/26
 * @version v1.0
 * @apiNote RMVB类型的视频文件  - 具体实现化角色
 */
public class RMVBFile implements VideoFile {
    @Override
    public void decode(String fileName) {
        System.out.println("rmvb: " + fileName);
    }
}
