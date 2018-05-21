/**
 * 
 */
package com.lu.api.user;

import java.io.Serializable;
import java.util.List;

import com.lu.common.mybatis.service.IBaseService;
import com.lu.entity.user.User;

/**
 * 系统用户管理(框架测试)
 * 
 * @author lu
 */
public interface UserService extends IBaseService<User> {

	Boolean addUser(User user) throws Exception;

	Boolean addUserAll(User user) throws Exception;

	Boolean deleteUser(int id) throws Exception;

	Boolean deleteAllyUser() throws Exception;

	Boolean modifyUser(int id) throws Exception;

	User getUser(Serializable id) throws Exception;

	User getUsers(int id) throws Exception;

	List<User> getUserByOne() throws Exception;

	List<User> getUserListAll() throws Exception;

	List<User> getUserBySql() throws Exception;

}
