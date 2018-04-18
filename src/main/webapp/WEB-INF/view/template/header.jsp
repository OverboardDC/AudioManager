<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.04.2018
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <header>
        <div class="row">
            <nav class="navbar bg-dark col">
                <a href="/app/" class="navbar-brand text-light"><img src="${pageContext.request.contextPath}/img/logo.jpg" alt="logo" class="logo">
                    Audio Manager</a>

                <ul class="navbar-nav">
                    <c:if test="${sessionScope.user == null}">
                        <li class="navbar-item">
                            <a class="nav-link text-light" href="/app/loginPage">Login</a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.user != null}">
                        <p class="text-light">Welcome ${sessionScope.user.name}</p>
                        <a class="nav-link text-light" href="/app/redirect/logout">Logout</a>
                    </c:if>
                </ul>
            </nav>
        </div>
    </header>

