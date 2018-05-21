//个人资料
function persionalInfo(userId) {
	var data = {
		"user_id" : userId
	};
	var pane = $('#modalPane');
	$.ajax({
		type : "get",
		async : false, // 同步请求
		url : "user/suserbyid.do",
		data : data,
		timeout : 1000,
		success : function(dates) {
			pane.empty();
			pane.html(dates);
		},
		error : function() {
			alert("查询个人资料失败，网络错误，请稍后再试！");
		}
	});
	var modalPane = $('#persionPanl');
	modalPane.modal({
		backdrop : 'static'
	}).modal('show');
}

// 邮件
function email() {
	alert("暂无！待开发！");
}

// 系统设置
function systemCof() {
	alert("暂无！待开发！");
}

// 遮罩层
function aaa() {
	var data = {
		type : 1
	};
	var pane = $('#modalPane');
	$.ajax({
		type : "get",
		async : false, // 同步请求
		url : "user/muser.do",
		data : data,
		timeout : 1000,
		success : function(dates) {
			pane.empty();
			pane.html(dates);
		},
		error : function() {
			alert("请求失败，网络错误，请稍后再试！");
		}
	});
	var modalPane = $('#persionPanl');
	modalPane.modal({
		backdrop : 'static'
	}).modal('show');
}