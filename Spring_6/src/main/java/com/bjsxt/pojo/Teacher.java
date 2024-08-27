package com.bjsxt.pojo;

import lombok.Data;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Data
public class Teacher implements ResourceLoaderAware {


    private Properties prop;


    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        try {
            Resource resource = resourceLoader.getResource("classpath:resource.properties");
            InputStream inputStream = resource.getInputStream();
            prop= new Properties();
            prop.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
