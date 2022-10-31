package questao1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public Connection buscaConexao() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost/produtoscadastro?useTimezone=true&serverTimezone=UTC", "root", "vini");
	}
	
}