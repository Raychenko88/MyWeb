<%--
  Created by IntelliJ IDEA.
  User: Серега
  Date: 18.04.2020
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User cabinet</title>
</head>
<body>
<H2>Hello, <%= session.getAttribute("user-name")%></H2>
</body>
</html>
