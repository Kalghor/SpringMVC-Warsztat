<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 19.05.2021
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/books/" method="post">
    <input type="text" name="isbn" placeholder="isbn">
    <input type="text" name="title" placeholder="title">
    <input type="text" name="publisher" placeholder="publisher">
    <input type="text" name="type" placeholder="type">
    <input type="text" name="author" placeholder="author">
    <input type="submit" value="submit" >
</form>
</body>
</html>
