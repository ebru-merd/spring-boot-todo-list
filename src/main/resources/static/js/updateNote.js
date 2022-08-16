
function updateNote(){
    var param={
        id:$('#id').val(),
        title:$('#exampleInputText2').val(),
        content:$('#exampleFormControlTextarea2').val()
    }

    $.ajax({
        type:"POST",
        contentType:'application/json; charset=UTF-8',
        url:'/note/updateNote',
        data:JSON.stringify(param),
        success:function (data){
            //console.log("başarılı")
            //alert(data);
            //$(location).attr('href','/note/viewNotes')
            window.location.href='/note/viewNotes'
        },error:function (data){
            //alert(data);
            //console.log("başarısız")
        }
    });
}

