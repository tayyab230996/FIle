import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author TAYYAB
 */
@WebServlet("/Image_Upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
maxFileSize = 1024 * 1024 * 10,
maxRequestSize = 1024 * 1024 * 50)

public class Image_Upload extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
       
        String description = request.getParameter("desc");
        
        Part part=request.getPart("file");
        String fileName = extractFileName(part);
        String savepath ="C:\\Users\\TAYYAB\\Downloads\\Compressed\\bootstrap-3.3.7-dist\\Java_Image_Upload\\web\\images" + File.separator + fileName;
        File fileSaveDir = new File(savepath);
        part.write(savepath + File.separator);
try{
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","tayyab","tayyab7277");
    PreparedStatement pst= con.prepareStatement("insert into java_image_upload values(?,?,?)");
    pst.setString(1, fileName);
    pst.setString(2, description);
    pst.setString(3, savepath);
    pst.executeUpdate();
    out.println("<center><h1>Image Inserted Sucessfully</h1>/center>");
    out.println("<center><a href='display.jsp?id='>Display Image</a>/center>");
}
catch(Exception e)
{
    out.println(e);
}
}


    private String extractFileName(Part part)
    {
    String contentDisp = part.getHeader("content-disposition");
    String[] items=contentDisp.split(";");
    for(String s : items)
    {
    if(s.trim().startsWith("fileName"))
    {
    return s.substring(s.indexOf("=" +2,s.length() - 1));
    }
    }
return "";
    }
}
