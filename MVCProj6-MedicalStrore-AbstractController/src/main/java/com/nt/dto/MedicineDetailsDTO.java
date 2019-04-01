package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class MedicineDetailsDTO implements Serializable {
	private int medId;
	private String medName;
	private float price;
	private String company;

}
