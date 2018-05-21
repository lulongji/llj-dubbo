/**
 * 鲁龙基个人版权所有
 * Copyright (C)   2016 - 2020 Corporation. All Rights Reserved
 */
package com.lu.management.controller.system.user;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lu.api.user.UserService;
import com.lu.entity.user.User;
import com.lu.management.controller.base.BaseController;

/**
 * 
 * 用户管理
 * 
 * @author LongJi.LU (lulongji2011@163.com)
 * @version 2016年7月4日 上午10:02:46
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/test", produces = "application/json; charset=utf-8")
	@ResponseBody
	public void userTest() {
		logBefore(logger, "框架测试");
		try {
			User user = new User();
			Boolean b = userService.addUser(user);
			Boolean b1 = userService.addUserAll(user);
			Boolean b2 = userService.deleteUser(1);
			Boolean b3 = userService.deleteAllyUser();
			Boolean b4 = userService.modifyUser(1);
			User user2 = userService.getUser(1);
			User user1 = userService.getUsers(1);
			List<User> list = userService.getUserByOne();
			List<User> list1 = userService.getUserListAll();
			List<User> list2 = userService.getUserBySql();

			System.out.println("==========");
		} catch (Exception e) {
			System.out.println();
			logger.error(e.toString(), e);
		}
	}

	@RequestMapping(value = "/info", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ModelAndView getUserInfo() {
		logBefore(logger, "user-用户信息页面！");
		ModelAndView mv = this.getModelAndView();
		try {
			List<User> userList = userService.getUserListAll();
			mv.addObject("userList", userList);
			mv.setViewName("system/user");
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		return mv;
	}

}
