<%--
  Created by IntelliJ IDEA.
  User: wangchaohu
  Date: 2017/1/23
  Time: 下午9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<h1>用户登录</h1>
<form action="login" method="get">
    <table border="1">
        <tr>
            <td>用户号：</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>密 码：</td>
            <td><input type="password" name="pwd"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
            <td><input type="reset" value="清空"></td>
        </tr>
    </table>
</form>

</body>
</html>
