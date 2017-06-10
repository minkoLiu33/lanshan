$(function(){
	// 用户登录
	$("#login").on("click", function(){
		 login();
	});
	
	// 用户注册
	$("#signup").on("click", function(){
		signup();
	});
	
	function login(){
		var account = $("#l_account").val();
		var password = $("#l_password").val();
		if(account == ""){
			layer.msg("请输入邮箱！");
			return;
		}
		
		if(password == ""){
			layer.msg("请输入密码！");
			return;
		}
		$.ajax({
			type: "post",
			url: 'account/user/signin.htm',
			data: 'account=' + account + "&password=" + password,
			async:false,
			success: function(data){
				var json = $.parseJSON(data);
				if(json.errCode=='0000'){
					layer.msg("登录成功！");
				}else{
					layer.msg(json.errMsg);
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				layer.msg('网络出现异常！');
			}
		});
	}
	
	function signup(){
		var account = $("#r_account").val();
		var password = $("#r_password").val();
		var confirmpassword = $("#r_confirm_password").val();
		if(account == ""){
			layer.msg("请输入邮箱！");
			return;
		}
		
		if(!isEmail(account)){
			layer.msg("请输入正确邮箱！");
			return;
		}
		
		if(password == ""){
			layer.msg("请输入密码！");
			return;
		}
		
		if(confirmpassword == ""){
			layer.msg("请输入重复密码！");
			return;
		}
		// 验证信息
		if(password != confirmpassword){
			layer.msg("两次密码不一致！");
			return;
		}
		layer.load(1);
		$.ajax({
			type: "post",
			url: 'account/user/signup.htm',
			data: 'account=' + account + "&password=" + password + "&confirmpassword=" + confirmpassword,
			async:false,
			success: function(data){
				var json = $.parseJSON(data);
				if(json.errCode=='0000'){
					layer.closeAll();
					$("tab_0_li").trigger("click");
					layer.msg('注册成功，请重新登录！', {icon: 1});
				}else{
					layer.msg(json.errMsg);
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				layer.msg('网络出现异常！');
			}
		});
	}
	
	
	function isEmail(str){
	       var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	       return reg.test(str);
	}
	
});
