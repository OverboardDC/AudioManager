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
    <section>
        <div class="row main-content">
            <jsp:include page="template/left_menu.jsp"/>

            <div class="col-md-9 bg-white">
                <h2 class="text-center">Login</h2>
                <hr>
                <form method="post" action="app/redirect/login" class="login_form col-md-6 offset-md-3 text-center">
                    <label style="color: red">${sessionScope.loginError}</label>
                    <c:remove var="loginError" scope="session"/>

                    <input placeholder="Username" class="input-group" name="username">
                    <input type="password" placeholder="Password" class="input-group" name="password">
                    <a href="/app/registrationPage" class="input-group">Create account</a>
                    <button class="btn btn-success">Login</button>
                </form>
            </div>
        </div>
    </section>
</div>
</body>
</html>
