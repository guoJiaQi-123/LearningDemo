package com.itbaizhan.map;/*
 *作者：郭家旗 *时间：2023/09/10
 *本类内容：HashMap的基本用法*/
import java.util.Map;
import java.util.Set;
public class HashMap {
    public static void main(String[] args) {
        //实例化一个HashMap容器
        Map<String,String> map =new java.util.HashMap<>();
        //添加元素
        String put1 = map.put("a", "A");
        String put2 = map.put("b", "B");
        String put3 = map.put("c", "C");
        String put4 = map.put("a", "AA");
        System.out.println(put1+"\t"+put2+"\t"+put3+"\t"+put4);
        //容器元素个数
        int size = map.size();
        System.out.println(size);
        //查找HashMap容器中的元素
        //方法一
        String s = map.get("a");
        System.out.println(s);
        System.out.println("----------------");
        //方法二
        Set<String> keySet = map.keySet();
        for (String key :keySet){
            String values = map.get(key);
            System.out.println(key+"--"+values);
        }
        System.out.println("----------------");
        //方法三
        Set<Map.Entry<String, String>> entriedSet = map.entrySet();
        for (Map.Entry<String,String> entry:entriedSet){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+"---"+value);
        } System.out.println("----------------");
        //并集操作
        Map<String,String> map1 =new java.util.HashMap<>();
        map1.put("f","F");
        map1.put("c","CC");//如果key值相等，则覆盖原来的value
        map.putAll(map1);
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String,String> entry :entrySet){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+"----"+value);
        }System.out.println("----------------");
        //删除元素
        String remove = map.remove("b");
        System.out.println(remove);
        Set<String> set = map.keySet();
        for(String key:set){
            System.out.println(key+"------"+map.get(key));}
        //判断key是否在容器中
        boolean containsKey = map.containsKey("a");
        System.out.println(containsKey);
        //判断value是否在容器中
        boolean containsValue = map.containsValue("CC");
        System.out.println(containsValue);

    }

}
