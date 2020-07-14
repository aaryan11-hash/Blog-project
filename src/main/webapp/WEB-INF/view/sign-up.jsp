<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sign-up</title>
    <style>
        .error{color: red}

    </style>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>

<body style="background-color: blanchedalmond">

<div style=" background-color: blanchedalmond ;max-width: 15cm ; " >
<form:form action="${pageContext.request.contextPath}/blog/profileBuilder" method="GET" modelAttribute="newuser">
    <div class="form-group" >
        <label for="exampleInputEmail1">User Name</label>
        <form:input path="username" cssClass="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"/>
        <form:errors path="username" cssClass="error"></form:errors>
    </div>

    <div class="form-group">
        <label for="exampleInputPassword1">Enter Password</label>
        <form:input path="password" class="form-control" id="exampleInputPassword1"/>
        <form:errors path="password" cssClass="error"/>
    </div>

<input type="submit" value="Proceed" class="btn btn-primary">

</form:form>

</div>


</body>

</html>