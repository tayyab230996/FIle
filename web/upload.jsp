<%-- 
    Document   : upload
    Created on : 11 Jul, 2018, 9:20:59 PM
    Author     : TAYYAB
--%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Image_Upload" method="post"  enctype="multipart/form-data">
            <table width="500px" align="center" border="0">
                
                <tr>
                    <td>
                        Enter Description:
                    </td>
                    <td>
                        <textarea name="desc" cols="21" rows="4">Enter the description</textarea>
                    </td>
                </tr> 
                <tr>
                    <td>
                        Image Link:
                    </td>
                    <td>
                        <input type="file" name="file">
                    </td>
                </tr> 
                <tr>
                    <td>
                        <input type="submit" value="UPLOAD">
                    </td>
                </tr> 
            </table>
        </form>
    </body>
</html>
