/**
 * 
 */
package com.siminglun.ssh.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.StringUtils;

import com.siminglun.ssh.dao.IDemoDao;
import com.siminglun.ssh.pojo.Users;

/**
 * @author 司明仑 --2014-1-6
 *
 */
public class DemoDaoJdbc extends HibernateDaoSupport implements IDemoDao {
	/*private DataSource dataSource;

	*//**
		* @return the dataSource
		*/
	/*
	public DataSource getDataSource() {
	return dataSource;
	}

	*//**
		* @param dataSource the dataSource to set
		*/
	/*
	public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
	}*/

	@Override
	public Map login(Map map) {
		String name = (String) map.get("name");
		String password = (String) map.get("password");
		/*String sql = "select count(1) from users where name=? and password=?";
		SqlFunction sf = new SqlFunction(dataSource, sql);
		sf.declareParameter(new SqlParameter(Types.VARCHAR));
		sf.declareParameter(new SqlParameter(Types.VARCHAR));
		sf.compile();
		int i = sf.run(new Object[] { name, password });
		System.out.println("此用户的数量是：" + i);
		if (i >= 1) {
			map.put("result", 1);
		}*/
		String sql = "select count(1) from users where name=:name and password=:password";
		List list = getSession().createSQLQuery(sql).setString("name", name)
				.setString("password", password).list();
		int i = Integer.parseInt(list.get(0).toString());
		System.out.println("此用户的数量是：" + i);
		if (i >= 1) {
			map.put("result", 1);
		}
		return map;
	}

	@Override
	public List query(Map map) {
		/*String sql = "select * from users";
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		List list = jt.queryForList(sql);*/
		String name = (String) map.get("name");
		Criteria criteria = getSession().createCriteria(Users.class);
		List list = null;
		if (StringUtils.hasLength(name)) {
			criteria.add(Restrictions.like("name", "%" + name.trim() + "%"));
		}
		list = criteria.list();
		return list;
	}

	@Override
	public void save(Map map) {
		String[] names = (String[]) map.get("name");
		String[] passwords = (String[]) map.get("password");
		Users u = null;
		for (int i = 0; i < names.length; i++) {
			if (StringUtils.hasLength(passwords[i])) {
				u = new Users();
				u.setName(names[i]);
				u.setPassword(passwords[i]);
				getSession().save(u);
			}
		}
	}

	@Override
	public void save(Users u) {
		getSession().save(u);
	}

	@Override
	public void del(Map map) {
		String[] ids = (String[]) map.get("id");
		int i = getSession()
				.createSQLQuery("delete from users where id in (:id)")
				.setParameterList("id", ids).executeUpdate();
		System.out.println("共删除行数：" + i);
	}

	@Override
	public void update(Map map) {
		String[] ids = (String[]) map.get("id");
		String[] names = (String[]) map.get("name");
		String[] passwords = (String[]) map.get("password");
		Users u = null;
		for (int i = 0; i < ids.length; i++) {
			u = (Users) getSession().load(Users.class, ids[i]);
			u.setName(names[i]);
			u.setPassword(passwords[i]);
			getSession().update(u);
		}
	}

	@Override
	public void queryById(String id) {
		Users u = (Users) getSession().load(Users.class, id);
		System.out.println(u);

	}

	@Override
	public List queryByZw() {
		String sql = "select sex,zw,count(id) as count from Users group by zw";
		Query query = getSession().createSQLQuery(sql).setResultTransformer(
				Transformers.ALIAS_TO_ENTITY_MAP);
		List list = query.list();
		return list;
	}
}
