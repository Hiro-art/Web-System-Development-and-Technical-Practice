import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Jia Xiaoning
 */
@WebServlet(name = "SelectBeerServlet", value = "/SelectBeerServlet")
public class SelectBeerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码 req指的是请求
        request.setCharacterEncoding("UTF-8");
        //resp指的是响应
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String color = request.getParameter("color");
        String taste = request.getParameter("taste");
        PrintWriter out = response.getWriter();
        out.println("color: " + color + "<br>");//print和 println在servlet中没有任何区别
        out.println("taste: " + taste);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
