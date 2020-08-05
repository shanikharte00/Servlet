package com.sk.bo;

public class CustomerBO {
	private long acc_no;
	private String accHolder_name;
	private String acc_type;
	private float initial_amt;
	private float cashback_amt;
	private float final_balance;

	public long getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(long acc_no) {
		this.acc_no = acc_no;
	}

	public String getAccHolder_name() {
		return accHolder_name;
	}
	public void setAccHolder_name(String accHolder_name) {
		this.accHolder_name = accHolder_name;
	}
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
	public float getInitial_amt() {
		return initial_amt;
	}
	public void setInitial_amt(float initial_amt) {
		this.initial_amt = initial_amt;
	}
	public float getCashback_amt() {
		return cashback_amt;
	}
	public void setCashback_amt(float cashback_amt) {
		this.cashback_amt = cashback_amt;
	}
	public float getFinal_balance() {
		return final_balance;
	}
	public void setFinal_balance(float final_balance) {
		this.final_balance = final_balance;
	}
	
	
}
