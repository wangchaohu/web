<%--
  Created by IntelliJ IDEA.
  User: wangchaohu
  Date: 2017/1/16
  Time: 下午9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="Login" method="post">      <%--这里的login要与Controller中响应这个视图中的注解参数相对应--%>
    <p>
        用户名：<input type="text" name="username">
    </p>
    <p >
        密&nbsp;&nbsp;码：<input type="password" name="password">
    </p>
    <p>
        <input type="submit" name="登录">
    </p>
    <%--错误信息--%>
    <%--<font color="red">${error}</font>--%>
</form>

<%--<a href="login">login</a>--%>

</body>
</html>
