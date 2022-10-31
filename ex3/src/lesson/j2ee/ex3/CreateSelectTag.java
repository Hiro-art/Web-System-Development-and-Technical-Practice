package lesson.j2ee.ex3;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.IOException;

/**
 * 自定义选择标签
 * 使用SimpleTag重新开发
 * @author Xiaoning Jia
 *
 */
public class CreateSelectTag extends SimpleTagSupport {

//	public int doStartTag() throws JspException {
//		try {
//			JspWriter out = getJspContext().getOut();
//			String outPrint = "";
//			String[] color = { "light", "amber", "brown", "dark" };
//			outPrint += "<select name='color' size='1'>";
//			for (int i = 0; i < color.length; i++) {
//				outPrint += "<option>";
//				outPrint += color[i];
//				outPrint += "</option>";
//			}
//			outPrint += "</select>";
//			out.print(outPrint);
//		} catch (java.io.IOException e) {
//			throw new JspTagException(e.getMessage());
//		}
//		return SKIP_BODY;
//	}

	@Override
	public void doTag() throws JspException, IOException {
		try {
			JspWriter out = getJspContext().getOut();
			String outPrint = "";
			String[] color = { "light", "amber", "brown", "dark" };
			outPrint += "<select name='color' size='1'>";
			for (int i = 0; i < color.length; i++) {
				outPrint += "<option>";
				outPrint += color[i];
				outPrint += "</option>";
			}
			outPrint += "</select>";
			out.print(outPrint);
		} catch (java.io.IOException e) {
			throw new JspTagException(e.getMessage());
		}
	}
}
