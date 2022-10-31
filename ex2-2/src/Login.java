import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//实现用户登录操作
@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        Cookie[] c1=request.getCookies();
        String username=null;
        String password=null;

        //在Cookies不为空的情况下把账号密码赋值给username和password
        if(c1!=null) {
            for (Cookie c : c1) {
                String cookiename = c.getName();
                if (cookiename.compareTo("username")==0) {
                    String val = c.getValue();
                    username = val;
                }
                if (cookiename.compareTo("password")==0) {
                    String val = c.getValue();
                    password = val;
                }
            }
        }
        //判断Cookies保存的账号密码是否正确
        if("jiaxiaoning".equals(username) && "123832852".equals(password)){
            response.sendRedirect("bookstore.html");
        }else{
            response.sendRedirect("UserLogin.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //定义编码格式，防止乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        String username = request.getParameter("username");
        String password= request.getParameter("password");
        String remember = request.getParameter("remember");

        if("jiaxiaoning".equals(username) && "123832852".equals(password)){
            //判断是否选择自动登录
            if ("on".equals(remember)) {
                Cookie c1=new Cookie("username",username);
                Cookie c2=new Cookie("password",password);
                c1.setMaxAge(60*60*24*30);
                c2.setMaxAge(60*60*24*30);
//                c1.setPath("/");
//                c2.setPath("/");
                response.addCookie(c1);
                response.addCookie(c2);
            }else{
                //如果没有选择自动登录则将Cookies时间设置为0
                Cookie[] cookies=request.getCookies();
                if (cookies != null){
                    for (Cookie cookie: cookies) {
                        String cookiename = cookie.getName();
                        if (cookiename.compareTo("username")==0) {
                            cookie.setMaxAge(0);
                            response.addCookie(cookie);
                        }
                        if (cookiename.compareTo("password")==0) {
                            cookie.setMaxAge(0);
                            response.addCookie(cookie);
                        }
                    }
                }
            }
//            response.getWriter().println("保存到Cookies的user："+username);
//            response.getWriter().println("<br><br>");
//            response.getWriter().println("保存到Cookies的pwd："+password);

            response.sendRedirect("bookstore.html");
        }else{
            response.sendRedirect("UserLogin.html");
        }
    }
}
