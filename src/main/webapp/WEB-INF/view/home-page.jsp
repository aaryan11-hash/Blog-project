<%--
  Created by IntelliJ IDEA.
  User: Aaaryan
  Date: 07-07-2020
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body style="background-color: azure">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Blogulo</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <c:url var="currentUser" value="/blog/myBlogLink">
                    <c:param name="userid" value="${userid}"></c:param>
                </c:url>
                <a class="nav-link" href="${currentUser}"><div style="color: darkcyan">MY-BLOGS</div></a>
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
            <li class="nav-item">
                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" >
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>


<div class="jumbotron">
   <div style="color: indigo" >
    <h1 class="display-4">Hello ${user.firstname} !!</h1>
    <p class="lead">Your preffered Genre:<c:forEach var="user1" items="${user.prefferedGenre}"> ${user1}</c:forEach></p>
    <p class="lead">Number of times people viewed your blogs</p>
    <hr class="my-4">
    <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/blog/newBlog" role="button">GO BLOG</a>
    <p>this link button will tell about new posts</p>
   </div>
</div>



Welcome The Home Page!!

your id

<br><br>
YOUR BLOGS










YOUR RECOMMENDATIONS(Blogs per se)
<!--this part is for suggesting blogs from bloggers who this current user follows-->
<!--future code will auto suggest on the basis of likes/followers of popular bloggers as well -->
<br><br>




YOUR PROFILE
<!-- this part will handle the display of the current users logged in info display -->
<!-- this link will redirect to a profile page where the uder can change and customize his/her profile-->




</body>
</html>
