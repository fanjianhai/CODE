package com.xiaofan.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    // 每隔3秒钟执行一次
    @Scheduled(cron = "0/3 * * * * ?")
    public void hello() {
        System.out.println("hello, 你被执行了~");
    }
}
