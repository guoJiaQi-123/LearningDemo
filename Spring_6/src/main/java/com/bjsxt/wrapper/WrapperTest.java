package com.bjsxt.wrapper;

public class WrapperTest {

    public static void main(String[] args) {

        JavaSubject javaSubject= new JavaSubject();
        SubjectWrapperImpl subjectWrapper = new SubjectWrapperImpl(javaSubject);
        subjectWrapper.subject();

    }
}
