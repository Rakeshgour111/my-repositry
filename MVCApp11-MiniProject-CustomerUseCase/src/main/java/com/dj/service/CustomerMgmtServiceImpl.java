package com.dj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.dj.bo.CustomerBO;
import com.dj.dao.CustomerMgmtDAO;
import com.dj.dto.CustomerDTO;

public class CustomerMgmtServiceImpl implements CustomerMgmtService {
	private CustomerMgmtDAO dao;

	public CustomerMgmtServiceImpl(CustomerMgmtDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<CustomerDTO> fetchAllCustomers() {
		List<CustomerBO> listBO=null;
		List<CustomerDTO> listDTO=new ArrayList<CustomerDTO>();
		//Use DAO
		listBO=dao.getAllCustomers();
		
		//Convert ListBO to ListDTO
		listBO.forEach(bo->{
			CustomerDTO dto = new CustomerDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);
		});
		
		return listDTO;
	}

	@Override
	public CustomerDTO findCustomerByCno(int cno) {
		CustomerBO bo = null;
		CustomerDTO dto = null;
		// use DAO
		bo = dao.getCustomerByCno(cno);
		// convert BO to DTO
		dto = new CustomerDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public String modifyCustomerBySno(CustomerDTO dto) {
		int count=0;
		CustomerBO bo=null;
		// Convert DTO to BO
		bo=new CustomerBO();
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		count=dao.updateCustomerBySno(bo);
		if(count==0)
			return "Customer Details Updatation Failed";
		else
			return "Customer Details Updated Successfully";
	}

	@Override
	public String removeCustomerByCno(int cno) {
		int count=0;
		//use DAO
		count=dao.deleteCustomerByCno(cno);
		if(count==0)
			return "Customer Record not found Deletion !";
		else
			return "Customer Record Deleted";
	
	}

	@Override
	public String addCustomer(CustomerDTO dto) {
		int count = 0;
		CustomerBO bo = null;
		// convert DTO to BO
		bo = new CustomerBO();
		//Convert DTO to BO
		bo.setCname(dto.getCname());
		bo.setCaddr(dto.getCaddr());
		bo.setMobileNo(dto.getMobileNo());
		bo.setBillAmt(dto.getBillAmt());
		// use DAO
		count = dao.addCustomer(bo);
		if (count == 0)
			return "New Customer Registration Failed";
		else
			return "New Customer Added Successfully !";
	}

}
