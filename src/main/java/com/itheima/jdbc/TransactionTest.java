package com.itheima.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {
	@Test
	public void xmlTest() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountDao accountDao=(AccountDao) applicationContext.getBean("accountDao");
		accountDao.transfer("Jack", "Rose", 100.0);
		System.out.println("转账成功");
	}
}
