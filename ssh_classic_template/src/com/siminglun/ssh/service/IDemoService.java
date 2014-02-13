/**
 * 
 */
package com.siminglun.ssh.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.siminglun.ssh.pojo.Users;

/**
 * @author 司明仑 --2014-1-6
 *
 */
public interface IDemoService {
	public Map login(Map map);

	//查询所有用户列表
	List query(Map map);

	//导出
	void export(Map map, HttpServletResponse response);

	//导入
	void importExcel(File file);

	//新增用户
	void save(Map map);

	//新增用户
	void save(Users u);

	//删除用户
	void del(Map map);

	//删除用户
	void update(Map map);

	void queryById(String id);

	//按用职务分组
	List queryByZw();
}
