<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- jQuery -->
<script src="/admin/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/admin/js/bootstrap.min.js"></script>


<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/admin/system/index.jsp">信息管理系统</a>
    </div>
    <!-- Top Menu Items  -->
    <ul class="nav navbar-right top-nav">
        <!-- 邮件开始 -->
<!--         <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b
                    class="caret"></b></a>
            <ul class="dropdown-menu message-dropdown">
                <li class="message-preview">
                    <a href="#">
                        <div class="media">
                            <span class="pull-left">
                                <img class="media-object" src="http://placehold.it/50x50" alt="">
                            </span>
                            <div class="media-body">
                                <h5 class="media-heading"><strong>Admin</strong>
                                </h5>
                                <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                <p>Lorem ipsum dolor sit amet, consectetur...</p>
                            </div>
                        </div>
                    </a>
                </li>
                <li class="message-preview">
                    <a href="#">
                        <div class="media">
                            <span class="pull-left">
                                <img class="media-object" src="http://placehold.it/50x50" alt="">
                            </span>
                            <div class="media-body">
                                <h5 class="media-heading"><strong>Admin</strong>
                                </h5>
                                <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                <p>Lorem ipsum dolor sit amet, consectetur...</p>
                            </div>
                        </div>
                    </a>
                </li>
                <li class="message-preview">
                    <a href="#">
                        <div class="media">
                            <span class="pull-left">
                                <img class="media-object" src="http://placehold.it/50x50" alt="">
                            </span>
                            <div class="media-body">
                                <h5 class="media-heading"><strong>Admin</strong>
                                </h5>
                                <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                <p>Lorem ipsum dolor sit amet, consectetur...</p>
                            </div>
                        </div>
                    </a>
                </li>
                <li class="message-footer">
                    <a href="#">Read All New Messages</a>
                </li>
            </ul>
        </li> -->
        <!-- 邮件结束 -->

        <!-- 提醒开始 -->
        <!-- <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
            <ul class="dropdown-menu alert-dropdown">
                <li>
                    <a href="#">Alert Name <span class="label label-default">Alert Badge</span></a>
                </li>
                <li>
                    <a href="#">Alert Name <span class="label label-primary">Alert Badge</span></a>
                </li>
                <li>
                    <a href="#">Alert Name <span class="label label-success">Alert Badge</span></a>
                </li>
                <li>
                    <a href="#">Alert Name <span class="label label-info">Alert Badge</span></a>
                </li>
                <li>
                    <a href="#">Alert Name <span class="label label-warning">Alert Badge</span></a>
                </li>
                <li>
                    <a href="#">Alert Name <span class="label label-danger">Alert Badge</span></a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="#">View All</a>
                </li>
            </ul>
        </li> -->
        <!-- 提醒结束 -->

        <!-- 账户开始 -->
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            	<i class="fa fa-user"></i> 系统管理<b  class="caret"></b>
            </a>
            <ul class="dropdown-menu" contenteditable="false">
                <li>
                    <a href="javascript:void(0);" onclick="persionalInfo();" ><i class="fa fa-fw fa-user"></i>个人资料</a>
                </li>
                <li>
                    <a href="javascript:void(0);" onclick="email();"><i class="fa fa-fw fa-envelope"></i>发送邮件</a>
                </li>
                <li>
                    <a href="javascript:void(0);" onclick="systemCof();"><i class="fa fa-fw fa-gear"></i>系统设置</a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="login/logout"><i class="fa fa-fw fa-power-off"></i> 退 出</a>
                </li>
            </ul>
        </li>
        <!-- 账户结束 -->
    </ul>
    <%@ include file="left.jsp" %>
</nav>