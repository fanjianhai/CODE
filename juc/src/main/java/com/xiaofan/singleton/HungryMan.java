package com.xiaofan.singleton;

/**
 * 饿汉式单例
 */
public class HungryMan {
    // 可能会浪费空间
    private byte[] data1 = new byte[1024*1024];
    private byte[] data2 = new byte[1024*1024];
    private byte[] data3 = new byte[1024*1024];
    private byte[] data4 = new byte[1024*1024];

    private HungryMan() {}

    private final static HungryMan HUNGRY = new HungryMan();

    public static HungryMan getInstance() {
        return HUNGRY;
    }
}
