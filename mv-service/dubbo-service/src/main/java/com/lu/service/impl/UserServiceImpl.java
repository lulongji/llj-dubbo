/**
 * 
 */
package com.lu.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lu.api.user.UserService;
import com.lu.common.mybatis.service.BaseServiceImpl;
import com.lu.entity.user.User;
import com.lu.service.dao.UserMapper;

/**
 * 系统用户
 * 
 * @author lu
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, UserMapper> implements UserService {

	@Override
	public Boolean addUser(User user) throws Exception {
		return this.insert(user) > 0;
	}

	@Override
	public Boolean addUserAll(User user) throws Exception {
		Map<String, Object> params = new HashMap<>();
		String sql = "";
		return super.insertBySql(sql, params) > 0;
	}

	@Override
	public Boolean deleteUser(int id) throws Exception {
		return null;
	}

	@Override
	public Boolean deleteAllyUser() throws Exception {
		return null;
	}

	@Override
	public Boolean modifyUser(int id) throws Exception {
		return null;
	}

	@Override
	public User getUser(Serializable id) throws Exception {
		return null;
	}

	@Override
	public User getUsers(int id) throws Exception {
		return null;
	}

	@Override
	public List<User> getUserByOne() throws Exception {
		return null;
	}

	@Override
	public List<User> getUserListAll() throws Exception {
		return null;
	}

	@Override
	public List<User> getUserBySql() throws Exception {
		return null;
	}

}