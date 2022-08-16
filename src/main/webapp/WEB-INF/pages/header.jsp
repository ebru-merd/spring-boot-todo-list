<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ToDos</title>
    <link rel="stylesheet" href="/css/index.css">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>


</head>
<body>

<header>
    <nav>
        <input type="checkbox" id="check">
        <label for="check" class="checkbtn">
            <i class="fas fa-bars"></i>
        </label>
        <label class="title" >${username}</label>
        <ul class="asd">
            <li><a href="/note/viewNotes">ToDos</a></li>
            <li><a href="/logout">Logout</a></li>
        </ul>
    </nav>
</header>

<mytag:scripts/>
</body>
<script>
    $('.checkbtn').click(function() {
        $('ul').toggleClass('active');
    })
</script>

</html>