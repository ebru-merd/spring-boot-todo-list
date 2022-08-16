var errorReg=document.getElementById("errorReg")
function addRegister(){
    var param={
        name:$('#name').val(),
        surname:$('#surname').val(),
        username:$('#username').val(),
        email:$('#email').val(),
        pass:$('#pass').val(),
        pass2:$('#pass2').val()
    }

    $.ajax({
        type:"POST",
        contentType:'application/json; charset=UTF-8',
        url:'/user/addRegister',
        data:JSON.stringify(param),
        success:function (data){
            if (data=='OK'){
                //$(location).attr('href','/note/viewNotes')
                window.location.href='/note/viewNotes'
            }else{
                errorReg.style.display="block"
            }
        },error:function (data){

        }
    });
}


$('#username').blur(function(){
    var _self = $(this);
    var param={
        username:$('#username').val(),
    }
    $.ajax({
        type: 'POST',
        url:'/user/checkUsername',
        data: JSON.stringify(param),
        contentType:'application/json; charset=UTF-8',
        success:function(data){
            if (data == "OK") {
                if (!$('.form-message').text()) {
                    $('.form-message').text('Bu kullanıcı adı alınmış.Başka bir tane deneyin.')
                }
                _self.closest('.wrap-input100').find('.focus-input100').addClass('input-error-span');
            }else{
                if ($('.form-message').text()) {
                    $('.form-message').text('')
                }
                _self.closest('.wrap-input100').find('.focus-input100').removeClass('input-error-span');

            }

    },
    error:function(data){

    }
})
})