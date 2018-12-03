package com.price.Pipeline;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.spider.SpiderBean;

/**
 * Created by xijue.aty on 2018/12/3
 **/
public class consolePipeline implements Pipeline<SpiderBean> {
    @Override
    public void process(SpiderBean bean) {
        System.out.println(JSON.toJSONString(bean));
    }
}
