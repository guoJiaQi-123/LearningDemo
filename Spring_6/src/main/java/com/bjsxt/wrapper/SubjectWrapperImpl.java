package com.bjsxt.wrapper;


/**
 * 抽象装饰具体实现
 */
public class SubjectWrapperImpl implements SubjectWrapper{

    //装饰器设计模式的本质：使用关联对象代替继承
    //关联对象放在装饰器的具体实现中
    //关联对象关联的是组件（Subject）

    private Subject subject;


    public SubjectWrapperImpl(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void subject() {
        subject.subject();
        friend();
    }

    @Override
    public void friend() {
        System.out.println("找朋友");
    }
}
