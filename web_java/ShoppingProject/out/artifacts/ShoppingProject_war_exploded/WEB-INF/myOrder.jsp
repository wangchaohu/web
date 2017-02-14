<%@ page import="bean.Users" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Books" %><%--
  Created by IntelliJ IDEA.
  User: wangchaohu
  Date: 2017/2/12
  Time: 下午10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的订单</title>
    <script type="text/javascript">

        function goSumbitOrder(){
            window.location.href="/submitOrder";
        }
    </script>
</head>
<body>
<h1>我的订单</h1>
<%
    Users user = (Users) session.getAttribute("user");
    ArrayList<Books> al = (ArrayList<Books>) request.getAttribute("shoppingBooks");
%>
<table border="1" style="border-collapse: collapse ">
    <tr>
        <td colspan="2" align="center">用户个人信息</td>
    </tr>
    <tr>
        <td>用户名：</td>
        <td><%=user.getName()%>
        </td>
    </tr>
    <tr>
        <td>电子邮件：</td>
        <td><%=user.getEmail()%>
        </td>
    </tr>
    <tr>
        <td>用户级别</td>
        <td><%=user.getGrade()%>
        </td>
    </tr>
</table>

<table border="1" style="border-collapse: collapse">
    <tr>
        <td colspan="5" align="center">订单信息</td>
    </tr>
    <tr>
        <td>BookId</td>
        <td>书名</td>
        <td>价格</td>
        <td>出版社</td>
        <td>数量</td>
    </tr>
    <%
        for (int i = 0; i < al.size(); i++) {
    %>
    <tr>
        <td><%=al.get(i).getId()%>
        </td>
        <td><%=al.get(i).getName()%>
        </td>
        <td><%=al.get(i).getPrice()%>
        </td>
        <td><%=al.get(i).getPublishHouse()%>
        </td>
        <td><%=al.get(i).getShoppingNums()%>
        </td>
    </tr>
    <%
        }
    %>
    <tr>
        <td colspan="5" align="center">总价为：${shoppingBooksPrice}元</td>
    </tr>
</table>
<br>
<a href="/order">返回购物车</a>
<input type="button" onclick="goSumbitOrder()" value="确认订单">
</body>
</html>
