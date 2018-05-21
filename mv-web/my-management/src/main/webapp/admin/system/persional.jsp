<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div id="persionPanl" class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="gridSystemModalLabel">个人资料</h4>
      </div>
      <div class="modal-body">
			<form class="form-horizontal" action="system/muser.do" name="persionForm" id="persionForm" method="post">
				<div class="control-group">
					<label class="control-label" for="exampleInputName2">用户昵称：</label>
					<div class="controls">
						<input id="inputUser" type="text" value="${pd.name}" maxlength="32" placeholder="用户名称" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="exampleInputName2">登录Id：</label>
					<div class="controls">
						<input id="inputUser" type="text"  value="${1}" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputPassword" maxlength="32" placeholder="输入密码">密码：</label>
					<div class="controls">
						<input id="inputPassword1" type="text"  value="${1}" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputPassword">确认密码：</label>
					<div class="controls">
						<input id="inputPassword2" type="text"  value="${1}" maxlength="32" placeholder="确认密码"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="exampleInputName2">电子邮箱：</label>
					<div class="controls">
						<input id="inputEmail" type="text"  value="${1}"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="exampleInputName2">电话号码：</label>
					<div class="controls">
						<input id="inputPhone" type="text"  value="${1}" />
					</div>
				</div>
				<br/>
				<div class="control-group">
					<div class="controls">
						 <button type="submit" class="btn">保存</button>
						 <button type="submit" class="btn">取消</button>
					</div>
				</div>
			</form>
      </div>
      <div class="modal-footer">
     	 <button type="button" class="btn btn-primary">保存</button>
         <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->