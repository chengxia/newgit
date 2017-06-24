<%--
  Created by IntelliJ IDEA.
  User: FLC
  Date: 2017/6/16
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">

        function up() {
            alert("已经是第一页了,请点击下一页查看！");
        }
        function down() {
            alert("已经是最后一页了,请点击上一页查看！");
        }
        function downs(pageIndex) {

            document.form1.action="<%=path%>/EmployeeServlet?select=aaaa&pageIndex="+pageIndex;
            document.form1.submit();
        }
        function ups(pageIndex) {
            document.form1.action="<%=path%>/EmployeeServlet?select=aaaa&pageIndex="+pageIndex;
            document.form1.submit();
        }
    </script>
    <style>
        li {
            list-style: none;
            float: left;
        }

        a {
            text-decoration: none;
        }
    </style>
    <title>员工信息</title>
</head>
<body>
<div align="center">
<form method="post" name="form1" action="<%=path%>/EmployeeServlet?select=aaaaa">
    <input type="text" placeholder="请按员工姓名查询" name="selectname" style="width: 130px;" value="${selectname}"/>
    <select name="deptid" style="margin-bottom: 5px;">
        <option value="0">请选择部门</option>
        <c:if test="${deptlist !=null }">



                    <c:forEach var="item" items="${deptlist }">
                        <option value="${item.id}"
                                <c:if test="${item.id==deptid }">selected="selected"</c:if>
                        >${item.name}</option>


            </c:forEach>
        </c:if>
    </select>
    <input type="submit" value="查询"/>
</form>

        <table border="1px;">
            <tr style="background-color: aqua">
                <th>员工编号</th>
                <th>员工姓名</th>
                <th>所属部门</th>
                <th>员工薪资</th>
            </tr>
            <c:forEach var="item" items="${Page.emplist}">
                <tr>
                    <td>${item.empid}</td>
                    <td>${item.name}</td>
                    <c:if test="${item.department_id eq 1}">
                        <td align="center">开发部</td>
                    </c:if>
                    <c:if test="${item.department_id eq 2}">
                        <td align="center">研发部</td>
                    </c:if>
                    <c:if test="${item.department_id eq 3}">
                        <td align="center">测试部</td>
                    </c:if>
                    <c:if test="${item.department_id eq 4}">
                        <td align="center">市场部</td>
                    </c:if>
                    <td>${item.salary}</td>
                </tr>

            </c:forEach>

        </table>
<div style="padding-left: 650px;">

    <ul>

        <li>当前页数:[${Page.pageIndex} / ${Page.pagetotalpages}
            ]&nbsp;&nbsp;&nbsp;</li>
        <li><a href="<%=path%>/EmployeeServlet?pageIndex=1">首页</a>&nbsp;&nbsp;&nbsp;</li>

        <c:if test="${Page.pagetotalpages==1}">

            <li><a onclick="up();">上一页</a>&nbsp;&nbsp;&nbsp;</li>
            <li><a onclick="down();">下一页</a>&nbsp;&nbsp;&nbsp;</li>

        </c:if>

        <c:if test="${Page.pageIndex < Page.pagetotalpages && Page.pageIndex==1}">

            <li><a onclick="up();">上一页</a>&nbsp;&nbsp;&nbsp;</li>
            <li><a href="javascript:downs(${Page.pageIndex+1})">下一页</a>&nbsp;&nbsp;&nbsp;</li>

        </c:if>
        <c:if test="${Page.pageIndex < Page.pagetotalpages && Page.pageIndex!=1}">

            <li><a href="javascript:ups(${Page.pageIndex-1})">上一页</a>&nbsp;&nbsp;&nbsp;</li>
            <li><a href="javascript:downs(${Page.pageIndex+1})">下一页</a>&nbsp;&nbsp;&nbsp;</li>

        </c:if>
        <c:if test="${Page.pageIndex >= Page.pagetotalpages && Page.pageIndex>1}">

            <li><a  href="javascript:ups(${Page.pageIndex-1})">上一页</a>&nbsp;&nbsp;&nbsp;</li>
            <li><a  onclick="down();">下一页</a>&nbsp;&nbsp;&nbsp;</li>
        </c:if>
        <li><a  href="<%=path%>/EmployeeServlet?pageIndex=${Page.pagetotalpages}">尾页</a>&nbsp;&nbsp;&nbsp;</li>
    </ul>
</div>
    </div>
</body>
</html>
