<%@ page import="javax.imageio.stream.ImageInputStream" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <script type="text/javascript" src="assets/js/test.js"></script>

    <link rel="stylesheet" href="assets/css/quiz.css">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">

        <a class="navbar-brand" href="start">Start</a>

        <div class="collapse navbar-collapse" id="">
            <ul class="navbar-nav mr-auto">
                <%--            <li class="nav-item active">--%>
                <%--                <a class="nav-link" href="home.jsp">Home</a>--%>
                <%--            </li>--%>
                <li class="nav-item">
                    <a class="nav-link" href="#" style="">Profile</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="https://en.wikipedia.org/wiki/Vocabulary" target="_blank">About</a>
                </li>
            </ul>
            <form class="form-inline">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</header>

<div>
<img src="abc.jpg" style=" background-size: cover ; height: 100vh; width: 100%; float: inside">

<%--    <div style="position: absolute ; top: 50% ; left: 50% ; transform: translate(-50%, -50%);">Mahammad Eminov</div>--%>
    <p style="position: absolute ; top: 50% ; left: 50% ; transform: translate(-50%, -50%);">
        Mahammad Eminov
    </p>

</div>

</body>
</html>
