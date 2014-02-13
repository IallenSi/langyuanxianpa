/**
 * 
 */
package com.siminglun.ssh.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.siminglun.ssh.pojo.Users;
import com.siminglun.ssh.service.IDemoService;

/**
 * @author 司明仑 --2014-1-26
 *
 */
public class JsonAction extends ActionSupport {
	private String message; //使用json返回单个值  
	private Users userInfo; //使用json返回对象  
	private List<Users> userInfosList; //使用josn返回List对象  
	private Map<String, Users> userInfosMap; //使用json返回Map对象  
	private IDemoService demoService;

	/**
	 * @return the demoService
	 */
	/*public IDemoService getDemoService() {
		return demoService;
	}*/

	/**
	 * @param demoService the demoService to set
	 */
	public void setDemoService(IDemoService demoService) {
		this.demoService = demoService;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the userInfo
	 */
	public Users getUserInfo() {
		return userInfo;
	}

	/**
	 * @param userInfo the userInfo to set
	 */
	public void setUserInfo(Users userInfo) {
		this.userInfo = userInfo;
	}

	/**
	 * @return the userInfosList
	 */
	public List<Users> getUserInfosList() {
		return userInfosList;
	}

	/**
	 * @param userInfosList the userInfosList to set
	 */
	public void setUserInfosList(List<Users> userInfosList) {
		this.userInfosList = userInfosList;
	}

	/**
	 * @return the userInfosMap
	 */
	public Map<String, Users> getUserInfosMap() {
		return userInfosMap;
	}

	/**
	 * @param userInfosMap the userInfosMap to set
	 */
	public void setUserInfosMap(Map<String, Users> userInfosMap) {
		this.userInfosMap = userInfosMap;
	}

	/**  
	* <p>  
	*  返回单个值  
	* <p>  
	* @return  
	*/
	public String returnMessage() {
		this.message = "成功返回单个值";
		return "message";
	}

	/**  
	* <p>  
	*  返回Users对象  
	* </p>  
	* @return  
	*/
	public String returnUserInfo() {
		userInfo = new Users("99", "JSON测试", "123456");
		return "userInfo";
	}

	/**  
	* <p>  
	*  返回List对象  
	* </p>  
	* @return  
	*/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String returnList() {
		userInfosList = demoService.query(new HashMap());
		return "list";
	}

	/**  
	 * <p>  
	 *  返回Map对象  
	 * </p>  
	 * @return  
	 */
	public String returnMap() {
		userInfosMap = new HashMap<String, Users>();
		List<Users> list = demoService.query(new HashMap());
		for (Users u : list) {
			userInfosMap.put(u.getId(), u);
		}
		return "map";
	}

	/**  
	 * <p>  
	 *  获得对象，也就是通过表达获得对象(异步的)  
	 * </P>  
	 * @return  
	 */
	public String gainUserInfo() {
		return "userInfo";
	}
}
