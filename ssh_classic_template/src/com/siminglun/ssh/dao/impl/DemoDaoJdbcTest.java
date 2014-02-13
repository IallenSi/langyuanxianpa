/**
 * 
 */
package com.siminglun.ssh.dao.impl;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 司明仑 --2014-1-7
 *
 */
public class DemoDaoJdbcTest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		DemoDaoJdbc daoJdbc = context.getBean("demoDao", DemoDaoJdbc.class);
		List<Map> list = daoJdbc.queryByZw();
		/*for (int i = 0; i < list.size(); i++) {
			Map object = list.get(i);
			System.out.println(object);
		}*/
		System.out.println(list);
	}
}
