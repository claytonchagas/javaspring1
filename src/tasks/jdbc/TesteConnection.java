package tasks.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConnection {
	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().getConnection();
		System.out.println("Conexão aberta com o Banco de Dados");
		con.close();
	}
}