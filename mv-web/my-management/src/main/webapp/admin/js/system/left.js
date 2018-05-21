// 菜单状态切换
function myMenu(id, fid, MENU_NAME, MENU_URL) {
	var data = {
		type : 1
	};
	$.ajax({
		type : "get",
		async : false, // 同步请求
		url : MENU_URL,
		data : data,
		timeout : 1000,
		success : function(dates) {
			$("#mainContent").empty();
			$("#mainContent").html(dates);// 要刷新的div
		},
		error : function() {
			alert("请求失败，网络错误，请稍后再试！");
		}
	});
}
