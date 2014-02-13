/**
 * 
 */
package com.siminglun.ssh.pojo;

import java.io.Serializable;

/**
 * @author 司明仑 --2014-1-6
 *
 */
public class Users implements Serializable {
	private String id;
	private String name;
	private String password;
	private String sex;
	private String zw;

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
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the zw
	 */
	public String getZw() {
		return zw;
	}

	/**
	 * @param zw the zw to set
	 */
	public void setZw(String zw) {
		this.zw = zw;
	}

	/**
	 * @param id
	 * @param name
	 * @param password
	 */
	public Users(String id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public Users() {
		//
	}
}
