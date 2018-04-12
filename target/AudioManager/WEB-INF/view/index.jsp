<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <a class="add_track_link" href="app/admin/addTrackPage">Add new track</a>
                <div class="clearfix"></div>
                <c:forEach items="${requestScope.tracks}" var="track">
                    <div class="track">
                        <h3>${track.name}</h3>
                        <p>Performer: <a href="/app/getTracksByPerformer?id=${track.performer.id}">${track.performer.name}</a></p>
                        <p>Album: ${track.album}</p>
                        <p>Genre: <a href="/app/getTracksByGenre?id=${track.genre.id}">${track.genre.name}</a></p>
                        <p>Duration: ${track.duration}</p>
                        <p>Creation date: ${track.creatingDateTime}</p>
                        <a href="/app/admin/editTrackPage?id=${track.id}">Edit</a>
                        <a href="app/redirect/admin/removeTrack?id=${track.id}">Remove</a>
                    </div>
                </c:forEach>
            </div>
        </section>
    </div>
</div>
</body>
</html>
