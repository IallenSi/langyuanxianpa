/**
 * 
 */
package com.siminglun.ssh.action;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.siminglun.ssh.service.IDemoService;

/**
 * @author 司明仑 --2014-1-22
 *
 */
public class ExcelAction extends ActionSupport {
	private String name;
	private String password;
	private IDemoService demoService;
	private File excelFile;//上传的文件
	private String excelFileFileName;//原始的文件名

	/**
	 * @return the excelFile
	 */
	public File getExcelFile() {
		return excelFile;
	}

	/**
	 * @param excelFile the excelFile to set
	 */
	public void setExcelFile(File excelFile) {
		this.excelFile = excelFile;
	}

	/**
	 * @return the excelFileFileName
	 */
	public String getExcelFileFileName() {
		return excelFileFileName;
	}

	/**
	 * @param excelFileFileName the excelFileFileName to set
	 */
	public void setExcelFileFileName(String excelFileFileName) {
		this.excelFileFileName = excelFileFileName;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
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
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

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
	 * 导出
	 * @return
	 * @throws Exception
	 */
	public String export() throws Exception {
		System.out.println(">>进入导出方法");
		Map<String, Object> parameters = ActionContext.getContext()
				.getParameters();
		Set<Entry<String, Object>> entrySet = parameters.entrySet();
		for (Entry<String, Object> e : entrySet) {
			System.err.println("请求过来的参数是：" + e.getKey() + "="
					+ ((String[]) e.getValue())[0].toString());
		}

		System.err.println("----运行导出方法");
		Map map = new HashMap();
		map.put("name", getName());
		demoService.export(map, ServletActionContext.getResponse());
		return SUCCESS;
	}

	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
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

	/**
	 * 导入
	 * @return
	 * @throws Exception
	 */
	public String importExcel() throws Exception {
		System.out.println(">>进入导入方法");
		demoService.importExcel(excelFile);
		return SUCCESS;
	}
}
