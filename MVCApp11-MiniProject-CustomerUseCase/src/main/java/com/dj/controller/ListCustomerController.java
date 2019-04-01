package com.dj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.dj.dto.CustomerDTO;
import com.dj.service.CustomerMgmtService;

public class ListCustomerController extends AbstractController {
	private CustomerMgmtService service;

	public ListCustomerController(CustomerMgmtService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<CustomerDTO> listDTO=null;
		
		// Use Service
		listDTO=service.fetchAllCustomers();
		
		//Create and return MAV object
		return new ModelAndView("list_customers", "listDTO",listDTO);

	}

}
