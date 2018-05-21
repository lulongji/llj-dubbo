/**
 * 鲁龙基个人版权所有
 * Copyright (C)   2016 - 2020 Corporation. All Rights Reserved
 */
package com.lu.web.controller.system.login;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lu.api.user.UserService;
import com.lu.web.controller.base.BaseController;

/**
 * 登陆
 * 
 * @author LongJi.LU (lulongji2011@163.com)
 * @version 2016年4月21日 下午1:32:38
 */
@Controller
public class LoginController extends BaseController {

	@Resource(name = "userService")
	private UserService userService;

	/**
	 * 进入首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login_index")
	public String defaultPage() {
		return "index";
	}

	/**
	 * 登陆
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login_test")
	public ModelAndView login() throws Exception {
		return null;
	}
}
