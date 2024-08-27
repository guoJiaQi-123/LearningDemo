package com.tyut.pattern._02_structure_model.e02adapter.object_adapter;

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
        SDAdapterTF sdAdapterTF = new SDAdapterTF(new TFCardImpl());
        String s1 = computer.readSD(sdAdapterTF);
        System.out.println(s1);


    }


}
