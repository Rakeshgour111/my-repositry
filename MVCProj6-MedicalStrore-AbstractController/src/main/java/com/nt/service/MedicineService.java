package com.nt.service;

import java.util.List;

import com.nt.dto.MedicineDetailsDTO;

public interface MedicineService {
	public List<MedicineDetailsDTO> fetchAllMedicines();

}
