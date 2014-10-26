<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  User: Kaka, Date: 2014/10/26, Time: 11:16.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    // 模拟菜单数据
    List first = new ArrayList();
    for (int i = 1; i < 5; i++) {
        Map bean = new HashMap();
        bean.put("id", i);
        bean.put("name", "系统管理" + i);

        if (i % 2 == 0) {
            List second = new ArrayList();
            for (int k = 10; k < 5; k++) {
                Map s = new HashMap();
                s.put("id", k);
                s.put("name", "部门管理" + i);
                second.add(s);
            }
            bean.put("children", second);
        }

        first.add(bean);
    }

    session.setAttribute("menus", first);
%>

<div id="page-sidebar" class="page-sidebar collapse in">
    <ul class="firstMenu nav nav-pills nav-stacked">
        <c:forEach items="${sessionScope.menus}" var="menu">
            <li><a href="#">${menu.name}</a></li>
        </c:forEach>



        <li><a href="#">
            <i class="glyphicon glyphicon-home"></i>
            <span class="title">首页</span>
        </a></li>
        <li class="active">
            <a href="#collapseOne" data-toggle="collapse">
                <i class="glyphicon glyphicon-cog"></i>
                <span class="title">系统管理</span>
                <i class="arrow glyphicon glyphicon-chevron-down"></i>
                <span class="selected"></span>
            </a>
            <ul id="collapseOne" class="nav nav-pills nav-stacked collapse in">
                <li class="active"><a>部门管理</a></li>
                <li><a>员工管理</a></li>
                <li><a>角色管理</a></li>
            </ul>
        </li>
        <li class="open">
            <a href="#collapseOne2" data-toggle="collapse">
                <i class="glyphicon glyphicon-user"></i>
                <span class="title">人事行政</span>
                <i class="arrow glyphicon glyphicon-chevron-left"></i>
            </a>

            <ul id="collapseOne2" class="nav nav-pills nav-stacked collapse">
                <li><a>部门管理</a></li>
                <li><a>员工管理</a></li>
                <li><a>角色管理</a></li>
            </ul>
        </li>
        <li>
            <a href="#collapseOne3" data-toggle="collapse">
                <i class="glyphicon glyphicon-user"></i>
                <span class="title">人事行政</span>
                <i class="arrow glyphicon glyphicon-chevron-left"></i>
            </a>

            <ul id="collapseOne3" class="nav nav-pills nav-stacked collapse">
                <li><a>部门管理</a></li>
                <li><a>员工管理</a></li>
                <li><a>角色管理</a></li>
            </ul>
        </li>
    </ul>
</div>