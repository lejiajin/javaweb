<%--
  Created by IntelliJ IDEA.
  User: lucky
  Date: 2020/11/23
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/uploadServlet" method="post" enctype="multipart/form-data">
    用户名:<input type="text" name="username"/><br>
    头像: <input type="file" name="photo"><br>
    <input type="submit" value="submit"><br>

</form>

</body>
</html>
