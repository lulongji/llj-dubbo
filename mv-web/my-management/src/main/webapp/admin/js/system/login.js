$(function() {
	// login 密码验证
	$('#login').click(function() {
		var name_state = $('#name');
		var psd_state = $('#psd');
		var name = $('#name').val();
		var psd = $('#psd').val();
		if (name == '') {
			name_state.parent().next().next().css("display", "block");
			return false;
		} else if (psd == '') {
			name_state.parent().next().next().css("display", "none");
			psd_state.parent().next().next().css("display", "block");
			return false;
		} else {
			name_state.parent().next().next().css("display", "none");
			psd_state.parent().next().next().css("display", "none");
			var data = {
				"user_id" : name,
				"pwd" : psd
			};
			login(data);
		}
	});

})

// login
function idFormatter(value) {
	return value + 100;
}

function ok_or_errorBylogin(l) {
	var content = $(l).val();
	if (content != "") {
		$(l).parent().next().next().css("display", "none");
	}
}

function barter_btn(bb) {
	$(bb).parent().parent().fadeOut(1000);
	$(bb).parent().parent().siblings().fadeIn(2000);
}

// 登录验证
function login(data) {
	$.ajax({
		type : "get",
		async : false, // 同步请求
		url : "login/loginVal.do",
		data : data,
		timeout : 1000,
		success : function(datas) {
			if (datas.result == "success") {
				saveCookie();
				top.location = "/admin/system/index.jsp";
			} else if (datas.result == "failure") {
				alert("登录名或者密码错误，请重新输入！");
			} else {
				alert("系统错误！");
			}

		},
		error : function() {
			alert("请求失败，网络错误，请稍后再试！");
		}
	});

}

function saveCookie() {
}
