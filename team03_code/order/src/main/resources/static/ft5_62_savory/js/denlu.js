$(function(){
    chkuser();
})

/**
 * 检查用户是否登录，没有登录，则跳至登录页面
 */
function chkuser(){
    $.ajax({
        method:'post',
        url:'user',
        success:function(data){
            if(data.id=='-9999'){
                //跳至login.html
                location.href='login.html';
            }
        },
        dataType:'json'
    })
}