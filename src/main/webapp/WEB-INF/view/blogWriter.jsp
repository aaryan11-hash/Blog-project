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
</head>
<body>
Welcome to the blog page!!
<br><br>
Your UserName:${user.username}
Your Age:${user.age}
Your preffered Genre:<c:forEach var="user1" items="${user.prefferedGenre}"> ${user1}</c:forEach>
<br><br>
<br><br>
MAKE SURE YOUR FIELDS ARE NOT EMPTY!!
<form:form action="${pageContext.request.contextPath}/blog/blogchecker" method="GET" modelAttribute="blog">



<p class="paragraph1">enter the heading</p><form:input path="heading"/>
<form:errors path="heading" cssClass="error"></form:errors>
<br><br>
enter the body<form:textarea path="blogbody" cols="40" rows="40"/>
<form:errors path="blogbody" cssClass="error"></form:errors>
<br><br>

<p>enter the genre of your blog</p>

<input type="submit" value="submit">


</form:form>


<br><br>










</body>
</html>