package lesson.j2ee.ex3;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.IOException;

/**
 * 计数标签
 * 使用SimpleTag重新开发
 * @author Xiaoning Jia
 *
 */
public class CounterTag extends SimpleTagSupport {

	private static int counter = 1;

//	public int doStartTag() throws JspException {
//		try {
//			JspWriter out = pageContext.getOut();
//			out.print(counter);
//			setCounter();
//		} catch (java.io.IOException e) {
//			throw new JspTagException(e.getMessage());
//		}
//		return SKIP_BODY;
//	}

	@Override
	public void doTag() throws JspException, IOException {
		try {
			JspWriter out = getJspContext().getOut();
			out.print(counter);
			setCounter();
		} catch (java.io.IOException e) {
			throw new JspTagException(e.getMessage());
		}
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter() {
		counter++;
	}
}
