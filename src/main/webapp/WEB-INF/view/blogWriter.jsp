<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>
<head>
    <title>Title</title>
    <style type="text/css">
    .error{color:red}
    </style>

    <link rel="stylesheet" href="../../../resources/static/css/blogwriter.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
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

Welcome to the blog page!!
<br><br>
Your UserName:${user.username}
Your Age:${user.age}

<div class="container">
MAKE SURE YOUR FIELDS ARE NOT EMPTY!!
<form:form action="${pageContext.request.contextPath}/blog/blogchecker" method="GET" modelAttribute="blog">



    <div class="form-group" >
        <label for="exampleInputEmail1">Heading</label>
        <form:input path="heading" cssClass="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"/>
        <form:errors path="heading" cssClass="error"></form:errors>
    </div>

    <div class="form-group">
        <label for="exampleInputPassword1">Body</label>
        <form:textarea cols="40" rows="40" path="blogbody" class="form-control" id="exampleInputPassword1" />
        <form:errors path="blogbody" cssClass="error"/>
    </div>

<p>enter the genre of your blog</p>


<input type="submit" value="save">


</form:form>



</div>











</body>
</html>