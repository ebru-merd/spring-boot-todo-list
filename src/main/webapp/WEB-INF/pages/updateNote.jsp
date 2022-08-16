
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<input type="hidden" value="${id}" id="id"/>

        <div class="form">
            <strong><label style="color:#CC00FF">Title</label></strong>
            <input type="text"  id="exampleInputText2"  placeholder="Title" value="${title}" >
            <strong><label style="color: #CC00FF">Content</label></strong>
            <textarea name="Content"  cols="35" rows="10"  id="exampleFormControlTextarea2" >${content}</textarea>
            <button type="button" onclick="updateNote()" href="/note/viewNotes" >Update</button>
        </div>

<mytag:scripts/>


</body>
</html>
