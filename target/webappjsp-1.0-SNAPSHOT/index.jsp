<%-- 
    Document   : index.jsp
    Created on : 21 oct 2022, 19:15:12
    Author     : MI PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Main Menu</h1>
        <ul>
            <li><a href="<%= request.getContextPath()%>/UserServlet">Add User</a></li>
            <li><a href="<%= request.getContextPath()%>/EditUserServlet">Edit User</a></li>

            <li></li>
            
            <li></li>
        </ul>
    </body>
</html>
