
$('#login').on('click',login);

function login() {
    var uname=$('#uname').val();
    var upwd=$('#upwd').val();
    var url='';
    if (uname==null||upwd==null){
        alert("账号密码不能为空");
    }else {

        url=`/users/user/${uname}/${upwd}`;
        $.ajax({
            method:'post',
            url:url,
            success:function (data) {
                if (data!=null){
                    window.location.href='index2.html';
                    //将token写入本地
                    setJwtToken(data);
                    //进入主页
                }else {
                    layer.msg("登录失败");
                }
            },
            dataType:'text',
        })
    }


}