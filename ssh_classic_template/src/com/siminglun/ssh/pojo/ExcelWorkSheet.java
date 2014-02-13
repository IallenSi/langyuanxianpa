/**
 * 
 */
package com.siminglun.ssh.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 司明仑 --2014-1-22
 *
 */
public class ExcelWorkSheet<T> {
	private String sheetName;
	private List<T> data = new ArrayList<T>();//数据
	private List<String> columns;//列名

	/**
	 * @return the sheetName
	 */
	public String getSheetName() {
		return sheetName;
	}

	/**
	 * @param sheetName the sheetName to set
	 */
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	/**
	 * @return the data
	 */
	public List<T> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<T> data) {
		this.data = data;
	}

	/**
	 * @return the columns
	 */
	public List<String> getColumns() {
		return columns;
	}

	/**
	 * @param columns the columns to set
	 */
	public void setColumns(List<String> columns) {
		this.columns = columns;
	}

}
