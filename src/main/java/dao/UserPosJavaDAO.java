package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Telefone;
import model.UserPosJava;

public class UserPosJavaDAO {
	
	private Connection connection;
	
	public UserPosJavaDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(UserPosJava userPosJava) {
		String sql = "INSERT INTO userposjava (nome, email) VALUES (?, ?);";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, userPosJava.getNome());
			st.setString(2, userPosJava.getEmail());
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
	
	public void salvarTelefone(Telefone telefone) {
		String sql = "INSERT INTO telefoneuser (numero, tipo, usuariopessoa) VALUES (?,?,?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, telefone.getNumero());
			st.setString(2, telefone.getTipo());
			st.setLong(3, telefone.getUsuario());
			st.execute();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
	
	public void atualizar(UserPosJava userPosJava) {
		String sql = "UPDATE userposjava SET nome = ? WHERE id = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, userPosJava.getNome());
			st.setLong(2, userPosJava.getId());
			st.execute();
			connection.commit();
		}catch(SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public void deletar(Long id) {
		String sql = "DELETE FROM userposjava WHERE id = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setLong(1, id);
			st.execute();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	

}
