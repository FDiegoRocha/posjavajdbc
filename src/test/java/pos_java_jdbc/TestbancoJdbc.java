package pos_java_jdbc;

import java.util.List;

import org.junit.jupiter.api.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosJavaDAO;
import model.UserPosJava;

public class TestbancoJdbc {
	
	@Test
	public void initBanco() {
		SingleConnection.getConnection();
		
		UserPosJava user = new UserPosJava();
		user.setId(4L);
		user.setNome("Janmille Rocha");
		user.setEmail("Janmille@gmail.com");
		UserPosJavaDAO userPosJavaDAO = new UserPosJavaDAO();
		
		userPosJavaDAO.salvar(user);
	}
	
	@Test
	public void initLista() {
		UserPosJavaDAO userPosJavaDAO = new UserPosJavaDAO();
		List<UserPosJava> usuarios = userPosJavaDAO.listarUsuarios();
		usuarios.stream().forEach(System.out::println);
	}

}
