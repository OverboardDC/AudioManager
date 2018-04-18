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
<jsp:include page="template/head.jsp"/>
<body>
<div class="wrapper">
    <jsp:include page="template/header.jsp"/>
    <section>
        <div class="row main-content">
            <jsp:include page="template/left_menu.jsp"/>

            <div class="col-md-9 bg-white text-center">
                <h2 class="text-center">Error</h2>
                <hr>
                <p>Something went wrong...</p>
            </div>
        </div>
    </section>

</div>
</body>
</html>
