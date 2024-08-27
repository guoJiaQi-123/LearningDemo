package com.itbaizhan.springbootmybatisplus.meta;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

@Component//将自动填充类放入spring容器中
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //插入操作时，给deleted字段自动填充值为0
        this.setFieldValByName("deleted",0,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
