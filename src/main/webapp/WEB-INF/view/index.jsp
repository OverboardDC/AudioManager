<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <h2 class="text-center">Tracks</h2>
                <c:if test="${sessionScope.user.admin}">
                    <a class="btn btn-primary" href="/app/admin/addTrackPage">Add new</a>
                </c:if>
                <hr>
                <div class="row justify-content-start">
                    <c:forEach items="${requestScope.tracks}" var="track">
                        <div class="col-md-3 bg-light text-center music_track">
                            <h3>${track.name}</h3>
                            <img class="music_track_image " src="${pageContext.request.contextPath}/img/music_track.png">
                            <h5>Album: </h5>
                            <p>${track.album}</p>
                            <h5>Performer: </h5>
                            <a class="text-dark"
                               href="/app/getTracksByPerformer?id=${track.performer.id}">${track.performer.name}</a>
                            <h5>Genre: </h5>
                            <a class="text-dark"
                               href="/app/getTracksByGenre?id=${track.genre.id}">${track.genre.name}</a>
                            <h5>Duration: </h5>
                            <p>${track.duration}</p>
                            <h5>Creation date:</h5>
                            <p>${track.creatingDateTime}</p>
                            <c:if test="${sessionScope.user.admin}">
                                <div>
                                    <a class="btn btn-primary" href="/app/admin/editTrackPage?id=${track.id}">Edit</a>
                                    <a class="btn btn-danger"
                                       href="app/redirect/admin/removeTrack?id=${track.id}">Remove</a>
                                </div>
                            </c:if>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>
</div>
</body>
</html>
