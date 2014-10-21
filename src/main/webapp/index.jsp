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
            <a href="#page-sidebar" data-toggle="collapse"><i class="glyphicon glyphicon-align-justify"></i></a>
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
                    <li><a href="#"><i class="glyphicon glyphicon-user"></i> My Profile</a></li>
                    <li><a href="#"><i class="glyphicon glyphicon-calendar"></i> My Calendar</a></li>
                    <li><a href="#"><i class="glyphicon glyphicon-envelope"></i> My Inbox(3)</a></li>
                    <li><a href="#"><i class="glyphicon glyphicon-tasks"></i> My Tasks</a></li>
                    <li class="divider"></li>
                    <li><a href="#"><i class="glyphicon glyphicon-lock"></i> Lock Screen</a></li>
                    <li><a href="#"><i class="glyphicon glyphicon-log-out"></i> Log Out</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>

<div class="page-container">
    <div id="page-sidebar" class="page-sidebar collapse in">
        <ul class="nav nav-pills nav-stacked">
            <li>
                <a data-toggle="collapse" href="#collapseOne">
                    Collapsible Group Item #1
                </a>
                <ul id="collapseOne" class="nav nav-pills nav-stacked collapse">
                    <li>
                        <a data-toggle="collapse" href="#collapseOne3">
                            Collapsibl Item #3
                        </a>
                        <ul id="collapseOne3" class="nav nav-pills nav-stacked collapse">
                            <li><a>Cras justo odio</a></li>
                            <li><a>Cras justo odio</a></li>
                            <li><a>Cras justo odio</a></li>
                        </ul>
                    </li>
                    <li><a>Cras justo odio</a></li>
                    <li><a>Cras justo odio</a></li>
                    <li><a>Cras justo odio</a></li>
                </ul>
            </li>
            <li><a>Cras justo odio2</a></li>
            <li><a>Cras justo odio3</a></li>
            <li><a>Cras justo odio4</a></li>
        </ul>


        <ul class="list-group">
            <li class="list-group-item">
                <a data-toggle="collapse" href="#collapseOne5">Dapibus1</a>
                <ul id="collapseOne5" class="list-group collapse">
                    <li class="list-group-item"><a href="#">Dapibus4</a></li>
                    <li class="list-group-item"><a href="#">Dapibus5</a></li>
                    <li class="list-group-item"><a href="#">Dapibus6</a></li>
                </ul>
            </li>
            <li class="list-group-item"><a href="#">Dapibus2</a></li>
            <li class="list-group-item"><a href="#">Dapibus3</a></li>
        </ul>
    </div>

    <%--<div class="footer">©2014 kaka base project v0.1.demo</div>--%>
</div>
</body>
</html>
