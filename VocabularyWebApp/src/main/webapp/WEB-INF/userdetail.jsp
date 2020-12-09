<%@ page import="com.company.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/5c2575856c.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>
<body>

<%
    User user = (User)request.getAttribute("user");

%>
<div class="row">
    <div class="col-4" style="margin-left: 30px">
        <form:form action="userdetail" method="POST" modelAttribute="userd" >
            <input type="hidden" name="action" value="update">
            <form:input type="hidden" path="id" />
            <div class="form-group row">
                <label for="name">name</label>
                <form:input class="form-control" path="name" placeholder="enter name"/>
            </div>
            <div class="form-group row">
                <label for="surname">surname</label>
                <form:input class="form-control" path="surname"  placeholder="enter surname"/>
            </div>

            <div class="form-group row">
                <label for="email">email</label>
                <form:input class="form-control" path="email" placeholder="enter email"/>
            </div>
            <div class="form-group row">
                <label for="score">score</label>
                <form:input class="form-control" path="score" placeholder="enter score"/>
            </div>
            <div class="form-group row">
                <label for="password">password</label>
                <form:input class="form-control" path="password" placeholder="enter password"/>
            </div>
            <input class="btn btn-primary" type="submit" name="save" value="Save"/>
        </form:form>
    </div>
</div>

</body>
</html>
