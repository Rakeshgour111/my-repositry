package com.dj.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.dj.bo.CustomerBO;

public class CustomerMgmtDAOImpl implements CustomerMgmtDAO {

	private static final String GET_ALL_CUSTOMERS = "SELECT CUSNO,CUSNAME,ADDRS,MOBILENO,BILLAMT FROM CUSTOMER_INFO";
	private static final String GET_CUSTOMER_BY_CNO = "SELECT CUSNO,CUSNAME,ADDRS,MOBILENO,BILLAMT FROM CUSTOMER_INFO WHERE CUSNO=?";
	private static final String UPDATE_CUSTOMER_BY_CNO = "UPDATE CUSTOMER_INFO SET CUSNAME=?,ADDRS=?,MOBILENO=?,BILLAMT=? WHERE CUSNO=?";
	private static final String DELETE_CUSTOMER_BY_CNO = "DELETE FROM CUSTOMER_INFO WHERE CUSNO=?";
	private static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMER_INFO VALUES(CUSTOMER_SEQ.NEXTVAL,?,?,?,?)";
	private JdbcTemplate jt;

	public CustomerMgmtDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public List<CustomerBO> getAllCustomers() {
		List<CustomerBO> listBO=null;
		
		listBO=jt.query(GET_ALL_CUSTOMERS, 
						rs->{
							System.out.println("CustomerMgmtDAOImpl.getAllCustomers()");
							List<CustomerBO> listBO1=new ArrayList<CustomerBO>();
							
							while(rs.next()) {
								CustomerBO bo=new CustomerBO();
								bo.setCno(rs.getInt(1));
								bo.setCname(rs.getString(2));
								bo.setCaddr(rs.getString(3));
								bo.setMobileNo(rs.getLong(4));
								bo.setBillAmt(rs.getFloat(5));
								listBO1.add(bo);
							}
							return listBO1;
						});

		return listBO;
	}

	@Override
	public CustomerBO getCustomerByCno(int cno) {
		CustomerBO bo=null;
		//use DAO
		bo=jt.queryForObject(GET_CUSTOMER_BY_CNO, 
			(rs,index)->{
			CustomerBO bo1=null;
			bo1=new CustomerBO();
			bo1.setCno(rs.getInt(1));
			bo1.setCname(rs.getString(2));
			bo1.setCaddr(rs.getString(3));
			bo1.setMobileNo(rs.getLong(4));
			bo1.setBillAmt(rs.getFloat(5));
			return bo1;
		}, cno);
		return bo;
	}

	@Override
	public int updateCustomerBySno(CustomerBO bo) {
		int  count=0;
		count=jt.update(UPDATE_CUSTOMER_BY_CNO,bo.getCname(),bo.getCaddr(),bo.getMobileNo(),bo.getBillAmt(),bo.getCno());
		return count;
	}

	@Override
	public int deleteCustomerByCno(int cno) {
		int count=0;
		count=jt.update(DELETE_CUSTOMER_BY_CNO,cno);
		return count;
	}

	@Override
	public int addCustomer(CustomerBO bo) {
		int count=0;
		count=jt.update(INSERT_CUSTOMER, bo.getCname(),bo.getCaddr(),bo.getMobileNo(),bo.getBillAmt());
		return count;
	}

}
