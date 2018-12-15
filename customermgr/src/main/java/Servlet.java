import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class Servlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("quickStarServlet running");
    }

    /**
     * 以POST方式访问页面时执行该函数。执行前不会执行getLastModified
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        doGet(request,response);
        this.log("执行doPost方法...");
    }

    /**
     * 以Get方式访问页面执行的函数
     * 执行doGet前会先执行getLastModified，如果浏览器发现getLastModified返回的数值
     * 与上次访问时返回的数值相同，则认为该文档没有更新，浏览器采用缓存而不执行doGet
     * 如果getLastModified返回-1，则认为是时刻更新的，总是执行该函数
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("first Demo");

        ///customer
        System.out.println("contextPath是：" + request.getContextPath());

        //realPath的结果是：/Users/gaojie/IdeaProjects/exerciseweb/customermgr/src/main/webapp
        System.out.println("realPath: " + request.getRealPath("/"));

        //0:0:0:0:0:0:0:1
        System.out.println(request.getRemoteAddr());

        //url:http://localhost:9080/customer/servlet/HelloServlet
        System.out.println(request.getRequestURL());

        //uri:/customer/servlet/HelloServlet
        System.out.println(request.getRequestURI());

        //null
        System.out.println(request.getHeader("referer"));


    }
}
