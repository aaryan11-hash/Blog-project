<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sign-up</title>
<style>
.error{color:red}
</style>
</head>

Welcome to the profile builder page!!
<br><br>
Your UserName: ${username}
<br><br>

<form:form action="${pageContext.request.contextPath}/blog/postProcessing" method="GET" modelAttribute="user">

Enter FirstName<form:input path="firstname"/>
<form:errors path="firstname" cssClass="error"></form:errors>
<br><br>

Enter LastName<form:input path="lastname"/>
<form:errors path="lastname" cssClass="error"></form:errors>
<br><br>

Enter Education<form:textarea path="education" cols="20" rows="20"/>
<form:errors path="education"></form:errors>
<br><br>

Enter Age<form:input path="age"/>
<form:errors path="age" cssClass="error"></form:errors>
<br><br>

Just to get you Started on the Posts you will see
<br>
Select your Preferred Genre's 
<form:checkbox path="prefferedGenre" value="Fiction" label="Fiction"/>
<form:checkbox path="prefferedGenre" value="Science" label="Science"/>
<form:checkbox path="prefferedGenre" value="Romance" label="Romance"/>

<input type="submit" value="Proceed">

</form:form>


</html>