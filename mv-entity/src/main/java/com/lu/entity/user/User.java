package com.lu.entity.user;

import java.io.Serializable;

import com.lu.common.mybatis.annotation.Column;
import com.lu.common.mybatis.annotation.Id;
import com.lu.common.mybatis.annotation.Table;

import lombok.Data;

/**
 * 系统用户
 * 
 * @author lu
 */
@Data
@Table("sys_user")
public class User implements Serializable {

	private static final long serialVersionUID = -4748003404265418597L;
	@Id("id")
	private int id;
	@Column("user_id")
	private String userId;
	@Column("name")
	private String name;
	@Column("pwd")
	private String pwd;
	@Column("tel")
	private String tel;
	@Column("mail")
	private String mail;
	@Column("phone")
	private String phone;
	@Column("roles_id")
	private int rolesId;
	@Column("ip")
	private String ip;
	@Column("status")
	private int status;

}
