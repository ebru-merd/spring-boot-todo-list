function addNotes(){
    var param={
        title:$('#exampleInputText1').val(),
        content:$('#exampleFormControlTextarea1').val()
    }


    $.ajax({
        type:"POST",
        contentType:'application/json; charset=UTF-8',
        url:'addNotes',
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



