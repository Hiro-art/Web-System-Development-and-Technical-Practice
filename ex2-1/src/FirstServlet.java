import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Jia Xiaoning
 */
@WebServlet(name = "FirstServlet", value = "/FirstServlet")
public class FirstServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //使用PrintWriter.write()方法向前台页面输出内容
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("good good study, learn to change");
        writer.close();
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //使用PrintWriter.write()方法gaifang向前台页面输出内容
        PrintWriter writer = resp.getWriter();
        writer.write("good good study, learn to change");
        writer.close();
        doGet(req, resp);
    }
}
