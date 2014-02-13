/**
 * 
 */
package com.siminglun.ssh.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.siminglun.ssh.dao.IDemoDao;
import com.siminglun.ssh.pojo.ExcelWorkSheet;
import com.siminglun.ssh.pojo.Users;
import com.siminglun.ssh.service.IDemoService;

/**
 * @author 司明仑 --2014-1-6
 *
 */
public class DemoServiceImpl implements IDemoService {
	private IDemoDao demoDao;

	/**
	 * @return the demoDao
	 */
	public IDemoDao getDemoDao() {
		return demoDao;
	}

	/**
	 * @param demoDao the demoDao to set
	 */
	public void setDemoDao(IDemoDao demoDao) {
		this.demoDao = demoDao;
	}

	@Override
	public Map login(Map map) {
		return demoDao.login(map);
	}

	@Override
	public List query(Map map) {
		return demoDao.query(map);
	}

	@Override
	public void save(Map map) {
		demoDao.save(map);
	}

	@Override
	public void del(Map map) {
		demoDao.del(map);
	}

	@Override
	public void update(Map map) {
		demoDao.update(map);
	}

	@Override
	public void queryById(String id) {
		demoDao.queryById(id);
	}

	@Override
	public List queryByZw() {
		return demoDao.queryByZw();
	}

	@Override
	public void export(Map map, HttpServletResponse response) {
		List retList = query(map);
		setResponseHeader(response);
		try {
			exprotExcel(response.getOutputStream(), retList);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置响应头
	 * @param response
	 */
	private void setResponseHeader(HttpServletResponse response) {
		response.setContentType("application/octet-stream;charset=utf-8");
		try {
			response.setHeader("Content-Disposition", "attachment;filename="
					+ URLEncoder.encode("用户信息表.xls", "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.addHeader("Pargam", "no-cache");
		response.addHeader("Cache-Control", "no-cache");
	}

	/**
	 * 设置导出内容
	 * @param os
	 * @param list
	 * @throws IOException
	 */
	private void exprotExcel(OutputStream os, List list) throws IOException {
		HSSFWorkbook book = new HSSFWorkbook();
		HSSFSheet sheet = book.createSheet("用户");

		HSSFRow row = sheet.createRow(0);
		row.createCell((short) 0).setCellValue(new HSSFRichTextString("用户名"));
		row.createCell((short) 1).setCellValue(new HSSFRichTextString("密码"));
		row.createCell((short) 2).setCellValue(new HSSFRichTextString("性别"));

		HSSFCellStyle cellStyle = book.createCellStyle();

		Users user = null;
		for (int i = 1; i <= list.size(); i++) {
			user = (Users) list.get(i - 1);
			row = sheet.createRow(i);
			row.createCell((short) 0).setCellValue(
					new HSSFRichTextString(user.getName()));
			row.createCell((short) 1).setCellValue(
					new HSSFRichTextString(user.getPassword()));
			row.createCell((short) 2).setCellValue(
					new HSSFRichTextString(user.getSex()));
		}
		book.write(os);
	}

	@Override
	public void importExcel(File file) {
		ExcelWorkSheet<Users> excelWorkSheet = new ExcelWorkSheet<Users>();
		HSSFWorkbook book = null;
		try {
			book = new HSSFWorkbook(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (book == null) {
			return;
		}
		HSSFSheet sheet = book.getSheetAt(0);//就取第一个sheet

		//保存工作表标题名称
		HSSFRow firstRow = sheet.getRow(0);
		Iterator<HSSFCell> iterator = firstRow.cellIterator();
		List<String> columns = new ArrayList<String>();
		while (iterator.hasNext()) {
			columns.add(iterator.next().getStringCellValue());
		}
		excelWorkSheet.setColumns(columns);

		HSSFRow dataRow = null;
		Users user = null;
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			dataRow = sheet.getRow(i);
			user = new Users();
			user.setName(dataRow.getCell((short) 0).getRichStringCellValue()
					.getString());
			user.setPassword(dataRow.getCell((short) 1)
					.getRichStringCellValue().getString());
			user.setSex(dataRow.getCell((short) 2).getRichStringCellValue()
					.getString());
			excelWorkSheet.getData().add(user);
		}
		for (Users u : excelWorkSheet.getData()) {
			demoDao.save(u);
		}
		try {
			saveTempFile(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void save(Users u) {
		demoDao.save(u);
	}

	private void saveTempFile(File file) throws Exception {
		File desFile = new File("d:/用户" + new Date().getTime() + ".xls");
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(desFile);
		FileChannel cin = fis.getChannel();
		FileChannel cout = fos.getChannel();
		cin.transferTo(0, cin.size(), cout);
		fos.flush();
		cin.close();
		cout.close();
		fis.close();
		fos.close();
		desFile = null;
	}
}
