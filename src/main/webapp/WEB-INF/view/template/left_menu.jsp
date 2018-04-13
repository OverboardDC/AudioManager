<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.04.2018
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section>
    <div class="left_menu">
        <h3>Genres</h3>
        <h6>Add new genre</h6>
        <c:if test="${sessionScope.user.admin}">
            <form action="app/redirect/admin/addGenre" method="post">
                <p style="color: red">${sessionScope.genreName}</p>
                <c:remove var="genreName" scope="session"/>
                <input name="genre_name" placeholder="Genre name">
                <button type="submit">Add</button>
            </form>
        </c:if>
        <ul class="genres_list">
            <c:forEach items="${requestScope.genres}" var="genre">
                <li>
                    <a class="genre_link" href="/app/getTracksByGenre?id=${genre.id}">${genre.name}</a>
                    <c:if test="${sessionScope.user.admin}">
                        <a class="remove_genre" href="app/redirect/admin/removeGenre?id=${genre.id}">Remove</a>
                    </c:if>
                </li>
            </c:forEach>
        </ul>
        <h3>Duration</h3>
        <form action="/app/getTracksByDuration">

            <p style="color: red">${sessionScope.min}</p>
            <c:remove var="min" scope="session"/>
            <input placeholder="from" name="min">

            <p style="color: red">${sessionScope.max}</p>
            <c:remove var="max" scope="session"/>
            <input placeholder="to" name="max">
            <button type="submit">Find compositions</button>
        </form>
    </div>
</section>
