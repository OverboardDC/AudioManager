<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.04.2018
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <div class="content">
        <header>
            <div class="header">
                <div class="header_logo">
                    <a href="/app/"><img src="${pageContext.request.contextPath}/img/logo.jpg" alt="logo" class="logo"></a>
                </div>
                <div class="header_right">
                    <c:if test="${sessionScope.user == null}">
                    <a href="/app/loginPage">Login</a>
                    </c:if>
                    <c:if test="${sessionScope.user != null}">
                        <p>Welcome ${sessionScope.user.name}</p>
                        <a href="/app/redirect/logout">Logout</a>
                    </c:if>
                </div>
            </div>
        </header>
    </div>

