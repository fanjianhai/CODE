package com.xiaofan.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service   // 放到容器中
public class UserService {

    @Reference
    TicketService ticketService;

    public void buyTicket() {
        String ticket = ticketService.getTicket();
        System.out.println("在注册中心拿到的：" + ticket);
    }
}
