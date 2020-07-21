<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="javax.persistence.criteria.CriteriaBuilder" %><%--
  Created by IntelliJ IDEA.
  User: Aaaryan
  Date: 16-07-2020
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<% Integer empty=(Integer) request.getAttribute("emptyBlogList");
String message="";
if(empty==0)
    message="oops,you have not written any blogs!!";

%>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Blogulo</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <c:url var="userlink" value="/blog/refresh-to-home-page">
                    <c:param name="userid" value="${userid}"></c:param>
                </c:url>
                <a class="nav-link" href="${userlink}"><div style="color: darkcyan">HOME-PAGE</div></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dropdown
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>

        </ul>
        <form class="form-inline my-2 my-lg-0" >
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>








<div class="container">
<table class="table">
    <thead class="thead-dark">
    <tr>

        <th scope="col">Blog</th>
        <th scope="col">Total views</th>
        <th scope="col">Comments</th>
        <th scope="col">Update</th>
    </tr>
    <tr><%=message %></tr>
    </thead>
    <c:forEach var="userblog" items="${myblog}">
       <c:url var="blogid" value="#">
           <c:param name="blogId" value="${userblog.id}"></c:param>
       </c:url>

        <tr>
            <td>${userblog.heading}</td>
            <td>Total Views</td>
            <td>Comments</td>
            <td><a href="${blogid}"></a>GO</td>
        </tr>

    </c:forEach>
    <tbody>
    </tbody>
</table>
</div>


</body>
</html>
