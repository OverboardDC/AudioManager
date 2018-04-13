<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.04.2018
  Time: 12:07
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
                <h2>Registration</h2>
                <p style="color: red">${sessionScope.registrationError}</p>
                <c:remove var="registrationError" scope="session"/>
                <form method="post" action="app/redirect/registration">
                    <p style="color: red">${sessionScope.username}</p>
                    <c:remove var="username" scope="session"/>
                    <label>Username</label>
                    <input name="username" placeholder="Username" type="text">

                    <p style="color: red">${sessionScope.password}</p>
                    <c:remove var="password" scope="session"/>
                    <label>Password</label>
                    <input name="password" placeholder="Password" type="password">

                    <p style="color: red">${sessionScope.password_confirm}</p>
                    <c:remove var="password_confirm" scope="session"/>
                    <label>Confirm password</label>
                    <input name="password_confirm" placeholder="Confirm password" type="password">
                    <button>Submit</button>
                </form>
            </div>
        </section>
    </div>
</div>
</body>
</html>
