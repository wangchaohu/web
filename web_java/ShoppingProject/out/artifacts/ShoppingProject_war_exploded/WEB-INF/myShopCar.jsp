<%--
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
<form action="#" method="post">
    <table border="1" style="border-collapse: collapse">
        <tr><td>书编号</td><td>书名</td><td>价格</td><td>出版社</td><td>购买数量</td><td>删除 </td></tr>
        <tr><td>1</td><td>天龙八部</td><td>100</td><td>清华出版社</td><td><input type="text" name="bookNum">本</td><td><a href="#">删除</a> </td></tr>
        <tr><td>2</td><td>天龙八部</td><td>100</td><td>清华出版社</td><td><input type="text" name="bookNum">本</td><td><a href="#">删除</a> </td></tr>
        <tr><td>3</td><td>天龙八部</td><td>100</td><td>清华出版社</td><td><input type="text" name="bookNum">本</td><td><a href="#">删除</a> </td></tr>
        <tr><td colspan="6"><input type="submit" value="确认购买"></td> </tr>
        <tr><td colspan="6">所有书的总价格：300元</td></tr>
    </table>
</form>
</body>
</html>
