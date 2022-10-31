import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * @author Jia Xiaoning
 */
public class CodeReturn extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CodeReturn() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //检查是否有文件上传请求
        boolean isMultipart=ServletFileUpload.isMultipartContent(request);
        if(isMultipart){
            DiskFileItemFactory factory=new DiskFileItemFactory();
            ServletFileUpload upload=new ServletFileUpload(factory);
            upload.setSizeMax(10 * 1024 * 1024);// 以byte为单位 不能超过10M 1024byte

            // Parse the request 调用ServletFileUpload.parseRequest方法解析request对象，得到一个保存了所有上传内容的List对象
            try {
                List<FileItem> items = upload.parseRequest(request);
                // Process the uploaded items
                Iterator<FileItem> iter=items.iterator();
                while(iter.hasNext()){
                    FileItem item=iter.next();
                    //遍历list，每迭代一个FileItem对象，调用其isFormField方法判断是否是上传文件
                    if(item.isFormField()==true){// 普通表单元素
                        String name=item.getFieldName();// name属性值
                        String value=item.getString();// name对应的value值
                        System.out.println("form field："+name+"--"+value);
                    }else{
                        String fieldName = item.getFieldName();
                        String fileName = item.getName();// 文件名称
                        String contentType = item.getContentType();
                        boolean isInMemory = item.isInMemory();
                        long sizeInBytes = item.getSize();
                        System.out.println("file upload："+fieldName+"--"+fileName+"--"+contentType+"--"+isInMemory+"--"+sizeInBytes);
                    }

                    // Process a file upload
                    if(!item.isFormField()){
                        //保存到指定盘符
                        String fileName=item.getName();
                        File uploadedFile=new File("D:\\desktop桌面\\SoftwareEngineering\\Web\\作业\\ex2-1\\web\\resources\\"+fileName);
                        item.write(uploadedFile);
                        request.setAttribute("message",
                                "文件上传成功!");
                    }
                }
            } catch (Exception e) {
                request.setAttribute("message",
                        "错误信息: " + e.getMessage());
            }

            // 跳转到 message.jsp
            request.getServletContext().getRequestDispatcher("/message.jsp").forward(
                    request, response);

        }
    }

}