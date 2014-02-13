/**
 * 
 */
package com.siminglun.ssh.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.siminglun.ssh.service.IDemoService;

/**
 * @author 司明仑 --2014-1-6
 *
 */
public class DemoAction extends ActionSupport {
	private String name;
	private String password;
	private String id;
	private IDemoService demoService;

	/**
	 * @return the demoService
	 */
	public IDemoService getDemoService() {
		return demoService;
	}

	/**
	 * @param demoService the demoService to set
	 */
	public void setDemoService(IDemoService demoService) {
		this.demoService = demoService;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name == null ? "" : name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password == null ? "" : password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		Map<String, Object> parameters = ActionContext.getContext()
				.getParameters();
		Set<Entry<String, Object>> entrySet = parameters.entrySet();
		for (Entry<String, Object> e : entrySet) {
			System.err.println("请求过来的参数是：" + e.getKey() + "="
					+ ((String[]) e.getValue())[0].toString());
		}

		Map map = new HashMap();
		map.put("name", getName());
		map.put("password", getPassword());
		map = demoService.login(map);
		if (map.get("result") == null) {
			return ERROR;
		} else {
			ActionContext.getContext().getSession().put("user", getName());

			Map<String, Object> parameters2 = ActionContext.getContext()
					.getParameters();
			Set<Entry<String, Object>> entrySet2 = parameters2.entrySet();
			for (Entry<String, Object> e2 : entrySet2) {
				System.err.println("响应的参数是：" + e2.getKey() + "="
						+ ((String[]) e2.getValue())[0].toString());
			}

			return SUCCESS;
		}
	}

	public String query() throws Exception {
		System.out.println(">>进入查询用户列表方法");
		Map<String, Object> parameters = ActionContext.getContext()
				.getParameters();
		Set<Entry<String, Object>> entrySet = parameters.entrySet();
		for (Entry<String, Object> e : entrySet) {
			System.err.println("请求过来的参数是：" + e.getKey() + "="
					+ ((String[]) e.getValue())[0].toString());
		}
		Map map = new HashMap();
		map.put("name", getName());
		List list = demoService.query(map);
		System.out.println("用户列表为：" + list);
		ActionContext.getContext().put("users", list);
		Map<String, Object> parameters2 = ActionContext.getContext()
				.getParameters();
		Set<Entry<String, Object>> entrySet2 = parameters2.entrySet();
		for (Entry<String, Object> e2 : entrySet2) {
			System.err.println("响应的参数是：" + e2.getKey() + "="
					+ ((String[]) e2.getValue())[0].toString());
		}
		return "users";
	}

	public String save() throws Exception {
		System.out.println(">>进入用户新增方法");
		Map<String, Object> parameters = ActionContext.getContext()
				.getParameters();
		Set<Entry<String, Object>> entrySet = parameters.entrySet();
		for (Entry<String, Object> e : entrySet) {
			System.err.println("请求过来的参数是：" + e.getKey() + "="
					+ ((String[]) e.getValue())[0].toString());
		}
		Map map = ActionContext.getContext().getParameters();
		System.out.println("用户提交参数为：" + map);
		demoService.save(map);
		Map<String, Object> parameters2 = ActionContext.getContext()
				.getParameters();
		Set<Entry<String, Object>> entrySet2 = parameters2.entrySet();
		for (Entry<String, Object> e2 : entrySet2) {
			System.err.println("响应的参数是：" + e2.getKey() + "="
					+ ((String[]) e2.getValue())[0].toString());
		}
		return SUCCESS;
	}

	public String del() throws Exception {
		System.out.println(">>进入用户删除方法");
		Map<String, Object> parameters = ActionContext.getContext()
				.getParameters();
		Set<Entry<String, Object>> entrySet = parameters.entrySet();
		for (Entry<String, Object> e : entrySet) {
			System.err.println("请求过来的参数是：" + e.getKey() + "="
					+ ((String[]) e.getValue())[0].toString());
		}
		Map map = ActionContext.getContext().getParameters();
		demoService.del(map);
		Map<String, Object> parameters2 = ActionContext.getContext()
				.getParameters();
		Set<Entry<String, Object>> entrySet2 = parameters2.entrySet();
		for (Entry<String, Object> e2 : entrySet2) {
			System.err.println("响应的参数是：" + e2.getKey() + "="
					+ ((String[]) e2.getValue())[0].toString());
		}
		return "del";
	}

	public String update() throws Exception {
		System.out.println(">>进入用户修改方法");

		Map<String, Object> parameters = ActionContext.getContext()
				.getParameters();
		Set<Entry<String, Object>> entrySet = parameters.entrySet();
		for (Entry<String, Object> e : entrySet) {
			System.err.println("请求过来的参数是：" + e.getKey() + "="
					+ ((String[]) e.getValue())[0].toString());
		}

		Map map = ActionContext.getContext().getParameters();
		demoService.update(map);
		Map<String, Object> parameters2 = ActionContext.getContext()
				.getParameters();
		Set<Entry<String, Object>> entrySet2 = parameters2.entrySet();
		for (Entry<String, Object> e2 : entrySet2) {
			System.err.println("响应的参数是：" + e2.getKey() + "="
					+ ((String[]) e2.getValue())[0].toString());
		}
		return "update";
	}

	public String queryById() throws Exception {
		System.out.println(">>进入按主键查询");
		Map<String, Object> parameters = ActionContext.getContext()
				.getParameters();
		Set<Entry<String, Object>> entrySet = parameters.entrySet();
		for (Entry<String, Object> e : entrySet) {
			System.err.println("请求过来的参数是：" + e.getKey() + "="
					+ ((String[]) e.getValue())[0].toString());
		}
		Map map = ActionContext.getContext().getParameters();
		String[] ids = (String[]) map.get("id");
		System.out.println(ids[0]);
		demoService.queryById(ids[0]);
		Map<String, Object> parameters2 = ActionContext.getContext()
				.getParameters();
		Set<Entry<String, Object>> entrySet2 = parameters2.entrySet();
		for (Entry<String, Object> e2 : entrySet2) {
			System.err.println("响应的参数是：" + e2.getKey() + "="
					+ ((String[]) e2.getValue())[0].toString());
		}
		return SUCCESS;

	}

}
