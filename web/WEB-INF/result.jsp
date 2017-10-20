<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" crossorigin="anonymous">

</head>
<body>

<table class="table">
  <thead>
  <tr>
    <th>id</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>email</th>
    <th>phone</th>
  </tr>
  </thead>
  <tbody>

  <c:forEach items="${students}" var="student">
    <tr>
      <th scope="row">${student.id}</th>
      <td>${student.name}</td>
      <td>${student.surname}</td>
      <td>${student.email}</td>
      <td>${student.phone}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<%--js bibliotekos turi buti failo apacioje--%>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"  crossorigin="anonymous"></script>
</body>
</html>