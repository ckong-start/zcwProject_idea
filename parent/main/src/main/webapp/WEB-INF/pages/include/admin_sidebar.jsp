<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-sm-3 col-md-2 sidebar">

    <div class="tree">
        <ul style="padding-left:0px;" class="list-group">
            <c:forEach items="${menus}" var="pMenu">
                <c:choose>
                    <%--没有子菜单的父菜单--%>
                    <c:when test="${empty pMenu.children}">
                        <li class="list-group-item tree-closed" >
                            <a href="${PATH}/${pMenu.url}"><i class="${pMenu.icon}"></i>${pMenu.name}</a>
                        </li>
                    </c:when>
                    <%--有子菜单的--%>
                    <c:otherwise>
                        <li class="list-group-item tree-closed">
                            <span><i class="${pMenu.icon}"></i>${pMenu.name}<span class="badge" style="float:right">${pMenu.children.size()}</span></span>
                            <ul style="margin-top:10px;display:none;">
                                <%--遍历子菜单集合--%>
                                <c:forEach items="${pMenu.children}" var="menu">
                                    <li style="height:30px;">
                                        <a href="${PATH}/${menu.url}"><i class="${menu.icon}"></i>${menu.name}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </ul>
    </div>
</div>