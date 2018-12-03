package com.price.Pipeline;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import com.price.biz.GDHtmlBean;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by xijue.aty on 2018/12/3
 **/
@PipelineName("gdProductListPipeline")
public class GDProductListPipeline implements Pipeline<GDHtmlBean> {
    @Override
    public void process(GDHtmlBean productList) {
        HttpRequest currRequest = productList.getRequest();
        //下一页继续抓取
        int currPage = productList.getCurrPage();
        int nextPage = currPage + 1;
        int totalPage = 100;
        if(nextPage <= totalPage) {
            String nextUrl = "";
            String currUrl = currRequest.getUrl();
            if(currUrl.contains("p=")) {
                nextUrl = StringUtils.replaceOnce(currUrl, "p=" + currPage, "p=" + nextPage);
            } else {
                nextUrl = currUrl + "&" + "page=" + nextPage;
            }
            SchedulerContext.into(currRequest.subRequest(nextUrl));
        }
    }
}
