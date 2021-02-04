package com.xiaofan.singleton;

import java.io.*;

public enum  SerEnumSingleton implements Serializable {
    INSTANCE;
    private  String content;
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    private SerEnumSingleton() {
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerEnumSingleton s = SerEnumSingleton.INSTANCE;
        s.setContent("枚举单例序列化");
        System.out.println("枚举序列化前读取其中的内容："+s.getContent());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SerEnumSingleton.obj"));
        oos.writeObject(s);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("SerEnumSingleton.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        SerEnumSingleton s1 = (SerEnumSingleton)ois.readObject();
        ois.close();
        System.out.println(s+"\n"+s1);
        System.out.println("枚举序列化后读取其中的内容："+s1.getContent());
        System.out.println("枚举序列化前后两个是否同一个："+(s==s1));
    }
}
