//var error=document.getElementById("error")
function controlLogin(){
    $("#loginform").submit()
    /*var param={
        username:$('#username').val(),
        pass:$('#pass').val()
    }

    $.ajax({
        type:"POST",
        contentType:'application/json; charset=UTF-8',
        url:'/user/controlLogin',
        data:JSON.stringify(param),
        success:function (data){
            if (data=='OK'){
                $(location).attr('href','/note/viewNotes')
            }else if (data=='ERROR'){
                error.style.display="block"
            }
            console.log(data)
        },error:function (data){

        }
    });*/
}

