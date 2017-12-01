package cn.wang.store.web;

import cn.wang.store.entity.Page;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by 王 on 2017/11/30.
 */
public class PageNumTag extends SimpleTagSupport {
    private Page page ;

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public void doTag() throws JspException, IOException {
        StringBuffer buffer = new StringBuffer("<ul>");
        Class clazz = page.getData().get(0).getClass();
        String clazzName = clazz.getName().substring(clazz.getName().lastIndexOf(".")+1);
        int totalPage = page.getTotalPage();
        int pageNum = page.getPageNum();
        System.out.println(pageNum);
        if (pageNum - 3 > 0) {
            for (int i = pageNum-3; i <= (pageNum+2>page.getTotalPage()?page.getTotalPage():pageNum+2); i++) {
                if (i == page.getPageNum()) {
                    buffer.append("<li><a href='/test/servlet/showProperty?property="+clazzName+"&pageNum="+i+
                            "&currentPage="+page.getCurrentPage()+"'>" +
                            "<font color='green'>"+i+"</font></a></li>");
                }else {
                    buffer.append("<li><a href='/test/servlet/showProperty?property="+clazzName+"&pageNum="+i+
                            "&currentPage="+page.getCurrentPage()+"'>" +i+"</a></li>");
                }
            }
        }
        else if (pageNum - 3 <=0){
            for (int i = 1; i <= (5>page.getTotalPage()?page.getTotalPage():5); i++) {
                if (i == page.getPageNum()) {
                    buffer.append("<li><a href='/test/servlet/showProperty?property=" + clazzName + "&pageNum=" + i +
                            "&currentPage=" + page.getCurrentPage() + "'>" +
                            "<font color='green'>" + i + "</font></a></li>");
                } else {
                    buffer.append("<li><a href='/test/servlet/showProperty?property="+clazzName+"&pageNum="+i+
                            "&currentPage="+page.getCurrentPage()+"'>" +i+"</a></li>");
                }
            }

        }
        buffer.append("</ul>");
        this.getJspContext().getOut().write(buffer.toString());
    }
}
