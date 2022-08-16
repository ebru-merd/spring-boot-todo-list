
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Todos</title>

    <link rel="stylesheet" href="/css/style1.css">
    <jsp:include page="header.jsp" />
</head>
<body class="body">

        <div class="form">
            <strong><label style="color:#CC00FF">Title</label></strong>
            <input type="text" class="form-control" id="exampleInputText1" >
            <strong><label style="color: #CC00FF">Content</label></strong>
            <textarea name="Content"  cols="35" rows="10" id="exampleFormControlTextarea1" rows="3" ></textarea>
            <button type="button"  onclick="addNotes()" href="/note/viewNotes">Save</button>
        </div>


<mytag:scripts/>
</body>
</html>
