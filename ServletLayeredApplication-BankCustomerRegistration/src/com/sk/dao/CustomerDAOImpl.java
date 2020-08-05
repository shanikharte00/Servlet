package com.sk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sk.bo.CustomerBO;

public class CustomerDAOImpl implements CustomerDAO {

	private static final String QUERY_PARAM = "INSERT INTO REGISTER VALUES (S2.NEXTVAL,?,?,?,?,?)";
	private Connection getPooledConnection() throws Exception {
		// to Locate Jndi Registry
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		// create InitialContext obj
		ic = new InitialContext();
		// for look those jndi registry by using lookup method
		ds = (DataSource) ic.lookup("java:/comp/env/Dsjndi");
		// get Datasource obj through lookup operation
		con = ds.getConnection();
		return con;
	}
	@Override
	public int insert(CustomerBO bo) throws Exception {
		Connection con = null;
		// prepare the Statement
		PreparedStatement ps;
		int count = 0;
		// get pooled JDBC connection Object
		con = getPooledConnection();
		// create PreparedStatement
		ps = con.prepareStatement(QUERY_PARAM);
		// set the PreparedStatement
		
		ps.setString(1, bo.getAccHolder_name());
		ps.setString(2, bo.getAcc_type());
		ps.setFloat (3, bo.getInitial_amt());
		ps.setFloat (4, bo.getCashback_amt());
		ps.setFloat (5, bo.getFinal_balance());
		
		//execute the query
		count = ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		return count;
	}
}
