<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Books" %>
<%@ page import="service.MyCar" %><%--
  Created by IntelliJ IDEA.
  User: wangchaohu
  Date: 2017/1/23
  Time: 下午9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的购物车</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css">
</head>
<body>
<h1>我的购物车</h1>
<br>
<a href="/shoppingDl?type=returnHall">返回购物大厅</a>
<br><br>
<form action="/shoppingDl?type=update" method="post">
    <table border="1" style="border-collapse: collapse">
        <tr><td>书编号</td><td>书名</td><td>价格</td><td>出版社</td><td>购买数量</td><td>删除 </td></tr>
        <%
            ArrayList<Books> booksList = (ArrayList<Books>) request.getAttribute("bookList");
            int totalPrice = 0;
            for (int i = 0; i < booksList.size(); i++){
                Books book = booksList.get(i);
        %>
        <tr>
            <td><%=book.getId()%><input type="hidden" name="id" value="<%=book.getId()%>"></td>
            <td><%=book.getName()%></td>
            <td><%=book.getPrice()%></td>
            <td><%=book.getPublishHouse()%></td>
            <td><input type="text" name="bookNum" value="<%=book.getShoppingNums()%>">本</td>
            <td><a href="/shoppingDl?type=delBook&&delectId=<%=book.getId()%>">删除</a> </td>
        </tr>
        <%
            }
        %>
        <tr>
            <td colspan="6"><input type="submit" value="更新"></td> </tr>
        <tr><td colspan="6">所有书的总价格：${totalPrice}元</td></tr>
    </table>
</form>

<a href="/order">提交订单</a>
</body>
</html>
