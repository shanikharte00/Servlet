package com.sk.service;

import com.sk.bo.CustomerBO;
import com.sk.dao.CustomerDAO;
import com.sk.dao.CustomerDAOImpl;
import com.sk.dto.CustomerDTO;

public class CustomerServiceImpl implements CustomerService {
	public CustomerDAO dao;
    
	public CustomerServiceImpl() {
		dao = new CustomerDAOImpl();
	}
	
	@Override
	public String register(CustomerDTO dto) throws Exception {
		CustomerBO bo = null;
		float cashback = 0.0f;
		float finalBal = 0.0f;
		int count=0;
		float run=0.0f;
		
		//prepare persistable Data
		bo = new CustomerBO();
		// write Business
		if(bo.getInitial_amt() >= 1000 || bo.getInitial_amt() <= 100000) {
			cashback = 1000;
		}
		else {
			cashback = 2000;
		}	
		
		bo.setAccHolder_name(dto.getName());
		bo.setAcc_type(dto.getAccType());
		bo.setInitial_amt(dto.getInitAmt());
		bo.setCashback_amt(cashback);
	
		finalBal =cashback+bo.getInitial_amt();
		bo.setFinal_balance(finalBal);
		//System.out.println(bo.getAccHolder_name());
		//use Dao
		count=dao.insert(bo);
		//process the Result
		if(count==0) {
			return "Connection is failed";
		}
		else{
			return "connection is Successful";
		}
	}
}
