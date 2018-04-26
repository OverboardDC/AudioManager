<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.04.2018
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <div class="col-md-3 bg-light border-right">
        <div class="genres_div">
            <h3>Get tracks by genre</h3>
            <ul class="list-group list-group-flush">
                <c:forEach items="${requestScope.genres}" var="genre">
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        <c:url value="/app/getTracksByGenre" var="getByGenre">
                            <c:param name="id" value="${genre.id}"/>
                            <c:if test="${requestScope.page != null}">
                                <c:param name="page" value="${requestScope.page}"/>
                            </c:if>
                        </c:url>
                        <a class="text-dark" href="${getByGenre}">${genre.name}</a>
                        <c:if test="${sessionScope.user.admin}">
                            <a class="badge badge-danger"
                               href="app/redirect/admin/removeGenre?id=${genre.id}">Remove</a>
                        </c:if>
                    </li>
                </c:forEach>
            </ul>
            <c:if test="${sessionScope.user.admin}">
                <form action="/app/redirect/admin/addGenre" method="post">

                    <label style="color: red">${sessionScope.genre_name}</label>
                    <c:remove var="genre_name" scope="session"/>
                    <input placeholder="Genre name" class="input-group" name="genre_name">
                    <button class="btn btn-primary">Add new</button>
                </form>
            </c:if>
        </div>
        <hr>
        <div class="duration_div">
            <h3>Set duration</h3>
            <c:url value="/app/getTracksByDuration" var="getByDuration"/>
            <form action="${getByDuration}" method="get">

                <label style="color: red">${sessionScope.min}</label>
                <c:remove var="min" scope="session"/>
                <input class="input-group" placeholder="Min" name="min">

                <label style="color: red">${sessionScope.max}</label>
                <c:remove var="max" scope="session"/>
                <input class="input-group" placeholder="Max" name="max">
                <button class="btn btn-dark">Find</button>
            </form>
        </div>
    </div>

