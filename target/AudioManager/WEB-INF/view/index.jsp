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
                            <img class="music_track_image "
                                 src="${pageContext.request.contextPath}/img/music_track.png">
                            <h5>Album: </h5>
                            <p>${track.album}</p>
                            <h5>Performer: </h5>
                            <c:url value="/app/getTracksByPerformer" var="getByPerformer">
                                <c:param name="id" value="${track.performer.id}"/>
                                <c:if test="${requestScope.page != null}">
                                    <c:param name="page" value="${requestScope.page}"/>
                                </c:if>
                            </c:url>
                            <a class="text-dark"
                               href="${getByPerformer}">${track.performer.name}</a>
                            <h5>Genre: </h5>
                            <c:url value="/app/getTracksByGenre" var="getByGenre">
                                <c:param name="id" value="${track.genre.id}"/>
                                <c:if test="${requestScope.page != null}">
                                    <c:param name="page" value="${requestScope.page}"/>
                                </c:if>
                            </c:url>
                            <a class="text-dark"
                               href="${getByGenre}">${track.genre.name}</a>
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
                <c:if test="${!requestScope.tracks.isEmpty()}">
                    <div class="row justify-content-center">
                        <ul class="pagination">
                            <c:forEach var="page" items="${requestScope.pages}">
                                <c:url value="" var="changePage">
                                    <c:param name="page" value="${page}"/>
                                    <c:if test="${requestScope.last_genre_id != null}">
                                        <c:param name="id" value="${requestScope.last_genre_id}"/>
                                    </c:if>
                                    <c:if test="${requestScope.last_performer_id != null}">
                                        <c:param name="id" value="${requestScope.last_performer_id}"/>
                                    </c:if>
                                    <c:if test="${requestScope.last_min_duration != null && requestScope.last_max_duration != null}">
                                        <c:param name="min" value="${requestScope.last_min_duration}"/>
                                        <c:param name="max" value="${requestScope.last_max_duration}"/>
                                    </c:if>
                                </c:url>
                                <c:if test="${requestScope.current_page == page}">
                                    <li class="page-item"><a class="page-link alert-info" href="${changePage}">${page}</a></li>
                                </c:if>
                                <c:if test="${requestScope.current_page != page}">
                                    <li class="page-item"><a class="page-link" href="${changePage}">${page}</a></li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </div>
                </c:if>
            </div>
        </div>
    </section>
</div>
</body>
</html>
