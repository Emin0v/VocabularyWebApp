<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>
<body>
<style>
    .error{
        color: red;
    }
</style>

<div class="row">
    <div class="col-4" style="margin-left: 30px">
        <form:form action="adduser" method="POST" modelAttribute="useradd">
            <div class="form-group row">
                <label for="name">name</label>
                <form:input class="form-control" path="name" placeholder="enter name"/>
<%--                <form:errors path="name" cssClass="error"/>--%>
            </div>
            <div class="form-group row">
                <label for="surname">surname</label>
                <form:input class="form-control" path="surname" placeholder="enter surname"/>
<%--                <form:errors path="surname" cssClass="error"/>--%>
            </div>

            <div class="form-group row">
                <label for="email">email</label>
                <form:input class="form-control" path="email" placeholder="enter email"/>
<%--                <form:errors path="email" cssClass="error"/>--%>
            </div>
            <div class="form-group row">
                <label for="score">score</label>
                <form:input class="form-control" path="score" placeholder="enter score"/>
            </div>
            <div class="form-group row">
                <label for="password">password</label>
                <form:input class="form-control" path="password" placeholder="enter password"/>
<%--                <form:errors path="password" cssClass="error"/>--%>
            </div>
            <input class="btn btn-primary" type="submit" name="save" value="Save"/>
        </form:form>
    </div>
</div>
</body>
</html>
