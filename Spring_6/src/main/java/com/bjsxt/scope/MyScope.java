package com.bjsxt.scope;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;

import java.util.HashMap;
import java.util.Map;

public class MyScope implements Scope {

    private ThreadLocal<Map<String,Object>> threadLocal = new NamedThreadLocal<>("myScope"){
        @Override
        protected Map<String,Object> initialValue() {
            return new HashMap<>();
        }
    };
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {


        Map<String, Object> map = threadLocal.get();
        Object o = map.get(name);
        if(o==null){
            Object object = objectFactory.getObject();
            map.put(name,object);
        }
        return map.get(name);
    }

    @Override
    public Object remove(String name) {
        Map<String, Object> map = threadLocal.get();
        Object remove = map.remove(name);
        return remove;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return Thread.currentThread().getName();
    }
}
