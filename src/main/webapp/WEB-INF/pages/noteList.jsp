
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<%@ page import="java.text.DateFormat,java.util.Date" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ToDos</title>

    <link rel="stylesheet" href="/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <jsp:include page="header.jsp" />
</head>
<body>

<%!
    Date date = new Date();
    DateFormat shortFormat = DateFormat.getDateInstance(DateFormat.SHORT);
%>



<input type="hidden" value="${id}" id="id"/>

    <%--<a href="add"><div class="baslik"><h2>Add ToDos</h2></div></a>--%>
    <div class="container">
        <div class="baslikTable">
            <div class="d-flex">
                <h3>List of Todos</h3>
                <button class="btn-todos" ><a href="add" role="button">Add ToDos</a></button>
            </div>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Title</th>
                <th scope="col">Target Date</th>
                <th scope="col"></th>

            </tr>
            </thead>
            <tbody>
             <c:forEach items="${notes}" var="note">
            <tr >
                    <td>${note.title}</td>
                    <td><%=shortFormat.format(date)%><br></td>
                    <td><a class="btn btn-success" href="getUpdate/${note.id}" role="button">Update</a>
                        <a class="btn btn-del btn-warning" data-id="${note.id}" role="button">Delete</a>
                    </td>
            </tr>
           </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script>
    $(document).ready(function() {
        $(document).on("click",".btn-del",function() {
            var _button = $(this);
            $.ajax({
                type:"DELETE",
                contentType:'application/json; charset=UTF-8',
                url:'/note/deleteNote/' + _button.data("id"),
                success:function (data){
                    console.log("başarılı")
                    _button.parent().parent().remove();
                },error:function (data){
                    //alert(data);
                    console.log("başarısız")
                }
            });
        });
    });


    function deleteNote(id) {

    }
</script>

<mytag:scripts/>

</body>
</html>
