package src;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    // ServletContainer에 Filter가 등록되어 초기화 될때 실행됩니다.
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init--------");
        Filter.super.init(filterConfig);
    }

    // Filter가 매핑된 Servlet에 사용자의 요청이 들어왔을때 Servlet에게 전달하기 전 실행됩니다.
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // req attribute로 servlet에게 데이터 전달가능.
        servletRequest.setAttribute("filterParam", "after filter servlet!!!!!!!!!!!!!");

        System.out.println("myFilter do++++++++++++++++++");

        /* doFilter가 호출되어야 다음 filter로 넘어가면서 최종적으로 사용자요청이 servlet으로 전달된다.
        * (호출하지않으면 servlet호출이 되지않음)*/
        filterChain.doFilter(servletRequest, servletResponse);
    }

    // ServletContainer가 종료되기전 Filter가 삭제될때 호출됩니다.
    @Override
    public void destroy() {
        System.out.println("filter destroy==========");
        Filter.super.destroy();
    }
}
