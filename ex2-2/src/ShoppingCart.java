import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingCart extends HttpServlet {

    /**
     * 将用户选择书目存入Session,并打印全部选择记录。
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 取得Session对象
        // 如果Session不存在，为本次会话创建此对象
        HttpSession session = req.getSession(true);
        //其中一种方法，还可以通过webxml中去设置
        session.setMaxInactiveInterval(180);
        //每次刷新在三分钟内的话，页面显示的sessionID不会改变，同时请求页面会在同一个对象的基础上累加
        //但是如果超过三分钟，则会启用一个新的sessionID,并且页面显示会重置

        Integer itemCount = (Integer) session.getAttribute("itemCount");
        // 如果session是新的
        if (itemCount == null)
            itemCount = new Integer(0);

        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        // 接收传来的参数
        String[] itemsSelected;
        String itemName;
        itemsSelected = req.getParameterValues("item");

        System.out.println("===============");
        if (itemsSelected != null) {
            for (int i = 0; i < itemsSelected.length; i++) {
                itemName = itemsSelected[i];
                itemCount = new Integer(itemCount.intValue() + 1);
                // 购买的条目
                session.setAttribute("item" + itemCount, itemName);
//                System.out.println("item" + (i+1) + ": " + itemName);//打印出现有的item的值
            }
            // 总条目
            session.setAttribute("itemCount", itemCount);

        }
        System.out.println("===============");

        out.println("<html>");
        out.println("<title>");
        out.println("item list");
        out.println("</title>");
        out.println("<body><h4>Session List:</h4><hr><br><br>");

        for (int i = 1; i <= itemCount.intValue(); i++) {
            out.println((String) session.getAttribute("item" + i) + "<hr>");
        }

        out.println("ItemCount: " + itemCount + "<hr><br><br>");
        out.println("</body>");
        out.println("</html>");
        out.close();


    }
}