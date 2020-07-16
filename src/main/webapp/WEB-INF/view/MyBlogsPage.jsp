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
</head>
<% Integer empty=(Integer) request.getAttribute("emptyBlogList");
String message="";
if(empty==0)
    message="oops,you have not written any blogs!!";

%>

<body>
your blogs!!


<table>
    <tr>
        <td>Heading</td>
    </tr>
    <tr><%=message %></tr>
    <c:forEach var="userblog" items="${myblog}">
        <tr>
            <td>${userblog.heading}</td>
        </tr>

    </c:forEach>

</table>

<a href="${pageContext.request.contextPath}/blog/refresh-to-home-page">home page</a>

</body>
</html>
