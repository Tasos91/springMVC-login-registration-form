<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    
    <body>
        <h1>fefefe</h1>
        <div class="container"><table class="table table-striped">
    <c:forEach items="${users}" var="user">
        <tr>
            <td> ${user.firstname} <td>
            <td> ${user.surname} <td>
            <td> ${user.username} <td>
            <td> ${user.password} <td><br>
        <tr>
        </c:forEach>
            </table>
        </div>
    </body>
</html>
