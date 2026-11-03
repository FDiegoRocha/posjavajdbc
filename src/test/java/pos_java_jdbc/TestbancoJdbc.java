package pos_java_jdbc;

import org.junit.jupiter.api.Test;

import conexaojdbc.SingleConnection;

public class TestbancoJdbc {
	
	@Test
	public void initBanco() {
		SingleConnection.getConnection();
	}

}
