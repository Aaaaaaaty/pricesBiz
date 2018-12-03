package com.price.biz;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import com.price.bo.ItemBO;
import lombok.Data;

import java.util.List;

/**
 * Created by xijue.aty on 2018/12/3
 **/
@Data
@Gecco(matchUrl="https://guangdiu.com/index.php?p={page}", pipelines={"consolePipeline", "gdProductListPipeline"})
public class GDHtmlBean implements HtmlBean {

    private static final long serialVersionUID = 4369792078959596706L;

    @Request
    private HttpRequest request;

    /**
     * 抓取列表项的详细内容，包括titile，价格，详情页地址等
     */
    @HtmlField(cssPath="#mainleft > div.zkcontent > div > div.iteminfoarea > h2")
    private List<ItemBO> details;
    /**
     * 获得商品列表的当前页
     */
    @Text
    @HtmlField(cssPath=".currentPageNum")
    private int currPage;
    /**
     * 获得商品列表的总页数
     */
    @Text
    @HtmlField(cssPath="#main > div.page > a:nth-child(10)")
    private int totalPage;

    public static void main(String[] args) {
        //先获取分类列表
        HttpGetRequest start = new HttpGetRequest("https://guangdiu.com/index.php?p=1");
        start.setCharset("utf-8");
        GeccoEngine.create()
            .classpath("com.geccocrawler.gecco.demo.juhuasuan")
            //开始抓取的页面地址
            .start(start)
            //开启几个爬虫线程
            .thread(1)
            //单个爬虫每次抓取完一个请求后的间隔时间
            .interval(2000)
            .run();

    }
}
