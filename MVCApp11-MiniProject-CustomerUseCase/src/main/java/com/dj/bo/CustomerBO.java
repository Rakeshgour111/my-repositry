package com.dj.bo;

import lombok.Data;

@Data
public class CustomerBO {

	private int cno;
	private String cname;
	private String caddr;
	private long mobileNo;
	private float billAmt;
}
