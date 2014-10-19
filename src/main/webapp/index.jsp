<%--
  User: Kaka, Date: 2014/10/19, Time: 12:22.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>kaka's base project</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/common.css">
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body class="skinblue">
<div class="navbar navbar-fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">kaka'project</a>

        <div class="navbar-left">
            <a href="#"><i class="glyphicon glyphicon-align-justify"></i></a>
        </div>
        <ul class="navbar-right nav navbar-nav">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-envelope"></i>
                    <span class="badge">10</span>
                </a>
                <ul class="dropdown-menu">
                    <li class="header">You have 10 messages</li>
                    <li><a href="#">Messages1</a></li>
                    <li><a href="#">Messages2</a></li>
                    <li class="divider"></li>
                    <li><a href="#">See All Messages</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-warning-sign"></i>
                    <span class="badge">6</span>
                </a>
                <ul class="dropdown-menu">
                    <li class="header">You have 10 messages</li>
                    <li><a href="#">Messages1</a></li>
                    <li><a href="#">Messages2</a></li>
                    <li class="divider"></li>
                    <li><a href="#">See All Messages</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-tasks"></i>
                    <span class="badge">8</span>
                </a>
                <ul class="dropdown-menu">
                    <li class="header">You have 10 messages</li>
                    <li><a href="#">Messages1</a></li>
                    <li><a href="#">Messages2</a></li>
                    <li class="divider"></li>
                    <li><a href="#">See All Messages</a></li>
                </ul>
            </li>
            <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-user"></i>
                    <span>kaka <i class="caret"></i></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="extra_profile.html"><i class="glyphicon glyphicon-user"></i> My Profile</a></li>
                    <li><a href="page_calendar.html"><i class="glyphicon glyphicon-calendar"></i> My Calendar</a></li>
                    <li><a href="inbox.html"><i class="glyphicon glyphicon-envelope"></i> My Inbox(3)</a></li>
                    <li><a href="#"><i class="glyphicon glyphicon-tasks"></i> My Tasks</a></li>
                    <li class="divider"></li>
                    <li><a href="extra_lock.html"><i class="glyphicon glyphicon-lock"></i> Lock Screen</a></li>
                    <li><a href="login.html"><i class="glyphicon glyphicon-log-out"></i> Log Out</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>

<div class="page-container">
    <div class="page-sidebar">
        <div class="panel-group" id="accordion">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" href="#collapseOne">
                            Collapsible Group Item #1
                        </a>
                    </h4>
                </div>
                <div id="collapseOne" class="panel-collapse collapse">
                    <div class="list-group">
                        <a href="#" class="list-group-item active">
                            Cras justo odio
                        </a>
                        <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
                        <a href="#" class="list-group-item">Morbi leo risus</a>
                        <a href="#" class="list-group-item">Porta ac consectetur ac</a>
                        <a href="#" class="list-group-item">Vestibulum at eros</a>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" href="#collapse2">
                            Collapsible Group Item #2
                        </a>
                    </h4>
                </div>
                <div id="collapse2" class="panel-collapse collapse">
                    <div class="list-group">
                        <a href="#" class="list-group-item active">
                            Cras justo odio
                        </a>
                        <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
                        <a href="#" class="list-group-item">Morbi leo risus</a>
                        <a href="#" class="list-group-item">Porta ac consectetur ac</a>
                        <a href="#" class="list-group-item">Vestibulum at eros</a>
                    </div>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <a class="panel-title" style="display: block" data-toggle="collapse" href="#"> Group Item #3</a>
                </div>
            </div>
        </div>
        <ul class="nav nav-pills nav-stacked">
            <li role="presentation" class="active"><a href="#">Home</a></li>
            <li role="presentation"><a href="#">Profile</a></li>
        </ul>

        <%--<ul class="page-sidebar-menu">--%>
        <%--<li class="start active ">--%>
        <%--<a href="index.html">--%>
        <%--<i class="icon-home"></i>--%>
        <%--<span class="title">Dashboard</span>--%>
        <%--<span class="selected"></span>--%>
        <%--</a>--%>
        <%--</li>--%>

        <%--<li class="">--%>
        <%--<a href="javascript:;">--%>
        <%--<i class="icon-cogs"></i>--%>
        <%--<span class="title">Layouts</span>--%>
        <%--<span class="arrow "></span>--%>
        <%--</a>--%>
        <%--<ul class="sub-menu">--%>
        <%--<li>--%>
        <%--<a href="layout_ajax.html">--%>
        <%--Content Loading via Ajax</a>--%>
        <%--</li>--%>
        <%--<li>--%>
        <%--<a href="layout_sidebar_closed.html">--%>
        <%--Sidebar Closed Page</a>--%>
        <%--</li>--%>
        <%--<li>--%>
        <%--<a href="layout_blank_page.html">--%>
        <%--Blank Page</a>--%>
        <%--</li>--%>
        <%--<li>--%>
        <%--<a href="layout_boxed_page.html">--%>
        <%--Boxed Page</a>--%>
        <%--</li>--%>
        <%--<li>--%>
        <%--<a href="layout_boxed_not_responsive.html">--%>
        <%--Non-Responsive Boxed Layout</a>--%>
        <%--</li>--%>
        <%--</ul>--%>
        <%--</li>--%>
        <%--</ul>--%>
    </div>


    <%--<div class="footer">©2014 kaka base project v0.1.demo</div>--%>
</div>
</body>
</html>
