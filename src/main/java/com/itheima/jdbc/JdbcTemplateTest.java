package com.itheima.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {
	@Test
	public void mainTest() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdTemplate=(JdbcTemplate) applicationContext.getBean("jdbcTemplate");
		jdTemplate.execute("create table account("+
							"id int primary key auto_increment,"+
							"username varchar(50),"+
							"balance double)");
		System.out.println("账户表account创建成功！");
	}
	@Test
	public void addAccountTest() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountDao accountDao=(AccountDao) applicationContext.getBean("accountDao");
		Account account=new Account();
		account.setUsername("tom11");
		account.setBalance(1000.00);
		int num=accountDao.addAccount(account);
		if(num>0) {
			System.out.println("成功插入了"+num+"条数据");
		}else {
			System.out.println("插入数据操作执行失败！");
		}
	}
	@Test
	public void updateAccountTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountDao accountDao=(AccountDao)applicationContext.getBean("accountDao");
		Account account=new Account();
		account.setId(1);
		account.setUsername("tom");
		account.setBalance(2000.00);
		int num=accountDao.updateAccount(account);
		if(num>0) {
			System.out.println("修改了第"+num+"条数据");
		}else {
			System.out.println("修改操作失败！");
		}
	}
	@Test
	public void deleteAccountTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountDao accountDao=(AccountDao)applicationContext.getBean("accountDao");
		int num=accountDao.deleteAccount(1);
		if(num>0) {
			System.out.println("成功删除了"+num+"条数据");
		}else {
			System.out.println("删除操作执行失败");
		}
	}
}
