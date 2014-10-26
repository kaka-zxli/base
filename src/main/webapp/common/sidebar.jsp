<%--
  User: Kaka, Date: 2014/10/26, Time: 11:16.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page-sidebar" class="page-sidebar collapse in">
    <ul class="firstMenu nav nav-pills nav-stacked">
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