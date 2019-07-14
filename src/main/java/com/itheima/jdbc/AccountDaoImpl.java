package com.itheima.jdbc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class AccountDaoImpl implements AccountDao {

	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	//添加账户
	public int addAccount(Account account) {
		// TODO Auto-generated method stub
		String sql="insert into account(username,balance) value(?,?)";
		Object[] obj=new Object[] {
				account.getUsername(),
				account.getBalance()
		};
		int num=this.jdbcTemplate.update(sql,obj);
		return num;
	}

	
	public int updateAccount(Account account) {
		// TODO Auto-generated method stub
		String sql="update account set username=?,balance=?where id=?";
		Object[] params=new Object[] {
				account.getUsername(),
				account.getBalance(),
				account.getId()
		};
		int num=this.jdbcTemplate.update(sql,params);
		return num;
	}

	
	public int deleteAccount(int id) {
		// TODO Auto-generated method stub
		String sql="delete from account where id=?";
		int num=this.jdbcTemplate.update(sql,id);
		return num;
	}
	
	public Account findAccountById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from account where id=?";
		RowMapper<Account> rowMapper=new BeanPropertyRowMapper<Account>(Account.class);
		return this.jdbcTemplate.queryForObject(sql, rowMapper,id);
	}
	
	public List<Account> findAllAccount() {
		// TODO Auto-generated method stub
		String sql="select * from account";
		RowMapper<Account> rowMapper=new BeanPropertyRowMapper<Account>(Account.class);
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	public void transfer(String outUser, String inUser, Double money) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update account set balance=balance+?"+"where username=?",money,inUser);
		int i=1/0;
		this.jdbcTemplate.update("update account set balance=balance-?"+"where username=?",money,outUser);
	}
}
