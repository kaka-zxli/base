<%--
  User: Kaka, Date: 2014/10/26, Time: 10:44.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>kaka's base project</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body class="skinblue">
<%@include file="/common/header.jsp" %>
<div class="page-container">
    <%@include file="/common/sidebar.jsp" %>
    <div class="page-main">
        部门管理${param.fid}${param.sid}
    </div>
</div>
<%@include file="/common/footer.jsp" %>
</body>
</html>