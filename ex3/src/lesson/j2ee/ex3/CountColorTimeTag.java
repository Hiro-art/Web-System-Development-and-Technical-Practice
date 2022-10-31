package lesson.j2ee.ex3;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Xiaoning Jia
 * @description 定义标签，替换生成的选择啤酒颜色的历史记录列表，并实现合并相同的颜色条目，在其后显示选择次数
 */

public class CountColorTimeTag extends TagSupport {

    private static int light_counter = 0;
    private static int amber_counter = 0;
    private static int brown_counter = 0;
    private String select_color;
    private String[] select_color_history;

    public String[] getSelect_color_history() {
        return select_color_history;
    }

    public void setSelect_color_history(String[] select_color_history) {
        this.select_color_history = select_color_history;
    }

    @Override
    public int doStartTag() throws JspException {
        try{
            //因为每次跳转该页面都会重新调用daStartTag方法，所以每次都要重新初始化计数值
            light_counter = 0;
            amber_counter = 0;
            brown_counter = 0;
//            HttpSession session = pageContext.getSession();
//            ServletRequest myrequest = pageContext.getRequest();
            JspWriter out = pageContext.getOut();
            String outprint = "";
            outprint += "<p>";
            for (String str: select_color_history) {
                if(str.equals("light")){
                    setLight_counter();
                }else if(str.equals("amber")){
                    setAmber_counter();
                }else if(str.equals("brown")){
                    setBrown_counter();
                }
            }
            if(light_counter!=0 && amber_counter!=0 && brown_counter!=0){
                outprint += "light: " + light_counter + "<hr>";
                outprint += "amber: " + amber_counter + "<hr>";
                outprint += "brown: " + brown_counter + "<hr>";
            }else if(amber_counter!=0 && brown_counter!=0 && light_counter == 0){
                outprint += "amber: " + amber_counter + "<hr>";
                outprint += "brown: " + brown_counter + "<hr>";
            }else if(light_counter!=0 && brown_counter!=0 && amber_counter==0){
                outprint += "light: " + light_counter + "<hr>";
                outprint += "brown: " + brown_counter + "<hr>";
            }else if (light_counter!=0 && amber_counter!=0 && brown_counter==0){
                outprint += "light: " + light_counter + "<hr>";
                outprint += "amber: " + amber_counter + "<hr>";
            }else if (light_counter!=0 && amber_counter==0 && brown_counter==0){
                outprint += "light: " + light_counter + "<hr>";
            }else if (light_counter ==0 && amber_counter!=0 && brown_counter==0){
                outprint += "amber: " + amber_counter + "<hr>";
            }else if (light_counter==0 && amber_counter==0 && brown_counter!=0){
                outprint += "brown: " + brown_counter + "<hr>";
            }else if(light_counter==0 && amber_counter==0 && brown_counter==0){
                outprint += "这里什么都没有<hr>";
            }
//            if(select_color.equals("light")){
//                setLight_counter();
//                outprint += "light: " + light_counter + "<hr>";
//            }else if(select_color.equals("amber")){
//                setAmber_counter();
//                outprint += "amber: " + amber_counter + "<hr>";
//            }else if(select_color.equals("brown")){
//                setBrown_counter();
//                outprint += "brown: " + brown_counter + "<hr>";
//            }else if(select_color == ""){
//                outprint += "这里什么都没有<hr>";
//            }
            outprint += "</p>";
            out.print(outprint);
        }catch(Exception e){
            throw new JspTagException(e.getMessage());
        }
        return SKIP_BODY;
    }

    public int getLight_counter() {
        return light_counter;
    }

    public void setLight_counter() {
        light_counter++;
    }

    public int getAmber_counter() {
        return amber_counter;
    }

    public void setAmber_counter() {
        amber_counter++;
    }

    public int getBrown_counter() {
        return brown_counter;
    }

    public void setBrown_counter() {
        brown_counter++;
    }

    public String getSelect_color() {
        return select_color;
    }

    public void setSelect_color(String select_color) {
        this.select_color = select_color;
    }
}
