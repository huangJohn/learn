<%@ page %><%--
  Created by IntelliJ IDEA.
  User: zhuanghuang
  Date: 2018/6/19
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<c:forEach var="entry" items="${info}">
    ${entry.key}
    ${entry.value}
</c:forEach>
</body>
</html>
