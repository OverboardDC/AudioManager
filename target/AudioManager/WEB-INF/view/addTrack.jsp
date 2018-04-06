<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.04.2018
  Time: 19:43
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
                <h2>Adding a new track:</h2>
                <form action="app/redirect/admin/addTrack" method="post">

                    <p style="color: red">${sessionScope.performer}</p>
                    <c:remove var="performer" scope="session"/>
                    <input list="performers" placeholder="Performer" name="performer">
                    <datalist id="performers">
                        <c:forEach items="${requestScope.performers}" var="genre">
                            <option>${genre.name}</option>
                        </c:forEach>
                    </datalist>

                    <p style="color: red">${sessionScope.genreId}</p>
                    <c:remove var="genreId" scope="session"/>
                    <select name="genreId" title="genre">
                        <c:forEach items="${requestScope.genres}" var="genre">
                            <option value="${genre.id}">${genre.name}</option>
                        </c:forEach>
                    </select>

                    <p style="color: red">${sessionScope.album}</p>
                    <c:remove var="album" scope="session"/>
                    <input placeholder="Album" name="album">

                    <p style="color: red">${sessionScope.name}</p>
                    <c:remove var="name" scope="session"/>
                    <input placeholder="Name" name="name">

                    <p style="color: red">${sessionScope.duration}</p>
                    <c:remove var="duration" scope="session"/>
                    <input placeholder="Duration" name="duration">

                    <button type="submit">Add new track</button>
                    <button type="reset">Reset</button>
                </form>
            </div>
        </section>
    </div>
</div>
</body>
</html>
