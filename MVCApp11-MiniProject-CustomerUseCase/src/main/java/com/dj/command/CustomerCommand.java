package com.dj.command;

import lombok.Data;

@Data
public class CustomerCommand {
	private int srNo;
	private Integer cno;
	private String cname;
	private String caddr;
	private Long mobileNo;
	private Float billAmt;
}
