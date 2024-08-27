package com.itbaizhan;


import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//容器类
public class Container {
    static Map<String,Object> map = new HashMap();

    static {
        // 读取配置文件
        InputStream is = Container.class.getClassLoader().getResourceAsStream("IOC.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Enumeration<Object> keys = properties.keys();
        // 遍历配置文件的所有配置
        while (keys.hasMoreElements()){
            String key = keys.nextElement().toString();
            String value = properties.getProperty(key);
            try {
                // 通过反射技术创建对象
                Object o = Class.forName(value).newInstance();
                // 将对象放入集合中
                map.put(key,o);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    // 从容器中获取对象
    public static Object getBean(String name){
        return map.get(name);
    }

}
