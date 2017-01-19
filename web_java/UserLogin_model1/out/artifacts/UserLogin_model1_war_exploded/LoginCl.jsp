<%--
  Created by IntelliJ IDEA.
  User: wangchaohu
  Date: 2017/1/19
  Time: 下午8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>

<html>
<head>
    <title>My JSP 'LoginCl.jsp' starting page</title>
</head>
<body>
<%
    //获取用户信息
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    //连接到数据库
    Class.forName("oracle.jdbc.driver.OracleDriver");

    if (true){
        //用户名，密码合法
    }else {
        //不合法
    }
%>
</body>
</html>
