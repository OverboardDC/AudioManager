<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31.03.2018
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Audio manager</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="wrapper">
    <jsp:include page="template/header.jsp"/>
    <div class="content">
        <jsp:include page="template/left_menu.jsp"/>
        <section>
            <div class="main_content">
                <h1>Error</h1>
                <p>Some problem has happened</p>
            </div>
        </section>
    </div>
</div>
</body>
</html>
