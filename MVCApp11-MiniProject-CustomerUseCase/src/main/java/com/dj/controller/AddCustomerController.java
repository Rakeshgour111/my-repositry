package com.dj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.dj.command.CustomerCommand;
import com.dj.dto.CustomerDTO;
import com.dj.service.CustomerMgmtService;

public class AddCustomerController extends SimpleFormController {
	private CustomerMgmtService service;

	public AddCustomerController(CustomerMgmtService service) {
		this.service = service;
	}

	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		String resultMsg = null;
		CustomerCommand cmd = null;
		CustomerDTO dto = null;
		ModelAndView mav = null;
		List<CustomerDTO> listDTO = null;
		// convert cmd to DTO
		cmd = (CustomerCommand) command;
		dto = new CustomerDTO();
		//Convert Cmd to DTO
		dto.setCname(cmd.getCname());
		dto.setCaddr(cmd.getCaddr());
		dto.setMobileNo(cmd.getMobileNo());
		dto.setBillAmt(cmd.getBillAmt());
		// use Service
		resultMsg = service.addCustomer(dto);
		listDTO = service.fetchAllCustomers();
		// return MAV
		mav = new ModelAndView();
		mav.addObject("resMsg", resultMsg);
		mav.addObject("listDTO", listDTO);
		mav.setViewName("list_customers");
		return mav;
	}// method

	@Override
	public ModelAndView handleInvalidSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		String errorMsg="Sorry , Double Posting Not Allowed !";
		mav.addObject("errorMsg", errorMsg);
		mav.setViewName("list_customers");
		return mav;
		
	}

}
