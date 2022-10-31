import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * @author Jia Xiaoning
 */
@WebListener
public class BookAddedListener implements HttpSessionAttributeListener {

    public BookAddedListener() {
        super();
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
        int count =0;
        if (sbe.getName().equals("itemCount")){
            System.out.println("[最新]" + sbe.getName() + ":" + sbe.getValue());
        }else{
            System.out.println("选中了：" + sbe.getName() + ":" + sbe.getValue());
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
        System.out.println("[最新]" + sbe.getName() + ":" + sbe.getSession().getAttribute(sbe.getName()));
    }
}
