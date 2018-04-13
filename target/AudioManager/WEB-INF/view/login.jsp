<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12.04.2018
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="template/head.jsp"/>
<body>
<div class="wrapper">
    <jsp:include page="template/header.jsp"/>
    <div class="content">
        <jsp:include page="template/left_menu.jsp"/>
        <section>
            <div class="main_content">
                <h2>Login</h2>
                <a href="/app/registrationPage">Create account</a>
                <p style="color: red">${sessionScope.loginError}</p>
                <c:remove var="loginError" scope="session"/>
                <form method="post" action="app/redirect/login">
                    <label>Username</label>
                    <input placeholder="Username" type="text" name="username">
                    <label>Password</label>
                    <input placeholder="Password" type="password" name="password">
                    <button>Login</button>
                </form>
            </div>
        </section>
    </div>
</body>
</html>
