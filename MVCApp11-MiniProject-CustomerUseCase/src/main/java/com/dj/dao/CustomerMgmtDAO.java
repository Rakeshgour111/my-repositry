package com.dj.dao;

import java.util.List;

import com.dj.bo.CustomerBO;

public interface CustomerMgmtDAO {
	public List<CustomerBO> getAllCustomers();

	public CustomerBO getCustomerByCno(int cno);

	public int updateCustomerBySno(CustomerBO bo);

	public int deleteCustomerByCno(int cno);

	public int addCustomer(CustomerBO bo);

}
