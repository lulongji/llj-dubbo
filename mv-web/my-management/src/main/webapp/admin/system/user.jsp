<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="row>
	<div class="span12">
		<form action="" method="post" name="userForm" id="userForm">
			<input class="input-medium search-query" type="text" />&nbsp;&nbsp;
			<button class="btn" type="submit"> 搜索</button>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>
							<strong>编号</strong>
						</th>
						<th>用户Id</th>
						<th>昵称</th>
						<th>角色</th>
						<th>邮箱</th>
						<th>IP地址</th>
						<th>座机</th>
						<th>手机</th>
						<th>最后登录</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
				<c:choose>
					<c:when test="${not empty userList}">
						<c:forEach items="${userList}" var="user" varStatus="vs">
						<tr>
							<td>${user.id}</td>
							<td>${user.user_id}</td>
							<td>${user.name}</td>
							<td>${user.roles_id}</td>
							<td>${user.mail}</td>
							<td>${user.ip}</td>
							<td>${user.tel}</td>
							<td>${user.phone}</td>
							<td>${user.status}</td>
							<td class="btn btn-primary btn-mini">修改</td>
							<td class="btn btn-danger btn-mini">删除</td>
						</tr>
						</c:forEach>
					</c:when>
				</c:choose>
				</tbody>
			</table>
		</from>
		<nav>
		  <ul class="pagination">
		    <li>
		      <a href="#" aria-label="Previous">
		        <span aria-hidden="true">&laquo;上一页</span>
		      </a>
		      </li>
			    <li><a href="#">1</a></li>
			    <li><a href="#">2</a></li>
			    <li><a href="#">3</a></li>
			    <li><a href="#">4</a></li>
			    <li><a href="#">5</a></li>
		      <li>
		      <a href="#" aria-label="Next">
		        <span aria-hidden="true">下一页&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>		
	</div>
</div>
