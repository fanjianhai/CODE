package com.xiaofan.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 懒汉式
 * 标准枚举懒汉式2021/02/03
 */
public class LazyManApp {
    // 私有化构造方法
    private LazyManApp() {}


    //定义一个静态枚举类
    static enum SingletonEnum{
        //创建一个枚举对象，该对象天生为单例
        INSTANCE;

        private LazyManApp lazyManApp;

        //私有化枚举的构造函数
        private SingletonEnum(){
            lazyManApp = new LazyManApp();
        }
        public LazyManApp getInstance(){
            return lazyManApp;
        }
    }

    //对外暴露一个获取LazyManApp对象的静态方法
    public static LazyManApp getInstance(){
        return SingletonEnum.INSTANCE.getInstance();
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        test2();
    }

    // 测试序列化
    public static void test3() throws IOException, ClassNotFoundException {
        SingletonEnum s = SingletonEnum.INSTANCE;
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SerEnumSingleton.obj"));
        oos.writeObject(s);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("SerEnumSingleton.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        SingletonEnum s1 = (SingletonEnum)ois.readObject();
        ois.close();
        System.out.println(s+"\n"+s1);
        System.out.println("枚举序列化前后两个是否同一个："+(s==s1));
    }

    // 测试反射
    public static void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<SingletonEnum> constructor = SingletonEnum.class.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        SingletonEnum lazyMan1 = constructor.newInstance();
        SingletonEnum lazyMan2 = constructor.newInstance();
        System.out.println(lazyMan1.getInstance());
        System.out.println(lazyMan2.getInstance());
    }

    // 测试并发
    public static void test1() {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + LazyManApp.getInstance());
            }).start();
        }
    }
}
