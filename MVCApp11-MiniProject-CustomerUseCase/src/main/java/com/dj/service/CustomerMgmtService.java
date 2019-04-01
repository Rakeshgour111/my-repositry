package com.dj.service;

import java.util.List;

import com.dj.dto.CustomerDTO;

public interface CustomerMgmtService {
	public List<CustomerDTO> fetchAllCustomers();

	public CustomerDTO findCustomerByCno(int cno);

	public String modifyCustomerBySno(CustomerDTO dto);

	public String removeCustomerByCno(int cno);

	public String addCustomer(CustomerDTO dto);

}
