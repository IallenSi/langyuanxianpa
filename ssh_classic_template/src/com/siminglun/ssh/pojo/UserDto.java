/**
 * 
 */
package com.siminglun.ssh.pojo;

/**
 * @author 司明仑 --2014-1-13
 *
 */
public class UserDto {
	private String sex;
	private String zw;
	private String count;

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
	 * @return the count
	 */
	public String getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(String count) {
		this.count = count;
	}

	/**
	 * @param sex
	 * @param zw
	 * @param count
	 */
	public UserDto(String sex, String zw, String count) {
		super();
		this.sex = sex;
		this.zw = zw;
		this.count = count;
	}

	public UserDto() {
		//
	}

}
