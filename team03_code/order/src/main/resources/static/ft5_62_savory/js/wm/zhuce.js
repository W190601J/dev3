
$('#huoque').on('click',yzm);
$('#zhuce').on('click',zhuce);

function yzm(){
   var uname=$('#uname').val();
   var upwd=$('#upwd').val();
   var upwd2=$('#upwd2').val();
   var phone=$('#phone').val();
   if (upwd!=upwd2){
      console.log("两次输入密码请相同")
   }else{
      $.ajax({
          method:'post',
          url:'/users/user/${phone}',
          success:function (data) {
             if (data!=null){
                console.log("验证码为"+data);
             }else {
                console.log("验证码发送失败");
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
   var phone=$('#phone').val();
   var yzm=$('#yzm').val();
   var yzm2=$('#yzm2').val();

   if (upwd!=upwd2){
      console.log("两次输入密码请相同")
   }else {
      if (yzm!=yzm2){
         console.log("验证码错误")
      }else{
         let users = {
            uname: uname,
            upwd: upwd,
            phone: phone,
         }
         //obj.user=user;
         //将JSON对象转换成JSON字符串
         let user = JSON.stringify(users);
         $.ajax({
            method: 'post',
            url:'/users/${user}',
            success:function (data) {
               console.log(data);
            },
            dataType: 'text',
         })
      }
   }
}