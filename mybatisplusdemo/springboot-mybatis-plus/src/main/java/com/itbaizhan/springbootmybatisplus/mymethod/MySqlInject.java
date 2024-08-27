package com.itbaizhan.springbootmybatisplus.mymethod;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlInject extends AbstractSqlInjector {
    //注入自定义方法集合
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
        List<AbstractMethod> abstractMethods = new ArrayList<>();
        abstractMethods.add(new DeleteAll());
        return abstractMethods;
    }
}
