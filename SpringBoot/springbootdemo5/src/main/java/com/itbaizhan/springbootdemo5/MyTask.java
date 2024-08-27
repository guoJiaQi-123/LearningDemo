package com.itbaizhan.springbootdemo5;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MyTask {

    @Scheduled(cron = "* * * * * *")
    public void task1() throws InterruptedException {

        System.out.println(Thread.currentThread().getId()+"task1");
        Thread.sleep(5000);
    }
    @Scheduled(cron = "* * * * * *")
    public void task2(){
        System.out.println(Thread.currentThread().getId()+"task2");
    }
}
