package cn.working.web;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by 王 on 2017/11/27.
 */
public class myTag extends SimpleTagSupport{
    private int type;

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
    }
}
