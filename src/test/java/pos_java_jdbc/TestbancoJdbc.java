package pos_java_jdbc;

import java.util.List;

import org.junit.jupiter.api.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosJavaDAO;
import model.Telefone;
import model.UserPosJava;

public class TestbancoJdbc {
	
	@Test
	public void initBanco() {
		SingleConnection.getConnection();
		
		UserPosJava user = new UserPosJava();
		user.setNome("Albert Silva");
		user.setEmail("Albert@gmail.com");
		UserPosJavaDAO userPosJavaDAO = new UserPosJavaDAO();
		
		userPosJavaDAO.salvar(user);
	}
	
	@Test
	public void initLista() {
		UserPosJavaDAO userPosJavaDAO = new UserPosJavaDAO();
		List<UserPosJava> usuarios = userPosJavaDAO.listarUsuarios();
		usuarios.stream().forEach(System.out::println);
	}
	
	@Test
	public void initListaPorId() {
		UserPosJavaDAO userPosJavaDAO = new UserPosJavaDAO();
		UserPosJava usuario = userPosJavaDAO.listarPorId(3L);
		System.out.println(usuario);
	}
	
	@Test
	public void initAtualizar() {
		UserPosJavaDAO dao = new UserPosJavaDAO();
		UserPosJava userBanco = dao.listarPorId(1L);
		userBanco.setNome("Alex Joaquim da Silva Xavier");
		dao.atualizar(userBanco);
	}
	
	@Test
	public void initDeletar() {
		UserPosJavaDAO dao = new UserPosJavaDAO();
		dao.deletar(7L);
	}
	
	@Test
	public void testSalvarTelefone() {
		UserPosJavaDAO dao = new UserPosJavaDAO();
		Telefone tel = new Telefone();
		tel.setNumero("85 32659856");
		tel.setTipo("Casa");
		tel.setUsuario(9L);
		dao.salvarTelefone(tel);
	}

}
