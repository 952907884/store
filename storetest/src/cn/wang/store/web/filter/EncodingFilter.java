package cn.wang.store.web.filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决请求和响应的乱码问题
 * Created by 王 on 2017/11/25.
 */
@javax.servlet.annotation.WebFilter(filterName = "EncodingFilter")
public class EncodingFilter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        HttpServletRequest request;
        HttpServletResponse response;
        try{
            request=(HttpServletRequest)req;
            response=(HttpServletResponse)resp;
        }catch (ClassCastException e){
            throw new ServletException("non-HTTP request or response");
        }

        if ("get".equals(request.getMethod())) {
            request = new MyHttpRequest(request);
        }else {
            request.setCharacterEncoding("UTF-8");
        }
        response.setContentType("text/html;charset=UTF-8");
        chain.doFilter(request, response);
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {

    }

}
