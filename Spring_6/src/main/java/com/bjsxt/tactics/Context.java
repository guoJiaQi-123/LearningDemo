package com.bjsxt.tactics;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Context {

    private ITtactics iTtactics;




    public void study(){
        iTtactics.study();
    }
}
