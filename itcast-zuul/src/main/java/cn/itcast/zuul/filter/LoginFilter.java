package cn.itcast.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {
    /**
     * 过滤器的类型：pre,route，post，error
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 执行顺序，返回值越小，优先级越高
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 10;
    }

    /**
     * 是否执行run方法
     * true;执行run方法
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 编写过滤器的业务逻辑
     * <p>
     * 返回值为null，就代表该过滤器什么都不做
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //初始化context上下文对象
        RequestContext currentContext = RequestContext.getCurrentContext();
        //获取request对象
        HttpServletRequest request = currentContext.getRequest();
        //获取参数
        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)) {
            //拦截，不转发请求
            currentContext.setSendZuulResponse(false);
            //设置响应状态码,401身份未认证
            currentContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            //设置响应的提示，中文会有乱码
            currentContext.setResponseBody("request error!");
        }
        return null;
    }
}
