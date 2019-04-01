package com.dj.dto;

import lombok.Data;

@Data
public class CustomerDTO {
	private int srNo;
	private Integer cno;
	private String cname;
	private String caddr;
	private long mobileNo;
	private float billAmt;
}
