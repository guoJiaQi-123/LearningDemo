package com.itbaizhan.springbootmybatisplus.mymethod;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

public class DeleteAll extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        //定义SQL语句
        String sql = "delete from "+tableInfo.getTableName();
        //定义方法名
        String method = "deleteAll";
        //构建SqlSource,它负责将SQL语句传递到数据库
        SqlSource sqlSource = this.languageDriver.createSqlSource(configuration, sql, modelClass);
        //构建删除方法
        return this.addDeleteMappedStatement(mapperClass,method,sqlSource);
    }
}
