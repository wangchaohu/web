<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Books" %>
<%@ page import="service.BookService" %><%--
  Created by IntelliJ IDEA.
  User: wangchaohu
  Date: 2017/1/23
  Time: 下午9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物大厅</title>
</head>
<body>
<h1>欢迎进入购物大厅</h1>
<table border="1">
    <tr><td>书名</td><td>价格</td><td>出版社</td><td>作者</td><td>点击购买</td></tr>
    <%
        ArrayList<Books> bookses = (ArrayList<Books>) request.getAttribute("books");
        for (int i = 0; i < bookses.size(); i++){
    %>
    <tr><td><%= bookses.get(i).getName()%></td><td><%= bookses.get(i).getPrice()%></td><td><%= bookses.get(i).getPublishHouse()%></td><td><%= bookses.get(i).getAuthor()%></td><td><a href="#">购买</a> </td></tr>
    <%
        }
    %>

    <tr><td colspan="4"><input type="button" value="查看购物车"></td></tr>
</table>

</body>
</html>
