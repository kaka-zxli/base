<%--
  User: Kaka, Date: 2014/10/16, Time: 22:04.
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
    <style>
        html {
            background: url(image/201111816166.jpg) no-repeat center center fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
        }

        body {
            padding-top: 80px;
            background: transparent;
        }

        .panel {
            background-color: rgba(255, 255, 255, 0.9);
        }

        .margin-base-vertical {
            margin: 40px 0 20px;
        }

        .logo {
            top: 5px;
            position: absolute;
        }

        .logo img {
            width: 60px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4 panel panel-default form-horizontal">
            <div class="logo"><img src="image/logo.jpg"></div>
            <div class="margin-base-vertical text-center">
                <h2>kaka's project</h2>
            </div>
            <div class="form-group margin-base-vertical">
                <label class="col-sm-3 control-label">用 户</label>

                <div class="col-sm-8">
                    <input type="text" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">密 码</label>

                <div class="col-sm-8">
                    <input type="password" class="form-control">
                </div>
            </div>

            <div class="margin-base-vertical text-center">
                <button class="btn btn-success btn-lg" onclick="login()">登 录</button>
            </div>
        </div>
    </div>
</div>
<div class="footer">©2014 kaka base project v0.1.demo</div>
</body>

<script type="text/javascript">
    function login(){
        location.href="index.jsp";
    }
</script>

</html>
