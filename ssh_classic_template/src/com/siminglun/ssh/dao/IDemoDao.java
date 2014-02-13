/**
 * 
 */
package com.siminglun.ssh.dao;

import java.util.List;
import java.util.Map;

import com.siminglun.ssh.pojo.Users;

/**
 * @author 司明仑 --2014-1-6
 *
 */
public interface IDemoDao {
	public Map login(Map map);

	//查询所有用户信息
	List query(Map map);

	//新增用户
	void save(Map map);

	//删除用户
	void del(Map map);

	//删除用户
	void update(Map map);

	void queryById(String id);

	//按用职务分组
	List queryByZw();

	/**
	 * @param u
	 */
	void save(Users u);
}
