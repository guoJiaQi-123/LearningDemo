package com.tyut.pattern._02_structure_model.e02adapter.class_adapter;

/**
 * @author OldGj 2024/02/23
 * @version v1.0
 * @apiNote 客户端 - 测试类
 */
public class Client {

    public static void main(String[] args) {
        Computer computer = new Computer();

        SDCard sdCard = new SDCardImpl();
        String s = computer.readSD(sdCard);
        System.out.println(s);

        System.out.println("=============");

        SDAdapterTF adapterTF = new SDAdapterTF();
        String s1 = computer.readSD(adapterTF);
        System.out.println(s1);

    }


}
