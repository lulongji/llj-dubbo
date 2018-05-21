/**
 * 鲁龙基个人版权所有
 * Copyright (C)   2016 - 2020 Corporation. All Rights Reserved
 */
package com.lu.management.controller.system.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lu.management.StatusCode;
import com.lu.management.controller.base.BaseController;
import com.lu.management.pagedata.PageData;

/**
 * 登陆
 * 
 * @author LongJi.LU (lulongji2011@163.com)
 * @version 2016年4月21日 下午1:32:38
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController {

	/**
	 * 登陆页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/loginPage", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ModelAndView loginPage() {
		logBefore(logger, "login-跳转登陆页面！");
		ModelAndView mv = this.getModelAndView();
		try {
			mv.setViewName("system/login/login");
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		return mv;
	}

	/**
	 * 登陆校验
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/loginVal", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<Object, Object> login() throws Exception {
		logBefore(logger, "login-用户登录！");
		PageData pd = new PageData();
		pd = this.getPageData();
		HashMap<Object, Object> map = new HashMap<>();
		try {
			boolean flag = loginValidation(pd);
			if (flag) {
				map.put(StatusCode.RESULT, StatusCode.SUCCESS);
			} else {
				map.put(StatusCode.RESULT, StatusCode.FAILURE);
			}
		} catch (Exception e) {
			map.put(StatusCode.RESULT, StatusCode.ERROR);
			logger.error(e.toString(), e);
		}
		return map;
	}

	/**
	 * 登陆校验
	 * 
	 * @param user
	 * @throws Exception
	 */
	public boolean loginValidation(PageData pd) throws Exception {
		String userId = pd.getString("user_id");
		String password = pd.getString("pwd");
		if (userId != null && password != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 登陆页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/main", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ModelAndView mainIndex() {
		logBefore(logger, "登陆成功！");
		ModelAndView mv = this.getModelAndView();
		try {
			mv.setViewName("system/index");
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		return mv;
	}
}
