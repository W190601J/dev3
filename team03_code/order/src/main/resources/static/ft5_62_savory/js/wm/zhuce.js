
$('#huoque').on('click',yzm);
$('#zhuce').on('click',zhuce);

function yzm(){
   var uname=$('#uname').val();
   var upwd=$('#upwd').val();
   var upwd2=$('#upwd2').val();
   var phone=$('#phone').val();
   var url=`/users/user/${phone}`
   if (upwd!=upwd2){
      alert("两次输入密码请相同")
   }else{
      $.ajax({
          method:'post',
          url:url,
          success:function (data) {
             if (data!=null){
                //layer.msg("验证码为"+data);
                $("#yz").val(data);
             }else {
                alert("验证码发送失败");
             }
          },
          dataType:'text',
      })
   }
}

function zhuce() {
   var uname=$('#uname').val();
   var upwd=$('#upwd').val();
   var upwd2=$('#upwd2').val();
   var uphone=$('#phone').val();
   var yzm=$('#yzm').val();
   var yz=$('#yz').val();
   alert(uname)
       alert(upwd)
   alert(uphone)
   if (upwd!=upwd2){
      alert("两次输入密码请相同")
   }else {
      if (yzm!=yz){
         alert("验证码错误")
      }else{
         let users = {
            uname: uname,
            upwd: upwd,
            uphone: uphone,
         }
         //obj.user=user;
         //将JSON对象转换成JSON字符串
         let user = JSON.stringify(users);
         $.ajax({
            method: 'post',
            url:'/users/user',
            data:user,
            success:function (data) {
               if (data=='注册成功'){
                  window.location.href='denlu.html';
               }else {
                  alert(data);
               }

            },
            contentType:'application/json;charset=utf-8',
            dataType: 'text',
         })
      }
   }
}