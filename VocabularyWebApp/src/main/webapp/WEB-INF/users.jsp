<%@ page import="com.company.entity.User" %>
<%@ page import="java.util.List" %>
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
    <script>
        function setIdForDelete(id) {
            var elem = document.getElementById("idForDelete")
            elem.value = id;
        }

    </script>

</head>
<body>

     <style>
         .error{
             color: red;
         }
     </style>

<div class="row">
    <div class="col-4" style="margin-left: 30px">
        <form:form action="usersm" method="GET" modelAttribute="user">

            <div class="form-group row">
                <label for="name">name</label>
                <form:input class="form-control" path="name" placeholder="Enter name"/>
<%--                <form:errors path="name" cssClass="error"/>--%>
            </div>
            <div class="form-group row">
                <label for="surname">surname</label>
                <form:input class="form-control" placeholder="Enter surname" path="surname"/>
<%--                <form:errors path="surname" cssClass="error"/>--%>
            </div>

            <form:button class="btn btn-primary">Search</form:button>
        </form:form>
    </div>
</div>
<br/>
<div style="margin-left: 30px">
    <form action="adduser" method="GET">
        <input type="hidden" name="action" value="add"/>
        <button class="btn btn-secondary" type="submit" value="AddUser">
            <i class="fas fa-user-plus"></i>
        </button>
    </form>
</div>

<div style="margin-left: 30px ; margin-right: 30px">
    <table class="table table-hover table-dark">
        <thead>
        <tr>
            <th>name</th>
            <th>surname</th>
            <th>email</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="u">
            <tr>
                <td>${u.name}
                </td>
                <td>${u.surname}
                </td>
                <td>${u.email}
                </td>
                <td style="width: 5px">
                    <input type="hidden" name="id" value="${u.id}"/>
                    <input type="hidden" name="action" value="delete"/>
                    <button class="btn btn-danger" type="submit" value="Delete"
                            data-toggle="modal" data-target="#exampleModal" onclick="setIdForDelete(${u.id})">
                        <i class="fas fa-trash-alt"></i>
                    </button>
                </td>
                <td style="width: 5px">
                    <form action="userdetail" method="GET">
                        <input type="hidden" name="id" value="${u.id}"/>
                        <input type="hidden" name="action" value="update"/>
                        <button class="btn btn-secondary" type="submit" value="Update">
                            <i class="fas fa-edit"></i>
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure?
            </div>
            <div class="modal-footer">
                <form action="userdetail" method="POST">
                    <input type="hidden" name="id" value="" id="idForDelete">
                    <input type="hidden" name="action" value="delete">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-danger" value="Delete"/>
                </form>

            </div>
        </div>
    </div>
</div>
</body>
</html>
