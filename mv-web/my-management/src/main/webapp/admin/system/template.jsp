<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<%@ include file="../compose/head.jsp"%>
</head>
<body>
	<div id="wrapper">
		<%@ include file="../compose/top.jsp"%>

		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- 内容 -->
			</div>
		</div>
		<!-- /#page-wrapper -->
		<%@ include file="../compose/footer.jsp"%>
	</div>
</body>
</html>
