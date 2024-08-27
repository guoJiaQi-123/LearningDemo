package com.bjsxt.tactics;

public class User {

    public static void main(String[] args) {

        Context context = new Context(new JavaTactics());
        context.study();

        Context context1 = new Context(new FontedTactics());
        context1.study();

        Context context2 = new Context(new PythonTactics());
        context2.study();
    }
}
