package questao2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost/listafilmes?useTimezone=true&serverTimezone=UTC", "root", "vini");
	}
	
}