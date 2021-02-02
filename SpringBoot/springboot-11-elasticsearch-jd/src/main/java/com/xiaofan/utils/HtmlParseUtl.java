package com.xiaofan.utils;

import com.xiaofan.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Component
public class HtmlParseUtl {

//    public static void main(String[] args) throws IOException {
//        new HtmlParseUtl().parseJD("全栈工程师").forEach(System.out::println);
//    }

    public List<Content> parseJD(String keywords) throws IOException {
        String url = "https://search.jd.com/Search?keyword=" + keywords;
        Document document = Jsoup.parse(new URL(url), 30000);
        Element divElement = document.getElementById("J_goodsList");
        Elements lis = divElement.getElementsByTag("li");

        List<Content> contents = new ArrayList<>();

        for (Element li : lis) {
            String title = li.getElementsByClass("p-name").eq(0).text();
            // 注意：懒加载的图片
            String imgUrl = li.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = li.getElementsByClass("p-price").eq(0).text();
            contents.add(new Content(title, imgUrl, price));
        }

        return contents;
    }
}
