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
<jsp:include page="template/head.jsp"/>
<body>
<div class="wrapper">
    <jsp:include page="template/header.jsp"/>
    <section>
        <div class="row main-content">
            <jsp:include page="template/left_menu.jsp"/>
            <div class="col-md-9 bg-white">
                <h2 class="text-center">Add track</h2>
                <hr>
                <form action="app/redirect/admin/addTrack" method="post" class="col-md-6 track_form">

                    <p style="color: red">${sessionScope.genreId}</p>
                    <c:remove var="genre_id" scope="session"/>
                    <label class="font-weight-bold">Genre:</label>
                    <select name="genre_id" title="genre" class="input-group">
                        <c:forEach items="${requestScope.genres}" var="genre">
                            <option value="${genre.id}">${genre.name}</option>
                        </c:forEach>
                    </select>

                    <p style="color: red">${sessionScope.performer}</p>
                    <c:remove var="performer" scope="session"/>
                    <label class="font-weight-bold">Performer:</label>
                    <input class="input-group" list="performers" placeholder="Performer" name="performer">
                    <datalist id="performers">
                        <c:forEach items="${requestScope.performers}" var="genre">
                            <option>${genre.name}</option>
                        </c:forEach>
                    </datalist>

                    <p style="color: red">${sessionScope.name}</p>
                    <c:remove var="name" scope="session"/>
                    <label class="font-weight-bold">Name:</label>
                    <input class="input-group" placeholder="Name" name="name">

                    <p style="color: red">${sessionScope.album}</p>
                    <c:remove var="album" scope="session"/>
                    <label class="font-weight-bold">Album:</label>
                    <input class="input-group" placeholder="Album" name="album">

                    <p style="color: red">${sessionScope.duration}</p>
                    <c:remove var="duration" scope="session"/>
                    <label class="font-weight-bold">Duration:</label>
                    <input class="input-group" placeholder="Duration" name="duration">

                    <button class="btn btn-success">Submit</button>
                    <button type="reset" class="btn btn-danger">Reset</button>
                </form>
            </div>
        </div>
    </section>
</div>
</div>
</body>
</html>
