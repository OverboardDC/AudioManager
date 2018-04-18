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
    <section>
        <div class="row main-content">
            <jsp:include page="template/left_menu.jsp"/>

            <div class="col-md-9 bg-white">
                <h2 class="text-center">Registration</h2>
                <hr>

                <form method="post" action="app/redirect/registration" class="col-md-6 track_form">
                    <label style="color: red" class="input-group">${sessionScope.registrationError}</label>
                    <c:remove var="registrationError" scope="session"/>

                    <p style="color: red">${sessionScope.username}</p>
                    <c:remove var="username" scope="session"/>
                    <label class="font-weight-bold">Username</label>
                    <input class="input-group" name="username" placeholder="Username" type="text">

                    <p style="color: red">${sessionScope.password}</p>
                    <c:remove var="password" scope="session"/>
                    <label class="font-weight-bold">Password</label>
                    <input class="input-group" name="password" placeholder="Password" type="password">

                    <p style="color: red">${sessionScope.password_confirm}</p>
                    <c:remove var="password_confirm" scope="session"/>
                    <label class="font-weight-bold">Confirm password</label>
                    <input class="input-group" name="password_confirm" placeholder="Confirm password" type="password">
                    <button class="btn btn-success">Submit</button>
                    <button type="reset" class="btn btn-danger">Reset</button>
                </form>
            </div>
    </section>

</div>
</body>
</html>
