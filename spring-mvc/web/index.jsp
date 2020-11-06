<%--
  Created by IntelliJ IDEA.
  User: tyjin
  Date: 20-10-23
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/app/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file"><br><br>
    <input type="submit" value="上传">
  </form>
  </body>
</html>
