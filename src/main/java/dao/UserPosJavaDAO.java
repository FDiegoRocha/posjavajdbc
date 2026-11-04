package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.UserPosJava;

public class UserPosJavaDAO {
	
	private Connection connection;
	
	public UserPosJavaDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(UserPosJava userPosJava) {
		String sql = "INSERT INTO userposjava (id, nome, email) VALUES (?, ?, ?);";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setLong(1, userPosJava.getId());
			st.setString(2, userPosJava.getNome());
			st.setString(3, userPosJava.getEmail());
			st.execute();
			connection.commit();
			System.out.println("Usuario salvo!");
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public List<UserPosJava> listarUsuarios(){
		String sql = "SELECT * FROM userposjava;";
		List<UserPosJava> usuarios = new ArrayList<>(); 
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				UserPosJava user = new UserPosJava();
				user.setId(rs.getLong("id"));
				user.setNome(rs.getString("nome"));
				user.setEmail(rs.getString("email"));
				usuarios.add(user);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public UserPosJava listarPorId(Long id){
		String sql = "SELECT * FROM userposjava WHERE id = ?";
		UserPosJava user = new UserPosJava(); 
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setLong(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				user.setId(rs.getLong("id"));
				user.setNome(rs.getString("nome"));
				user.setEmail(rs.getString("email"));
								
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	

}
