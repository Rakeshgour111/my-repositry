package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.MedicineDetailsDTO;
import com.nt.service.MedicineService;

public class ListMedicinesController extends AbstractController {
	private MedicineService service;
	
    public ListMedicinesController(MedicineService service) {
		this.service = service;
	}
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<MedicineDetailsDTO> listDTO=null;
		//use SErvice
		listDTO=service.fetchAllMedicines();
		//return MAV
		return new ModelAndView("show_report","listMed", listDTO);
	}

}
