package com.xiaofan.pojo;

import java.io.Serializable;

public class Content implements Serializable {
    private String title;
    private String imgUrl;
    private String price;

    public Content() {
    }

    public Content(String title, String imgUrl, String price) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Content{" +
                "title='" + title + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
