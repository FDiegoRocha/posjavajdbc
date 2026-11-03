package dao;

import java.sql.Connection;

import conexaojdbc.SingleConnection;

public class UserPosJavaDAO {
	
	private Connection connection;
	
	public UserPosJavaDAO() {
		connection = SingleConnection.getConnection();
	}
	
	
	

}
