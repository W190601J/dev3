
$('#login').on('click',login);

function login() {
    var uname=$('#uname').val();
    var upwd=$('#upwd').val();
    var url='';
    if (uname!=null&&upwd!=null){
        url='/users/${uname}/${upwd}';
    }else {
        alert("账号密码不能为空");
    }
    $.ajax({
        method:'post',
        url:url,
        success:function (data) {
            if (data!=null){
                //将token写入本地
                setJwtToken(data);
                //进入主页
            }else {
                alert("登录失败");
            }
        },
        dataType:'text',
    })
}