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
            for (int k = 1; k < 5; k++) {
                Map s = new HashMap();
                s.put("id", "" + k + i);
                s.put("name", "部门管理" + i + k);
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
            <c:if test="${menu.children == null}">
                <li ${param.fid == menu.id ? "class='active'" : ""}>
                    <a href="/system/dept.jsp?fid=${menu.id}">
                        <i class="glyphicon glyphicon-home"></i>
                        <span class="title">${menu.name}</span>
                        <c:if test="${param.fid == menu.id}">
                            <span class="selected"></span>
                        </c:if>
                    </a>
                </li>
            </c:if>
            <c:if test="${menu.children != null}">
                <li ${param.fid == menu.id ? "class='open'" : ""}>
                    <a href="#menu${menu.id}" data-toggle="collapse" onclick="linkSecondMenu(this)">
                        <i class="glyphicon glyphicon-home"></i>
                        <span class="title">${menu.name}</span>
                        <i class="arrow glyphicon glyphicon-chevron-${param.fid == menu.id ? "down" : "left"}"></i>
                    </a>
                    <ul id="menu${menu.id}"
                        class="nav nav-pills nav-stacked collapse ${param.fid == menu.id ? "in" : ""}">
                        <c:forEach items="${menu.children}" var="children">
                            <li ${param.sid == children.id ? "class='active'" : ""}>
                                <a href="/system/dept.jsp?fid=${menu.id}&sid=${children.id}">
                                        ${children.name}
                                    <c:if test="${param.sid == children.id}">
                                        <span class="selected"></span>
                                    </c:if>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </li>
            </c:if>
        </c:forEach>
    </ul>
</div>

<script type="text/javascript">
    function linkSecondMenu(obj) {
        var li = $(obj).parent();
        var arrow = $(obj).find(".arrow:first");
        if (li.hasClass("open")) {
            li.removeClass("open");
            arrow.removeClass("glyphicon-chevron-down");
            arrow.addClass("glyphicon-chevron-left");
        } else {
            li.addClass("open");
            arrow.removeClass("glyphicon-chevron-left");
            arrow.addClass("glyphicon-chevron-down");
        }
    }
</script>