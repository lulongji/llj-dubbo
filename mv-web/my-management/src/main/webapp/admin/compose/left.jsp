<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
<!-- 导航 -->
<div class="collapse navbar-collapse navbar-ex1-collapse">
	<ul class="nav navbar-nav side-nav">
		<li class="" id="luindex">
			<a href="admin/system/index.jsp" data-toggle="collapse" data-target="#demo1">
				<i class="fa fa-fw fa-dashboard"></i> 后台首页
			</a>
		</li>
		<li id="xtgl">
			<a href="javascript:;" data-toggle="collapse" data-target="#demo2">
				<i class="glyphicon glyphicon-cog"></i> 系统管理<i class="fa fa-fw fa-caret-down"></i>
			</a>
			<ul id="demo2" class="collapse">
				<li><a href="javascript:void(0);" onclick="myMenu('qxgl','demo1','权限管理','user/role.do');">权限管理</a></li>
				<li><a href="javascript:void(0);" onclick="myMenu('yhgl','demo2','用户管理','user/info.do');">用户管理</a></li>
				<li><a href="javascript:void(0);" onclick="myMenu('hygl','demo3','会员管理','user/vip.do');">会员管理</a></li>
			</ul>
		</li>
		<li>
			<a href="javascript:;" data-toggle="collapse" data-target="#demo3">
				<i class="glyphicon glyphicon-wrench"></i> 系统工具<i class="fa fa-fw fa-caret-down"></i>
			</a>
			<ul id="demo3" class="collapse">
				<li><a href="javascript:void(0);" onclick="">代码生成</a></li>
			</ul>
		</li>
		<li>
			<a href="javascript:;" data-toggle="collapse" data-target="#demo4">
				<i class="glyphicon glyphicon-list"></i> 信息管理<i class="fa fa-fw fa-caret-down"></i>
			</a>
			<ul id="demo4" class="collapse">
				<li><a href="javascript:void(0);" onclick="">首页管理</a></li>
				<li><a href="javascript:void(0);" onclick="">商品管理</a></li>
			</ul>
		</li>
		<li>
			<a href="javascript:;" data-toggle="collapse" data-target="#demo5">
				<i class="glyphicon glyphicon-align-justify"></i> 订单管理<i class="fa fa-fw fa-caret-down"></i>
			</a>
			<ul id="demo5" class="collapse">
				<li><a href="javascript:void(0);" onclick="myMenu('1','2','1','2');">订单信息</a></li>
			</ul>
		</li>
	</ul>
</div>
<!-- /.navbar-collapse -->
