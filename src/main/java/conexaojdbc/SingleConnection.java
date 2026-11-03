package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

	private static String url = "jdbc:postgresql://localhost:5432/posjava";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection;

	// bloco de inicialização estatico, executado na hora que classe carregada na
	// memoria pela jvm
	static {
		conectar();
	}

	public SingleConnection() {
		conectar();
	}

	private static void conectar() {
		try {
			if (connection == null) {
				// força a JVM carregar o pacote dinamicamente em tempo de execução, não
				// obrigatório a partir do JDBC 4.0
				Class.forName("org.postgresql.Driver");
				
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
				System.out.println("Connectou com sucesso!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}
