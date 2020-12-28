package com.xiaofan.demo01;

public class Proxy implements Rent{

    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        seeHouse();
        host.rent();
        gainMoney();
    }

    public void seeHouse() {
        System.out.println("看房子");
    }

    public void gainMoney() {
        System.out.println("收中介费");
    }
}
