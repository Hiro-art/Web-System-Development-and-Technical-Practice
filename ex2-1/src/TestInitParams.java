import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//通过注释为其添加初始化参数email、telephone
/**
 * @author Jia Xiaoning
 */
@WebServlet(name = "TestInitParams",
            value = "/TestInitParams",
            initParams = {@WebInitParam(name="email",value="telephone")})
/**
 * @author Jia Xiaoning
 */
public class TestInitParams extends HttpServlet {
    private ServletConfig config;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //定义编码格式，防止乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        String value1 = this.getServletConfig().getInitParameter("admin-QQ");
        response.getWriter().println("web.xml文件中的init初始化参数值admin-QQ: " + value1);
        response.getWriter().println("<br><br>");

        ServletContext context = this.getServletContext();
        String adminEmail = context.getInitParameter("admin-email");//利用名字获取值
        String adminTel = context.getInitParameter("admin-tel");//利用名字获取值
        response.getWriter().println("web.xml文件中的context初始化参数值admin-email: " + adminEmail);
        response.getWriter().println("<br><br>");
        response.getWriter().println("web.xml文件中的context初始化参数值admin-tel: " + adminTel);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
