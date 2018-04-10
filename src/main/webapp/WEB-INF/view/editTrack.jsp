<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.04.2018
  Time: 14:48
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
                <h2>Edit:</h2>
                <form action="app/redirect/admin/editTrack" method="post">
                    <input type="hidden" value="${requestScope.track.id}" name="id">

                    <p style="color: red">${sessionScope.performer}</p>
                    <c:remove var="performer" scope="session"/>
                    <label>Performer:</label>
                    <input list="performers" placeholder="Performer" name="performer" value="${requestScope.track.performer.name}">
                    <datalist id="performers">
                        <c:forEach items="${requestScope.performers}" var="performer">
                            <option>${performer.name}</option>
                        </c:forEach>
                    </datalist>

                    <p style="color: red">${sessionScope.genreId}</p>
                    <c:remove var="genreId" scope="session"/>
                    <label>Genre:</label>
                    <select name="genreId" title="genre">
                        <c:forEach items="${requestScope.genres}" var="genre">
                            <option value="${genre.id}">${genre.name}</option>
                        </c:forEach>
                    </select>

                    <p style="color: red">${sessionScope.album}</p>
                    <c:remove var="album" scope="session"/>
                    <label>Album:</label>
                    <input placeholder="Album" name="album" value="${requestScope.track.album}">

                    <p style="color: red">${sessionScope.name}</p>
                    <c:remove var="name" scope="session"/>
                    <label>Name:</label>
                    <input placeholder="Name" name="name" value="${requestScope.track.name}">

                    <p style="color: red">${sessionScope.duration}</p>
                    <c:remove var="duration" scope="session"/>
                    <label>Duration:</label>
                    <input placeholder="Duration" name="duration" value="${requestScope.track.duration}">

                    <button type="submit">Save</button>
                </form>
            </div>
        </section>
    </div>
</div>
</body>
</html>
