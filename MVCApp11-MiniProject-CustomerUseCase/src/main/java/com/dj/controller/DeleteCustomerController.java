package com.dj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.dj.dto.CustomerDTO;
import com.dj.service.CustomerMgmtService;

public class DeleteCustomerController extends AbstractController {
	private CustomerMgmtService service;

	public DeleteCustomerController(CustomerMgmtService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int cno=Integer.parseInt(req.getParameter("cno"));
		String resultMsg = null;
		ModelAndView mav = null;
		List<CustomerDTO> listDTO = null;
		// use Service
		resultMsg = service.removeCustomerByCno(cno);
		listDTO = service.fetchAllCustomers();
		// return MAV
		mav = new ModelAndView();
		mav.addObject("listDTO", listDTO);
		mav.addObject("resMsg", resultMsg);
		mav.setViewName("list_customers");
		return mav;
	}

}
