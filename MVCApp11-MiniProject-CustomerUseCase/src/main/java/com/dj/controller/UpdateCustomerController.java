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

public class UpdateCustomerController extends SimpleFormController {
	private CustomerMgmtService service;

	public UpdateCustomerController(CustomerMgmtService service) {
		this.service = service;
	}

	@Override
	public Object formBackingObject(HttpServletRequest request) throws Exception {
		int cno = 0;
		CustomerDTO dto = null;
		CustomerCommand cmd = null;
		// read additional req param values
		cno = Integer.parseInt(request.getParameter("cno"));
		// use service
		dto = service.findCustomerByCno(cno);
		// Convert DTO to Command obj
		cmd = new CustomerCommand();
		BeanUtils.copyProperties(dto, cmd);
		return cmd;
	}
	
	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		CustomerCommand cmd=null;
		CustomerDTO dto=null;
		String resultMsg=null;
		List<CustomerDTO> listDTO=null;
		ModelAndView mav=null;
		
		//TypeCast Command Object
		cmd=(CustomerCommand)command;
		//Convert Command obj to DTO
		dto=new CustomerDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use Service
		resultMsg=service.modifyCustomerBySno(dto);
		listDTO=service.fetchAllCustomers();
		//return MAV
		mav=new ModelAndView();
		mav.addObject("listDTO",listDTO);
		mav.addObject("resMsg",resultMsg);
		mav.setViewName("list_customers");
		return mav;
	}

}
