package com.price.bo;

import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HrefBean;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Data;

import java.util.List;

/**
 * Created by xijue.aty on 2018/12/3
 **/
@Data
public class ItemBO implements HtmlBean {

    private static final long serialVersionUID = 3018760488621382659L;

    @Text
    @HtmlField(cssPath="a")
    private String parentName;

    @HtmlField(cssPath="a")
    private List<HrefBean> categorys;
}
