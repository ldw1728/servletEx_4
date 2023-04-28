package src.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import src.listener.InitListener;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class RequestInfoFilter implements Filter {

    private static Logger log = (Logger) LogManager.getLogger(RequestInfoFilter.class);

    // ServletContainer에 Filter가 등록되어 초기화 될때 실행됩니다.
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    // Filter가 매핑된 Servlet에 사용자의 요청이 들어왔을때 Servlet에게 전달하기 전 실행됩니다.
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // req attribute로 servlet에게 데이터 전달가능.
        //servletRequest.setAttribute("filterParam", "after filter servlet");

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String queryStr     = request.getQueryString();
        String reqUri       = queryStr == null ? request.getRequestURI() : request.getRequestURI() + "?" + queryStr;
        String reqAddr      = request.getRemoteAddr();
        String httpMtd      = request.getMethod();
        String contentType  = request.getContentType();
        String params       = getReqPrmStr(request);

        log.info("HTTP REQUEST - [{}] method : [{}] URI : [{}] contentType : [{}] params : [{}]",
                                         reqAddr,      httpMtd,   reqUri,            contentType,  params );


        /* doFilter가 호출되어야 다음 filter로 넘어가면서 최종적으로 사용자요청이 servlet으로 전달된다.
        * (호출하지않으면 servlet호출이 되지않음)*/
        filterChain.doFilter(servletRequest, servletResponse);
    }

    // ServletContainer가 종료되기전 Filter가 삭제될때 호출됩니다.
    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    protected String getReqPrmStr(HttpServletRequest request){
        String result = "";
        for(Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()){
            String  entryStr = entry.getKey();
                    entryStr += "=";
                    entryStr += Arrays.toString(entry.getValue());
                    entryStr += ", ";

            result += entryStr;
        }
        return result;
    }
}
